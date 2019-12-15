package cn.xyy.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateful(name = "ProductCartBeanEJB")
@Remote(ProductCartRemote.class)

public class ProductCartBean implements ProductCartRemote{
    public ProductCartBean() { }

    private ArrayList<String> cartList = new ArrayList<String>();
    private int totalPrice=0;

    @Override
    public void addProduct(String productName, int price) {
        this.cartList.add(productName);
        totalPrice += price;
    }

    @Override
    public ArrayList<String> listProducts() {
        return this.cartList;
    }

    @Override
    public int totalPrice() {
        return totalPrice;
    }
}
