package com.example.myapplicationcart;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    // My Step 1
    //Coming From Activity
    int rowLayout ;
    List<Product> productList;
    Context context;


    // My Step 2

    //Cell
    public static class ProductViewHolder  extends RecyclerView.ViewHolder{

        TextView productTitle;
        TextView prodcutDesc;
        ImageView  mProductImage;
        LinearLayout baseLayout;




        public ProductViewHolder(View v) {
            super(v);
            productTitle = (TextView) v.findViewById(R.id.productTitle);
            prodcutDesc = (TextView) v.findViewById(R.id.productDesc);
            mProductImage = (ImageView) v.findViewById(R.id.productImage);
            baseLayout = (LinearLayout) v.findViewById(R.id.product_layout);
        }

    }





    // this are my work to do
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.productTitle.setText(productList.get(position).getProductTitle());
        holder.prodcutDesc.setText(productList.get(position).getProductDesc());

        Glide.with(context)
                .load(productList.get(position).getProductImage())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mProductImage);

        holder.baseLayout.setOnClickListener(view -> {

            Intent intent = new Intent(context,Detail_Product.class);
            //intent.putExtra("PRODUCT",ProductList.get(position));
            intent.putExtra("PRODUCT",productList.get(position));
            context.startActivity(intent);



        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }




    public  ProductAdapter(Context context, int rowLayout, List<Product> productList) {
        this.context = context;
        this.rowLayout = rowLayout;
        this.productList = productList;
    }
}
