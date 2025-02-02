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
                    
                    """);
            System.out.print("choice:");
            Scanner in = new Scanner(System.in);
            Scanner str = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1 -> {
                    System.out.print("name company: ");
                    String name = str.nextLine();
                    System.out.print("write the company adrress: ");
                    String adrress = str.nextLine();

                    System.out.println(companyService.addCompany(new Company(name, adrress)));

                }
            }

        }


    }
}
