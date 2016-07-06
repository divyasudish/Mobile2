package welding.taal.com.mobile2app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import welding.taal.com.mobile2app.server.controller.RetrofitSingleton;
import welding.taal.com.mobile2app.server.services.TaskService;


public class MainActivity extends AppCompatActivity {
    private TaskService mTaskService;
    private EditText edit;
    private TextView text;
    private Button but;
    private Button but1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.editSend);
        text = (TextView) findViewById(R.id.textViewData);
        but  = (Button) findViewById(R.id.but);
        but1 = (Button) findViewById(R.id.textView1);

        mTaskService = RetrofitSingleton.getRestAdapter().create(TaskService.class);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTaskService.getTaskList1(new Callback<String>() {
                    @Override
                    public void success(String s, Response response) {
                        System.out.println("Inside " + s.toString());
                        text.setText(s.toString());
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTaskService.uploadTask1(edit.getText().toString().trim(), new Callback<String>() {
                    @Override
                    public void success(String s, Response response) {

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

    }
}
