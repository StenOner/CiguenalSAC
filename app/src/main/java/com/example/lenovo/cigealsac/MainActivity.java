package com.example.lenovo.cigealsac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements ToursFragment.OnTourSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.flay_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
            ToursFragment toursFragment = new ToursFragment();
            toursFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.flay_container, toursFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
    @Override
    public void onTourSelected(int position) {
        DescripcionFragment descripcionFragment = (DescripcionFragment)getSupportFragmentManager()
                .findFragmentById(R.id.fgm_container);
        if(descripcionFragment != null){
            descripcionFragment.updateDescription(position);
        }else{
            DescripcionFragment fragmentonuevo = new DescripcionFragment();
            Bundle args = new Bundle();
            args.putInt(DescripcionFragment.ARG_POSITION,position);
            fragmentonuevo.setArguments(args);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fgm_container,fragmentonuevo)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
