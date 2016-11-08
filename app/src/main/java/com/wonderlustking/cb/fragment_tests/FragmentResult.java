package com.wonderlustking.cb.fragment_tests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chris on 8/11/2016.
 */

public class FragmentResult extends Fragment {
    private TextView textView;
    private String message;
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.result_fragment,container, false);
        textView = (TextView) rootView.findViewById(R.id.resutlText);
        if(savedInstanceState != null) textView.setText(message);
        else textView.setText(getArguments().getString("message"));
        return rootView;
    }

    public void updateMessage(String message){
        textView.setText(message);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        message = textView.getText().toString();
    }
}
