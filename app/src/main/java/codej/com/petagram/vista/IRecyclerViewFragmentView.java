package codej.com.petagram.vista;

import java.util.ArrayList;

import codej.com.petagram.adapter.MascotaAdaptador;
import codej.com.petagram.model.Mascota;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
