package model;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    ArrayList<Product> listaProduse;
    SqlUtil s = new SqlUtil();

    public Control(){ listaProduse=s.allProducts();}
    public Product checkProduct(String pname, int price){
        for(Product produse: listaProduse){
            if(produse.getPname().equals(pname)&&produse.getPrice()==price){
                return produse;

            }


        }
        System.out.println("Produsul cautat nu exista in baza de date, va rugam sa verificatii detaliile intorduse!");
        return null;

    }


}