package com.ita.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder>{

    private List<Todo> todos;
    private OnItemClickListener onItemClickListener;

    public class TodoViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName;
        public TextView tvUrgency;

        public TodoViewHolder(View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvUrgency = itemView.findViewById(R.id.tvUrgency);
        }
    }

    public TodoAdapter(List<Todo> todos, OnItemClickListener onItemClickListener) {
        this.todos = todos;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.tvName.setText(todo.getName());
        holder.tvUrgency.setText(todo.getUrgency());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(todo);
                }
            }
        });
    }

    @Override
    public int getItemCount() { return todos.size();}

    public interface OnItemClickListener {
        void onItemClick(Todo item);
    }
}
