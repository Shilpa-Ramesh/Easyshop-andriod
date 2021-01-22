package com.example.finaleasyshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends Fragment {

    ListView listView;
    ImageView book, elect, sofa, car;
    BottomNavigationView navigation;
    FrameLayout frameLayout;
    private home exploreFragment;
    private sell sellFragment;
    // private MyAddFragment myAddFragment;
    private profile profileFragment;


    public home() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

        book = view.findViewById(R.id.books);
        elect = view.findViewById(R.id.phones);
        sofa = view.findViewById(R.id.furnitures);
        car = view.findViewById(R.id.cars);

        navigation = view.findViewById(R.id.bottomNavigationView);
        frameLayout = view.findViewById(R.id.frameLayout);


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new buy_book();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new buy_phones();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        sofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new buy_furnitures();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
//
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new buy_cars();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //switch to select which case is chosen

                switch (menuItem.getItemId()) {
                    case R.id.explore:
                        Fragment fragment = new home();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frag_container, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;


                    case R.id.sell:
                        Fragment fragment1 = new sell();
                        FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.frag_container, fragment1);
                        fragmentTransaction1.addToBackStack(null);
                        fragmentTransaction1.commit();
                        return true;

                    case R.id.feedback:
                        Fragment fragment3 = new Feedback();
                        FragmentManager fragmentManager3 = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                        fragmentTransaction3.replace(R.id.frag_container, fragment3);
                        fragmentTransaction3.addToBackStack(null);
                        fragmentTransaction3.commit();
                        return true;


                    case R.id.profile:
                        Fragment fragment2 = new profile();
                        FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.frag_container, fragment2);
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();
                        return true;

                }
                return false;
            }
        });


//        private void InitializeFragment(Fragment fragment){
//
//
//
//
//        }
        return view;
    }
}


