package de.thoffbauer.aaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

@EActivity
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.editTextName)
    protected EditText editTextName;
    @ViewById(R.id.editTextAddress)
    protected EditText editTextAddress;

    @ViewById(R.id.textViewReply)
    protected TextView textViewReply;
    @ViewById(R.id.textViewId)
    protected TextView textViewId;

    @RestService
    protected HelloWorldClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Click(R.id.buttonGet)
    protected void buttonGet() {
        doGet();
    }

    @Background
    protected void doGet() {
        Saying saying = client.get(editTextName.getText().toString());
        displaySaying(saying);
    }

    @Click(R.id.buttonPost)
    protected void buttonPost() {
        doPost();
    }

    @Background
    protected void doPost() {
        Saying saying = client.post(editTextName.getText().toString(),
                editTextAddress.getText().toString());
        displaySaying(saying);
    }

    @UiThread
    protected void displaySaying(Saying saying) {
        textViewReply.setText(saying.getContent());
        textViewId.setText(String.valueOf(saying.getId()));
    }
}
