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
import edu.galileo.android.moviemanager.adapters.MovieRecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Movie;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {
    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Movie> movies;
    public UpcomingFragment() {
        // Required empty public constructor
    }
//cocina
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        ButterKnife.bind(this, view);
        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);
        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(this.getContext(), movies);
        rvMovies.setAdapter(adapter);
        return view;
    }
    private void initializeData() {
        movies = new ArrayList<>();
        movies.add(new Movie(1, "cafetera.", "oster.", 120.30, 5, "https://images-na.ssl-images-amazon.com/images/I/41zR9OmibVL._AC_US160_.jpg"));
        movies.add(new Movie(2, "buller.", "nuevo.", 130.40, 4, "https://images-na.ssl-images-amazon.com/images/I/413kmauL+KL._AC_US160_.jpg"));
        movies.add(new Movie(3, "Olla De Presión.", "Olla de presión eléctrica Instant Pot Smart WIFI de 6 cuartos, plateada.", 90.00, 4,
                "https://images-na.ssl-images-amazon.com/images/I/414Puwa8G+L._AC_US160_.jpg"));
        movies.add(new Movie(4, "Cuisinart GR-4N.", "Cuisinart GR-4N Griddler 5 en 1, negra.", 50.95, 5.03,
                "https://images-na.ssl-images-amazon.com/images/I/51jHurgMT1L._AC_US160_.jpg"));
        movies.add(new Movie(5, "Sartén.", "Sartén de hierro fundido de 10,25 pulgadas.", 14.80, 5,
                "https://images-na.ssl-images-amazon.com/images/I/31FZDSUNb3L._AC_US160_.jpg"));
        movies.add(new Movie(6, "Caldera Eléctrica.", "Caldera eléctrica de acero inoxidable 1 litro.", 15.29, 4.80,
                "https://images-na.ssl-images-amazon.com/images/I/41Kf0mndKyL._AC_US160_.jpg"));
        movies.add(new Movie(7, "Licuadora de mostrador Ninja.", "Licuadora de mostrador Ninja Professional de 72 oz con base 1000 vatios.",
                57.98, 4.80, "https://images-na.ssl-images-amazon.com/images/I/41gdjOddwrL._AC_US160_.jpg"));
        movies.add(new Movie(8, "Wafflera.", "Maquna para hacer gofres belga Presto 03510 Ceramic FlipSide.", 29.99, 5,
                "https://images-na.ssl-images-amazon.com/images/I/51Zr0Y7t3tL._AC_US160_.jpg"));
        movies.add(new Movie(9, "Nostalgia.", "Nostalgia HDT600RETRORED Retro Pop-Up Hot Dog Toaster.", 19.77, 4,
                "https://images-na.ssl-images-amazon.com/images/I/512TsWWej3L._AC_US160_.jpg"));
        movies.add(new Movie(10, "Cocina Eléctrica de huevo", "Dash DEC012BK- Cocina elétrica de huevo rápida de alta calidad para cocción dura, cocida, revuelta.",
                23.99, 4.50, "https://images-na.ssl-images-amazon.com/images/I/41QwQ9IIz0L._AC_US160_.jpg"));

    }
}
