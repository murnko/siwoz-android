package com.example.david.drsiwoz.Drugs;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.REST.RequestResult;

import java.util.List;

/**
 * Created by david on 2016-03-19.
 */
public interface DrugsView {
    void updateDrugsList(List<Drug> drugs);
    void addDrugsResult(RequestResult result);
    void deleteDrugsResult(RequestResult result);
}
