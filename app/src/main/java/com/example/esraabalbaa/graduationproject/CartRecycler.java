package com.example.esraabalbaa.graduationproject;

/**
 * Created by Shiko on 26/04/2017.
 */

public class CartRecycler {
    int images_id;
    String productname,productprice,productquantity;

    public CartRecycler(int images_id , String productname , String productprice , String productquantity){
        this.setImages_id(images_id);
        this.setProductname(productname);
        this.setProductprice(productprice);
        this.setProductquantity(productquantity);

    }
    public int getImages_id() {
        return images_id;
    }

    public void setImages_id(int images_id) {
        this.images_id = images_id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(String productquantity) {
        this.productquantity = productquantity;
    }

}
