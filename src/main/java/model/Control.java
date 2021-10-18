package model;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    ArrayList<Product> listaProduse;
    SqlUtil s = new SqlUtil();

    public Control(){ listaProduse=s.allProducts();}

    public void play() {



    }
}