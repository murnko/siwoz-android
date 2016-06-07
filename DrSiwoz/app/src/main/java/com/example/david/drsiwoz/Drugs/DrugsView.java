package com.example.david.drsiwoz.Drugs;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Serving;

import java.util.List;

/**
 * Created by jacek on 25.05.16.
 */
public interface DrugsView {
    void showDrugsList(List<Serving> servings);
    void displayGetDrugsError();
}
