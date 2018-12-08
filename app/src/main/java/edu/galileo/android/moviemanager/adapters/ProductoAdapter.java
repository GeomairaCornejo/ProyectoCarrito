package edu.galileo.android.moviemanager.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.ProductoDetailActivity;
import edu.galileo.android.moviemanager.models.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {
    List<Producto> productos;
    Context context;
    public ProductoAdapter(Context context, List<Producto> productos){
        this.productos = productos;
        this.context = context;
    }
    private Context getContext(){
        return context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.tvTitle.setText(producto.getTitle());
        holder.tvOverview.setText(producto.getOverview());
        holder.txtPrecio.setText(String.valueOf(producto.getPrecio()));
        holder.ratingBar.setRating((float) producto.getRating());
        holder.dolar.setText(producto.getDolar());
        Picasso.with(getContext())
                .load(producto.getImagen())
                .into(holder.ivMovieImage);
    }
    @Override
    public int getItemCount() {
        return productos.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.ivMovieImage)
        ImageView ivMovieImage;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvOverview)
        TextView tvOverview;
        @BindView(R.id.txtPrecio)
        TextView txtPrecio;
        @BindView(R.id.myRatingBar)
        RatingBar ratingBar;
        @BindView(R.id.txtdolar)
        TextView dolar;
        @BindView(R.id.cvMovie)
        CardView cvMovie;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Producto producto = productos.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), ProductoDetailActivity.class);
            intent.putExtra("MOVIE", producto);
            getContext().startActivity(intent);

        }
    }
}
