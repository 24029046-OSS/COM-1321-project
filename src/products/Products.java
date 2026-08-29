/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package products;

/**
 *
 * @author 24029046
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Products {
   public static void main(String[]args){
        Products app=new Products();
        app.DisplayManu();}
   
    public ArrayList<ReportData> productList =new ArrayList<>();
    public Scanner scanner =new Scanner(System.in);
    
    public void DisplayManu(){
    
    System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
    System.out.println("--------------------------------------");
    System.out.println("Enter (1) to launch menu or any key to exit.");
    
   String choice = scanner.nextLine();
   
   if(choice.equals("1")){
       runMenu();
   }else{ExitApplication();}
    }
    
       //  main menu navigation choices 
    public void runMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new product.");
            System.out.println("(2) Search for a product.");
            System.out.println("(3) Update a product.");
            System.out.println("(4) Delete a product.");
            System.out.println("(5) Print report.");
            System.out.println("(6) Exit application.");
            System.out.print("Selection: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    CaptureProduct();
                    break;
                case "2":
                    SearchProduct();
                    break;
                case "3":
                    UpdateProduct();
                    break;
                case "4":
                    DeleteProduct();
                    break;
                case "5":
                    PrintReport();
                    break;
                case "6":
                    ExitApplication();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    
    public void CaptureProduct() {
        System.out.println("\nCAPTURE A NEW PRODUCT");
        System.out.println("-----------------------");

        System.out.print("Enter the product code: ");
        String code = scanner.nextLine();

        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();

        
        String category = "";
        while (true) {
            System.out.println("Select the product category:");
            System.out.println("Desktop Computer -> 1");
            System.out.println("Laptop -> 2");
            System.out.println("Tablet -> 3");
            System.out.println("Printer -> 4");
            System.out.println("Gaming Console -> 5");
            System.out.print("Product Category: ");
            String catChoice = scanner.nextLine();

            if (catChoice.equals("1")) { category = "Desktop Computer"; break; }
            else if (catChoice.equals("2")) { category = "Laptop"; break; }
            else if (catChoice.equals("3")) { category = "Tablet"; break; }
            else if (catChoice.equals("4")) { category = "Printer"; break; }
            else if (catChoice.equals("5")) { category = "Gaming Console"; break; }
            else {
                System.out.println("Invalid category selection. Please re-enter.");
            }
        }

        //  Warranty option selection
        System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years: ");
        String warChoice = scanner.nextLine();
        String warranty = warChoice.equals("1") ? "6 months" : "2 years";

        System.out.print("Enter the price for " + name + ": ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter the stock level for "+ name + ": ");
        int stock = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the supplier for " + name + ": ");
        String supplier = scanner.nextLine();

        
        ReportData product = new ReportData(code, name, category, warranty, price, stock, supplier);
        SaveProduct(product);

        // Success notification
        System.out.println("Product details have been saved successfully!!!");
        promptReturn();
    }

    
    public void SaveProduct(ReportData product) {
        productList.add(product);
    }

    //  Searches for a product by code and displays details if found 
    public void SearchProduct() {
        System.out.print("\nPlease enter the product code to search: ");
        String code = scanner.nextLine();

        ReportData product = findProductByCode(code);

        if (product != null) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("PRODUCT SEARCH RESULTS");
            System.out.println("------------------------------------------------------------------");
            System.out.println("PRODUCT CODE:\t" + product.getCode());
            System.out.println("PRODUCT NAME:\t" + product.getName());
            System.out.println("PRODUCT WARRANTY:\t" + product.getWarranty());
            System.out.println("PRODUCT PRICE:\t" + product.getPrice());
            System.out.println("PRODUCT STOCK LEVEL:\t" + product.getStock());
            System.out.println("PRODUCT SUPPLIER:\t" + product.getSupplier());
            System.out.println("------------------------------------------------------------------");
        } else {
            System.out.println("The product cannot be located. Invalid Product");
        }
        promptReturn();
    }

    //  Updates specific details (warranty, price, stock) of a product 
    public void UpdateProduct() {
        System.out.print("\nPlease enter the product code to update: ");
        String code = scanner.nextLine();

        ReportData product = findProductByCode(code);

        if (product != null) {
            System.out.print("Update the warranty? (y) Yes, (n) No: ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter (1) for 6 months or any other key for 2 years: ");
                String warChoice = scanner.nextLine();
                product.setWarranty(warChoice.equals("1") ? "6 months" : "2 years");
            }

            System.out.print("Update the product price? (y) Yes, (n) No: ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter the new price for " + product.getName() + ": ");
                product.setPrice(Double.parseDouble(scanner.nextLine()));
            }

            System.out.print("Update the stock level? (y) Yes, (n) No: ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter the new stock level for " + product.getName() + ": ");
                product.setStock(Integer.parseInt(scanner.nextLine()));
            }

            System.out.println("Product details have been updated successfully!!!");
        } else {
            System.out.println("The product cannot be located. Invalid Product");
        }
        promptReturn();
    }

    //  Deletes a product from memory 
    public void DeleteProduct() {
        System.out.print("\nPlease enter the product code to delete: ");
        String code = scanner.nextLine();

        ReportData product = findProductByCode(code);

        if (product != null) {
            System.out.print("Are you sure you want to delete product " + code + "? (y) Yes, (n) No: ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                productList.remove(product);
                System.out.println("Product has been successfully deleted.");
            } else {
                System.out.println("Delete action cancelled.");
            }
        } else {
            System.out.println("The product cannot be located. Invalid Product");
        }
        promptReturn();
    }

    
    public void PrintReport() {
        System.out.println("\nPRODUCT REPORT");
        System.out.println("==================================================================");

        double totalValue = 0;
        int count = productList.size();

        for (int I = 0; I < count; I++) {
            ReportData p = productList.get(I);
            System.out.println("PRODUCT " + (I + 1));
            System.out.println("------------------------------------------------------------------");
            System.out.println("PRODUCT CODE:\t" + p.getCode());
            System.out.println("PRODUCT NAME:\t" + p.getName());
            System.out.println("PRODUCT CATEGORY:\t" + p.getCategory());
            System.out.println("PRODUCT WARRANTY:\t" + p.getWarranty());
            System.out.println("PRODUCT PRICE:\t" + p.getPrice());
            System.out.println("PRODUCT STOCK LEVEL:\t" + p.getStock());
            System.out.println("PRODUCT SUPPLIER:\t" + p.getSupplier());
            System.out.println("------------------------------------------------------------------");

            totalValue += p.getPrice() * p.getStock();
        }

        Double averageValue = count > 0 ? totalValue / count : 0;

        System.out.println("==================================================================");
        System.out.println("TOTAL PRODUCT COUNT: " + count);
        System.out.println("TOTAL PRODUCT VALUE: " + totalValue);
        System.out.println("AVERAGE PRODUCT VALUE: " + averageValue);
        System.out.println("==================================================================");

        promptReturn();
    }

    // Terminates application execution (Q.1.12)
    public void ExitApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

    // Searches the internal list by product code
    private ReportData findProductByCode(String code) {
        for (ReportData p : productList) {
            if (p.getCode().equalsIgnoreCase(code)) {
                return p;
            }
        }
        return null;
    }

    //  Prompts user to return to the main menu or exit
    private void promptReturn() {
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String choice = scanner.nextLine();
        if (!choice.equals("1")) {
            ExitApplication();
        }   
       
        
    }
}


   
    
            

   
    
    
            
