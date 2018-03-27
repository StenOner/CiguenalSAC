package com.example.lenovo.cigealsac;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by LenoVo on 3/27/2018.
 */

public class DescripcionFragment extends Fragment {

    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.descripcion,
                container,false);
    }
    public void updateDescription(int position){
        TextView descripcion = (TextView)getActivity().findViewById(R.id.txt_descripcion);
        String desc= getString(R.string.price) + " " + Contenido.Prices[position] + "\n" +
                    getString(R.string.stay) + " " + Contenido.Days[position] + "\n" +
                    getString(R.string.desc) + " " + Contenido.Description[position];
        descripcion.setText(desc);
        mCurrentPosition = position;
    }
    @Override
    public void onStart(){
        super.onStart();
        TextView descripcion = (TextView)getActivity().findViewById(R.id.txt_descripcion);
        descripcion.setTextColor(Color.parseColor("Black"));
        descripcion.setTextSize(20);
        descripcion.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        descripcion.setPadding(3,3,3,3);
        Bundle args = getArguments();
        if (args != null){
            updateDescription(args.getInt(ARG_POSITION));
        }else if (mCurrentPosition!=-1){
            updateDescription(mCurrentPosition);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,
                mCurrentPosition);
    }
}
