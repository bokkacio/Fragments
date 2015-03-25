package com.example.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sanea on 25.03.15.
 */
public class TestFragment extends Fragment implements View.OnClickListener {

    private Button btnFragment;
    private TextView txtFragment;

    //LayoutInflater
    //Instantiates a layout XML file into its corresponding View objects. It is never used directly. Instead, use getLayoutInflater() or getSystemService(String) to retrieve a standard LayoutInflater instance that is already hooked up to the current context and correctly configured for the device you are running on.

    private View initUiComponents(LayoutInflater inflater, ViewGroup container){
        //Inflate a new view hierarchy from the specified XML node.
        View result = inflater.inflate(R.layout.test_fragment, container, false);
        btnFragment = (Button)result.findViewById(R.id.buttonFragment);
        txtFragment = (TextView)result.findViewById(R.id.txtFragment);
        btnFragment.setOnClickListener(this);
        return (result);
    }

    //The system calls this when it's time for the fragment to draw its user interface for the first time. To draw a UI for your fragment, you must return a View from this method that is the root of your fragment's layout. You can return null if the fragment does not provide a UI.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initUiComponents(inflater, container);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonFragment:
                //http://developer.android.com/reference/java/util/Formatter.html
                txtFragment.setText(String.format("The current activity is %s", getActivity().getLocalClassName()));
                break;
        }

    }
}