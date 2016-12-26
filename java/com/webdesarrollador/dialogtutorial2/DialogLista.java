package com.webdesarrollador.dialogtutorial2;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by raulrevillas on 26/12/2016.
 */

public class DialogLista extends DialogFragment {

    //Definimos la interfaz
    public interface ItemListener {
        void onItemSelect(String inputText);
    }
    ItemListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Checkeamos que la actividad contenedora haya implementado la interfaz. Si no, lanzamos una excepción
        try {
            // Instanciamos el listener, para poder enviar eventos a la activity
            listener = (ItemListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +" debe implementar ItemListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Elementos de la lista
        final String[] items = {"Pop", "Dance", "Rock"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Opciones")
            .setItems(items, new DialogInterface.OnClickListener() {
                //Al hacer clik sobre cualquier item, lanzaremos un evento que ejecutará el método onItemSelect
                public void onClick(DialogInterface dialog, int which) {

                    listener.onItemSelect(items[which]);

                }
            });
        return builder.create();
    }
}