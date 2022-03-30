package com.ita.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Serializable {

    public static final String KEY_TODO = "todo";
    Context context = null;
    TextView tvDipslay = null;

    private static final String TODOLIST_KEY = "TODOLIST_KEY";
    private List<Todo> todos = new ArrayList<>();
    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.todo :
                Intent intent = new Intent(context, AddTodoActivity.class);

                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.recyclerview_main);

        //tvDipslay = findViewById(R.id.tvDisplay);
        context = getApplicationContext();
        recyclerView = findViewById(R.id.rvTodo);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        //if(savedInstanceState != null){
            //todos = savedInstanceState.getParcelableArrayList(TODOLIST_KEY);
            //todoAdapter = new TodoAdapter(todos);
            //recyclerView.setAdapter(todoAdapter);
        //}

    }

    @Override
    protected void onStart() {
        super.onStart();

        TodoDAO todoDao = new TodoDAO(this);
        //String temp = "";
        //tvDipslay.setText("");
        List<Todo> todos = todoDao.list();
        TodoAdapter todoAdapter = new TodoAdapter(todos, new TodoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Todo item) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("todo", item);

                startActivity(intent);
            }
        });
        recyclerView.setAdapter(todoAdapter);
        //for (Todo todo : todos) {
            //Log.d("Request", todo.getName());
            //tvDipslay.append("\n" + todo.getName() + ":" +todo.getUrgency());
            //temp += String.format(" %s / %s\n",todo.getName(),todo.getUrgency());
        //}
        //tvDipslay.setText(temp);

    }
}