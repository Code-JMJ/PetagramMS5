package codej.com.petagram.vista;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import codej.com.petagram.R;
import codej.com.petagram.adapter.MascotaAdaptador;
import codej.com.petagram.db.ConstantesBaseDatos;
import codej.com.petagram.model.Mascota;
import codej.com.petagram.presentador.IRecyclerViewFragmentPresenter;
import codej.com.petagram.presentador.RecyclerViewFragmentPresenter;

public class MascotaFavoritaFragment extends AppCompatActivity implements IRecyclerViewFragmentView {

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotasFav;
    private RecyclerViewFragmentPresenter presenter;
    private Toolbar toolbar;

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMasFavoritas);
        presenter = new RecyclerViewFragmentPresenter(this,this, ConstantesBaseDatos.MASCOTAS_FAV);

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotasFav.setAdapter(adaptador);
    }

}