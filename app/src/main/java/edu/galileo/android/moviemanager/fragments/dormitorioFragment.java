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



public class dormitorioFragment extends Fragment {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Movie> movies;

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

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(getContext(), movies);
        rvMovies.setAdapter(adapter);

        return view;
    }

    private void initializeData() {

        movies = new ArrayList<>();
        movies.add(new Movie(1, "Sábana.", "Stone & Beam Starburst Sateen Cotton Sheet Set, Queen, Cloud.", 59.49, 5, "https://images-na.ssl-images-amazon.com/images/I/41EeJ-RG+XL._AC_US160_.jpg"));
        movies.add(new Movie(2, "Almohada.", "MyPillow Standard/ Queen classic Medium Support set of 2.", 79.99, 3.20, "https://images-na.ssl-images-amazon.com/images/I/315IoCvg1dL._AC_US160_.jpg"));
        movies.add(new Movie(3, "Almohada.", " Alaska Bear- Natural Silk momme, 600 thread count 100 percent Mulberry Silk", 22.99, 4.60, "https://images-na.ssl-images-amazon.com/images/I/41zR9OmibVL._AC_US160_.jpg"));
        movies.add(new Movie(4, "Pregnancy Pillow.", "Pregnancy Pillow, Full Body Maternity Pillow with Contoured U-Shape by Blueston. Back Support.", 30.38, 4.20, "https://images-na.ssl-images-amazon.com/images/I/41KeR0Ed-tL._AC_US160_.jpg"));
        movies.add(new Movie(5, "Colcha.", "BEDSURE Sherpa Fleece Blanl Twin Size Grey Plush Throw Blanket Fuzzy Soft Blanket Microfiber.", 31.99, 5, "https://images-na.ssl-images-amazon.com/images/I/51IPsZuMWaL._AC_US160_.jpg"));

    }
}
