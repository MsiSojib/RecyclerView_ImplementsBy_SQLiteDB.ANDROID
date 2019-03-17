package com.example.sirajulislamsojib.recyclerviewfromsqlitedb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<DataModel> getData;
    Context context;

    public CustomAdapter(Context context,ArrayList<DataModel> getData) {
        this.context = context;
        this.getData = getData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sampleview_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_Id.setText(getData.get(i).getId());
        myViewHolder.tv_Name.setText(getData.get(i).getName());
        myViewHolder.tv_Text.setText(getData.get(i).getText());

    }

    @Override
    public int getItemCount() {
        return getData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_Id, tv_Name, tv_Text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Id = itemView.findViewById(R.id.tv_id);
            tv_Name = itemView.findViewById(R.id.tv_name);
            tv_Text = itemView.findViewById(R.id.tv_text);
        }
    }
}
