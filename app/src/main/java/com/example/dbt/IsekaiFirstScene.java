package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class IsekaiFirstScene extends AppCompatActivity {

    int track = 0;
    int c1Id;
    int c2Id;
    int c3Id;
    int c4Id;
    String playerName;
    Status status = new Status();
    private ImageView viewEDice;
    private ImageView viewCDice;
    private ImageView background;
    private ImageView eImage;
    private ImageView cImage;
    private TextView cHPTxt;
    private TextView eHPTxt;
    private TextView scenario;
    int minA = 1;
    int maxA = 6;
    int characterHP;
    int enemyHP;
    int eDamage;
    int cDamage;
    int turncounter = 0;
    int battleCounter = 0;
    int battleEnds = 0;
    int attackBonus = 0;
    static int IsekScore;
    MediaPlayer backgroundmusic2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.isekai_first_scene);

       /* backgroundmusic2 = MediaPlayer.create(this,R.raw.maintheme_david_renda);
        backgroundmusic2.setLooping(true);
        backgroundmusic2.start();
*/
        Intent action4 = getIntent();

        c1Id = action4.getIntExtra("c1", R.drawable.b);
        c2Id = action4.getIntExtra("c2", R.drawable.b_attack);
        c3Id = action4.getIntExtra("c3", R.drawable.b_die);
        c4Id = action4.getIntExtra("c4", R.drawable.b_win);
        playerName = action4.getStringExtra("c5");

        viewCDice =findViewById(R.id.cDice);
        viewEDice =findViewById(R.id.eDice);
        background = findViewById(R.id.exImage1);
        eHPTxt = findViewById(R.id.eHPTxt);
        cHPTxt = findViewById(R.id.cHPTxt);
        scenario = findViewById(R.id.scenarioTxt);
        eImage = findViewById(R.id.imageView7);
        cImage = findViewById(R.id.imageView6);
        cImage.setImageResource(c1Id);

        viewEDice.setVisibility(View.INVISIBLE);
        viewCDice.setVisibility(View.INVISIBLE);

        scenario.setText("Player must click their dice on the left to roll random damage to the enemy. \n Once your turn is done, click the CONTINUE button for the enemy's turn. \n Then, after their turn is done, it is your's again. \n HP is viewed under each dice. \n If your health goes below 0, you lose \n You win the battle if enemy's HP goes to 0 \nClick on next then press on your dice to attack!");
        background.setImageResource(R.drawable.sceneone);
        eImage.setImageResource(R.drawable.goblin);

        enemyHP = 12;
        characterHP = 20;
