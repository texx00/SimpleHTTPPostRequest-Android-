package com.texx.simplehttppostrequest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc(View view) {
        Toast.makeText(this,"Sending data", Toast.LENGTH_SHORT).show();

        //getting data from view
        final EditText et=(EditText)findViewById(R.id.edit);
        /* creating request
        *   passing context, url and listener
        */
        HTTPPostTask httpPostTask=new HTTPPostTask(this, "http://texx.altervista.org/u/httpposttask/calc.php", new HTTPPostTask.HTTPPostTaskListener() {

            //What to do when the result is available
            @Override
            public void onDataReceived(Context context, String result) {
                //decoding json string
                try {
                    final JSONArray jsona=new JSONArray(result);

                    //to modify a view it's necessary to use a runnable in this way
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                /*
                                    here you can work on views
                                 */
                                et.setText("" + jsona.getString(1));

                            }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                    });
                    Log.d("MainActivity", "The result of " + jsona.getString(0) + " is " + jsona.getString(1));
                }catch (JSONException jsone){
                    Log.e("MainActivity", "Something went wrong!");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Context context){
                Log.d("MainActivity","An error has occurred");
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
