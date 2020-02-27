package com.example.tourist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ServicesAdapter  extends  RecyclerView.Adapter<ServicesAdapter.ServiceViewHolder>{

    List<ProvidedServices> servicesList;
    Context context;
    DatabaseReference servProvDbReference;
    ServProvider servProvider;
    SessionManager sessionManager;

    public ServicesAdapter(List<ProvidedServices> servicesList, Context context){
        this.servicesList = servicesList;
        this.context = context;
        this.servProvDbReference = FirebaseDatabase.getInstance().getReference(context.getString(R.string.servProviderTable));
        this.sessionManager = new SessionManager(context);
    }
    public ServicesAdapter(List<ProvidedServices> servicesList, Context context, ServProvider servProvider){
        this.servicesList = servicesList;
        this.context = context;
        this.servProvDbReference = FirebaseDatabase.getInstance().getReference(context.getString(R.string.servProviderTable));
        this.servProvider = servProvider;
        this.sessionManager = new SessionManager(context);
    }
    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.service_item_layout, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ServiceViewHolder holder, int position) {
        final ProvidedServices service = servicesList.get(position);
        if (service== null)
            return;
        holder.serviceNameTxt.setText(service.getServiceName());
        holder.servicePaymentTxt.setText(service.getServicePayment());
        holder.serviceOpenCloseTimeTxt.setText( getNextOpenCloseTimeTxt(service));
        holder.serviceStatusSwitch.setChecked(service.getIsAvailable());

        holder.serviceStatusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, final boolean b) {
                if (servProvider == null){
                    ServProvider provider = sessionManager.getServiceProvider();
                    if (provider!=null)
                        servProvider = provider;
                    else return;
                }
                final List<ProvidedServices> services = servProvider.getServicesList();
                for (ProvidedServices ser : services){
                    if (ser.getServiceName().equals(service.getServiceName())){
                        ser.setIsAvailable(b);
                    }
                }
                servProvDbReference.child(extractUsername()).child("servicesList").setValue(services).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(context, "Service edited successfully", Toast.LENGTH_SHORT).show();
                                    servProvider.setServicesList(services);
                                    sessionManager.clearSession();
                                    sessionManager.createSession(servProvider);
                                    service.setIsAvailable(b);
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(context, "Could not edit service. Try again later", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    private String getNextOpenCloseTimeTxt(ProvidedServices service) {
        Calendar today = Calendar.getInstance();
        Date now = today.getTime();
        if (service.getServicenextUpTime() == null || service.getServicenextUpTime().isEmpty()
        || service.getServiceNextDownTime() == null || service.getServiceNextDownTime().isEmpty()){
            return "";
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(context.getString(R.string.default_date_format));
            Date serviceStartTime = sdf.parse(service.getServicenextUpTime());
            Date serviceEndTime = sdf.parse(service.getServiceNextDownTime());

            if ( now.after(serviceStartTime) ){
                if ( now.before(serviceEndTime) ){
                    return "Closes on " + service.getServiceNextDownTime();
                }else{
                    return "Currently Closed";
                }
            }else{
                return "Opens on " + service.getServicenextUpTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public int getItemCount() {
        return servicesList.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        TextView serviceNameTxt, serviceOpenCloseTimeTxt, servicePaymentTxt;
        Switch serviceStatusSwitch;
        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceNameTxt = itemView.findViewById(R.id.service_name_txt);
            serviceOpenCloseTimeTxt = itemView.findViewById(R.id.service_opening_closing_time);
            servicePaymentTxt = itemView.findViewById(R.id.service_payment_txt);
            serviceStatusSwitch = itemView.findViewById(R.id.service_status_switch);
        }
    }
    private String extractUsername(){
        String username = servProvider.getEmail().split("@")[0];
        username.replace(".", "");
        return username;
    }
}
