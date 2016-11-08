package com.wonderlustking.cb.fragment_tests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewGroupCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by chris on 8/11/2016.
 */

public class FragmentTest extends Fragment {
    private EditText editText;
    private Button button;
    private CommunicateWithActivity communicator;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        communicator = (CommunicateWithActivity) getActivity();
        button = (Button) rootView.findViewById(R.id.button1);
        editText = (EditText) rootView.findViewById(R.id.edit1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                communicator.sendToActivity(editText.getText().toString());
            }
        });
        return rootView;
    }
}
