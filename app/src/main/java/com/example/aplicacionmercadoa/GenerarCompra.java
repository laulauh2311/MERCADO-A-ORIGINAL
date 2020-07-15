package com.example.aplicacionmercadoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GenerarCompra extends AppCompatActivity {
    TextView Nombres , Apellidos , email , Distrito,Total;
    EditText Direccion;
    private FirebaseAuth mAuth;
    private DatabaseReference mReference;
    private Button comprar , efectivo;
    ScrollView pago;

    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID="NO";
    private final static int NOTIFICACION_ID=0;

    NotificationCompat.Builder notificacion;
    private static final int idUnica = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_compra);
        Nombres = (TextView) findViewById(R.id.NombreCompra);
        Apellidos = (TextView) findViewById(R.id.ApellidosCompra);
        email = (TextView) findViewById(R.id.EmailCompra);
        Total = (TextView) findViewById(R.id.TotalCompra);
        Distrito = (TextView) findViewById(R.id.DistritoCompra);
        comprar = (Button) findViewById(R.id.GenerarCompra);
        Direccion = (EditText) findViewById(R.id.DireccionCompra);
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();
        pago = (ScrollView) findViewById(R.id.scrollView3);
        efectivo = (Button) findViewById(R.id.Efectivo);

        getUserInfo();


        Total.setText("Precio:" + getIntent().getDoubleExtra("Total ",6.0) + " nuevos soles");


        notificacion = new NotificationCompat.Builder(this);
        notificacion.setAutoCancel(true);


        Intent intent = new Intent(this,PaginaPerfil.class);
        intent.putExtra("Direccion",Direccion.getText().toString());


        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pago.setVisibility(View.VISIBLE);
            }
        });

        efectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GenerarCompra.this);
                builder.setTitle("Compra de Productos");
                builder.setView(R.layout.dialogo_pagoefectivo);
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Creacion de la Notificacion
                        notificacion.setSmallIcon(R.drawable.dineroenefectivo);
                        notificacion.setPriority(Notification.PRIORITY_HIGH);
                        notificacion.setTicker("Nueva Notificacion");
                        notificacion.setWhen(System.currentTimeMillis());
                        notificacion.setContentTitle("Mercadoña");
                        notificacion.setContentText("Tu Pedido esta siendo preparado para ser enviado");
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        nm.notify(idUnica,notificacion.build());

                        // Redireccionamiento a otra Activity
                        Intent i = new Intent(GenerarCompra.this , PaginaHome.class);
                        startActivity(i);
                        finish();
                    }
                });

                // Metodo para crear un Dialogo
                Dialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    // Metodo para mostrar los datos de un cliente
    private void getUserInfo() {
        String id = mAuth.getCurrentUser().getUid();
        mReference.child("Clientes").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String Nombre = dataSnapshot.child("Nombres").getValue().toString();
                    String Apellido = dataSnapshot.child("Apellidos").getValue().toString();
                    String Email = dataSnapshot.child("Correo Electronico").getValue().toString();
                    String Distritos = dataSnapshot.child("Distrito").getValue().toString();
                    //String DireccionDomicilio = dataSnapshot.child("Direccion").getValue().toString();

                    Nombres.setText("Nombres: " + Nombre);
                    Apellidos.setText("Apellidos: " + Apellido);
                    email.setText("Email: " + Email);
                    Distrito.setText("Distrito: " + Distritos);
                    //Direccion.setText("Direccion: " + DireccionDomicilio);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_cart);
        builder.setContentTitle("Notificacion de Mercadoña");
        builder.setContentText("Tu Pedido a sido aceptado y esta siendo preparado");
        builder.setColor(Color.BLUE);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA,100,100);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID,builder.build());
    }

    public void Pagar(View view){
        switch (view.getId()){
            case R.id.Efectivo:
                //startActivity(new Intent(GenerarCompra.this,PagoCompra.class));
                break;
            case R.id.Scotiabank:
                startActivity(new Intent(GenerarCompra.this,PagoCompra.class));
                break;
            case R.id.BCP:
                startActivity(new Intent(GenerarCompra.this,PagoCompra.class));
                break;
            case R.id.Interbank:
                startActivity(new Intent(GenerarCompra.this,PagoCompra.class));
                break;
            case R.id.CajaArequipa:
                startActivity(new Intent(GenerarCompra.this,PagoCompra.class));
                break;
            case R.id.BancoNacion:
                startActivity(new Intent(GenerarCompra.this,PagoCompra.class));
                break;
        }
    }
}