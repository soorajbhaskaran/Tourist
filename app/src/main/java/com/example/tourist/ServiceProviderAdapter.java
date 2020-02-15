package com.example.tourist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ServiceProviderAdapter extends  RecyclerView.Adapter<ServiceProviderAdapter.ProviderAdapter>{

    Context context;
    List<ServProvider> servProviderList;

    public ServiceProviderAdapter(List<ServProvider> servProviderList, Context context){

        this.servProviderList = servProviderList;
        this.context = context;
    }
    @NonNull
    @Override
    public ProviderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.service_provider_item, parent, false);
        return new ProviderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProviderAdapter holder, int position) {
        final ServProvider servProvider = servProviderList.get(position);
        holder.servProviderItemSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ServProviderHomeActivity.class);
                intent.putExtra("email", servProvider.getEmail());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return servProviderList.size();
    }

    public class ProviderAdapter extends RecyclerView.ViewHolder {
        LinearLayout servProviderItemSec;
        public ProviderAdapter(@NonNull View itemView) {
            super(itemView);
            servProviderItemSec = itemView.findViewById(R.id.serviceProviderItemSec);
        }
    }
}
