package Controller;

import Models.Product;
import Sort.SortAscending;
import Validate.Validate;
import io.ReadAndWrite;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    Validate validate = new Validate();

    ReadAndWrite readAndWrite = new ReadAndWrite();

    public void menu() {
        System.out.println("=====Menu=====");
        System.out.println("1.| Display product list");
        System.out.println("2.| Create product");
        System.out.println("3.| Edit product");
        System.out.println("4.| Delete product");
        System.out.println("5.| Sort product list");
        System.out.println("6.| Search the most expensive product");
        System.out.println("7.| Read on file");
        System.out.println("8.| Write on file");
        System.out.println("9.| Exit!!!");
        int choice = -1;
        try {
            System.out.println("Choose option: ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice < 0 || choice > 9) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("No option!! choose again!!");
        }
        switch (choice) {
            case 1:
                displayProduct(products);
                break;
            case 2:
                System.out.println("Option create product:");
                addProduct(createProduct());
                System.out.println("Create success!");
                break;
            case 3:
                System.out.println("Option edit product:");
                editProduct();
                break;
            case 4:
                System.out.println("Option delete product:");
                deleteProduct();
                break;
            case 5:
                products.sort(new SortAscending());
                System.out.println("Sort success");
                break;
            case 6:
                searchExpensiveProduct();
                break;
            case 7:
                readFile();
                break;
            case 8:
                writeFile();
                break;
            case 9:
                System.exit(0);
                break;
        }
    }

    public void displayProduct(ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if ((i + 1) % 5 == 0) {
                System.out.println(products.get(i));
                sc.nextLine();
            } else
                System.out.println(products.get(i));
        }
    }

    public Product createProduct() {
        int Id = validate.validateId(products);
        String name = validate.validateName();
        float price = validate.validatePrice();
        int amount = validate.validateAmount();
        System.out.println("Enter describe: ");
        String describe = sc.nextLine();
        return new Product(Id, name, price, amount, describe);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct() {
        while (true) {
            try {
                System.out.println("Enter Id: ");
                int id = Integer.parseInt(sc.nextLine());
                int index = validate.getIndex(id, products);
                if (index != -1) {
                    System.out.println("Edit product " + products.get(index).getName() + ":");
                    products.set(index, createProduct());
                    System.out.println("Edit success");
                    return;
                } else {
                    System.err.println("Id not exist");
                    System.out.println("Enter 'Y' to enter Id again!");
                    String yes = sc.nextLine();
                    if (!yes.equals("y")) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Enter again.");
            }
        }

    }

    public void deleteProduct() {
        while (true) {
            try {
                System.out.println("Enter id: ");
                int Id = Integer.parseInt(sc.nextLine());
                int index = validate.getIndex(Id, products);
                if (index == -1) {
                    System.out.println("Not found product to delete");
                    System.out.println("Enter 'Y' to enter Id again!");
                    String yes = sc.nextLine();
                    if (!yes.equals("y")) {
                        return;
                    }
                } else {
                    products.remove(index);
                    System.out.println("Are you sure delete product " + products.get(index).getName() + "? Yes press 'Y' - No press enter ");
                    String str = sc.nextLine();
                    if (str.equals("y")) {
                        products.remove(index);
                        System.out.println("Delete success");
                    }
                    return;
                }
            } catch (Exception e) {
                System.out.println("Enter again");
            }
        }
    }

    public void searchExpensiveProduct() {
        float max = products.get(0).getPrice();
        int index = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() > max) {
                max = products.get(i).getPrice();
                index = i;
            }
        }
        System.out.println("The most expensive product is: " + products.get(index).getName() + " price: " + max);
    }

    public void readFile() {
        System.out.println("Reading the file will erase all current data!");
        System.out.println("Enter 'y' to continue");
        String yes = sc.nextLine();
        if (yes.equals("y")) {
            products = readAndWrite.read();
            System.out.println("Read file success");
        }
    }
    public void writeFile(){
        System.out.println("Write the file will erase all current data");
        System.out.println("Enter 'y' to continue");
        String yes = sc.nextLine();
        if (yes.equals("y")){
            readAndWrite.write(products);
            System.out.println("Write file success");
        }
    }
}