package com.example.lenovo.cigealsac;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by LenoVo on 3/27/2018.
 */

public class ToursFragment extends ListFragment {

    OnTourSelectedListener mCallBack;

    public interface OnTourSelectedListener{
        void onTourSelected(int position);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.tours, container, false);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                Contenido.Tours));
    }
    @Override
    public void onStart(){
        super.onStart();
        if (getFragmentManager().findFragmentById(R.id.flay_container) != null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            Activity activity = (Activity)context;
            mCallBack = (OnTourSelectedListener)activity; //se asegura que la actividad podra recibir la informacion enviada de manera correcta

        }catch(ClassCastException e){
            throw new ClassCastException(getActivity().toString() + " debe implementar la interfaz OnTourSelectedListener");
        }
    }
    @Override
    public void onListItemClick (ListView listView,
                                 View view, int position,
                                 long id){
        mCallBack.onTourSelected(position);
        getListView().setItemChecked(position,true);
    }
}
