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

        Button applyButton = (Button) rowView.findViewById(R.id.applyBtn);
        applyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getContext();
                activity.onScanInitiated(21);


            }
        });
        return rowView;
    }
}
