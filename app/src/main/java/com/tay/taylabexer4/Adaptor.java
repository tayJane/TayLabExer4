package com.tay.taylabexer4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adaptor extends ArrayAdapter<Company> {
    Context comCont;
    int comRes;


    public Adaptor(@NonNull Context context, int resource, @NonNull List<Company> objects) {
        super(context, resource, objects);
        comCont = context;
        comRes = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getComLogo();
        String companyNames = getItem(position).getComName();
        String companyCountries = getItem(position).getComCoun();
        String companyIndustries = getItem(position).getComIndus();
        String companyCEOs = getItem(position).getComCEO();

        LayoutInflater inflater = LayoutInflater.from(comCont);
        convertView = inflater.inflate(comRes, parent, false);

        TextView tvName = convertView.findViewById(R.id.textView);
        TextView tvCountry = convertView.findViewById(R.id.textView2);
        TextView tvIndustry = convertView.findViewById(R.id.textView3);
        TextView tvCEO = convertView.findViewById(R.id.textView4);
        ImageView ivLogo = convertView.findViewById(R.id.imageView);

        ivLogo.setImageResource(image);
        tvName.setText(companyNames);
        tvCountry.setText(companyCountries);
        tvIndustry.setText(companyIndustries);
        tvCEO.setText(companyCEOs);

        return convertView;
    }
}

