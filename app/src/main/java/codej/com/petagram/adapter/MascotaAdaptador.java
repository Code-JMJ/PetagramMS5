package codej.com.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import codej.com.petagram.DetalleMascota;
import codej.com.petagram.R;
import codej.com.petagram.db.ConstructorMascotas;
import codej.com.petagram.model.Mascota;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.ContactoViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }



    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        contactoViewHolder.imgFoto.setImageResource(mascota.getFoto());
        contactoViewHolder.tvNombre.setText(mascota.getNombre());
        contactoViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()) + " " + activity.getString(R.string.likes));

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("nombre", mascota.getNombre());
                activity.startActivity(intent);

            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeCotnacto(mascota);
                contactoViewHolder.tvLikes.setText(constructorMascotas.obtenerLikesContacto(mascota) + " " + activity.getString(R.string.likes));


            }
        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
