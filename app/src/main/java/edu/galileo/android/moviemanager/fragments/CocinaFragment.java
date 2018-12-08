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

/**
 * A simple {@link Fragment} subclass.
 */
public class CocinaFragment extends Fragment {
    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Producto> productos;
    public CocinaFragment() {
        // Required empty public constructor
    }
//cocina
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cocina, container, false);
        ButterKnife.bind(this, view);
        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);
        ProductoAdapter adapter = new ProductoAdapter(this.getContext(), productos);
        rvMovies.setAdapter(adapter);
        return view;
    }
    private void initializeData() {
        productos = new ArrayList<>();
        productos.add(new Producto(1, "cafetera.", "oster.", "$",120.30, 5, "https://images-na.ssl-images-amazon.com/images/I/41zR9OmibVL._AC_US160_.jpg"));
        productos.add(new Producto(2, "buller.", "nuevo.", "$",130.40, 4, "https://images-na.ssl-images-amazon.com/images/I/413kmauL+KL._AC_US160_.jpg"));
        productos.add(new Producto(3, "Olla De Presión.", "Olla de presión eléctrica Instant Pot Smart WIFI de 6 cuartos, plateada.", "$",90.00, 4,
                "https://images-na.ssl-images-amazon.com/images/I/414Puwa8G+L._AC_US160_.jpg"));
        productos.add(new Producto(4, "Cuisinart GR-4N.", "Cuisinart GR-4N Griddler 5 en 1, negra.", "$",50.95, 5.03,
                "https://images-na.ssl-images-amazon.com/images/I/51jHurgMT1L._AC_US160_.jpg"));
        productos.add(new Producto(5, "Sartén.", "Sartén de hierro fundido de 10,25 pulgadas.", "$",14.80, 5,
                "https://images-na.ssl-images-amazon.com/images/I/31FZDSUNb3L._AC_US160_.jpg"));
        productos.add(new Producto(6, "Caldera Eléctrica.", "Caldera eléctrica de acero inoxidable 1 litro.", "$",15.29, 4.80,
                "https://images-na.ssl-images-amazon.com/images/I/41Kf0mndKyL._AC_US160_.jpg"));
        productos.add(new Producto(7, "Licuadora de mostrador Ninja.", "Licuadora de mostrador Ninja Professional de 72 oz con base 1000 vatios.",
                "$",57.98, 4.80, "https://images-na.ssl-images-amazon.com/images/I/41gdjOddwrL._AC_US160_.jpg"));
        productos.add(new Producto(8, "Wafflera.", "Maquina para hacer gofres belga Presto 03510 Ceramic FlipSide.", "$",29.99, 5,
                "https://images-na.ssl-images-amazon.com/images/I/51Zr0Y7t3tL._AC_US160_.jpg"));
        productos.add(new Producto(9, "Nostalgia.", "Nostalgia HDT600RETRORED Retro Pop-Up Hot Dog Toaster.", "$",19.77, 4,
                "https://images-na.ssl-images-amazon.com/images/I/512TsWWej3L._AC_US160_.jpg"));
        productos.add(new Producto(10, "Cocina Eléctrica de huevo", "Dash DEC012BK- Cocina elétrica de huevo rápida de alta calidad para cocción dura, cocida, revuelta.",
                "$",23.99, 4.50, "https://images-na.ssl-images-amazon.com/images/I/41QwQ9IIz0L._AC_US160_.jpg"));
        productos.add(new Producto(11, "Russell Hobbs CM3100CRR.", "Cafetera de estilo retro 8 tazs.",
                "$",79.99, 3.80, "https://images-na.ssl-images-amazon.com/images/I/41t0gJlzgRL._AC_US160_.jpg"));
        productos.add(new Producto(12, "Sandwichera.", "Sandwichera de desayuno Hamilton Beach 25475A.", "$",18.99, 4.90,
                "https://images-na.ssl-images-amazon.com/images/I/41665b3Lh0L._AC_US160_.jpg"));
        productos.add(new Producto(13, "Carrusel K-Cup.", "Carrusel K-Cup - Sostiene 35 Copas K en Negro.", "$",14.04, 5,
                "https://images-na.ssl-images-amazon.com/images/I/51FpFDZMIYL._AC_US160_.jpg"));
        productos.add(new Producto(14, "Keuring K575 Cafetera", "Keuring K575 Cafetera de dosis única K-cup con 12 oz, control de fuerza y agua caliente a pedido, programable, platino.",
                "$",119.99, 4, "https://images-na.ssl-images-amazon.com/images/I/41qf6MC+99L._AC_US160_.jpg"));
        productos.add(new Producto(15, "Batidora de mano.", "Hamilton Beach 62682RZ Batidora de mano con estuche a presión, blanco.",
                "$",12.98, 4, "https://images-na.ssl-images-amazon.com/images/I/41pmPiPui4L._AC_US160_.jpg"));
        productos.add(new Producto(16, "Acoplador para espirales.", "Acoplador para espirales KitchenAid KSM1APC, 1, Plateado.", "$",74.99, 4.20,
                "https://images-na.ssl-images-amazon.com/images/I/41b88WwjtwL._AC_US160_.jpg"));
        productos.add(new Producto(17, "Botella de agua.", "Botella de agua para difusor de frutas a prueba de fugas, 32 oz.", "$",21.97, 5,
                "https://images-na.ssl-images-amazon.com/images/I/41hTurgAQLL._AC_US160_.jpg"));
        productos.add(new Producto(18, "Juego de Utensilios", "Rachael Ray - Juego de utensilios de cocina, 12 piezas, azul agave.",
                "$",87.39, 4, "https://images-na.ssl-images-amazon.com/images/I/51d6x96r1BL._AC_US160_.jpg"));
        productos.add(new Producto(19, "Spinner de ensalada.", "Spinner de ensalada Good Grips OXO.",
                "$",25.49, 4.80, "https://images-na.ssl-images-amazon.com/images/I/41K9RsAKi1L._AC_US160_.jpg"));
        productos.add(new Producto(20, "Nostalgia SMM200.", "Nostalgia SMM200 Electric S'mores Maker.", "$",24.99, 5,
                "https://images-na.ssl-images-amazon.com/images/I/41+Vsnm6i2L._AC_US160_.jpg"));

    }
}
