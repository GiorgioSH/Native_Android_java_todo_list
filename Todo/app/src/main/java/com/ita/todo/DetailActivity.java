package com.ita.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetail = findViewById(R.id.tvDetail);

        Intent intent = getIntent();
        Todo todo = (Todo)intent.getParcelableExtra("todo");

        tvDetail.setText(String.format("%d - %s - %s", todo.getId(), todo.getName(), todo.getUrgency()));
    }
}