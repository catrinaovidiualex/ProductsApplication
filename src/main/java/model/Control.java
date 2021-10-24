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
    public Product getDuplicationOfProduct(String pnume, int pret){
       for(Product prod:listaProduse){
           if(prod.getPname().equals(pnume)&&prod.getPrice()==pret){
               return prod;

           }
       }

        return null;
    }

    //CRUD

    //public Product(String pname, int price, int qty)
    public void addprodusNou(){
        Scanner citeste=new Scanner(System.in);

        System.out.println("Introduceti denumirea produsului:");
        String denumireProdusNou=citeste.nextLine();

        System.out.println("Introduceti pretul noului produs:");
        int pretProdusNou=citeste.nextInt();

        System.out.println("Introduceti cantitate noului produs:");
        int cantitateProdusNou=citeste.nextInt();

        Product produsN=new Product(denumireProdusNou,pretProdusNou,cantitateProdusNou);
        Product produsDuplicat= getDuplicationOfProduct(denumireProdusNou,pretProdusNou);

        if(produsDuplicat!=null){
            System.out.println("Exista deja produsul in baza de date, introduceti un nou produs!");
            addprodusNou();
        }
        else{
            s.addNewProduct(produsN);

        }
        listaProduse=s.allProducts();

    }
    public void modificareProdus(){

        Scanner citeste = new Scanner(System.in);

        System.out.println("Introduceti numele produsului pe care doriti sa il modificati");
        String numeProdus=citeste.nextLine();

        System.out.println("Introduceti pretul produsului pe care doriti sa il modificati");
        int pretPNou=citeste.nextInt();

        System.out.println("Introduceti cantitatea produsului pe care doriti sa il modificati");
        int cantitatePNou=citeste.nextInt();

        s.updateProduct(numeProdus,pretPNou,cantitatePNou);
       System.out.println("Produsul a fost modificat conform detaliilor introduse!");

    }
    public void stergereProdus(){

        System.out.println("Introduceti numele produsului pe care doriti sa il stergeti:");
        Scanner citire = new Scanner (System.in);
        String numeProdStergere = citire.nextLine();

        System.out.println("Introduceti pretul produsului pe care doriti sa il stergeti");
        int pretProdusSters = citire.nextInt();

        Product produsDeSters = getDuplicationOfProduct(numeProdStergere,pretProdusSters);
        if(produsDeSters!=null){
            s.deleteProuct(produsDeSters);
            System.out.println("Produsul a fost sters cu succes!");
        }

    }





    public static void meniu (){
        System.out.println("================================MENIU PRODUSE===================================");
        System.out.println("1->Inregistrare produs nou");
        System.out.println("2->Modificare produs existent");
        System.out.println("3->Sterere produs");
        System.out.println("4->Iesire meniu");

    }

    public void play(){
        ArrayList<Product> listaproduse=new ArrayList<>();
        Scanner citire=new Scanner(System.in);
        boolean iesire=false;
        meniu();
        System.out.println("Alegeti o optiune din meniul de produse");
        while(iesire==false){
            int actiune=citire.nextInt();
            if(actiune==1){
                addprodusNou();

            }
            else if (actiune==2) {
                modificareProdus();

            }else if (actiune==3){
                stergereProdus();
            }else if (actiune==4){
                System.out.println("Va multumim!");
                meniu();}
        }
    }


}