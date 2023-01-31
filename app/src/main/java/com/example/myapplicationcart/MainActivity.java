package com.example.myapplicationcart;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationcart.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        recyclerView = binding.productList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductAdapter (this,R.layout.product_box,getProductList()));
    }
    private List<Product> getProductList() {

        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();


        product1.setProductTitle("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
        product1.setProductDesc("Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday");
        product1.setProductImage("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");

        Product product2 = new Product();

        product2.setProductTitle("Mens Casual Premium Slim Fit T-Shirts");
        product2.setProductDesc("Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.");
        product2.setProductImage("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg");

        Product product3 = new Product();

        product3.setProductTitle("Mens Cotton Jacket");
        product3.setProductDesc("great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.");
        product3.setProductImage("https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg");

        Product product4 = new Product();

        product4.setProductTitle("John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet");
        product4.setProductDesc("From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.");
        product4.setProductImage("https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        return productList;


    }

}