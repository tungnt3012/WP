package com.example.weatherprojecttt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherprojecttt.Fragments.Fragment_Hour;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.ViewHolder> {

    private Fragment_Hour context;
    private ArrayList<Hourly> hourlies;

    public HourlyAdapter(Fragment_Hour context, ArrayList<Hourly> hourlies){
        this.context = context;
        this.hourlies = hourlies;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtHour, txtTemperature, txtFeeling, txtHumidity;

        public ViewHolder(View itemView) {
            super(itemView);
            txtHour = itemView.findViewById(R.id.txtHour);
            txtTemperature = itemView.findViewById(R.id.txtTemperature);
            txtFeeling = itemView.findViewById(R.id.txtFeel);
            txtHumidity = itemView.findViewById(R.id.txtHumidity);
        }
    }

    @Override
    public HourlyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context.getActivity());
        View hourlyView = inflater.inflate(R.layout.hourly_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(hourlyView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourlyAdapter.ViewHolder holder, int position) {
        Hourly hourly = hourlies.get(position);
        holder.txtHour.setText(hourly.getHour());
        holder.txtTemperature.setText(hourly.getTemperature());
        holder.txtFeeling.setText(hourly.getFeeling());
        holder.txtHumidity.setText(hourly.getHumidity());
    }

    @Override
    public int getItemCount() {
        return hourlies.size();
    }

}
