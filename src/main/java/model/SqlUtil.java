package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

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
}
