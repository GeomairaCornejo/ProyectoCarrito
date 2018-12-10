package edu.galileo.android.moviemanager.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.ProductoDetailActivity;
import edu.galileo.android.moviemanager.adapters.FacturaAdapter;
import edu.galileo.android.moviemanager.models.Producto;


public class factura extends Fragment {


    @BindView(R.id.rvProductos)
    RecyclerView rvJuegos;
    @BindView(R.id.txtTotal)
    TextView txtTotal;
    @BindView(R.id.txtIva)
    TextView txtDesceuntos;
    @BindView(R.id.txtTotalPagar)
    TextView txtTotalPagar;


   /* @BindView(R.id.search)
    SearchView searchView;*/

    //private TodosArticulosRecyclerViewAdapter adapter;
    // private List<Movie> movies;
    public static ArrayList<Producto> imageMovieArrayList2= new ArrayList<Producto>();

    public factura() {
        // Required empty public constructor
    }

    // @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_factura, container, false);
        ButterKnife.bind(this, view);
        //ProductoRepository.initializeData();
        //CargarLista();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvJuegos.setHasFixedSize(true);
        rvJuegos.setLayoutManager(llm);

        FacturaAdapter adapter = new FacturaAdapter(this.getContext(), ProductoDetailActivity.getListacarrito());
        rvJuegos.setAdapter(adapter);

        double iva=Double.parseDouble(totlIva());
        double subTotal=Double.parseDouble(Obtener_subTotal());
        //idNitems.setText(String.valueOf(MovieDetailActivity.getListaCarrito().size()));
        txtTotal.setText(Obtener_subTotal());
        txtDesceuntos.setText(totlIva());
        //txtDesceuntos.setTextColor(Color.parseColor("#ff0000"));
        txtTotalPagar.setText(Obtener_total(iva,subTotal));

        return view;
    }
    //Calcula la factura
    public String Obtener_subTotal() {
        String result = "";
        double total = 0.0;
        DecimalFormat formateo = new DecimalFormat("####.####");
        for (Producto listaJuegos : ProductoDetailActivity.getListacarrito()) {
            total = total + listaJuegos.getPrecio();
        }
        //return result=(String.valueOf(total));
        return result= formateo.format(total);
    }

    //Calcula la factura
    public String totlIva() {
        String results = "";
        double iva=0.12;
        double result=0;

        DecimalFormat formateo = new DecimalFormat("####.####");
        for (Producto listaJuegos : ProductoDetailActivity.getListacarrito()) {
            result = result + ( listaJuegos.getPrecio() *iva);

        }
        return results = formateo.format(result);
        //return results=String.valueOf(result);
    }

    //Calcula la factura
    public String Obtener_total(double iva,double subTotal) {
        String results = "";
        DecimalFormat formateo = new DecimalFormat("####.####");
        double total = iva + subTotal;


        return results= formateo.format(total);
    }

}
