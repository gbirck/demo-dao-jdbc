package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090.00 WHERE DepartmentId = 1");

            /*
            int x = 1;
            if (x < 2) {
                throw new SQLException("Erro Fake");
            }
            */

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090.00 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("rows1: " + rows1);
            System.out.println("rows2: " + rows2);
        }
        catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transação cancelada e revertida " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Erro no rollback " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}