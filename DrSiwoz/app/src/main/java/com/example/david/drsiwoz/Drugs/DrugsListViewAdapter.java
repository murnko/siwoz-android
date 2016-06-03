package com.example.david.drsiwoz.Drugs;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.david.drsiwoz.MainActivity;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.R;


import java.util.List;

/**
 * Created by jacek on 26.05.16.
 */
public class DrugsListViewAdapter extends ArrayAdapter<Drug> {
    private final Context context;
    private final List<Drug> values;
    private Button applyButton;
    final Integer appliedColor = getContext().getResources().getColor(android.R.color.holo_green_light);
    final Integer canceledColor = getContext().getResources().getColor(android.R.color.holo_red_light);
    final Integer waitingColor = getContext().getResources().getColor(android.R.color.holo_blue_bright);

    public DrugsListViewAdapter(Context context, List<Drug> values) {
        super(context, R.layout.drug_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.drug_list_item, parent, false);


        TextView drugNameTextView = (TextView) rowView.findViewById(R.id.drugNameTextView);
        TextView drugDosageTextView = (TextView) rowView.findViewById(R.id.drugDosageTextView);
        TextView drugUnitTextView = (TextView) rowView.findViewById(R.id.drugUnitTextView);
        Drug drug = values.get(position);
        drugNameTextView.setText(drug.getName());
        drugDosageTextView.setText(String.valueOf(drug.getDosage()));
        drugUnitTextView.setText(drug.getUnit());



        if (drug.getApplied().booleanValue()){
            drugNameTextView.setBackgroundColor(appliedColor);
            drugDosageTextView.setBackgroundColor(appliedColor);
            drugUnitTextView.setBackgroundColor(appliedColor);
        }

        if (drug.getCanceled().booleanValue()){
            drugNameTextView.setBackgroundColor(canceledColor);
            drugDosageTextView.setBackgroundColor(canceledColor);
            drugUnitTextView.setBackgroundColor(canceledColor);
        }

        if (drug.getAccepted().booleanValue()){
            drugNameTextView.setBackgroundColor(canceledColor);
            drugDosageTextView.setBackgroundColor(canceledColor);
            drugUnitTextView.setBackgroundColor(canceledColor);
        }


        return rowView;
    }
}
