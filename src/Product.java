public class Product {
    String id;
    String title;
    int quantity;
    double price;
    
    public Product() {}
 
    public Product(String id, String title, int quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
   
    @Override
    public String toString() {
        return(id + " | " + title + "  |  " + quantity + "  |  " + price);
    }
    
}