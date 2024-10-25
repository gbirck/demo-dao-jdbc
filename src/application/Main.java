package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== SELLER FIND BY ID ===");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);
        System.out.println();

        System.out.println("=== SELLER FIND BY DEPARTMENT ID ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("=== SELLER FIND ALL ===");
        list = sellerDao.findAll();
        for (Seller s : list) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("=== SELLER INSERT ===");
        Seller seller1 = new Seller(null, new Date(), "greg", "greg@gmail.com", 4000.00, department);
        sellerDao.insert(seller1);
        System.out.printf("Inserted! New ID: " + seller1.getId());
    }
}