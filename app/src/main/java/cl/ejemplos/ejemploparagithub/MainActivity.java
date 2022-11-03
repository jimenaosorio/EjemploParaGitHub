package cl.ejemplos.ejemploparagithub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import cl.ejemplos.ejemploparagithub.modelo.Medicion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGuardar=(Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(view);
            }
        });
    }
    public void guardar(View view)
    {
        EditText identificador=(EditText) findViewById(R.id.identificador);
        int iden=Integer.parseInt(identificador.getText().toString());
        EditText etFecha=(EditText) findViewById(R.id.fecha);
        String fecha=etFecha.getText().toString();
        EditText valor=(EditText) findViewById(R.id.valor);
        int val=Integer.parseInt(valor.getText().toString());

        Medicion datos=new Medicion(iden,fecha,val);
        DatabaseReference ref=FirebaseDatabase.getInstance("https://ejemploparagithub-default-rtdb.firebaseio.com/").getReference("datos");

        ref.setValue(datos);



        identificador.setText("");
        etFecha.setText("");
        valor.setText("");
        Toast.makeText(this,"OK",Toast.LENGTH_SHORT).show();

        //Leer
        ValueEventListener medicionListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Medicion medicion= snapshot.getValue(Medicion.class);
                Toast.makeText(MainActivity.this, medicion.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this,error.toException().toString(),Toast.LENGTH_SHORT).show();
            }
        };
        ref.addValueEventListener(medicionListener);
    }
}