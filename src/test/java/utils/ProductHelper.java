package utils;

import model.Product;

public class ProductHelper {


    public static Product addedProduct;

    public static Product buildProductInfo(String name, String price){
        addedProduct = new Product(name, price);
        return addedProduct;
    }
}
