package com.example.david.drsiwoz.TileMenu;


/**
 * Created by david on 2016-03-19.
 */
public class TileMenuPresenter {
    private TileMenuView view;

    public TileMenuPresenter(TileMenuView view){
        this.view = view;
    }

//    public Patient onUpdateButtonClick() throws Exception {
//        Call<Patient> call = ApiProvider.getApi().getPatient();
//        Patient patient = call.execute().body();
//        view.updatePatient(patient);
//        return patient;
//    }
//
//    public void onAddButtonClick(int id, String name, int dose, String unit) throws Exception {
//        Call<RequestResult> call = ApiProvider.getApi().setDrugs( id,  name,  dose,  unit);
//        RequestResult result = call.execute().body();
//        view.addPatientsResult(result);
//    }
//
//    public void onDeleteButtonClick(int id) throws Exception {
//        Call<RequestResult> call = ApiProvider.getApi().deletePatient(id);
//        RequestResult result = call.execute().body();
//        view.deletePatientsResult(result);
//    }
}
