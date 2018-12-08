package edu.galileo.android.moviemanager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.adapters.ProductoAdapter;
import edu.galileo.android.moviemanager.models.Producto;


public class comedorFragment extends Fragment {
    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Producto> productos;

    public comedorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comedor, container, false);
        ButterKnife.bind(this, view);

        initializeData();

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());

        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);

        ProductoAdapter adapter = new ProductoAdapter(getContext(), productos);
        rvMovies.setAdapter(adapter);

        return view;
    }

    private void initializeData() {

        productos = new ArrayList<>();
        productos.add(new Producto(1, "Sillas.", "Roundhill Furniture Habit Solid Wood Tufted Parsons Dining Chair (Set of 2), Tan.","$", 118.79, 4, "https://images-na.ssl-images-amazon.com/images/I/51yev6lw1bL._AC_US160_.jpg"));
        productos.add(new Producto(2, "Mesa.", "Mesa de comedor extensible gris natural Archer.", "$",1.600, 4, "https://images.zgallerie.com/is/image/ZGallerie/013144060c?$prodgrid$"));
        productos.add(new Producto(3, "Juego de Comedor.", "Coaster Home Furnishings 3-piece Dining Set with Drop Leaf Cappucino and Tan.","$", 163.76, 4.80, "https://images-na.ssl-images-amazon.com/images/I/41bqbM47r1L._AC_US160_.jpg"));
        productos.add(new Producto(4, "Mantel Decorativo.", "Violet Linen Decorative Printed Fruttela Tablecloth with Lace Trimming, Ivory,70'' x 105.", "$",49.49, 5, "https://images-na.ssl-images-amazon.com/images/I/51ugFyRLcbL._AC_US160_.jpg"));
        productos.add(new Producto(5, "Decoración.", "Vintage Car - Rustic Tin Living room decor, table decorations grey.", "$",118.79, 4, "https://images-na.ssl-images-amazon.com/images/I/51kLhO+LL2L._AC_US160_.jpg"));
        productos.add(new Producto(6, "Mantel de Cuentas.", "Mantel de cuentas.","$", 29.95, 5, "https://images.zgallerie.com/is/image/ZGallerie/068555603b?$prodgrid$"));
        productos.add(new Producto(7, "Banco.", "Archer Banquette - Gris Natural.", "$",929.00, 5, "https://images.zgallerie.com/is/image/ZGallerie/013856849?$prodgrid$"));
        productos.add(new Producto(8, "Silla.", "Silla logan Accent - Acrilico.","$", 999.00, 4.80, "https://images.zgallerie.com/is/image/ZGallerie/010003479b?$prodgrid$"));
        productos.add(new Producto(9, "Taburete.", "Taburete de Nottingham - Café Express.", "$",499.49, 5, "https://images.zgallerie.com/is/image/ZGallerie/013392390?$prodgrid$"));
        productos.add(new Producto(10, "Gabinete.", "Gabinete Grove Bar.", "$",1499.00, 4.80, "https://images.zgallerie.com/is/image/ZGallerie/600000024?$prodgrid$"));

    }
}
