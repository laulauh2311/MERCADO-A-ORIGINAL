package com.example.aplicacionmercadoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Dialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class PagoCompra extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mReference;

    EditText NumeroTarjeta,FechaTarjeta,Codigo,Nombre;

    private String Numero="";
    private String Fecha="";
    private String CodigoTarjeta="";
    private String NombrePropietario="";


    Button pagar;
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID="NO";
    private final static int NOTIFICACION_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_compra);
        pagar = (Button) findViewById(R.id.Pagar);

        NumeroTarjeta = (EditText) findViewById(R.id.NumeroTarjeta);
        FechaTarjeta = (EditText) findViewById(R.id.FechaTarjeta);
        Codigo = (EditText)findViewById(R.id.CVI);
        Nombre = (EditText) findViewById(R.id.NombreTarjeta);


        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Numero = NumeroTarjeta.getText().toString();
                Fecha = FechaTarjeta.getText().toString();
                CodigoTarjeta = Codigo.getText().toString();
                NombrePropietario = Nombre.getText().toString();

                if(!Numero.isEmpty() && !Fecha.isEmpty() && !CodigoTarjeta.isEmpty() && !NombrePropietario.isEmpty()){
                    if(Numero.length() <= 12 && CodigoTarjeta.length() <= 3 ){
                        registerUser();
                        AlertDialog.Builder builder = new AlertDialog.Builder(PagoCompra.this);
                        builder.setTitle("Compra de Productos");
                        builder.setView(R.layout.dialogo_pago);
                        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //createNotification();
                                Intent i = new Intent(PagoCompra.this , PaginaHome.class);
                                startActivity(i);
                                finish();
                                createNotification();
                            }
                        });
                        Dialog dialog = builder.create();
                        dialog.show();
                        Toast.makeText(PagoCompra.this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                        //Intent i = new Intent(RegistrodeClientes.this , LoginActivity.class);
                        //startActivity(i);
                        //finish();
                    }else{
                        Toast.makeText(PagoCompra.this,"Corriga hay datos erroneos",Toast.LENGTH_SHORT).show();

                    }


                }else{
                    Toast.makeText(PagoCompra.this,"Debe Llenar todos los Campos",Toast.LENGTH_SHORT).show();

                }
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

    public void registerUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("Numero de Tarjeta", Numero);
        map.put("Fecha de Caducidad", Fecha);
        map.put("CVI", CodigoTarjeta);
        map.put("Nombre Propietario", NombrePropietario);
        mReference.child("Compra de Productos").setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task2) {
                if(task2.isSuccessful()){
                    //startActivity(new Intent(RegistrodeClientes.this,Principal.class));
                    //Intent i = new Intent(RegistrodeClientes.this , Principal.class);
                    //startActivity(i);
                    //finish();
                }else{
                    Toast.makeText(PagoCompra.this,"No se pudieron crear los datos correctamente",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}