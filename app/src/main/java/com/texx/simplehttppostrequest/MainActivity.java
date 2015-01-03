package com.texx.simplehttppostrequest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc(View view) {
        Toast.makeText(this,"Sending data", Toast.LENGTH_SHORT).show();

        //getting data from view
        EditText et=(EditText)findViewById(R.id.edit);
        /* creating request
        *   passing context, url and listener
        */
        HTTPPostTask httpPostTask=new HTTPPostTask(this, "http://texx.altervista.org/u/httpposttask/calc.php", new HTTPPostTask.HTTPPostTaskListener() {

            //What to do when the result is available
            @Override
            public void onDataReceived(Context context, String result) {
                //decoding json string
                try {
                    JSONArray jsona=new JSONArray(result);
                    Log.d("MainActivity", "The result of "+jsona.getString(0)+" is "+jsona.getString(1));
                }catch (Exception jsone){
                    Log.e("MainActivity", "Something went wrong!");
                }
            }
        });

        /* adding post parameter:
        *   parameter name: num
        *  parameter value: et.getText().toString()
        */
        httpPostTask.addPostParam("num", et.getText().toString());
        // sending request
        httpPostTask.execute();
    }
}
