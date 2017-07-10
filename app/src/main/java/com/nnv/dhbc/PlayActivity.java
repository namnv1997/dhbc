package com.nnv.dhbc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.nnv.dhbc.R.*;

/**
 * Created by NamNv on 01/03/2017.
 */


public class PlayActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    private TextView numbers_heart;
    private TextView coin;
    private String TAG = PlayActivity.class.getSimpleName();
    private LinearLayout lnlAnswer1;
    private LinearLayout lnlAnswer2;
    private ImageView imgsrc;
    private Button btnDefault1;
    private Button btnDefault2;
    private Button btnDefault3;
    private Button btnDefault4;
    private Button btnDefault5;
    private Button btnDefault6;
    private Button btnDefault7;
    private Button btnDefault8;
    private Button btnDefault9;
    private Button btnDefault10;
    private Button btnDefault11;
    private Button btnDefault12;
    private Button btnDefault13;
    private Button btnDefault14;
    private Button btnDefault15;
    private Button btnDefault16;
    private List<Character> charactersAnswer;
    private List<Button> buttonsDefault;
    protected Button[] btn;
    private int count = 0;
    private int img = 0;
    private List<String> ans;
    private ImageView btnNext;
    private ImageView btnRetry;
    private Thread thread;
    private int heart = 5;
    private int coinnn = 0;
    private LinearLayout lnlDF;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.main_layout);
        initViews();
        initClicks();
        modulGame();
    }

    public static char RandomCharacter() {
        char x;
        List<Character> characters;
        characters = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            characters.add((char) i);
        }
        Random rd = new Random();
        int index = rd.nextInt(characters.size());
        x = characters.get(index);
        return x;
    }

    private void initClicks() {
        btnDefault1.setOnClickListener(this);
        btnDefault2.setOnClickListener(this);
        btnDefault3.setOnClickListener(this);
        btnDefault4.setOnClickListener(this);
        btnDefault5.setOnClickListener(this);
        btnDefault6.setOnClickListener(this);
        btnDefault7.setOnClickListener(this);
        btnDefault8.setOnClickListener(this);
        btnDefault9.setOnClickListener(this);
        btnDefault10.setOnClickListener(this);
        btnDefault11.setOnClickListener(this);
        btnDefault12.setOnClickListener(this);
        btnDefault13.setOnClickListener(this);
        btnDefault14.setOnClickListener(this);
        btnDefault15.setOnClickListener(this);
        btnDefault16.setOnClickListener(this);
    }

    private void initViews() {
        numbers_heart = (TextView) findViewById(id.numbers_play);
        coin = (TextView) findViewById(id.numbers_coin);
        coin.setText(coinnn+"");
        numbers_heart.setText(heart+"");
        imgsrc = (ImageView) findViewById(id.img_src);
        lnlAnswer1 = (LinearLayout) findViewById(id.lnl_answer1);
        lnlAnswer2 = (LinearLayout) findViewById(id.lnl_answer2);

        btnDefault1 = (Button) findViewById(id.btn_default_1);
        btnDefault2 = (Button) findViewById(id.btn_default_2);
        btnDefault3 = (Button) findViewById(id.btn_default_3);
        btnDefault4 = (Button) findViewById(id.btn_default_4);
        btnDefault5 = (Button) findViewById(id.btn_default_5);
        btnDefault6 = (Button) findViewById(id.btn_default_6);
        btnDefault7 = (Button) findViewById(id.btn_default_7);
        btnDefault8 = (Button) findViewById(id.btn_default_8);
        btnDefault9 = (Button) findViewById(id.btn_default_9);
        btnDefault10 = (Button) findViewById(id.btn_default_10);
        btnDefault11 = (Button) findViewById(id.btn_default_11);
        btnDefault12 = (Button) findViewById(id.btn_default_12);
        btnDefault13 = (Button) findViewById(id.btn_default_13);
        btnDefault14 = (Button) findViewById(id.btn_default_14);
        btnDefault15 = (Button) findViewById(id.btn_default_15);
        btnDefault16 = (Button) findViewById(id.btn_default_16);
        btnNext = (ImageView) findViewById(id.btn_next);
        btnRetry = (ImageView) findViewById(id.btn_retry);
        lnlDF = (LinearLayout) findViewById(id.buttons_default);

        buttonsDefault = new ArrayList<>();
        buttonsDefault.add(btnDefault1);
        buttonsDefault.add(btnDefault2);
        buttonsDefault.add(btnDefault3);
        buttonsDefault.add(btnDefault4);
        buttonsDefault.add(btnDefault5);
        buttonsDefault.add(btnDefault6);
        buttonsDefault.add(btnDefault7);
        buttonsDefault.add(btnDefault8);
        buttonsDefault.add(btnDefault9);
        buttonsDefault.add(btnDefault10);
        buttonsDefault.add(btnDefault11);
        buttonsDefault.add(btnDefault12);
        buttonsDefault.add(btnDefault13);
        buttonsDefault.add(btnDefault14);
        buttonsDefault.add(btnDefault15);
        buttonsDefault.add(btnDefault16);


    }

    private void modulGame() {
        ans = new ArrayList<>();
        ans.add("BAOCAO");
        ans.add("AOMUA");
        ans.add("CATTUONG");
        ans.add("CANTHIEP");
        ans.add("CHIEUTRE");
        ans.add("DANONG");
        ans.add("DANHLUA");
        ans.add("GIANDIEP");
        ans.add("GIANGMAI");
        ans.add("HOIDONG");
        ans.add("HONGTAM");
        ans.add("KIEMCHUYEN");
        ans.add("LANGBEN");
        ans.add("LANCAN");
        ans.add("MASAT");
        ans.add("NAMBANCAU");
        ans.add("OTO");
        ans.add("QUYHANG");
        ans.add("SONGSONG");
        ans.add("TICHPHAN");
        ans.add("TOHOAI");
        ans.add("TOTIEN");
        ans.add("THATTINH");
        ans.add("THOTHE");
        ans.add("TRANHTHU");
        ans.add("VUAPHALUOI");
        ans.add("VUONBACHTHU");
        ans.add("XAKEP");
        ans.add("XAPHONG");
        ans.add("XEDAPDIEN");
        thread = new Thread(this);
        thread.start();
    }

    private void imgSrc(int x) {
        switch (x) {
            case 0:
                imgsrc.setBackgroundResource(drawable.baocao);
                getAnswer(ans.get(0));
                break;
            case 1:
                imgsrc.setBackgroundResource(drawable.aomua);
                getAnswer(ans.get(1));
                break;
            case 2:
                imgsrc.setBackgroundResource(drawable.cattuong);
                getAnswer(ans.get(2));
                break;
            case 3:
                imgsrc.setBackgroundResource(drawable.canthiep);
                getAnswer(ans.get(3));
                break;
            case 4:
                imgsrc.setBackgroundResource(drawable.chieutre);
                getAnswer(ans.get(4));
                break;
            case 5:
                imgsrc.setBackgroundResource(drawable.danong);
                getAnswer(ans.get(5));
                break;
            case 6:
                imgsrc.setBackgroundResource(drawable.danhlua);
                getAnswer(ans.get(6));
                break;
            case 7:
                imgsrc.setBackgroundResource(drawable.giandiep);
                getAnswer(ans.get(7));
                break;
            case 8:
                imgsrc.setBackgroundResource(drawable.giangmai);
                getAnswer(ans.get(8));
                break;
            case 9:
                imgsrc.setBackgroundResource(drawable.hoidong);
                getAnswer(ans.get(9));
                break;
            case 10:
                imgsrc.setBackgroundResource(drawable.hongtam);
                getAnswer(ans.get(10));
                break;
            case 11:
                imgsrc.setBackgroundResource(drawable.kiemchuyen);
                getAnswer(ans.get(11));
                break;
            case 12:
                imgsrc.setBackgroundResource(drawable.khoailang);
                getAnswer(ans.get(12));
                break;
            case 13:
                imgsrc.setBackgroundResource(drawable.lancan);
                getAnswer(ans.get(13));
                break;
            case 14:
                imgsrc.setBackgroundResource(drawable.masat);
                getAnswer(ans.get(14));
                break;
            case 15:
                imgsrc.setBackgroundResource(drawable.nambancau);
                getAnswer(ans.get(15));
                break;
            case 16:
                imgsrc.setBackgroundResource(drawable.oto);
                getAnswer(ans.get(16));
                break;
            case 17:
                imgsrc.setBackgroundResource(drawable.quyhang);
                getAnswer(ans.get(17));
                break;
            case 18:
                imgsrc.setBackgroundResource(drawable.songsong);
                getAnswer(ans.get(18));
                break;
            case 19:
                imgsrc.setBackgroundResource(drawable.tichphan);
                getAnswer(ans.get(19));
                break;
            case 20:
                imgsrc.setBackgroundResource(drawable.tohoai);
                getAnswer(ans.get(20));
                break;
            case 21:
                imgsrc.setBackgroundResource(drawable.totien);
                getAnswer(ans.get(21));
                break;
            case 22:
                imgsrc.setBackgroundResource(drawable.thattinh);
                getAnswer(ans.get(22));
                break;
            case 23:
                imgsrc.setBackgroundResource(drawable.thothe);
                getAnswer(ans.get(23));
                break;
            case 24:
                imgsrc.setBackgroundResource(drawable.tranhthu);
                getAnswer(ans.get(24));
                break;
            case 25:
                imgsrc.setBackgroundResource(drawable.vuaphaluoi);
                getAnswer(ans.get(25));
                break;
            case 26:
                imgsrc.setBackgroundResource(drawable.vuonbachthu);
                getAnswer(ans.get(26));
                break;
            case 27:
                imgsrc.setBackgroundResource(drawable.xakep);
                getAnswer(ans.get(27));
                break;
            case 28:
                imgsrc.setBackgroundResource(drawable.xaphong);
                getAnswer(ans.get(28));
                break;
            case 29:
                imgsrc.setBackgroundResource(drawable.xedapdien);
                getAnswer(ans.get(29));
                break;
            default:
                break;
        }
    }
    private void check(String ans, int num){
        String x = "";
        if(num == ans.length()){
            for(int i = 0; i < num; i++){
                x += btn[i].getText().toString();
            }
        }
        if(count == ans.length()) {
            lnlDF.setVisibility(View.INVISIBLE);
            if (x.equals(ans)) {
                for(int i = 0; i < num; i++){
                    btn[i].setBackgroundResource(drawable.tile_true);
                    btnNext.setBackgroundResource(drawable.next);
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(this);
                }

            }else {
                for(int i = 0; i < num; i++){
                    btn[i].setBackgroundResource(drawable.tile_false);
                    btnRetry.setBackgroundResource(drawable.retry);
                    btnRetry.setVisibility(View.VISIBLE);
                    btnRetry.setOnClickListener(this);
                }
            }
        }
    }
    private void getAnswer(String answer){
        int n = answer.length();
        btn = new Button[n];
        for (int i = 0; i < n; i++) {
            btn[i] = new Button(this);
            btn[i].setBackgroundResource(R.drawable.tile_nothing);
            if (i < 5) {
                lnlAnswer1.addView(btn[i]);
            }else {
                lnlAnswer2.addView(btn[i]);
            }
        }
        charactersAnswer = new ArrayList<>();
        for(int i = 0; i < answer.length(); i++){
            charactersAnswer.add(answer.charAt(i));
        }
        RandomAnswer(charactersAnswer);
    }

    public void RandomAnswer(List listA){
        int size = listA.size();
        Random rd = new Random();
        for (int i = 0; i < 16 - size; i++){
            listA.add(RandomCharacter());
        }
        for(int i = 0; i < 16; i++) {
            if(listA.size()>0) {
                int index = rd.nextInt(listA.size());
                char ch = (char) listA.get(index);
                listA.remove(index);
                buttonsDefault.get(i).setText(ch + "");
            }else {
                return ;
            }
        }

    }

    @Override
    public void onClick(View view) {
        int index = img;
        switch (view.getId()) {
            case id.btn_default_1:
                String ch1 = btnDefault1.getText().toString();
                btn[count].setText(ch1);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault1.setVisibility(View.INVISIBLE);
                count++;
                System.out.println(count);
                check(ans.get(img), count);
                Log.d(TAG, "12345");
                break;
            case id.btn_default_2:
                String ch2 = btnDefault2.getText().toString();
                btn[count].setText(ch2);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault2.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_3:
                String ch3 = btnDefault3.getText().toString();
                btn[count].setText(ch3);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault3.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_4:
                String ch4 = btnDefault4.getText().toString();
                btn[count].setText(ch4);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault4.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_5:
                String ch5 = btnDefault5.getText().toString();
                btn[count].setText(ch5);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault5.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_6:
                String ch6 = btnDefault6.getText().toString();
                btn[count].setText(ch6);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault6.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_7:
                String ch7 = btnDefault7.getText().toString();
                btn[count].setText(ch7);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault7.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_8:
                String ch8 = btnDefault8.getText().toString();
                btn[count].setText(ch8);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault8.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_9:
                String ch9 = btnDefault9.getText().toString();
                btn[count].setText(ch9);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault9.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_10:
                String ch10 = btnDefault10.getText().toString();
                btn[count].setText(ch10);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault10.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_11:
                String ch11 = btnDefault11.getText().toString();
                btn[count].setText(ch11);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault11.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_12:
                String ch12 = btnDefault12.getText().toString();
                btn[count].setText(ch12);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault12.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_13:
                String ch13 = btnDefault13.getText().toString();
                btn[count].setText(ch13);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault13.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_14:
                String ch14 = btnDefault14.getText().toString();
                btn[count].setText(ch14);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault14.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_15:
                String ch15 = btnDefault15.getText().toString();
                btn[count].setText(ch15);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault15.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_default_16:
                String ch16 = btnDefault16.getText().toString();
                btn[count].setText(ch16);
                btn[count].setBackgroundResource(drawable.tile_hover);
                btnDefault16.setVisibility(View.INVISIBLE);
                count++;
                check(ans.get(img), count);
                break;
            case id.btn_next:
                lnlDF.setVisibility(View.VISIBLE);
                coinnn+= 100;
                coin.setText(coinnn+"");
                lnlAnswer1.removeAllViews();
                lnlAnswer2.removeAllViews();
                btnNext.setVisibility(view.INVISIBLE);
                btnDefault1.setVisibility(View.VISIBLE);
                btnDefault2.setVisibility(View.VISIBLE);
                btnDefault3.setVisibility(View.VISIBLE);
                btnDefault4.setVisibility(View.VISIBLE);
                btnDefault5.setVisibility(View.VISIBLE);
                btnDefault6.setVisibility(View.VISIBLE);
                btnDefault7.setVisibility(View.VISIBLE);
                btnDefault8.setVisibility(View.VISIBLE);
                btnDefault9.setVisibility(View.VISIBLE);
                btnDefault10.setVisibility(View.VISIBLE);
                btnDefault11.setVisibility(View.VISIBLE);
                btnDefault12.setVisibility(View.VISIBLE);
                btnDefault13.setVisibility(View.VISIBLE);
                btnDefault14.setVisibility(View.VISIBLE);
                btnDefault15.setVisibility(View.VISIBLE);
                btnDefault16.setVisibility(View.VISIBLE);
                img++;
                count = 0;
                imgSrc(img);
                break;
            case id.btn_retry:
                lnlDF.setVisibility(View.VISIBLE);
                heart-=1;
                if(heart < 0){
                    finish();
                }
                numbers_heart.setText(heart+"");
                btnRetry.setVisibility(View.INVISIBLE);
                for (int i = 0; i < ans.get(index).length(); i++){
                    btn[i].setVisibility(View.GONE);
                }
                btnDefault1.setVisibility(View.VISIBLE);
                btnDefault2.setVisibility(View.VISIBLE);
                btnDefault3.setVisibility(View.VISIBLE);
                btnDefault4.setVisibility(View.VISIBLE);
                btnDefault5.setVisibility(View.VISIBLE);
                btnDefault6.setVisibility(View.VISIBLE);
                btnDefault7.setVisibility(View.VISIBLE);
                btnDefault8.setVisibility(View.VISIBLE);
                btnDefault9.setVisibility(View.VISIBLE);
                btnDefault10.setVisibility(View.VISIBLE);
                btnDefault11.setVisibility(View.VISIBLE);
                btnDefault12.setVisibility(View.VISIBLE);
                btnDefault13.setVisibility(View.VISIBLE);
                btnDefault14.setVisibility(View.VISIBLE);
                btnDefault15.setVisibility(View.VISIBLE);
                btnDefault16.setVisibility(View.VISIBLE);
                count = 0;
                imgSrc(index);

            default:
                break;

        }
    }

    @Override
    public void run() {
        imgSrc(img);
    }
}
