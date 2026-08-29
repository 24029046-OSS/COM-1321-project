/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

/**
 *
 * @author hlulani
 */
public class ReportData {
    private String code,name,category,warranty,supplier;
    private double price;
    private int stock;
    
    public ReportData(String code,String name,String category,String warranty,double price,int stock,String supplier){
    
    this.code=code;
    this.name=name;
    this.category=category;
    this.warranty=warranty;
    this.price=price;
    this.stock=stock;
    this.supplier=supplier;
            
    }
    public String getCode(){return code;}
    public String getName(){return name;}
    public String getCategory(){return category;}
    public String getWarranty(){return warranty;}
    public double getPrice(){return price;}
    public int getStock(){return stock;}
    public int getstock(){return stock;}
    public String getSupplier(){return supplier;}
    public String getsupplier(){return supplier;}
    
    public void setWarranty(String warranty){this.warranty=warranty;}
    public void setPrice(double price){this.price=price;}
    public void setStock(int stock){this.stock=stock;}
}
