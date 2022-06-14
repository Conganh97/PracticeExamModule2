package io;

import Models.Product;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite {
    public void write (ArrayList<Product> products){
        File file = new File("C:\\Users\\ADMIN\\Desktop\\Code\\module2\\Thithuchanh\\data\\products.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product st : products) {
                bufferedWriter.write(st.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList <Product> read (){
        ArrayList <Product> students = new ArrayList<>();
        File file = new File("C:\\Users\\ADMIN\\Desktop\\Code\\module2\\Thithuchanh\\data\\products.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null){
                String [] arr = str.split(",");
                int Id = Integer.parseInt(arr[0]);
                String name = arr[1];
                float price = Float.parseFloat(arr[2]);
                int amount = Integer.parseInt(arr[3]);
                String describe = arr[4];
                students.add(new Product(Id,name,price,amount,describe));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.err.println("File error");
        }
        return students;
    }
}
