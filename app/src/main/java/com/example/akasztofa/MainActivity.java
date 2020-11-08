package com.example.akasztofa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnPlus, btnMinus, btnTip;
    private ImageView imgGallowsImage;
    private TextView tvCharacter, tvResult;


    private String[] words = {"ALMA", "KORTE", "CITROM", "BANAN", "SZILVA", "CSERESZNYE", "DINNYE",
            "EPER", "RIBIZLI", "SZOLO"};

    /*private String[] words = {"ALMA", "KÖRTE", "CITROM", "BANÁN", "SZILVA", "CSERESZNYE", "DINNYE",
            "EPER", "RIBIZLI", "SZŐLŐ"};*/

    private Character[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /*private Character[] chars = {'A', 'Á', 'B', 'C', 'D', 'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J', 'K', 'L', 'M', 'N',
            'O', 'Ó', 'Ö', 'Ő', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'Ü', 'Ű', 'V', 'W', 'X', 'Y', 'Z'};*/


    private Random rnd = new Random();
    private int randomSzo = rnd.nextInt(words.length);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    private void init() {
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnTip = (Button) findViewById(R.id.btnTip);

        imgGallowsImage = (ImageView) findViewById(R.id.imgGallowsImage);

        tvCharacter = (TextView) findViewById(R.id.tvCharacter);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }
}