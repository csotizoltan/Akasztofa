package com.example.akasztofa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
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


    private int betu, hp, containChar, missingCHar;

    private Random rnd = new Random();
    private int randomSzo  = rnd.nextInt(words.length);

    private String[] array;
    private String hyphen;
    private List<Character> usedChar = new ArrayList<Character>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        NewGame();


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (betu == chars.length - 1) {
                    betu = 0;
                } else {
                    betu++;
                }

                tvCharacter.setText("" + chars[betu]);

                for (int i = 0; i < usedChar.size(); i++) {
                    if (usedChar.contains(chars[betu])) {
                        tvCharacter.setTextColor(getResources().getColor(R.color.colorBlack));
                    }
                    else {
                        tvCharacter.setTextColor(getResources().getColor(R.color.colorOrange));
                    }
                }
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (betu == 0) {
                    betu = chars.length - 1;
                } else {
                    betu--;
                }

                tvCharacter.setText("" + chars[betu]);

                for (int i = 0; i < usedChar.size(); i++) {
                    if (usedChar.contains(chars[betu])) {
                        tvCharacter.setTextColor(getResources().getColor(R.color.colorBlack));
                    } else {
                        tvCharacter.setTextColor(getResources().getColor(R.color.colorOrange));
                    }
                }
            }
        });


        btnTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCharacter.setTextColor(getResources().getColor(R.color.colorBlack));
                usedChar.add(tvCharacter.getText().charAt(0));

                for (int i = 0; i < words[randomSzo ].length(); i++) {
                    if (tvCharacter.getText().charAt(0) == words[randomSzo ].charAt(i)) {
                        array[i] = tvCharacter.getText().toString();
                        tvResult.setText(onSreen(array, array.length));
                        containChar++;
                    }
                }

                if (containChar == 0) {
                    hp--;

                    switch (hp) {
                        case 0: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa13);
                            EndGame(false);
                            break;
                        }
                        case 1: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa12);
                            break;
                        }
                        case 2: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa11);
                            break;
                        }
                        case 3: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa10);
                            break;
                        }
                        case 4: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa09);
                            break;
                        }
                        case 5: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa08);
                            break;
                        }
                        case 6: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa07);
                            break;
                        }
                        case 7: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa06);
                            break;
                        }
                        case 8: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa05);
                            break;
                        }
                        case 9: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa04);
                            break;
                        }
                        case 10: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa03);
                            break;
                        }
                        case 11: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa02);
                            break;
                        }
                        case 12: {
                            imgGallowsImage.setBackgroundResource(R.drawable.akasztofa01);
                            break;
                        }
                    }
                }

                containChar = 0;
                missingCHar = 0;

                for (int i = 0; i < words[randomSzo ].length(); i++) {
                    if (array[i].equals("_")) {
                        missingCHar++;
                    }
                }


                if (missingCHar == 0) {
                    EndGame(true);
                }
            }
        });
    }


    public String[] HyphenArray(int asd) {
        String hyphen[] = new String[asd];

        for (int i = 0; i < asd; i++) {
            hyphen[i] = "_";
        }

        return hyphen;
    }


    public String onSreen(String[] array, int asd) {
        String hyphen = "";

        for (int i = 0; i < asd; i++) {
            hyphen += " " + array[i];
        }

        hyphen += " ";

        return hyphen;
    }


    public void NewGame() {
        betu = 0;
        randomSzo  = rnd.nextInt(words.length);
        hp = 13;
        containChar = 0;

        usedChar.clear();

        imgGallowsImage.setBackgroundResource(R.drawable.akasztofa00);

        array = HyphenArray(words[randomSzo ].length());
        hyphen = onSreen(array, words[randomSzo ].length());

        tvResult.setText(hyphen);
        tvCharacter.setText("" + chars[betu]);
        tvCharacter.setTextColor(getResources().getColor(R.color.colorOrange));

        // Csak teszteléshez --> Megjeleníti a random gyűmölcs nevét
        //Toast.makeText(getApplicationContext(), words[randomSzo ], Toast.LENGTH_LONG).show();
    }


    private void EndGame(boolean isSucesss) {

        AlertDialog.Builder AlertEndGame = new AlertDialog.Builder(this);

        if (isSucesss == true) {
            AlertEndGame.setTitle(Html.fromHtml(getString(R.string.msgSuccess))); // "Helyes megfejtés!"
        }
        else {
            AlertEndGame.setTitle(Html.fromHtml(getString(R.string.msgEndGame))); // "Nem sikerült kitalálni!"
        }

        AlertEndGame.setCancelable(false).setMessage("Szeretnél még egyet játszani?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); //System.exit(0);
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NewGame();
                    }
                });

        AlertEndGame.create().show();
    }


    private void init() {
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnTip = findViewById(R.id.btnTip);

        imgGallowsImage = findViewById(R.id.imgGallowsImage);

        tvCharacter = findViewById(R.id.tvCharacter);
        tvResult = findViewById(R.id.tvResult);
    }
}