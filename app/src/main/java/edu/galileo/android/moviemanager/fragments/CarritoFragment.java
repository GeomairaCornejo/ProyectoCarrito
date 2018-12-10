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
import edu.galileo.android.moviemanager.activities.ProductoDetailActivity;
import edu.galileo.android.moviemanager.adapters.ProductoAdapter;
import edu.galileo.android.moviemanager.models.Producto;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarritoFragment extends Fragment {




    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Producto> productos;

    public CarritoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carrito, container, false);
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
       for(Producto carrito: ProductoDetailActivity.getListacarrito()){
           productos.add(carrito);
       }
    }

}
