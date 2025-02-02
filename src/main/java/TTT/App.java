package TTT;

import TTT.config.DataBaseConfig;
import TTT.models.Company;
import TTT.sevice.impl.CompanyServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CompanyServiceImpl companyService = new CompanyServiceImpl();

        //save company
        while (true) {
            System.out.println("""
                    1. save company
                    2. find by id
                    3. update company
                    4  find all companies
                    5  delete company
                    """);
            System.out.print("choice:");
            Scanner in = new Scanner(System.in);
            Scanner str = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1 -> {
                    System.out.print("name company: ");
                    String name = str.nextLine();
                    System.out.print("write the company address: ");
                    String address = str.nextLine();

                    System.out.println(companyService.addCompany(new Company(name, address)));
                }
                case 2 ->{
                    System.out.print("id company: ");
                    Long id = in.nextLong();
                    System.out.println(companyService.findById(id));
                }
                case 3 -> {
                    System.out.println("update company with id: ");
                    Long id = in.nextLong();
                    System.out.print("new company name: ");
                    String name = str.nextLine();
                    System.out.print("new company address: ");
                    String address = str.nextLine();
                    Company company = new Company(name, address);
                    System.out.println(companyService.updateCompany(company, id));
                }
                case 4 -> {
                    System.out.println(companyService.findAllCompanies());
                }
                case 5 -> {
                    System.out.println("delete company with id: ");
                    Long id = in.nextLong();
                    companyService.deleteById(id);
                }
            }

        }


    }
}
