package com.example.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity implements View.OnClickListener{

    public static final String BUNDLE_COLLECTION = "stringBundleArray";
    public static final String INTENT_BUNDLE = "intentBundle";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button)findViewById(R.id.btnSecondActivity);
        btn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSecondActivity:
                //Launch a new activity. You will not receive any information about when the activity exits. This implementation overrides the base version, providing information about the activity performing the launch. Because of this additional information, the FLAG_ACTIVITY_NEW_TASK launch flag is not required; if not specified, the new activity will be added to the task of the caller.
                //startActivity
                Intent intent = new Intent(this, SecondActivity. class);
                String[] arrayToSend = {"one", "two", "three"};
                //A mapping from String values to various Parcelable types.
                //Constructs a new, empty Bundle.
                Bundle collection = new Bundle();
                collection.putStringArray(BUNDLE_COLLECTION, arrayToSend);
                intent.putExtra(INTENT_BUNDLE, collection);
                //Launch a new activity. You will not receive any information about when the activity exits. This implementation overrides the base version, providing information about the activity performing the launch. Because of this additional information, the FLAG_ACTIVITY_NEW_TASK launch flag is not required; if not specified, the new activity will be added to the task of the caller.
                startActivity(intent);
                //Launch an activity for which you would like a result when it finished. When this activity exits, your onActivityResult() method will be called with the given requestCode. Using a negative requestCode is the same as calling startActivity(Intent) (the activity is not launched as a sub-activity).
                //startActivityForResult;
                break;
        }

    }

    //Call this to set the result that your activity will return to its caller.
    //setResult

    //Call this when your activity is done and should be closed. The ActivityResult is propagated back to whoever launched you via onActivityResult().
    //finish

    //Called when an activity you launched exits, giving you the requestCode you started it with, the resultCode it returned, and any additional data from it. The resultCode will be RESULT_CANCELED if the activity explicitly returned that, didn't return any result, or crashed during its operation.
    //    @Override
    //    protected void onActivityResult( int requestCode, int resultCode, Intent data) {
    //        if (data == null) {return;}
    //    }
}
