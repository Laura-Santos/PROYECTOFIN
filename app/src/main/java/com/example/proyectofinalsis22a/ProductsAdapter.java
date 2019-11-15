package com.example.proyectofinalsis22a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;



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

        holder.imageView.setImageResource(R.drawable.cantar);
        holder.textViewCodigo1.setText(String.valueOf(product.getCodigo()));
        holder.textViewDescripcion1.setText(product.getDescripcion());
        holder.textViewAutor1.setText(product.getAutor());
        holder.textViewTipo1.setText(product.getTipo());



        holder.textViewCodigo1.setText(String.valueOf(product.getCodigo()));
        holder.textViewDescripcion1.setText(product.getDescripcion());
        holder.textViewAutor1.setText(product.getAutor());
        holder.textViewTipo1.setText(product.getTipo());
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCodigo1, textViewDescripcion1, textViewAutor1, textViewTipo1;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewCodigo1 = itemView.findViewById(R.id.textViewCodigo1);
            textViewDescripcion1 = itemView.findViewById(R.id.textViewDescripcion1);
            textViewAutor1= itemView.findViewById(R.id.textViewAutor1);
            textViewTipo1 = itemView.findViewById(R.id.textViewTipo1);
        }
    }


}
