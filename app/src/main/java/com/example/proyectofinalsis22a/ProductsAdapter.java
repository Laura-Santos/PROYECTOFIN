package com.example.proyectofinalsis22a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<Productos> productList;

    public ProductsAdapter(Context mCtx, List<Productos> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Productos product = productList.get(position);

        //loading the image

        //String im = product.getImagen();
        //Toast.makeText(mCtx, ""+im, Toast.LENGTH_SHORT).show();
        //String im = product.getCodigo();

        // if(im.isEmpty()) {
        holder.imageView.setImageResource(R.drawable.imgnoencontrada);
        holder.textViewCodigo1.setText(String.valueOf(product.getCodigo()));
        holder.textViewDescripcion1.setText(product.getDescripcion());
        holder.textViewAutor1.setText(product.getAutor());
        holder.textViewTipo1.setText(product.getTipo());

        //   }else{
        // Glide.with(mCtx)
        //       .load(product.getImagen())
        //     .into(holder.imageView);

        holder.textViewCodigo1.setText(String.valueOf(product.getCodigo()));
        holder.textViewDescripcion1.setText(product.getDescripcion());
        holder.textViewAutor1.setText(product.getAutor());
        holder.textViewTipo1.setText(product.getTipo());
    }