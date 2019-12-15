package cn.xyy.ejb;

import java.util.ArrayList;
import javax.ejb.Remote;

public interface ProductCartRemote {
    public void addProduct(String productName, int price);
    public ArrayList<String> listProducts();
    public int totalPrice();
}