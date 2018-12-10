package edu.galileo.android.moviemanager.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.models.Producto;

public class ProductoDetailActivity extends AppCompatActivity {

    Producto producto;
    @BindView(R.id.ivMovieBackdrop)
    ImageView ivMovieBackdrop;
    @BindView(R.id.tvOverview)
    TextView tvOverview;
    Context context;
    static List<Producto> Listacarrito= new ArrayList<Producto>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produc_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        Bundle extras = getIntent().getExtras();

        //obtiene los datos del Inten
        obtenerDatos(extras);

        //Para que se cambien los iconos
        cambiarIcono(fab);
       fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Producto saved as favorite", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
               if(valaidaLista()){
                   fab.setImageResource(R.drawable.ic_add_black_24dp);
                   Snackbar.make(view, "Producto eliminado", Snackbar.LENGTH_LONG)
                           .setAction("Action", null).show();
                   Listacarrito.remove(producto);
               }else{
                   fab.setImageResource(R.drawable.ic_remove_black_24dp);
                   Snackbar.make(view, "Producto agregado", Snackbar.LENGTH_LONG)
                           .setAction("Action", null).show();
                   Listacarrito.add(producto);
               }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // Bundle extras = getIntent().getExtras();
        /*if (extras != null) {
            producto = (Producto) extras.getSerializable("MOVIE");
            this.setTitle(producto.getTitle());
            tvOverview.setText(producto.getOverview());

            Picasso.with(this)
                    .load(producto.getImagen())
                    .into(ivMovieBackdrop);

        }*/
    }
    public void cambiarIcono(FloatingActionButton fab){
        if(validaRepetido()){
            fab.setImageResource(R.drawable.ic_remove_black_24dp);

        }else{
            fab.setImageResource(R.drawable.ic_add_black_24dp);


        }
    }

    //Obtener Datos
    public void obtenerDatos(Bundle extras){
        if (extras != null) {
            producto = (Producto) extras.getSerializable("MOVIE");
            this.setTitle(producto.getTitle());
            tvOverview.setText(producto.getOverview());
            //ObtenerImagenes(context,imagenJuego,producto.getUrl_image());
            ObtenerImagenes(context,ivMovieBackdrop,producto.getImagen());

        }
    }

    //Obtine las imagenes
    public void ObtenerImagenes(Context contex, ImageView ivPoster, String recurso){
        if (recurso.isEmpty()) { //url.isEmpty()
            Picasso.with(context)
                    .load(R.drawable.logo)
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(ivPoster);

        }else{
            Picasso.with(context)
                    .load(recurso)
                    .error(R.drawable.logo)
                    .placeholder(R.drawable.logo)
                    .into(ivPoster); //this is your ImageView
        }

    }

    //valida producto repetido
    public boolean validaRepetido(){
        for(Producto listaNew:getListacarrito()){
            if(listaNew.getId()==(producto.getId())){
                return true;
            }
        }
        return false;
    }

    public  boolean valaidaLista(){
        for (Producto listita :Listacarrito){
            if(listita.getId() == producto.getId()){
                return true;
            }

        }
        return false;
    }
    public static List<Producto> getListacarrito() {
        return Listacarrito;
    }
}
