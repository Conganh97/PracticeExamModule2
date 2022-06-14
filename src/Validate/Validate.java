package Validate;

import Models.Product;
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);
    public int validateId (ArrayList<Product> products){
        while (true){
            try {
                System.out.println("Enter ID: ");
                int Id = Integer.parseInt(sc.nextLine());
                if (getIndex(Id,products) != -1 || Id < 0) throw new Exception();
                else return Id;
            } catch (Exception e) {
                System.out.println("Enter uncorrected, please enter ID again! ");
            }
        }
    }

    public int getIndex (int Id, ArrayList <Product> products){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == Id)
                return i;
        }
        return -1;
    }

    public String validateName (){
        while (true){
            System.out.println("Enter Name: ");
            String name = sc.nextLine();
            if ("".equals(name)) {
                System.out.println("Name can't be empty, please enter again");
                continue;
            } else
                return name;
        }
    }
    public float validatePrice (){
        while (true){
            try {
                System.out.println("Enter price: ");
                Float price = Float.parseFloat(sc.nextLine());
                if (price < 0 ) throw new Exception();
                else return price;
            } catch (Exception e) {
                System.out.println("Enter uncorrected, please enter price again! ");
            }
        }
    }
    public int validateAmount (){
        while (true){
            try {
                System.out.println("Enter amount: ");
                int amount = Integer.parseInt(sc.nextLine());
                if (amount < 0) throw new Exception();
                else return amount;
            }catch (Exception e) {
                System.out.println("Enter uncorrected, please enter ID again! ");
            }
        }
    }

}