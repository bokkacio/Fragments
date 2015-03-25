package com.example.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sanea on 25.03.15.
 */
public class SecondActivity extends Activity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button btn = (Button)findViewById(R.id.btnMyActivity);
        TextView txtResult = (TextView)findViewById(R.id.txtResult);
        btn.setOnClickListener(this);

        try {
            //Return the intent that started this activity.
            Intent startedIntent = getIntent();
            if(startedIntent == null)
                return;

            Bundle bundleIntent = startedIntent.getBundleExtra(MyActivity.INTENT_BUNDLE);
            String[] strCollection = bundleIntent.getStringArray(MyActivity.BUNDLE_COLLECTION);

            String result = "";
            for (int i = 0; i< strCollection.length; i++)
                result += String.format("%s ", strCollection[i]);

            txtResult.setText(String.format("Collection from MyActivity: %s ", result));
        }
        catch (Exception ex)
        {
            txtResult.setText(ex.getMessage());
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnMyActivity:

                Intent intent = new Intent(this, MyActivity. class);
                startActivity(intent);
                break;
        }

    }
}