package codej.com.petagram.vista;

import android.app.Activity;
        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import java.util.ArrayList;

import codej.com.petagram.R;
import codej.com.petagram.adapter.MascotaAdaptador;
import codej.com.petagram.model.Mascota;


public class PerfilFragment extends  Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaPerfiles;
    Activity actividad;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaPerfiles = (RecyclerView) v.findViewById(R.id.rvPerfil);

        listaPerfiles.setLayoutManager(new GridLayoutManager(this.actividad,3));
        listaPerfiles.setHasFixedSize(true);



        inicializarListaMascotas();
        inicializarlistaAdaptador();
        return v;
    }

    public void inicializarlistaAdaptador(){
        MascotaAdaptador madaptador = new MascotaAdaptador(mascotas, getActivity());
        listaPerfiles.setAdapter(madaptador);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));
        mascotas.add(new Mascota( R.drawable.mascota5, "caty", 4));

    }


}