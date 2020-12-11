package codej.com.petagram.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import codej.com.petagram.R;
import codej.com.petagram.adapter.MascotaAdaptador;
import codej.com.petagram.db.ConstantesBaseDatos;
import codej.com.petagram.model.Mascota;
import codej.com.petagram.presentador.IRecyclerViewFragmentPresenter;
import codej.com.petagram.presentador.RecyclerViewFragmentPresenter;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext(), ConstantesBaseDatos.MASCOTAS_T);
        return v;
    }



    /*
    public void inicializarDatos(){
        contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.candy_icon, "Anahi Salgado", "77779999", "anahi@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.yammi_banana_icon, "Pedro Sanchez", "88882222", "pedro@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.shock_rave_bonus_icon, "Mireya Lopez", "33331111", "mireya@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.forest_mushroom_icon, "Juan Lopez", "44442222", "juan@gmail.com", likes));

    }*/


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }
}
