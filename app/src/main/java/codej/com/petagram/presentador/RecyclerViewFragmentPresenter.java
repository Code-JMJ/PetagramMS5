package codej.com.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import codej.com.petagram.db.ConstructorMascotas;
import codej.com.petagram.model.Mascota;
import codej.com.petagram.vista.IRecyclerViewFragmentView;
import codej.com.petagram.vista.RecyclerViewFragment;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private String opcion;

    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context, String opcion) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        this.opcion = opcion;
        obtenerContactos(opcion);
    }

    @Override
    public void obtenerContactos(String opcion) {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos(opcion);
        mostrarContactosRV();
    }


    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
