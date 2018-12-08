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


public class dormitorioFragment extends Fragment {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Producto> productos;

    public dormitorioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dormitorio, container, false);
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
        productos.add(new Producto(1, "Sábana.", "Stone & Beam Starburst Sateen Cotton Sheet Set, Queen, Cloud.", "$",59.49, 5, "https://images-na.ssl-images-amazon.com/images/I/41EeJ-RG+XL._AC_US160_.jpg"));
        productos.add(new Producto(2, "Almohada.", "MyPillow Standard/ Queen classic Medium Support set of 2.", "$",79.99, 5, "https://images-na.ssl-images-amazon.com/images/I/315IoCvg1dL._AC_US160_.jpg"));
        productos.add(new Producto(3, "Almohada.", " Alaska Bear- Natural Silk momme, 600 thread count 100 percent Mulberry Silk", "$",22.99, 4.60, "https://images-na.ssl-images-amazon.com/images/I/41zR9OmibVL._AC_US160_.jpg"));
        productos.add(new Producto(4, "Pregnancy Pillow.", "Pregnancy Pillow, Full Body Maternity Pillow with Contoured U-Shape by Blueston. Back Support.", "$",30.38, 4.20, "https://images-na.ssl-images-amazon.com/images/I/41KeR0Ed-tL._AC_US160_.jpg"));
        productos.add(new Producto(5, "Colcha.", "BEDSURE Sherpa Fleece Blanl Twin Size Grey Plush Throw Blanket Fuzzy Soft Blanket Microfiber.", "$",31.99, 5, "https://images-na.ssl-images-amazon.com/images/I/51IPsZuMWaL._AC_US160_.jpg"));
        productos.add(new Producto(6, "Cama.", "Cama Jameson.", "$",1499.00, 5, "https://images.zgallerie.com/is/image/ZGallerie/999310557a?$prodgrid$"));
        productos.add(new Producto(7, "Velador.", "Cofre de 3 cajones con espejo Omni.", "$",799.00,4.20, "https://images.zgallerie.com/is/image/ZGallerie/014761886?$prodgrid$"));
        productos.add(new Producto(8, "Mesita de Noche.", "Mesita de noche Ava 2 cajones", "$",499.99, 4.60, "https://images.zgallerie.com/is/image/ZGallerie/014187417a?$prodgrid$"));
        productos.add(new Producto(9, "Pantalla.", "Pantalla de la habitanción Hudson.", "$",399.38, 5, "https://images.zgallerie.com/is/image/ZGallerie/622095821?$prodgrid$"));
        productos.add(new Producto(10, "Ropa de Cama.", "Morningside 8 piezas Juego de cama.", "$",628.99, 5, "https://images.zgallerie.com/is/image/ZGallerie/620098546a?$prodgrid$"));

    }
}
