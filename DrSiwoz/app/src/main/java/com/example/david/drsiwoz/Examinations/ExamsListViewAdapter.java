package com.example.david.drsiwoz.Examinations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Examination;
import com.example.david.drsiwoz.R;

import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class ExamsListViewAdapter extends ArrayAdapter{
    private final Context context;
    private final List<Examination> values;
    final Integer doneColor = getContext().getResources().getColor(android.R.color.holo_green_light);
    final Integer progressColor = getContext().getResources().getColor(android.R.color.holo_red_light);


    public ExamsListViewAdapter(Context context, List<Examination> values) {
        super(context, R.layout.exam_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.exam_list_item, parent, false);


        TextView descTextView = (TextView) rowView.findViewById(R.id.doctorNameTextView);
        TextView docNameTextView = (TextView) rowView.findViewById(R.id.examinationDescriptionTextView);
        TextView createdTextView = (TextView) rowView.findViewById(R.id.examinationDateTextView);
        TextView statusTextView = (TextView) rowView.findViewById(R.id.examinationStatusTextView);
        Examination exam = values.get(position);
        descTextView.setText(exam.getDescription());
        docNameTextView.setText(String.valueOf(exam.getDoctorName()));
        createdTextView.setText(String.valueOf(exam.getCreated()));
        statusTextView.setText(String.valueOf(exam.getStatus()));




        if (exam.getStatus() == "Done"){
            statusTextView.setBackgroundColor(doneColor);
        }
        if (exam.getStatus() == "InProgress"){
            statusTextView.setBackgroundColor(progressColor);
        }




        return rowView;
    }
}
