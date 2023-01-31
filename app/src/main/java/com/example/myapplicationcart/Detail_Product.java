package com.example.myapplicationcart;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplicationcart.databinding.ActivityDetailProductBinding;

public class Detail_Product extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDetailProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        Product product =  (Product) getIntent().getExtras().getSerializable("PRODUCT");

        binding.title.setText(product.getProductTitle());
        binding.desc.setText(product.getProductDesc());
        Glide.with(this)
                .load(product.getProductImage())
                .into(binding.image);

    }
}