package com.example.aplicacionmercadoa;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;


/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//                                            //
//                                            //
//                                            //
////////////////////////////////////////////////


public class MemoNivelDificil extends AppCompatActivity {
    private ImageButton e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20;
    Button iniciar , salir , pausar , reiniciar , siguiente;
    int imagenes[];

    ImageButton[] botonera = new ImageButton[20];

    int fondo;

    ArrayList<Integer> arrayBarajado;

    ImageButton primero;

    int numeroPrimero , numeroSegundo;

    boolean bloqueo = false;

    final Handler handler = new Handler();

    int aciertos = 0 ;

    int puntuacion = 0;

    TextView textoPuntuacion , cronometro;

    //Cronometro
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;

    //Sonido
    MediaPlayer sonido , sonidoperder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_nivel_dificil);
        iniciar = (Button) findViewById(R.id.IniciarJuego);
        salir = (Button) findViewById(R.id.SalirJuego);
        chronometer = (Chronometer) findViewById(R.id.Crono);
        sonido = MediaPlayer.create(this,R.raw.sonidovictoria);
        siguiente = (Button) findViewById(R.id.Siguiente);
        sonidoperder = MediaPlayer.create(this,R.raw.sonidoperder);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 100000){
                    PauseChronometer();
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    AlertDialog.Builder builder = new AlertDialog.Builder(MemoNivelDificil.this);
                    sonidoperder.start();
                    //builder.setTitle(" ¿ Deseas Salir de Figuras Pares ?");
                    //builder.setMessage(" Has Ganado !!");
                    builder.setView(R.layout.dialogo_perdedor);
                    builder.setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            iniciar();
                        }
                    });
                    builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MemoNivelDificil.this ,NivelesMemorama.class);
                            startActivity(i);
                            finish();
                        }
                    });
                    Dialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MemoNivelDificil.this);
                builder.setTitle(" ¿ Deseas Salir de Figuras Pares ?");
                //builder.setMessage("");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(MemoNivelDificil.this , NivelesMemorama.class);
                        startActivity(i);
                        finish();
                    }
                });
                builder.setNegativeButton("No",null);
                Dialog dialog = builder.create();
                dialog.show();
            }
        });

        CargarImagenes();
    }

    public void StartChronometer(){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void PauseChronometer(){
        if(running){
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void ResetChronometer(){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    public void CargarImagenes(){
        imagenes = new int []{
                R.drawable.simba,
                R.drawable.timon_pumba,
                R.drawable.escar,
                R.drawable.timon,
                R.drawable.leona,
                R.drawable.timonypumba,
                R.drawable.nacimiento_simba,
                R.drawable.hienas,
                R.drawable.zira,
                R.drawable.simba1,
        };
        fondo = R.drawable.fondoblanco;
    }

    public ArrayList<Integer> barajar(int longitud) {
        ArrayList resultadoA = new ArrayList<Integer>();
        for(int i=0; i<longitud; i++)
            resultadoA.add(i % longitud/2);
        Collections.shuffle(resultadoA);
        return  resultadoA;
    }

    public void cargarBotones(){
        e1 = (ImageButton) findViewById(R.id.imageView1);
        botonera[0] = e1;
        e2 = (ImageButton) findViewById(R.id.imageView2);
        botonera[1] = e2;
        e3 = (ImageButton) findViewById(R.id.imageView3);
        botonera[2] = e3;
        e4 = (ImageButton) findViewById(R.id.imageView4);
        botonera[3] = e4;
        e5 = (ImageButton) findViewById(R.id.imageView5);
        botonera[4] = e5;
        e6 = (ImageButton) findViewById(R.id.imageView6);
        botonera[5] = e6;
        e7 = (ImageButton) findViewById(R.id.imageView7);
        botonera[6] = e7;
        e8 = (ImageButton) findViewById(R.id.imageView8);
        botonera[7] = e8;
        e9 = (ImageButton) findViewById(R.id.imageView9);
        botonera[8] = e9;
        e10 = (ImageButton) findViewById(R.id.imageView10);
        botonera[9] = e10;
        e11 = (ImageButton) findViewById(R.id.imageView11);
        botonera[10] = e11;
        e12 = (ImageButton) findViewById(R.id.imageView12);
        botonera[11] = e12;
        e13 = (ImageButton) findViewById(R.id.imageView13);
        botonera[12] = e13;
        e14 = (ImageButton) findViewById(R.id.imageView14);
        botonera[13] = e14;
        e15 = (ImageButton) findViewById(R.id.imageView15);
        botonera[14] = e15;
        e16 = (ImageButton) findViewById(R.id.imageView16);
        botonera[15] = e16;
        e17 = (ImageButton) findViewById(R.id.imageView17);
        botonera[16] = e17;
        e18 = (ImageButton) findViewById(R.id.imageView18);
        botonera[17] = e18;
        e19 = (ImageButton) findViewById(R.id.imageView19);
        botonera[18] = e19;
        e20 = (ImageButton) findViewById(R.id.imageView20);
        botonera[19] = e20;
        textoPuntuacion = (TextView)findViewById(R.id.Aciertos);
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }

    public void comprobar(int i, final ImageButton imgb){
        if(primero==null){//ningún botón ha sido pulsado
            //el botón primero será el que acabamos de pulsar
            primero = imgb;
        /*le asignamos la imagen del vector imágenes situada
        en la posición arrayBarajado.get(i), con un valor entre 0 y 7*/
            primero.setScaleType(ImageView.ScaleType.FIT_XY);
            primero.setImageResource(imagenes[arrayBarajado.get(i)]);
            //bloqueamos el botón
            primero.setEnabled(false);
            //almacenamos el valor de arrayBarajado[i]
            numeroPrimero=arrayBarajado.get(i);
        }else{//ya hay un botón descubierto
            //bloqueamos todos los demás
            bloqueo=true;
            //el botón segundo será el que acabamos de pulsar
        /*le asignamos la imagen del vector imágenes situada
        en la posición arrayBarajado.get(i), con un valor entre 0 y 7*/
            imgb.setScaleType(ImageView.ScaleType.FIT_XY);
            imgb.setImageResource(imagenes[arrayBarajado.get(i)]);
            //bloqueamos el botón
            imgb.setEnabled(false);
            //almacenamos el valor de arrayBarajado.get(i)
            numeroSegundo=arrayBarajado.get(i);
            if(numeroPrimero==numeroSegundo){//si coincide el valor los dejamos   destapados
                //reiniciamos
                primero=null;
                bloqueo=false;
                //aumentamos los aciertos y la puntuación
                aciertos++;
                puntuacion++;
                textoPuntuacion.setText("Puntuación: " + puntuacion);
                //al llegar a 8 aciertos se ha ganado el juego
                if(aciertos == 10){
                    PauseChronometer();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MemoNivelDificil.this);
                    sonido.start();
                    //builder.setTitle(" ¿ Deseas Salir de Figuras Pares ?");
                    //builder.setMessage(" Has Ganado !!");
                    builder.setView(R.layout.dialogo_ganador);
                    builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MemoNivelDificil.this , NivelesMemorama.class);
                            startActivity(i);
                            finish();
                        }
                    });
                    builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MemoNivelDificil.this ,PaginaJuego.class);
                            startActivity(i);
                            finish();
                        }
                    });
                    Dialog dialog = builder.create();
                    dialog.show();

                    //Toast toast = Toast.makeText(getApplicationContext(), "Has  ganado!!", Toast.LENGTH_LONG);
                    //toast.show();
                }
            }else{//si NO coincide el valor los volvemos a tapar al cabo de un segundo
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //les ponemos la imagen de fondo
                        primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        primero.setImageResource(R.drawable.interrogacion);
                        imgb.setScaleType(ImageView.ScaleType.CENTER);
                        imgb.setImageResource(R.drawable.interrogacion);
                        //los volvemos a habilitar
                        primero.setEnabled(true);
                        imgb.setEnabled(true);
                        //reiniciamos la variables auxiliares
                        primero = null;
                        bloqueo = false;
                        //restamos uno a la puntuación
                        /*if (puntuacion > 0) {
                            puntuacion--;
                            textoPuntuacion.setText("Puntuación: " + puntuacion);
                        }*/
                    }
                }, 1000);//al cabo de un segundo
            }
        }
    }

    public void iniciar(){
        StartChronometer();
        arrayBarajado = barajar(imagenes.length*2);
        cargarBotones();

        //MOSTRAMOS LA IMAGEN
        for(int i=0; i<botonera.length; i++) {
            botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(imagenes[arrayBarajado.get(i)]);
        }

        //Y EN UN SEGUNDO LA OCULTAMOS
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < botonera.length; i++) {
                    botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    botonera[i].setImageResource(fondo);
                }
            }
        }, 2000);

        //AÑADIMOS LOS EVENTOS A LOS BOTONES DEL JUEGO
        for(int i=0; i <arrayBarajado.size(); i++){
            final int j=i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!bloqueo)
                        comprobar(j, botonera[j]);
                }
            });
        }
        aciertos=0;
        puntuacion=0;
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }



}