//        cHPTxt.setText("Your HP is " + characterHP);
//        eHPTxt.setText("Enemies HP is " + enemyHP);
        eHPTxt.setVisibility(View.INVISIBLE);
        cHPTxt.setVisibility(View.INVISIBLE);

        ImageView IskaiFirstSceneSettings = findViewById(R.id.firstSceneSettings);
        backgroundmusic2 = MediaPlayer.create(this.getApplicationContext(), R.raw.maintheme_david_renda);
        try { backgroundmusic2.prepareAsync(); } catch (Exception prep) {prep.printStackTrace(); }
        IskaiFirstSceneSettings.setOnClickListener(v -> {
            SettingMenu set = new SettingMenu();
            set.showWindow(IsekaiFirstScene.this, IskaiFirstSceneSettings, backgroundmusic2);
        });
    }

    public void cClick(View v) {
        Button con = findViewById(R.id.con);
        con.setVisibility(View.VISIBLE);
        if (battleEnds == battleCounter){
            if (turncounter % 2 == 0) {
                System.out.println("cHP is " + characterHP);
                if (characterHP > 0) {
                    int randomNum = diceRoll(minA, maxA);
                    System.out.println(randomNum);

                    switch (randomNum) {
                        case 1:
                            viewCDice.setImageResource(R.drawable.dice1);
                            break;
                        case 2:
                            viewCDice.setImageResource(R.drawable.dice2);
                            break;
                        case 3:
                            viewCDice.setImageResource(R.drawable.dice3);
                            break;
                        case 4:
                            viewCDice.setImageResource(R.drawable.dice4);
                            break;
                        case 5:
                            viewCDice.setImageResource(R.drawable.dice5);
                            break;
                        case 6:
                            viewCDice.setImageResource(R.drawable.dice6);
                            break;
                        default:

                    }

                    cDamage = randomNum + attackBonus;
                    enemyHP = enemyHP - cDamage;
                    if(attackBonus == 0){
                        scenario.setText("you did " + randomNum +  " attack damage. \n It is now the enemies turn.");
                    }
                    else{
                        scenario.setText("you did " + randomNum + " + " + attackBonus + " (" + (attackBonus + randomNum) + ") attack damage. \n It is now the enemies turn.");
                    }

                    cImage.setImageResource(c2Id);
                    eHPTxt.setText("Enemies HP is " + enemyHP);
                    if (enemyHP <= 0) {
                        eImage.setVisibility(View.INVISIBLE);
                        cImage.setImageResource(c4Id);
                        Button next = (Button) findViewById(R.id.nextB);
                        next.setVisibility(View.VISIBLE);
                        if(battleCounter == 4){
                            scenario.setText("you won the battle!\nThe creature seems to dissolve into a mist and gets absorbed by your sword. You suddenly feel stronger.\nYou gain +2 attack damage!!!\nClick next to continue story.");
                            attackBonus = 3;
//                            Button con = findViewById(R.id.con);
                            con.setVisibility(View.INVISIBLE);
                        }
                        else if(battleCounter == 5){
                            scenario.setText("You beat the Demon Lord and the world is saved. A strange voice calls out\n'Thank you great hero for your service. The world is in your debt. Now that your adventure has come to an end, would you like to return to your previous life?\nYou reply 'Nope I rather stay and be a hero'\nGAME OVER!!");
                            ImageView finalWin = findViewById(R.id.imageView8);
                            finalWin.setImageResource(c4Id);
                            finalWin.setVisibility(View.VISIBLE);
                            eImage.setVisibility(View.INVISIBLE);
                            cImage.setVisibility(View.INVISIBLE);
                            Button gameOver = findViewById(R.id.gameOver);
                            gameOver.setVisibility(View.VISIBLE);
                            next.setVisibility(View.INVISIBLE);
                            viewCDice.setVisibility(View.INVISIBLE);
                            viewEDice.setVisibility(View.INVISIBLE);
                            eHPTxt.setVisibility(View.INVISIBLE);
                            cHPTxt.setVisibility(View.INVISIBLE);
                        }
                        else{
                            scenario.setText("you won the battle!\nClick next to continue story.");
                        }
                        battleEnds++;
                        battleCounter++;
//                        Button con = (Button) findViewById(R.id.con);
                        con.setVisibility(View.INVISIBLE);
                    }
                }
                turncounter++;
            } else {
                scenario.setText("it's not your turn!\nClick on CONTINUE!!!!!");
            }
        }
    }

    public void eClick(View v) {
        Button con = findViewById(R.id.con);
        con.setVisibility(View.INVISIBLE);
        if (battleEnds == battleCounter) {
            if (turncounter % 2 == 1) {
                System.out.println("eHP is " + enemyHP);

                if (enemyHP > 0) {
                    cImage.setImageResource(c1Id);
                    int randomNum = diceRoll(minA, maxA);
                    System.out.println(randomNum);

                    switch (randomNum) {
                        case 1:
                            viewEDice.setImageResource(R.drawable.dice1);
                            break;
                        case 2:
                            viewEDice.setImageResource(R.drawable.dice2);
                            break;
                        case 3:
                            viewEDice.setImageResource(R.drawable.dice3);
                            break;
                        case 4:
                            viewEDice.setImageResource(R.drawable.dice4);
                            break;
                        case 5:
                            viewEDice.setImageResource(R.drawable.dice5);
                            break;
                        case 6:
                            viewEDice.setImageResource(R.drawable.dice6);
                            break;
                        default:
                            ;
                    }
                    eDamage = randomNum;
//                System.out.println();

                    characterHP = characterHP - eDamage;
                    scenario.setText("enemy did " + randomNum + " damage. \n It is now your turn");
                    cHPTxt.setText("Your HP is " + characterHP);
                    if (characterHP <= 0) {
                        if(battleCounter == 5){
                            scenario.setText("The Demon Lord speaks\n'Puny human you never stood a chance, you WEEB'.\n Click on quit or try again");
                        }
                        else{
                            scenario.setText("You dead bro \n Click on quit or try again");
                        }
                        cImage.setImageResource(c3Id);
                        Button tryAgain = (Button) findViewById(R.id.tryAgain);
                        Button quit = (Button) findViewById(R.id.quit);
//                        Button con = (Button) findViewById(R.id.con);
                        tryAgain.setVisibility(View.VISIBLE);
                        quit.setVisibility(View.VISIBLE);
                        con.setVisibility(View.INVISIBLE);
                        battleEnds = 1;
                    }
                }
                turncounter++;
            } else {
                scenario.setText("It is your turn, dummy");
            }
        }
    }

    public void nextClick(View v ){
        eHPTxt.setVisibility(View.VISIBLE);
        cHPTxt.setVisibility(View.VISIBLE);
        viewCDice.setVisibility(View.VISIBLE);
        viewEDice.setVisibility(View.VISIBLE);
        turncounter = 0;

        if(battleCounter == 0){
            eImage.setVisibility(View.VISIBLE);
            Button next = (Button) findViewById(R.id.nextB);
            next.setVisibility(View.INVISIBLE);
            characterHP = 20;
            enemyHP = 12;
            cHPTxt.setText("Your HP is " + characterHP);
            eHPTxt.setText("Enemies HP is " + enemyHP);
            IsekScore += characterHP;
        }
        else if(battleCounter == 1) {
            eImage.setVisibility(View.VISIBLE);
            Button next = (Button) findViewById(R.id.nextB);
            next.setVisibility(View.INVISIBLE);


            characterHP = 25;
            enemyHP = 16;

            scenario.setText("You travel further ahead on your adventure. As you travel, the trees get thicker and your surroundings grow a bit darker. In the distance you find a homely cottage. A old woman can be seen standing in front of the cottage.  \n'Hello, small child, care for a pie?' \nShe holds up a pie, but it smells like poison. \n'Oh? What's wrong kiddo?' She says.\n 'Don't you want some? I guess I'll have to force you' as she lunges at you");

            background.setImageResource(R.drawable.scenetwo);
            eImage.setImageResource(R.drawable.meemaw);
            cImage.setImageResource(c1Id);

            cHPTxt.setText("Your HP is " + characterHP);
            eHPTxt.setText("Enemies HP is " + enemyHP);
            IsekScore += characterHP;

        }
        else if(battleCounter == 2){
            eImage.setVisibility(View.VISIBLE);
            Button next = (Button) findViewById(R.id.nextB);
            next.setVisibility(View.INVISIBLE);


            characterHP = 30;
            enemyHP = 21;

            scenario.setText("You must enter the cave to find your way to the castle.\nUnfortunately there is a rabbit that looks like it will blow up . . . .from emotional stress.\nKnock him unconscious and relieve him of his stress.");

            background.setImageResource(R.drawable.scenethree);
            eImage.setImageResource(R.drawable.zac);
            cImage.setImageResource(c1Id);

            cHPTxt.setText("Your HP is " + characterHP);
            eHPTxt.setText("Enemies HP is " + enemyHP);
            IsekScore += characterHP;
        }
        else if(battleCounter == 3){
            eImage.setVisibility(View.VISIBLE);
            Button next = (Button) findViewById(R.id.nextB);
            next.setVisibility(View.INVISIBLE);

            characterHP = 35;
            enemyHP = 27;

            scenario.setText("Look there is danger up ahead.\nIt is going to take more than your shoe to kill this spider.\nDon't worry, the giant arachnid still hasn't seen you.\nEven if it has eight eyes.\nDumb Spider.\nYou go and sneak attack it.");

            background.setImageResource(R.drawable.scenefour);
            eImage.setImageResource(R.drawable.sam);
            cImage.setImageResource(c1Id);

            cHPTxt.setText("Your HP is " + characterHP);
            eHPTxt.setText("Enemies HP is " + enemyHP);
            IsekScore += characterHP;
        }
        else if(battleCounter == 4){
            eImage.setVisibility(View.VISIBLE);
            Button next = (Button) findViewById(R.id.nextB);
            next.setVisibility(View.INVISIBLE);


            characterHP = 40;
            enemyHP = 35;

            scenario.setText("As you continue, you notice a strange energy all around. A strange figure appear in front of you saying\n'You have gone to far. Now, I will take care of you for I am the Darkness'\nYou cleverly say\n'Lucky for me, I was never afraid of the Dark.");

            background.setImageResource(R.drawable.scenefive);
            eImage.setImageResource(R.drawable.dark);
            cImage.setImageResource(c1Id);

            cHPTxt.setText("Your HP is " + characterHP);
            eHPTxt.setText("Enemies HP is " + enemyHP);
            IsekScore += characterHP;
        }
        else if(battleCounter == 5){
            eImage.setVisibility(View.VISIBLE);
            Button next = (Button) findViewById(R.id.nextB);
            next.setVisibility(View.INVISIBLE);


            characterHP = 48;
            enemyHP = 80;


            scenario.setText("Ah, " + playerName + ", so you're the hero that has been a pain to me for the last couple of levels.\nWell that ends now puny human. I'll send you into the next Isekai." );

            background.setImageResource(R.drawable.scenesix);
            eImage.setImageResource(R.drawable.demon_lord);
            cImage.setImageResource(c1Id);

            cHPTxt.setText("Your HP is " + characterHP);
            eHPTxt.setText("Enemies HP is " + enemyHP);
            IsekScore += characterHP;
            status.setIsekaiScore(IsekScore);
        }
    }

    public void tryAgainClick(View v ){
        turncounter = 0;
        battleEnds = battleCounter;
        Button quit = findViewById(R.id.quit);
        Button tryAgain = findViewById(R.id.tryAgain);
        Button next = findViewById(R.id.nextB);
        quit.setVisibility(View.INVISIBLE);
        tryAgain.setVisibility(View.INVISIBLE);
        next.setVisibility(View.VISIBLE);

        scenario.setText("Welcome Back, ready to try again?\nClick next");
    }

    public void gMClick(View v){
        Intent gM = new Intent(IsekaiFirstScene.this, IsekaiGameOver.class);
        gM.putExtra("c5",playerName);
        backgroundmusic2.stop();
        startActivity(gM);
    }

    public void quitClick(View v){
        finishAffinity();
    }

    public void fakeCick(View v){

    }

    public static int diceRoll(int min, int max){
        Random randomNum = new Random();
        return randomNum.nextInt((max - min) + 1) + min;
    }
}