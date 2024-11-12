package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {
    private int productID;
    private String click;
    private int addToCart;
    private int checkOut;
    private LocalDate dateTime;

    public Product() {}

    public Product(int productID, String click, int addToCart, int checkOut, LocalDate dateTime) {
        this.productID = productID;
        this.click = click;
        this.addToCart = addToCart;
        this.checkOut = checkOut;
        this.dateTime = dateTime;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public int getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(int addToCart) {
        this.addToCart = addToCart;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }
}
