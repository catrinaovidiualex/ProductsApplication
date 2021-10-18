package model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Product {
    private String pname;
    private int price;
    private int qty;

    public void setPname(String pname){
        this.pname=pname;
    }

    public String getPname(){
        return this.pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    ArrayList<Product> lista;

    public Product(String pname, int price, int qty){
        this.pname=pname;
        this.price=price;
        this.qty=qty;

    }

    @Override
    public String toString() {
        return "Product{" +
                "pname='" + pname + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }




}
