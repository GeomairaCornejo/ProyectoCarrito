package edu.galileo.android.moviemanager.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.models.Producto;

public class FacturaAdapter extends RecyclerView.Adapter<FacturaAdapter.ViewHolder> {


    List<Producto> productos;
    Context context;
    //Array para el filtro
   /* public static ArrayList<Producto> imageModelArrayList= new ArrayList<Producto>();
    private ArrayList<Producto> arraylist;*/


    public FacturaAdapter(Context context, List<Producto> movies) {
        this.productos = movies;
        this.context = context;

    }

    private Context getContext() {
        return context;
    }

    @Override
    public FacturaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto_fact, parent, false);

        return new FacturaAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(FacturaAdapter.ViewHolder holder, int position) {

        Producto producto = productos.get(position);
        holder.txtTitulo.setText(producto.getTitle());

        holder.txtPrecio.setText(String.valueOf(producto.getPrecio()));


        ObtenerImagenes(producto, holder);


    }


    //Obtener Imagenes
    public void ObtenerImagenes(Producto producto, FacturaAdapter.ViewHolder holder) {
        if (producto.getImagen().isEmpty()) { //url.isEmpty()
            Picasso.with(context)
                    .load(R.drawable.loguito)
                    .placeholder(R.drawable.loguito)
                    .error(R.drawable.loguito)
                    .into(holder.imPortada);

        } else {
            Picasso.with(context)
                    .load(producto.getImagen())
                    .error(R.drawable.loguito)
                    .placeholder(R.drawable.loguito)
                    .into(holder.imPortada); //this is your ImageView
        }

    }


    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivImagen)
        ImageView imPortada;
        @BindView(R.id.textNombre)
        TextView txtTitulo;
        @BindView(R.id.textViewPrices)
        TextView txtPrecio;
        @BindView(R.id.cvGamesFact)
        CardView cvFactura;
        @BindView(R.id.textPrecio)
        TextView textPrecioDescuento;
        @BindView(R.id.textViewPrice_ss2)
        TextView textViewPrice_s2;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            //view.setOnClickListener(this);

        }
    }
}
