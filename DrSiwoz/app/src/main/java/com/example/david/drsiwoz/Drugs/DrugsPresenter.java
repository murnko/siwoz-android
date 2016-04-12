package com.example.david.drsiwoz.Drugs;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.REST.ApiProvider;
import com.example.david.drsiwoz.REST.RequestResult;

import java.util.List;

import retrofit2.Call;

/**
 * Created by david on 2016-03-19.
 */
public class DrugsPresenter {
    private DrugsView view;

    public DrugsPresenter(DrugsView view){
        this.view = view;
    }

    public List<Drug> onUpdateButtonClick() throws Exception {
        Call<List<Drug>> call = ApiProvider.getApi().getDrugs();
        List<Drug> drugs = call.execute().body();
        view.updateDrugsList(drugs);
        return drugs;
    }

    public void onAddButtonClick(int id, String name, int dose, String unit) throws Exception {
        Call<RequestResult> call = ApiProvider.getApi().setDrugs( id,  name,  dose,  unit);
        RequestResult result = call.execute().body();
        view.addDrugsResult(result);
    }

    public void onDeleteButtonClick(int id) throws Exception {
        Call<RequestResult> call = ApiProvider.getApi().deleteDrugs(id);
        RequestResult result = call.execute().body();
        view.deleteDrugsResult(result);
    }
}
