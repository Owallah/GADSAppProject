package com.mulutu.gadsprojectone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProjectSubmitActivity extends AppCompatActivity {

    Toolbar toolbar;

    private EditText _firstName;
    private EditText _lastName;
    private EditText _email;
    private EditText _githubLink;
    private Button _btnSubmitFarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prepareToolbar();

        prepareView();
    }

    private void prepareToolbar() {
        // Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void prepareView() {
        _firstName = (EditText) findViewById(R.id.firstName);
        _lastName = (EditText) findViewById(R.id.lastName);
        _email = (EditText) findViewById(R.id.email);
        _githubLink = (EditText) findViewById(R.id.githubLink);
        _btnSubmitFarm = (Button) findViewById(R.id.btnSubmitFarm);
        _btnSubmitFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //submitFarm();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ProjectSubmitActivity.this, MainActivity.class );
        startActivity(intent);
        finish();
    }
}