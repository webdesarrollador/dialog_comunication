package com.webdesarrollador.dialogtutorial2;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements DialogLista.ItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLista (View view) {
        DialogFragment newFragment = new DialogLista();
        newFragment.show(getSupportFragmentManager(), "dialogoLista");
    }
    public void onItemSelect(String seleccionado){
        Log.d("seleccion",seleccionado);
    }

}
