package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SqlUtil {
    private String JdbcURL = "jdbc:mysql://localhost:3306/productscrud?autoreconnect=true&useSSL=false";
    private String username = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    private ArrayList<Product> lista;

    public SqlUtil() {
        try {
            connection = DriverManager.getConnection(JdbcURL, username, password);
            statement = connection.createStatement();
            // System.out.println("Conexiunea la BD s-a realizat cu succes");

        } catch (Exception e) {
            System.out.println("Conexiunea la BD nu s-a putut efectua!!!");
        }

    }

    public void executeStatement(String execute) {

        try {
            statement.execute(execute);
        } catch (Exception e) {
            System.out.println("NU s-a executat sintaxa in BD: " + execute);

        }
    }


    //CRUD


    private ResultSet allPr(){
        executeStatement("select * from products");
        try{
            return statement.getResultSet();

        }
        catch(Exception e){
            System.out.println("Nu s-a executat sintaxa SQL pentru afisare a produselor");
            return null;
        }

    }
    public ArrayList<Product>allProducts(){
        ResultSet set=allPr();
        ArrayList<Product> produse= new ArrayList <>();

        try{
            while(set.next()){
                //public Product(String pname, int price, int qty)
                produse.add(
                        new Product(set.getString(2),
                                   Integer.parseInt(set.getString(3)),
                                           Integer.parseInt(set.getString(4))
                                           ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return produse;
    }
    public void addNewProduct(Product pr){
        String insert="";
        insert+=String.format("insert into products (pname,price,qty) values (");
        insert+=String.format("'%s',%d,%d", pr.getPname(),pr.getPrice(),pr.getQty());
        insert+=String.format(");");

        executeStatement(insert);

        System.out.println("Produsul a fost adaugat!");
    }
    public void updateProduct(String pname,int newPrice, int newQty){

        String update="";
        update=String.format("update products set price=%d",newPrice);

        update+=String.format(",qty=%d",newQty);
        update+=String.format("where pname='%s'",pname);

        executeStatement(update);


    }
    public void deleteProuct(Product pr){
        String stergere="";



        String productName = pr.getPname();

        stergere=String.format("delete from products where pname='%s'",productName);

        executeStatement(stergere);
    }





}
