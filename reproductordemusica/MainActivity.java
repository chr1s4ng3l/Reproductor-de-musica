package google.tamayo.christopher.reproductordemusica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button playPause, btnRepetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

        MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playPause = (Button)findViewById(R.id.btn_play);
        btnRepetir = (Button)findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView);

        vectormp [0]=MediaPlayer.create(this, R.raw.dany);
        vectormp [1]=MediaPlayer.create(this, R.raw.joey);
        vectormp [2]=MediaPlayer.create(this, R.raw.maluma);
    }
    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            playPause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            playPause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Reproducir", Toast.LENGTH_SHORT).show();
        }
    }
    public void Stop(View view){
        if(vectormp[posicion]!=null){

            vectormp[posicion].stop();

            vectormp [0]=MediaPlayer.create(this, R.raw.dany);
            vectormp [1]=MediaPlayer.create(this, R.raw.joey);
            vectormp [2]=MediaPlayer.create(this, R.raw.maluma);
            posicion=0;
            playPause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();

        }
    }
    public void Repetir(View view){
        if (repetir == 1){
            btnRepetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;

        }else{
            btnRepetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir=1;
        }
    }
    public void Siguiente(View view){
        if (posicion < vectormp.length-1){

            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);

                }else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);

                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }else{
                posicion++;
                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);

                }else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);

                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }
        }else{

            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void anterior(View view){
        if (posicion >=1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp [0]=MediaPlayer.create(this, R.raw.dany);
                vectormp [1]=MediaPlayer.create(this, R.raw.joey);
                vectormp [2]=MediaPlayer.create(this, R.raw.maluma);
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);

                }else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);

                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
                vectormp[posicion].start();

            }else {
                posicion--;
                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);

                }else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);

                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }

            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();

        }
    }
}
