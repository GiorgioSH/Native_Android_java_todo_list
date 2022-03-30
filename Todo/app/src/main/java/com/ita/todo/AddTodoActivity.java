package com.ita.todo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTodoActivity extends AppCompatActivity {

    public static final String KEY_RESULT = "question";
    EditText etName = null;
    Button btnAdd = null;
    Button btnCancel = null;
    Spinner spUrgency = null;
    Context context = null;
    String temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int duration = Toast.LENGTH_SHORT;
        context = getApplicationContext();

        spUrgency = (Spinner)findViewById(R.id.spUrgency);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnCancel =(Button)findViewById(R.id.btnCancel);
        etName = (EditText)findViewById(R.id.etName);

        String[] arrayTodo = new String[]{
                "low",
                "medium",
                "high"
        };
        final List<String> arrayTodoList = new ArrayList<>(Arrays.asList(arrayTodo));

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,arrayTodoList);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spUrgency.setAdapter(spinnerArrayAdapter);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo todo = new Todo();
                //spUrgency.getSelectedItem().toString();
                //temp = etName.getText().toString();
                todo.setUrgency(spUrgency.getSelectedItem().toString());
                todo.setName(etName.getText().toString());

                CharSequence text = "NOM DE TODO OK !";
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                TodoDAO todoDAO = new TodoDAO(getApplicationContext());


                todoDAO.add(todo);
                finish();

                //arrayTodoList.add("Apple");
                //spinnerArrayAdapter.notifyDataSetChanged();
            }

        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo.setUrgency("");
                //todo.setName("");
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}