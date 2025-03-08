package com.thebytestrack_Vishal_patil_mungal.puzzle_2048;



import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;


public class Game_Activity extends Activity {

    private boolean c1, c2, c3;
    private AdView mAdView;
    private TextView gameoverBar, gamewontext;
    private ImageView gameOverBg, gamewonbg;
    private MediaPlayer mediaPlayer, gamewonsfx, gamebgm;
    private Button b11, b12, b13, b14, b21, b22, b23, b24, b31, b32, b33, b34, b41, b42, b43, b44;
    private GestureDetector gestureDetector;
    private String s11, s12, s13, s14, s21, s22, s23, s24, s31, s32, s33, s34, s41, s42, s43, s44;
    private int i11, i12, i13, i14, i21, i22, i23, i24, i31, i32, i33, i34, i41, i42, i43, i44,returning_number, abnd;
    private boolean bool1, bool2, bool3, bool4, golg, booln16, booln32, booln64, booln128, booln256, booln512, booln1024, booleangameover1, booleangameover2, booleangameover3, booleangameover4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Animation anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        booleangameover1=false;
        booleangameover2=false;
        booleangameover3=false;
        booleangameover4=false;

        abnd =0;



        // Play Game win Sfx



        s11 = "";
        s12 = "";
        s13 = "";
        s14 = "";
        s21 = "";
        s22 = "";
        s23 = "";
        s24 = "";
        s31 = "";
        s32 = "";
        s33 = "";
        s34 = "";
        s41 = "";
        s42 = "";
        s43 = "";
        s44 = "";

        i11 = 0;
        i12 = 0;
        i13 = 0;
        i14 = 0;
        i21 = 0;
        i22 = 0;
        i23 = 0;
        i24 = 0;
        i31 = 0;
        i32 = 0;
        i33 = 0;
        i34 = 0;
        i41 = 0;
        i42 = 0;
        i43 = 0;
        i44 = 0;


        b11 = findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);
        b14 = findViewById(R.id.button14);
        b21 = findViewById(R.id.button21);
        b22 = findViewById(R.id.button22);
        b23 = findViewById(R.id.button23);
        b24 = findViewById(R.id.button24);
        b31 = findViewById(R.id.button31);
        b32 = findViewById(R.id.button32);
        b33 = findViewById(R.id.button33);
        b34 = findViewById(R.id.button34);
        b41 = findViewById(R.id.button41);
        b42 = findViewById(R.id.button42);
        b43 = findViewById(R.id.button43);
        b44 = findViewById(R.id.button44);

        int num_of_tiles = generateRandomNumber(2, 8);
        for (int i = 0; i < num_of_tiles; i++) {
            int tile_number = generateRandomNumber(1, 16);
            int[] arr = {2, 4, 8};
            int val_selector = generateRandomNumber(1, 3);
            int value = 2;
            if (val_selector == 1) {
                value = 2;
            }
            if (val_selector == 2) {
                value = 4;
            }
            if (val_selector == 3) {
                value = 8;
            }
            String s = Integer.toString(value);
            if (tile_number == 1) {
                b11.setText(s);
            }
            if (tile_number == 2) {
                b12.setText(s);
            }
            if (tile_number == 3) {
                b13.setText(s);
            }
            if (tile_number == 4) {
                b14.setText(s);
            }
            if (tile_number == 5) {
                b21.setText(s);
            }
            if (tile_number == 6) {
                b22.setText(s);
            }
            if (tile_number == 7) {
                b23.setText(s);
            }
            if (tile_number == 8) {
                b24.setText(s);
            }
            if (tile_number == 9) {
                b31.setText(s);
            }
            if (tile_number == 10) {
                b32.setText(s);
            }
            if (tile_number == 11) {
                b33.setText(s);
            }
            if (tile_number == 12) {
                b34.setText(s);
            }
            if (tile_number == 13) {
                b41.setText(s);
            }
            if (tile_number == 14) {
                b42.setText(s);
            }
            if (tile_number == 15) {
                b43.setText(s);
            }
            if (tile_number == 16) {
                b44.setText(s);
            }
        }

        // Initialize GestureDetector
        gestureDetector = new GestureDetector(this, new Game_Activity.SwipeGestureListener());

        colorSetter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (gamebgm != null) {
            gamebgm.release();
        }
    }
    public static int generateRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    private void GameOver() {
        // Show gameover bar with fade-in animation

        s11=b11.getText().toString();s12=b12.getText().toString();s13=b13.getText().toString();s14=b14.getText().toString();
        s21=b21.getText().toString();s22=b22.getText().toString();s23=b23.getText().toString();s24=b24.getText().toString();
        s31=b31.getText().toString();s32=b32.getText().toString();s33=b33.getText().toString();s34=b34.getText().toString();
        s41=b41.getText().toString();s42=b42.getText().toString();s43=b43.getText().toString();s44=b44.getText().toString();
        i11 = Integer.parseInt(s11);i12 = Integer.parseInt(s12);i13 = Integer.parseInt(s13);i14 = Integer.parseInt(s14);
        i21 = Integer.parseInt(s21);i22 = Integer.parseInt(s22);i23 = Integer.parseInt(s23);i24 = Integer.parseInt(s24);
        i31 = Integer.parseInt(s31);i32 = Integer.parseInt(s32);i33 = Integer.parseInt(s33);i34 = Integer.parseInt(s34);
        i41 = Integer.parseInt(s41);i42 = Integer.parseInt(s42);i43 = Integer.parseInt(s43);i44 = Integer.parseInt(s44);

        int[] row1_right, row2_right, row3_right, row4_right;
        int[] row1_left, row2_left, row3_left, row4_left;
        int[] row1_bottom, row2_bottom, row3_bottom, row4_bottom;
        int[] row1_top, row2_top, row3_top, row4_top;

        row1_right =new int[] {i11,i12,i13,i14};
        row2_right =new int[] {i21,i22,i23,i24};
        row3_right =new int[] {i31,i32,i33,i34};
        row4_right =new int[] {i41,i42,i43,i44};

        row1_left = new int[]{i14,i13,i12,i11};
        row2_left = new int[]{i24,i23,i22,i21};
        row3_left = new int[]{i34,i33,i32,i31};
        row4_left = new int[]{i44,i43,i42,i41};

        row1_bottom = new int[]{i11,i21,i31,i41};
        row2_bottom = new int[]{i12,i22,i32,i42};
        row3_bottom = new int[]{i13,i23,i33,i43};
        row4_bottom = new int[]{i14,i24,i34,i44};

        row1_top = new int[]{i41,i31,i21,i11};
        row2_top = new int[]{i42,i32,i22,i12};
        row3_top = new int[]{i44,i34,i24,i14};
        row4_top = new int[]{i44,i34,i24,i14};

        int[] row1_result_right, row2_result_right, row3_result_right, row4_result_right;
        int[] row1_result_left, row2_result_left, row3_result_left, row4_result_left;
        int[] row1_result_bottom, row2_result_bottom, row3_result_bottom, row4_result_bottom;
        int[] row1_result_top, row2_result_top, row3_result_top, row4_result_top;

        row1_result_right = row_swipe_logic_solver(i11,i12,i13,i14);
        row2_result_right = row_swipe_logic_solver(i21,i22,i23,i24);
        row3_result_right = row_swipe_logic_solver(i31,i32,i33,i34);
        row4_result_right = row_swipe_logic_solver(i41,i42,i43,i44);

        row1_result_left = row_swipe_logic_solver(i14,i13,i12,i11);
        row2_result_left = row_swipe_logic_solver(i24,i23,i22,i21);
        row3_result_left = row_swipe_logic_solver(i34,i33,i32,i31);
        row4_result_left = row_swipe_logic_solver(i44,i43,i42,i41);

        row1_result_bottom = row_swipe_logic_solver(i11,i21,i31,i41);
        row2_result_bottom = row_swipe_logic_solver(i12,i22,i32,i42);
        row3_result_bottom = row_swipe_logic_solver(i13,i23,i33,i43);
        row4_result_bottom = row_swipe_logic_solver(i14,i24,i34,i44);

        row1_result_top = row_swipe_logic_solver(i41,i31,i21,i11);
        row2_result_top = row_swipe_logic_solver(i42,i32,i22,i12);
        row3_result_top = row_swipe_logic_solver(i43,i33,i23,i13);
        row4_result_top = row_swipe_logic_solver(i44,i34,i24,i14);

        if (row1_right == row1_result_right && row2_right == row2_result_right && row3_right == row3_result_right && row4_right == row4_result_right ){
            booleangameover1=true;
        }

        if (row1_left == row1_result_left && row2_left == row2_result_left && row3_left == row3_result_left && row4_left == row4_result_left ){
            booleangameover2=true;
        }

        if (row1_top == row1_result_top && row2_top == row2_result_top && row3_top == row3_result_top && row4_top == row4_result_top ){
            booleangameover3=true;
        }

        if (row1_bottom == row1_result_bottom && row2_bottom == row2_result_bottom && row3_bottom == row3_result_bottom && row4_bottom == row4_result_bottom ){
            booleangameover4=true;
        }

        if (booleangameover1==true && booleangameover2==true && booleangameover3==true && booleangameover4==true){
            // game over!!!!

            gamewonbg.setVisibility(View.VISIBLE);
            gamewontext.setVisibility(View.VISIBLE);
            Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
            gamewonbg.startAnimation(fadeInAnimation);
            gamewontext.startAnimation(fadeInAnimation);
            // Play Game win Sfx
            gamewonsfx.start();











        }
        
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Pass touch events to GestureDetector
        return gestureDetector.onTouchEvent(event);
    }

    private class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 70;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        // right swipe
                        b11 = findViewById(R.id.button11);b12 = findViewById(R.id.button12);b13 = findViewById(R.id.button13);b14 = findViewById(R.id.button14);
                        b21 = findViewById(R.id.button21);b22 = findViewById(R.id.button22);b23 = findViewById(R.id.button23);b24 = findViewById(R.id.button24);
                        b31 = findViewById(R.id.button31);b32 = findViewById(R.id.button32);b33 = findViewById(R.id.button33);b34 = findViewById(R.id.button34);
                        b41 = findViewById(R.id.button41);b42 = findViewById(R.id.button42);b43 = findViewById(R.id.button43);b44 = findViewById(R.id.button44);
                        s11 = b11.getText().toString();s12 = b12.getText().toString();s13 = b13.getText().toString();s14 = b14.getText().toString();
                        s21 = b21.getText().toString();s22 = b22.getText().toString();s23 = b23.getText().toString();s24 = b24.getText().toString();
                        s31 = b31.getText().toString();s32 = b32.getText().toString();s33 = b33.getText().toString();s34 = b34.getText().toString();
                        s41 = b41.getText().toString();s42 = b42.getText().toString();s43 = b43.getText().toString();s44 = b44.getText().toString();
                        if (s11 != "") {i11 = Integer.parseInt(s11);}if (s12 != "") {i12 = Integer.parseInt(s12);}if (s13 != "") {i13 = Integer.parseInt(s13);}if (s14 != "") {i14 = Integer.parseInt(s14);}
                        if (s21 != "") {i21 = Integer.parseInt(s21);}if (s22 != "") {i22 = Integer.parseInt(s22);}if (s23 != "") {i23 = Integer.parseInt(s23);}if (s24 != "") {i24 = Integer.parseInt(s24);}
                        if (s31 != "") {i31 = Integer.parseInt(s31);}if (s32 != "") {i32 = Integer.parseInt(s32);}if (s33 != "") {i33 = Integer.parseInt(s33);}if (s34 != "") {i34 = Integer.parseInt(s34);}
                        if (s41 != "") {i41 = Integer.parseInt(s41);}if (s42 != "") {i42 = Integer.parseInt(s42);}if (s43 != "") {i43 = Integer.parseInt(s43);}if (s44 != "") {i44 = Integer.parseInt(s44);}

                        if (i11>=16 || i12>=16 || i13>=16 || i14>=16 || i21>=16 || i22>=16 || i23>=16 || i24>=16 || i31>=16 || i32>=16 || i33>=16 || i34>=16 || i41>=16 || i42>=16 || i43>=16 || i44>=16){
                            abnd++;
                        }
                        booln16=false;
                        if (abnd>=4){
                            booln16=true;
                        }
                        int new_int_row_1 = new_tile_number_generator(booln16);
                        int new_int_row_2 = new_tile_number_generator(booln16);
                        int new_int_row_3 = new_tile_number_generator(booln16);
                        int new_int_row_4 = new_tile_number_generator(booln16);

                        String new_int_to_string_row1 = Integer.toString(new_int_row_1);
                        String new_int_to_string_row2 = Integer.toString(new_int_row_2);
                        String new_int_to_string_row3 = Integer.toString(new_int_row_3);
                        String new_int_to_string_row4 = Integer.toString(new_int_row_4);
                        
                        int[] r1_arr, r2_arr, r3_arr, r4_arr;

                        r1_arr = new int[]{i11, i12, i13, i14};
                        int[] row1 = row_swipe_logic_solver(i11, i12, i13, i14);
                        b11.setText("");
                        b12.setText("");
                        b13.setText("");
                        b14.setText("");
                        i11 = row1[0];i12 = row1[1];i13 = row1[2];i14 = row1[3];
                        s11 = Integer.toString(i11);s12 = Integer.toString(i12);s13 = Integer.toString(i13);s14 = Integer.toString(i14);
                        if (!s11.equals("0")) {b11.setText(s11);}if (!s12.equals("0")) {b12.setText(s12);}if (!s13.equals("0")) {b13.setText(s13);}if (!s14.equals("0")) {b14.setText(s14);}
                        if (r1_arr!=row1) {
                            if (r1_arr[0] != 0 && row1[0]==0) {
                                b11.setText(new_int_to_string_row1);
                            }
                            if (r1_arr[0] == 0 && row1[0]==0 && row1[1]==0 && r1_arr[1] != 0) {
                                b12.setText(new_int_to_string_row1);
                            }
                            if (r1_arr[0] == 0 && row1[0]==0 && row1[1]==0 && row1[2]==0 && r1_arr[1] == 0 && r1_arr[2] != 0) {
                                b13.setText(new_int_to_string_row1);
                            }
                        }
                        
                        r2_arr = new int[]{i21, i22, i23, i24};
                        int[] row2 = row_swipe_logic_solver(i21, i22, i23, i24);
                        b21.setText("");b22.setText("");b23.setText("");b24.setText("");
                        i21 = row2[0];i22 = row2[1];i23 = row2[2];i24 = row2[3];
                        s21 = Integer.toString(i21);s22 = Integer.toString(i22);s23 = Integer.toString(i23);s24 = Integer.toString(i24);
                        if (!s21.equals("0")) {b21.setText(s21);}if (!s22.equals("0")) {b22.setText(s22);}if (!s23.equals("0")) {b23.setText(s23);}if (!s24.equals("0")) {b24.setText(s24);}
                        if (r2_arr!=row2) {
                            if (r2_arr[0] != 0 && row2[0]==0) {
                                b21.setText(new_int_to_string_row2);
                            }
                            if (r2_arr[0] == 0 && row2[0]==0 && row2[1]==0 && r2_arr[1] != 0) {
                                b22.setText(new_int_to_string_row2);
                            }
                            if (r2_arr[0] == 0 && row2[0]==0 && row2[1]==0 && row2[2]==0 && r2_arr[1] == 0 && r2_arr[2] != 0) {
                                b23.setText(new_int_to_string_row2);
                            }
                        }

                        r3_arr = new int[]{i31, i32, i33, i34};
                        int[] row3 = row_swipe_logic_solver(i31, i32, i33, i34);
                        b31.setText("");b32.setText("");b33.setText("");b34.setText("");
                        i31 = row3[0];i32 = row3[1];i33 = row3[2];i34 = row3[3];
                        s31 = Integer.toString(i31);s32 = Integer.toString(i32);s33 = Integer.toString(i33);s34 = Integer.toString(i34);
                        if (!s31.equals("0")) {b31.setText(s31);}if (!s32.equals("0")) {b32.setText(s32);}if (!s33.equals("0")) {b33.setText(s33);}if (!s34.equals("0")) {b34.setText(s34);}
                        if (r3_arr!=row3) {
                            if (r3_arr[0] != 0 && row3[0]==0) {
                                b31.setText(new_int_to_string_row3);
                            }
                            if (r3_arr[0] == 0 && row3[0]==0 && row3[1]==0 && r3_arr[1] != 0) {
                                b32.setText(new_int_to_string_row3);
                            }
                            if (r3_arr[0] == 0 && row3[0]==0 && row3[1]==0 && row3[2]==0 && r3_arr[1] == 0 && r3_arr[2] != 0) {
                                b33.setText(new_int_to_string_row3);
                            }
                        }

                        r4_arr = new int[]{i41, i42, i43, i44};
                        int[] row4 = row_swipe_logic_solver(i41, i42, i43, i44);
                        b41.setText("");b42.setText("");b43.setText("");b44.setText("");
                        i41 = row4[0];i42 = row4[1];i43 = row4[2];i44 = row4[3];
                        s41 = Integer.toString(i41);s42 = Integer.toString(i42);s43 = Integer.toString(i43);s44 = Integer.toString(i44);
                        if (!s41.equals("0")) {b41.setText(s41);}if (!s42.equals("0")) {b42.setText(s42);}if (!s43.equals("0")) {b43.setText(s43);}if (!s44.equals("0")) {b44.setText(s44);}
                        if (r4_arr!=row4) {
                            if (r4_arr[0] != 0 && row4[0]==0) {
                                b41.setText(new_int_to_string_row4);
                            }
                            if (r4_arr[0] == 0 && row4[0]==0 && row4[1]==0 && r4_arr[1] != 0) {
                                b42.setText(new_int_to_string_row4);
                            }
                            if (r4_arr[0] == 0 && row4[0]==0 && row4[1]==0 && row4[2]==0 && r4_arr[1] == 0 && r4_arr[2] != 0) {
                                b43.setText(new_int_to_string_row4);
                            }
                        }

                        if (i11 == 2048 || i12 == 2048 || i13 == 2048 || i14 == 2048 || i21 == 2048 || i22 == 2048 || i23 == 2048 || i24 == 2048 || i31 == 2048 || i32 == 2048 || i33 == 2048 || i34 == 2048 || i41 == 2048 || i42 == 2048 || i43 == 2048 || i44 == 2048) {
                            // game won

                        }

                        colorSetter();

                        i11 = 0;i12 = 0;i13 = 0;i14 = 0;
                        i21 = 0;i22 = 0;i23 = 0;i24 = 0;
                        i31 = 0;i32 = 0;i33 = 0;i34 = 0;
                        i41 = 0;i42 = 0;i43 = 0;i44 = 0;

                        if (r1_arr == row1 && r2_arr == row2 && r3_arr == row3 && r4_arr == row4) {
                            bool1 = true;
                        } else {
                            bool1 = false;
                        }
                        if (bool1 == true && bool2 == true && bool3 == true && bool4 == true) {
                            GameOver();
                        }
                    }
                    else {
                        // swipe left
                        b11 = findViewById(R.id.button11);b12 = findViewById(R.id.button12);b13 = findViewById(R.id.button13);b14 = findViewById(R.id.button14);
                        b21 = findViewById(R.id.button21);b22 = findViewById(R.id.button22);b23 = findViewById(R.id.button23);b24 = findViewById(R.id.button24);
                        b31 = findViewById(R.id.button31);b32 = findViewById(R.id.button32);b33 = findViewById(R.id.button33);b34 = findViewById(R.id.button34);
                        b41 = findViewById(R.id.button41);b42 = findViewById(R.id.button42);b43 = findViewById(R.id.button43);b44 = findViewById(R.id.button44);
                        s11 = b11.getText().toString();s12 = b12.getText().toString();s13 = b13.getText().toString();s14 = b14.getText().toString();
                        s21 = b21.getText().toString();s22 = b22.getText().toString();s23 = b23.getText().toString();s24 = b24.getText().toString();
                        s31 = b31.getText().toString();s32 = b32.getText().toString();s33 = b33.getText().toString();s34 = b34.getText().toString();
                        s41 = b41.getText().toString();s42 = b42.getText().toString();s43 = b43.getText().toString();s44 = b44.getText().toString();
                        if (s11 != "") {i11 = Integer.parseInt(s11);}if (s12 != "") {i12 = Integer.parseInt(s12);}if (s13 != "") {i13 = Integer.parseInt(s13);}if (s14 != "") {i14 = Integer.parseInt(s14);}
                        if (s21 != "") {i21 = Integer.parseInt(s21);}if (s22 != "") {i22 = Integer.parseInt(s22);}if (s23 != "") {i23 = Integer.parseInt(s23);}if (s24 != "") {i24 = Integer.parseInt(s24);}
                        if (s31 != "") {i31 = Integer.parseInt(s31);}if (s32 != "") {i32 = Integer.parseInt(s32);}if (s33 != "") {i33 = Integer.parseInt(s33);}if (s34 != "") {i34 = Integer.parseInt(s34);}
                        if (s41 != "") {i41 = Integer.parseInt(s41);}if (s42 != "") {i42 = Integer.parseInt(s42);}if (s43 != "") {i43 = Integer.parseInt(s43);}if (s44 != "") {i44 = Integer.parseInt(s44);}


                        int new_int_row_1 = new_tile_number_generator(booln16);
                        int new_int_row_2 = new_tile_number_generator(booln16);
                        int new_int_row_3 = new_tile_number_generator(booln16);
                        int new_int_row_4 = new_tile_number_generator(booln16);

                        String new_int_to_string_row1 = Integer.toString(new_int_row_1);
                        String new_int_to_string_row2 = Integer.toString(new_int_row_2);
                        String new_int_to_string_row3 = Integer.toString(new_int_row_3);
                        String new_int_to_string_row4 = Integer.toString(new_int_row_4);


                        int[] r1_arr, r2_arr, r3_arr, r4_arr;


                        if (i11>=16 || i12>=16 || i13>=16 || i14>=16 || i21>=16 || i22>=16 || i23>=16 || i24>=16 || i31>=16 || i32>=16 || i33>=16 || i34>=16 || i41>=16 || i42>=16 || i43>=16 || i44>=16){
                            abnd++;
                        }
                        booln16=false;
                        if (abnd>=4){
                            booln16=true;
                        }


                        r1_arr = new int[]{i14, i13, i12, i11};
                        int[] row1 = row_swipe_logic_solver(i14, i13, i12, i11);
                        i11 = row1[3];
                        i12 = row1[2];
                        i13 = row1[1];
                        i14 = row1[0];
                        b11.setText("");
                        b12.setText("");
                        b13.setText("");
                        b14.setText("");
                        s11 = Integer.toString(i11);
                        s12 = Integer.toString(i12);
                        s13 = Integer.toString(i13);
                        s14 = Integer.toString(i14);
                        if (!s11.equals("0")) {
                            b11.setText(s11);
                        }
                        if (!s12.equals("0")) {
                            b12.setText(s12);
                        }
                        if (!s13.equals("0")) {
                            b13.setText(s13);
                        }
                        if (!s14.equals("0")) {
                            b14.setText(s14);
                        }
                        if (r1_arr!=row1) {
                            if (r1_arr[0] != 0 && row1[0]==0) {
                                b14.setText(new_int_to_string_row1);
                            }
                            if (r1_arr[0] == 0 && row1[0]==0 && row1[1]==0 && r1_arr[1] != 0) {
                                b13.setText(new_int_to_string_row1);
                            }
                            if (r1_arr[0] == 0 && row1[0]==0 && row1[1]==0 && row1[2]==0 && r1_arr[1] == 0 && r1_arr[2] != 0) {
                                b12.setText(new_int_to_string_row1);
                            }
                        }










                        r2_arr = new int[]{i24, i23, i22, i21};
                        int[] row2 = row_swipe_logic_solver(i24, i23, i22, i21);
                        i21 = row2[3];
                        i22 = row2[2];
                        i23 = row2[1];
                        i24 = row2[0];
                        b21.setText("");
                        b22.setText("");
                        b23.setText("");
                        b24.setText("");
                        s21 = Integer.toString(i21);
                        s22 = Integer.toString(i22);
                        s23 = Integer.toString(i23);
                        s24 = Integer.toString(i24);
                        if (!s21.equals("0")) {
                            b21.setText(s21);
                        }
                        if (!s22.equals("0")) {
                            b22.setText(s22);
                        }
                        if (!s23.equals("0")) {
                            b23.setText(s23);
                        }
                        if (!s24.equals("0")) {
                            b24.setText(s24);
                        }
                        if (r2_arr!=row2) {
                            if (r2_arr[0] != 0 && row2[0]==0) {
                                b24.setText(new_int_to_string_row2);
                            }
                            if (r2_arr[0] == 0 && row2[0]==0 && row2[1]==0 && r2_arr[1] != 0) {
                                b23.setText(new_int_to_string_row2);
                            }
                            if (r2_arr[0] == 0 && row2[0]==0 && row2[1]==0 && row2[2]==0 && r2_arr[1] == 0 && r2_arr[2] != 0) {
                                b22.setText(new_int_to_string_row2);
                            }
                        }

                        /** CHINMAY (Instagram ID : chinmay.0009)
                         * bn [ca-app-pub-9509508048113882/1749874320
                         *
                         * ca-app-pub-9509508048113882/7602435418
                         *
                         * ca-app-pub-9509508048113882/5167843762
                         * ]
                         * Int[
                         * ca-app-pub-9509508048113882/3732291404]
                         */






                        r3_arr = new int[]{i34, i33, i32, i31};
                        int[] row3 = row_swipe_logic_solver(i34, i33, i32, i31);
                        i31 = row3[3];
                        i32 = row3[2];
                        i33 = row3[1];
                        i34 = row3[0];
                        b31.setText("");
                        b32.setText("");
                        b33.setText("");
                        b34.setText("");
                        s31 = Integer.toString(i31);
                        s32 = Integer.toString(i32);
                        s33 = Integer.toString(i33);
                        s34 = Integer.toString(i34);
                        if (!s31.equals("0")) {
                            b31.setText(s31);
                        }
                        if (!s32.equals("0")) {
                            b32.setText(s32);
                        }
                        if (!s33.equals("0")) {
                            b33.setText(s33);
                        }
                        if (!s34.equals("0")) {
                            b34.setText(s34);
                        }
                        if (r3_arr!=row3) {
                            if (r3_arr[0] != 0 && row3[0]==0) {
                                b34.setText(new_int_to_string_row3);
                            }
                            if (r3_arr[0] == 0 && row3[0]==0 && row3[1]==0 && r3_arr[1] != 0) {
                                b33.setText(new_int_to_string_row3);
                            }
                            if (r3_arr[0] == 0 && row3[0]==0 && row3[1]==0 && row3[2]==0 && r3_arr[1] == 0 && r3_arr[2] != 0) {
                                b32.setText(new_int_to_string_row3);
                            }
                        }


                        r4_arr = new int[]{i44, i43, i42, i41};
                        int[] row4 = row_swipe_logic_solver(i44, i43, i42, i41);
                        i41 = row4[3];
                        i42 = row4[2];
                        i43 = row4[1];
                        i44 = row4[0];
                        b41.setText("");
                        b42.setText("");
                        b43.setText("");
                        b44.setText("");
                        s41 = Integer.toString(i41);
                        s42 = Integer.toString(i42);
                        s43 = Integer.toString(i43);
                        s44 = Integer.toString(i44);
                        if (!s41.equals("0")) {
                            b41.setText(s41);
                        }
                        if (!s42.equals("0")) {
                            b42.setText(s42);
                        }
                        if (!s43.equals("0")) {
                            b43.setText(s43);
                        }
                        if (!s44.equals("0")) {
                            b44.setText(s44);
                        }
                        if (r4_arr!=row4) {
                            if (r4_arr[0] != 0 && row4[0]==0) {
                                b44.setText(new_int_to_string_row4);
                            }
                            if (r4_arr[0] == 0 && row4[0]==0 && row4[1]==0 && r4_arr[1] != 0) {
                                b43.setText(new_int_to_string_row4);
                            }
                            if (r4_arr[0] == 0 && row4[0]==0 && row4[1]==0 && row4[2]==0 && r4_arr[1] == 0 && r4_arr[2] != 0) {
                                b42.setText(new_int_to_string_row4);
                            }
                        }

                        if (i11 == 2048 || i12 == 2048 || i13 == 2048 || i14 == 2048 || i21 == 2048 || i22 == 2048 || i23 == 2048 || i24 == 2048 || i31 == 2048 || i32 == 2048 || i33 == 2048 || i34 == 2048 || i41 == 2048 || i42 == 2048 || i43 == 2048 || i44 == 2048) {
                            // game won

                        }


                        colorSetter();


                        if (r1_arr == row1 && r2_arr == row2 && r3_arr == row3 && r4_arr == row4) {
                            bool1 = true;
                        } else {
                            bool1 = false;
                        }
                        if (bool1 == true && bool2 == true && bool3 == true && bool4 == true) {
                            GameOver();
                        }


                        i11 = 0;
                        i12 = 0;
                        i13 = 0;
                        i14 = 0;
                        i21 = 0;
                        i22 = 0;
                        i23 = 0;
                        i24 = 0;
                        i31 = 0;
                        i32 = 0;
                        i33 = 0;
                        i34 = 0;
                        i41 = 0;
                        i42 = 0;
                        i43 = 0;
                        i44 = 0;


                    }
                    return true;
                }
            }
            
            
            // Vertical Swipes 
            
            
            else {
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
            // bottom swipe
                    if (diffY > 0) {
                        // Swipe bottom
                        b11 = findViewById(R.id.button11);
                        b12 = findViewById(R.id.button12);
                        b13 = findViewById(R.id.button13);
                        b14 = findViewById(R.id.button14);
                        b21 = findViewById(R.id.button21);
                        b22 = findViewById(R.id.button22);
                        b23 = findViewById(R.id.button23);
                        b24 = findViewById(R.id.button24);
                        b31 = findViewById(R.id.button31);
                        b32 = findViewById(R.id.button32);
                        b33 = findViewById(R.id.button33);
                        b34 = findViewById(R.id.button34);
                        b41 = findViewById(R.id.button41);
                        b42 = findViewById(R.id.button42);
                        b43 = findViewById(R.id.button43);
                        b44 = findViewById(R.id.button44);
                        s11 = b11.getText().toString();
                        s12 = b12.getText().toString();
                        s13 = b13.getText().toString();
                        s14 = b14.getText().toString();
                        s21 = b21.getText().toString();
                        s22 = b22.getText().toString();
                        s23 = b23.getText().toString();
                        s24 = b24.getText().toString();
                        s31 = b31.getText().toString();
                        s32 = b32.getText().toString();
                        s33 = b33.getText().toString();
                        s34 = b34.getText().toString();
                        s41 = b41.getText().toString();
                        s42 = b42.getText().toString();
                        s43 = b43.getText().toString();
                        s44 = b44.getText().toString();
                        if (s11 != "") {
                            i11 = Integer.parseInt(s11);
                        }
                        if (s12 != "") {
                            i12 = Integer.parseInt(s12);
                        }
                        if (s13 != "") {
                            i13 = Integer.parseInt(s13);
                        }
                        if (s14 != "") {
                            i14 = Integer.parseInt(s14);
                        }
                        if (s21 != "") {
                            i21 = Integer.parseInt(s21);
                        }
                        if (s22 != "") {
                            i22 = Integer.parseInt(s22);
                        }
                        if (s23 != "") {
                            i23 = Integer.parseInt(s23);
                        }
                        if (s24 != "") {
                            i24 = Integer.parseInt(s24);
                        }
                        if (s31 != "") {
                            i31 = Integer.parseInt(s31);
                        }
                        if (s32 != "") {
                            i32 = Integer.parseInt(s32);
                        }
                        if (s33 != "") {
                            i33 = Integer.parseInt(s33);
                        }
                        if (s34 != "") {
                            i34 = Integer.parseInt(s34);
                        }
                        if (s41 != "") {
                            i41 = Integer.parseInt(s41);
                        }
                        if (s42 != "") {
                            i42 = Integer.parseInt(s42);
                        }
                        if (s43 != "") {
                            i43 = Integer.parseInt(s43);
                        }
                        if (s44 != "") {
                            i44 = Integer.parseInt(s44);
                        }

                        int[] r1_arr, r2_arr, r3_arr, r4_arr;


                        if (i11 >= 16 || i12 >= 16 || i13 >= 16 || i14 >= 16 || i21 >= 16 || i22 >= 16 || i23 >= 16 || i24 >= 16 || i31 >= 16 || i32 >= 16 || i33 >= 16 || i34 >= 16 || i41 >= 16 || i42 >= 16 || i43 >= 16 || i44 >= 16) {
                            abnd++;
                        }
                        booln16 = false;
                        if (abnd >= 4) {
                            booln16 = true;
                        }

                        int new_int_row_1 = new_tile_number_generator(booln16);
                        int new_int_row_2 = new_tile_number_generator(booln16);
                        int new_int_row_3 = new_tile_number_generator(booln16);
                        int new_int_row_4 = new_tile_number_generator(booln16);

                        String new_int_to_string_row1 = Integer.toString(new_int_row_1);
                        String new_int_to_string_row2 = Integer.toString(new_int_row_2);
                        String new_int_to_string_row3 = Integer.toString(new_int_row_3);
                        String new_int_to_string_row4 = Integer.toString(new_int_row_4);


                        r1_arr = new int[]{i11, i21, i31, i41};
                        int[] row1 = row_swipe_logic_solver(i11, i21, i31, i41);
                        b11.setText("");
                        b21.setText("");
                        b31.setText("");
                        b41.setText("");
                        i11 = row1[0];
                        i21 = row1[1];
                        i31 = row1[2];
                        i41 = row1[3];
                        s11 = Integer.toString(i11);
                        s21 = Integer.toString(i21);
                        s31 = Integer.toString(i31);
                        s41 = Integer.toString(i41);
                        if (!s11.equals("0")) {
                            b11.setText(s11);
                        }
                        if (!s21.equals("0")) {
                            b21.setText(s21);
                        }
                        if (!s31.equals("0")) {
                            b31.setText(s31);
                        }
                        if (!s41.equals("0")) {
                            b41.setText(s41);
                        }
                        if (r1_arr!=row1) {
                            if (r1_arr[0] != 0 && row1[0]==0) {
                                b11.setText(new_int_to_string_row1);
                            }
                            if (r1_arr[0] == 0 && row1[0]==0 && row1[1]==0 && r1_arr[1] != 0) {
                                b21.setText(new_int_to_string_row1);
                            }
                            if (r1_arr[0] == 0 && row1[0]==0 && row1[1]==0 && row1[2]==0 && r1_arr[1] == 0 && r1_arr[2] != 0) {
                                b31.setText(new_int_to_string_row1);
                            }
                        }
                        
                        
                        r2_arr = new int[]{i12, i22, i32, i42};
                        int[] row2 = row_swipe_logic_solver(i12, i22, i32, i42);
                        b12.setText("");
                        b22.setText("");
                        b32.setText("");
                        b42.setText("");
                        i12 = row2[0];
                        i22 = row2[1];
                        i32 = row2[2];
                        i42 = row2[3];
                        s12 = Integer.toString(i12);
                        s22 = Integer.toString(i22);
                        s32 = Integer.toString(i32);
                        s42 = Integer.toString(i42);
                        if (!s12.equals("0")) {
                            b12.setText(s12);
                        }
                        if (!s22.equals("0")) {
                            b22.setText(s22);
                        }
                        if (!s32.equals("0")) {
                            b32.setText(s32);
                        }
                        if (!s42.equals("0")) {
                            b42.setText(s42);
                        }

                        if (r2_arr!=row2) {
                            if (r2_arr[0] != 0 && row2[0]==0) {
                                b12.setText(new_int_to_string_row2);
                            }
                            if (r2_arr[0] == 0 && row2[0]==0 && row2[1]==0 && r2_arr[1] != 0) {
                                b22.setText(new_int_to_string_row2);
                            }
                            if (r2_arr[0] == 0 && row2[0]==0 && row2[1]==0 && row2[2]==0 && r2_arr[1] == 0 && r2_arr[2] != 0) {
                                b32.setText(new_int_to_string_row2);
                            }
                        }
                        
                        
                        
                        
                        r3_arr = new int[]{i13, i23, i33, i43};
                        int[] row3 = row_swipe_logic_solver(i13, i23, i33, i43);
                        b13.setText("");b23.setText("");b33.setText("");b43.setText("");
                        i13 = row3[0];i23 = row3[1];i33 = row3[2];i43 = row3[3];
                        s13 = Integer.toString(i13);s23 = Integer.toString(i23);s33 = Integer.toString(i33);s43 = Integer.toString(i43);
                        if (!s13.equals("0")) {b13.setText(s13);}if (!s23.equals("0")) {b23.setText(s23);}if (!s33.equals("0")) {b33.setText(s33);}if (!s43.equals("0")) {b43.setText(s43);}

                        if (r3_arr!=row3) {
                            if (r3_arr[0] != 0 && row3[0]==0) {
                                b13.setText(new_int_to_string_row3);
                            }
                            if (r3_arr[0] == 0 && row3[0]==0 && row3[1]==0 && r3_arr[1] != 0) {
                                b23.setText(new_int_to_string_row3);
                            }
                            if (r3_arr[0] == 0 && row3[0]==0 && row3[1]==0 && row3[2]==0 && r3_arr[1] == 0 && r3_arr[2] != 0) {
                                b33.setText(new_int_to_string_row3);
                            }
                        }

                        
                        
                        r4_arr = new int[]{i14, i24, i34, i44};
                        int[] row4 = row_swipe_logic_solver(i14, i24, i34, i44);
                        b14.setText("");b24.setText("");b34.setText("");b44.setText("");
                        i14 = row4[0];i24 = row4[1];i34 = row4[2];i44 = row4[3];
                        s14 = Integer.toString(i14);s24 = Integer.toString(i24);s34 = Integer.toString(i34);s44 = Integer.toString(i44);
                        if (!s14.equals("0")) {b14.setText(s14);}if (!s24.equals("0")) {b24.setText(s24);}if (!s34.equals("0")) {b34.setText(s34);}if (!s44.equals("0")) {b44.setText(s44);}

                        if (r4_arr!=row4) {
                            if (r4_arr[0] != 0 && row4[0]==0) {
                                b14.setText(new_int_to_string_row4);
                            }
                            if (r4_arr[0] == 0 && row4[0]==0 && row4[1]==0 && r4_arr[1] != 0) {
                                b24.setText(new_int_to_string_row4);
                            }
                            if (r4_arr[0] == 0 && row4[0]==0 && row4[1]==0 && row4[2]==0 && r4_arr[1] == 0 && r4_arr[2] != 0) {
                                b34.setText(new_int_to_string_row4);
                            }
                        }


                        if (i11 == 2048 || i12 == 2048 || i13 == 2048 || i14 == 2048 || i21 == 2048 || i22 == 2048 || i23 == 2048 || i24 == 2048 || i31 == 2048 || i32 == 2048 || i33 == 2048 || i34 == 2048 || i41 == 2048 || i42 == 2048 || i43 == 2048 || i44 == 2048) {
                            // game won

                        }


                        colorSetter();

                        if (r1_arr == row1 && r2_arr == row2 && r3_arr == row3 && r4_arr == row4) {
                            bool1 = true;
                        } else {
                            bool1 = false;
                        }
                        if (bool1 == true && bool2 == true && bool3 == true && bool4 == true) {
                            GameOver();
                        }

                        i11 = 0;i12 = 0;i13 = 0;i14 = 0;
                        i21 = 0;i22 = 0;i23 = 0;i24 = 0;
                        i31 = 0;i32 = 0;i33 = 0;i34 = 0;
                        i41 = 0;i42 = 0;i43 = 0;i44 = 0;


                    }

                    else {
                        // Swipe top
                        b11 = findViewById(R.id.button11);b12 = findViewById(R.id.button12);b13 = findViewById(R.id.button13);b14 = findViewById(R.id.button14);
                        b21 = findViewById(R.id.button21);b22 = findViewById(R.id.button22);b23 = findViewById(R.id.button23);b24 = findViewById(R.id.button24);
                        b31 = findViewById(R.id.button31);b32 = findViewById(R.id.button32);b33 = findViewById(R.id.button33);b34 = findViewById(R.id.button34);
                        b41 = findViewById(R.id.button41);b42 = findViewById(R.id.button42);b43 = findViewById(R.id.button43);b44 = findViewById(R.id.button44);
                        s11 = b11.getText().toString();s12 = b12.getText().toString();s13 = b13.getText().toString();s14 = b14.getText().toString();
                        s21 = b21.getText().toString();s22 = b22.getText().toString();s23 = b23.getText().toString();s24 = b24.getText().toString();
                        s31 = b31.getText().toString();s32 = b32.getText().toString();s33 = b33.getText().toString();s34 = b34.getText().toString();
                        s41 = b41.getText().toString();s42 = b42.getText().toString();s43 = b43.getText().toString();s44 = b44.getText().toString();
                        if (s11 != "") {
                            i11 = Integer.parseInt(s11);
                        }if (s12 != "") {
                            i12 = Integer.parseInt(s12);
                        }if (s13 != "") {
                            i13 = Integer.parseInt(s13);
                        }if (s14 != "") {
                            i14 = Integer.parseInt(s14);
                        }
                        if (s21 != "") {
                            i21 = Integer.parseInt(s21);
                        }if (s22 != "") {
                            i22 = Integer.parseInt(s22);
                        }if (s23 != "") {
                            i23 = Integer.parseInt(s23);
                        }if (s24 != "") {
                            i24 = Integer.parseInt(s24);
                        }
                        if (s31 != "") {
                            i31 = Integer.parseInt(s31);
                        }if (s32 != "") {
                            i32 = Integer.parseInt(s32);
                        }if (s33 != "") {
                            i33 = Integer.parseInt(s33);
                        }if (s34 != "") {
                            i34 = Integer.parseInt(s34);
                        }
                        if (s41 != "") {
                            i41 = Integer.parseInt(s41);
                        }if (s42 != "") {
                            i42 = Integer.parseInt(s42);
                        }if (s43 != "") {
                            i43 = Integer.parseInt(s43);
                        }if (s44 != "") {
                            i44 = Integer.parseInt(s44);
                        }


                        int[] r1_arr, r2_arr, r3_arr, r4_arr;


                        if (i11>=16 || i12>=16 || i13>=16 || i14>=16 || i21>=16 || i22>=16 || i23>=16 || i24>=16 || i31>=16 || i32>=16 || i33>=16 || i34>=16 || i41>=16 || i42>=16 || i43>=16 || i44>=16){
                            abnd++;
                        }
                        booln16=false;
                        if (abnd>=4){
                            booln16=true;
                        }

                        int new_int_row_1 = new_tile_number_generator(booln16);
                        int new_int_row_2 = new_tile_number_generator(booln16);
                        int new_int_row_3 = new_tile_number_generator(booln16);
                        int new_int_row_4 = new_tile_number_generator(booln16);


                        String new_int_to_string_row1 = Integer.toString(new_int_row_1);
                        String new_int_to_string_row2 = Integer.toString(new_int_row_2);
                        String new_int_to_string_row3 = Integer.toString(new_int_row_3);
                        String new_int_to_string_row4 = Integer.toString(new_int_row_4);


                        r1_arr = new int[]{i41, i31, i21, i11};
                        int[] row1 = row_swipe_logic_solver(i41, i31, i21, i11);
                        b11.setText("");b21.setText("");b31.setText("");b41.setText("");
                        i11 = row1[3];i21 = row1[2];i31 = row1[1];i41 = row1[0];
                        s11 = Integer.toString(i11);s21 = Integer.toString(i21);s31 = Integer.toString(i31);s41 = Integer.toString(i41);
                        if (!s11.equals("0")) {
                            b11.setText(s11);
                        }if (!s21.equals("0")) {
                            b21.setText(s21);
                        }if (!s31.equals("0")) {
                            b31.setText(s31);
                        }if (!s41.equals("0")) {
                            b41.setText(s41);
                        }
                        if (r1_arr!=row1) {
                            if (r1_arr[0] != 0 && row1[0]==0) {
                                b41.setText(new_int_to_string_row1);
                            }
                            if (r1_arr[0] == 0 && row1[0]==0 && row1[1]==0 && r1_arr[1] != 0) {
                                b31.setText(new_int_to_string_row1);
                            }
                            if (r1_arr[0] == 0 && row1[0]==0 && row1[1]==0 && row1[2]==0 && r1_arr[1] == 0 && r1_arr[2] != 0) {
                                b21.setText(new_int_to_string_row1);
                            }
                        }

                        r2_arr = new int[]{i12, i22, i32, i42};
                        int[] row2 = row_swipe_logic_solver(i42, i32, i22, i12);
                        b12.setText("");b22.setText("");b32.setText("");b42.setText("");
                        i12 = row2[3];i22 = row2[2];i32 = row2[1];i42 = row2[0];
                        s12 = Integer.toString(i12);s22 = Integer.toString(i22);s32 = Integer.toString(i32);s42 = Integer.toString(i42);
                        if (!s12.equals("0")) {
                            b12.setText(s12);
                        }if (!s22.equals("0")) {
                            b22.setText(s22);
                        }if (!s32.equals("0")) {
                            b32.setText(s32);
                        }if (!s42.equals("0")) {
                            b42.setText(s42);
                        }

                        if (r2_arr!=row2) {
                            if (r2_arr[0] != 0 && row2[0]==0) {
                                b42.setText(new_int_to_string_row2);
                            }
                            if (r2_arr[0] == 0 && row2[0]==0 && row2[1]==0 && r2_arr[1] != 0) {
                                b32.setText(new_int_to_string_row2);
                            }
                            if (r2_arr[0] == 0 && row2[0]==0 && row2[1]==0 && row2[2]==0 && r2_arr[1] == 0 && r2_arr[2] != 0) {
                                b22.setText(new_int_to_string_row2);
                            }
                        }


                        r3_arr = new int[]{i13, i23, i33, i43};
                        int[] row3 = row_swipe_logic_solver(i43, i33, i23, i13);
                        b13.setText("");
                        b23.setText("");
                        b33.setText("");
                        b43.setText("");
                        i13 = row3[3];
                        i23 = row3[2];
                        i33 = row3[1];
                        i43 = row3[0];
                        s13 = Integer.toString(i13);
                        s23 = Integer.toString(i23);
                        s33 = Integer.toString(i33);
                        s43 = Integer.toString(i43);
                        if (!s13.equals("0")) {
                            b13.setText(s13);
                        }
                        if (!s23.equals("0")) {
                            b23.setText(s23);
                        }
                        if (!s33.equals("0")) {
                            b33.setText(s33);
                        }
                        if (!s43.equals("0")) {
                            b43.setText(s43);
                        }

                        if (r3_arr!=row3) {
                            if (r3_arr[0] != 0 && row3[0]==0) {
                                b43.setText(new_int_to_string_row3);
                            }
                            if (r3_arr[0] == 0 && row3[0]==0 && row3[1]==0 && r3_arr[1] != 0) {
                                b33.setText(new_int_to_string_row3);
                            }
                            if (r3_arr[0] == 0 && row3[0]==0 && row3[1]==0 && row3[2]==0 && r3_arr[1] == 0 && r3_arr[2] != 0) {
                                b23.setText(new_int_to_string_row3);
                            }
                        }

                        r4_arr = new int[]{i14, i24, i34, i44};
                        int[] row4 = row_swipe_logic_solver(i44, i34, i24, i14);
                        b14.setText("");
                        b24.setText("");
                        b34.setText("");
                        b44.setText("");
                        i14 = row4[3];
                        i24 = row4[2];
                        i34 = row4[1];
                        i44 = row4[0];
                        s14 = Integer.toString(i14);
                        s24 = Integer.toString(i24);
                        s34 = Integer.toString(i34);
                        s44 = Integer.toString(i44);
                        if (!s14.equals("0")) {
                            b14.setText(s14);
                        }
                        if (!s24.equals("0")) {
                            b24.setText(s24);
                        }
                        if (!s34.equals("0")) {
                            b34.setText(s34);
                        }
                        if (!s44.equals("0")) {
                            b44.setText(s44);
                        }
                        if (r4_arr!=row4) {
                            if (r4_arr[0] != 0 && row4[0]==0) {
                                b34.setText(new_int_to_string_row4);
                            }
                            if (r4_arr[0] == 0 && r4_arr[1] != 0  && row4[1]==0) {
                                b24.setText(new_int_to_string_row4);
                            }
                            if (r4_arr[0] == 0 && r4_arr[1] == 0 && r4_arr[2] != 0 && row4[2]==0) {
                                b14.setText(new_int_to_string_row4);
                            }
                        }


                        if (i11 == 2048 || i12 == 2048 || i13 == 2048 || i14 == 2048 || i21 == 2048 || i22 == 2048 || i23 == 2048 || i24 == 2048 || i31 == 2048 || i32 == 2048 || i33 == 2048 || i34 == 2048 || i41 == 2048 || i42 == 2048 || i43 == 2048 || i44 == 2048) {
                            // game won

                        }


                        colorSetter();

                        if (r1_arr == row1 && r2_arr == row2 && r3_arr == row3 && r4_arr == row4) {
                            bool1 = true;
                        } else {
                            bool1 = false;
                        }
                        if (bool1 == true && bool2 == true && bool3 == true && bool4 == true) {
                            GameOver();
                        }

                        i11 = 0;i12 = 0;i13 = 0;i14 = 0;
                        i21 = 0;i22 = 0;i23 = 0;i24 = 0;
                        i31 = 0;i32 = 0;i33 = 0;i34 = 0;
                        i41 = 0;i42 = 0;i43 = 0;i44 = 0;


                    }
                    return true;
                }
            }
            return false;
        }

    }
    public int[] row_swipe_logic_solver(int i1, int i2, int i3, int i4) {
        // Create a copy of the input array
        int[] arr = {i1, i2, i3, i4};
        
        // Shift non-zero values to the right
        for (int i = 3; i > 0; i--) {
            if (arr[i] == 0 && arr[i - 1] != 0) {
                arr[i] = arr[i - 1];
                arr[i - 1] = 0;

            }
        }

        // Merge equal adjacent values
        for (int i = 0; i < 3; i++) {
            if (arr[i] == arr[i + 1]) {
                arr[i] *= 2;
                arr[i + 1] = 0;
            }
        }

        // Shift non-zero values to the right again
        for (int i = 3; i > 0; i--) {
            if (arr[i] == 0 && arr[i - 1] != 0) {
                arr[i] = arr[i - 1];
                arr[i - 1] = 0;
            }
        }

        if (arr[3] == 0 && arr[2] != 0) {
            arr[3] = arr[2];
            arr[2] = arr[1];
            arr[1] = arr[0];
           return arr;

        }
        if (arr[3]!=0 && arr[2]==0 && arr[1]!=0 ){
            arr[2]=arr[1];
            arr[1]=arr[0];
            arr[0]=0;
            return arr;

        }
        if (arr[3]!=0 && arr[2]==0 && arr[1]==0 && arr[0]!=0){
            arr[2]=arr[0];
            arr[0]=0;
            return arr;
        }
        else{
            return arr;
        }
    }
    public int new_tile_number_generator( boolean above_or_equal_to_16){
        b11 = findViewById(R.id.button11);b12 = findViewById(R.id.button12);b13 = findViewById(R.id.button13);b14 = findViewById(R.id.button14);
        b21 = findViewById(R.id.button21);b22 = findViewById(R.id.button22);b23 = findViewById(R.id.button23);b24 = findViewById(R.id.button24);
        b31 = findViewById(R.id.button31);b32 = findViewById(R.id.button32);b33 = findViewById(R.id.button33);b34 = findViewById(R.id.button34);
        b41 = findViewById(R.id.button41);b42 = findViewById(R.id.button42);b43 = findViewById(R.id.button43);b44 = findViewById(R.id.button44);
        s11 = b11.getText().toString(); s12 = b12.getText().toString(); s13 = b13.getText().toString(); s14 = b14.getText().toString();
        s21 = b21.getText().toString(); s22 = b22.getText().toString(); s23 = b23.getText().toString(); s24 = b24.getText().toString();
        s31 = b31.getText().toString(); s32 = b32.getText().toString(); s33 = b33.getText().toString(); s34 = b34.getText().toString();
        s41 = b41.getText().toString(); s42 = b42.getText().toString(); s43 = b43.getText().toString(); s44 = b44.getText().toString();
        if (s11!=""){i11 = Integer.parseInt(s11);}if (s12!=""){i12=Integer.parseInt(s12);} if (s13!=""){i13=Integer.parseInt(s13);} if(s14!=""){i14=Integer.parseInt(s14);}
        if (s21!=""){i21 = Integer.parseInt(s21);}if (s22!=""){i22=Integer.parseInt(s22);} if (s23!=""){i23=Integer.parseInt(s23);} if(s24!=""){i24=Integer.parseInt(s24);}
        if (s31!=""){i31 = Integer.parseInt(s31);}if (s32!=""){i32=Integer.parseInt(s32);} if (s33!=""){i33=Integer.parseInt(s33);} if(s34!=""){i34=Integer.parseInt(s34);}
        if (s41!=""){i41 = Integer.parseInt(s41);}if (s42!=""){i42=Integer.parseInt(s42);} if (s43!=""){i43=Integer.parseInt(s43);} if(s44!=""){i44=Integer.parseInt(s44);}

        if (i11==2 || i12==2 || i13==2 || i14==2 || i21==2 || i22==2 || i23==2 || i24==2 || i31==2 || i32==2 || i33==2 || i34==2 || i41==2 || i42==2 || i43==2 || i44==2 ){
            int a = generateRandomNumber(1,2);
            if (a==1){return 2;}if (a==2){ return 4;} else {return 0;}
        }


        if (i11==4 || i12==4 || i13==4 || i14==4 || i21==4 || i22==4 || i23==4 || i24==4 || i31==4 || i32==4 || i33==4 || i34==4 || i41==4 || i42==4 || i43==4 || i44==4  ){
            int a = generateRandomNumber(1,2);
            if (a==1){return 2;}if (a==2){ return 4;} else {return 0;}
        }


        if (i11==8 || i12==8 || i13==8 || i14==8 || i21==8 || i22==8 || i23==8 || i24==8 || i31==8 || i32==8 || i33==8 || i34==8 || i41==8 || i42==8 || i43==8 || i44==8 ){
            int a = generateRandomNumber(1,3);
            if (a==1){return 2;}if (a==2){ return 4;} if (a==3){return 8;}else {return 0;}
        }
        
        if (i11==16 || i12==16 || i13==16 || i14==16 || i21==16 || i22==16 || i23==16 || i24==16 || i31==16 || i32==16 || i33==16 || i34==16 || i41==16 || i42==16 || i43==16 || i44==16 && above_or_equal_to_16==true ){
            int a = generateRandomNumber(1,4);
            abnd=0;
            booln16=false;
            if (a==1){return 2;}if (a==2){ return 4;} if (a==3){return 8;} if(a==4){return 16;}else {return 0;}
        }

        if (i11==32 || i12==32 || i13==32 || i14==32 || i21==32 || i22==32 || i23==32 || i24==32 || i31==32 || i32==32 || i33==32 || i34==32 || i41==32 || i42==32 || i43==32 || i44==32 && above_or_equal_to_16==true ){
            int a = generateRandomNumber(1,5);
            abnd=0;
            booln16=false;
            if (a==1){return 2;}if (a==2){ return 4;} if (a==3){return 8;} if(a==4){return 16;}if(a==5){return 32;}else {return 0;}
        }

        if (i11==64 || i12==64 || i13==64 || i14==64 || i21==64 || i22==64 || i23==64 || i24==64 || i31==64 || i32==64 || i33==64 || i34==64 || i41==64 || i42==64 || i43==64 || i44==64 && above_or_equal_to_16==true ){
            int a = generateRandomNumber(1,6);
            abnd=0;
            booln16=false;
            if (a==1){return 2;}if (a==2){ return 4;} if (a==3){return 8;} if(a==4){return 16;}if(a==5){return 32;}if(a==5){return 64;}  else {return 0;}
        }

        if (i11==128 || i12==128 || i13==128 || i14==128 || i21==128 || i22==128 || i23==128 || i24==128 || i31==128 || i32==128 || i33==128 || i34==128 || i41==128 || i42==128 || i43==128 || i44==128 && above_or_equal_to_16==true ){
            int a = generateRandomNumber(1,7);
            abnd=0;
            booln16=false;
            if (a==1){return 2;}if (a==2){ return 4;} if (a==3){return 8;} if(a==4){return 16;}if(a==5){return 32;}if(a==5){return 64;}  if (a==7){return 128;} else {return 0;}
        }

        if (i11==256 || i12==256 || i13==256 || i14==256 || i21==256 || i22==256 || i23==256 || i24==256 || i31==256 || i32==256 || i33==256 || i34==256 || i41==256 || i42==256 || i43==256 || i44==256 && above_or_equal_to_16==true ){
            int a = generateRandomNumber(1,8);
            abnd=0;
            booln16=false;
            if (a==1){return 2;}if (a==2){ return 4;} if (a==3){return 8;} if(a==4){return 16;}if(a==5){return 32;}if(a==5){return 64;}  if (a==7){return 128;} if (a==8){return 256;}else {return 0;}
        }

        if (i11==512 || i12==512 || i13==512 || i14==512 || i21==512 || i22==512 || i23==512 || i24==512 || i31==512 || i32==512 || i33==512 || i34==512 || i41==512 || i42==512 || i43==512 || i44==512 && above_or_equal_to_16==true ){
            int a = generateRandomNumber(1,9);
            abnd=0;
            booln16=false;
            if (a==1){return 2;}if (a==2){ return 4;} if (a==3){return 8;} if(a==4){return 16;}if(a==5){return 32;}if(a==5){return 64;}  if (a==7){return 128;} if (a==8){return 256;} if (a==9){return 512;} else {return 0;}
        }

        else {

            return 0;
        }
   
    }
    private void colorSetter(){
        b11 = findViewById(R.id.button11);b12 = findViewById(R.id.button12);b13 = findViewById(R.id.button13);b14 = findViewById(R.id.button14);
        b21 = findViewById(R.id.button21);b22 = findViewById(R.id.button22);b23 = findViewById(R.id.button23);b24 = findViewById(R.id.button24);
        b31 = findViewById(R.id.button31);b32 = findViewById(R.id.button32);b33 = findViewById(R.id.button33);b34 = findViewById(R.id.button34);
        b41 = findViewById(R.id.button41);b42 = findViewById(R.id.button42);b43 = findViewById(R.id.button43);b44 = findViewById(R.id.button44);
        s11 = b11.getText().toString(); s12 = b12.getText().toString(); s13 = b13.getText().toString(); s14 = b14.getText().toString();
        s21 = b21.getText().toString(); s22 = b22.getText().toString(); s23 = b23.getText().toString(); s24 = b24.getText().toString();
        s31 = b31.getText().toString(); s32 = b32.getText().toString(); s33 = b33.getText().toString(); s34 = b34.getText().toString();
        s41 = b41.getText().toString(); s42 = b42.getText().toString(); s43 = b43.getText().toString(); s44 = b44.getText().toString();
        if (s11!=""){i11 = Integer.parseInt(s11);}if (s12!=""){i12=Integer.parseInt(s12);} if (s13!=""){i13=Integer.parseInt(s13);} if(s14!=""){i14=Integer.parseInt(s14);}
        if (s21!=""){i21 = Integer.parseInt(s21);}if (s22!=""){i22=Integer.parseInt(s22);} if (s23!=""){i23=Integer.parseInt(s23);} if(s24!=""){i24=Integer.parseInt(s24);}
        if (s31!=""){i31 = Integer.parseInt(s31);}if (s32!=""){i32=Integer.parseInt(s32);} if (s33!=""){i33=Integer.parseInt(s33);} if(s34!=""){i34=Integer.parseInt(s34);}
        if (s41!=""){i41 = Integer.parseInt(s41);}if (s42!=""){i42=Integer.parseInt(s42);} if (s43!=""){i43=Integer.parseInt(s43);} if(s44!=""){i44=Integer.parseInt(s44);}

        if (i11==0){
            // back to normal
            b11.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i11==2){
            // color 1
            b11.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==4){
            // color 2
            b11.setBackgroundColor(Color.parseColor("#51A334"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==8){
            // color 
            b11.setBackgroundColor(Color.parseColor("#02103A"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==16){
            // color 4
            b11.setBackgroundColor(Color.parseColor("#BC3333"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==32){
            // color 5
            b11.setBackgroundColor(Color.parseColor("#B5B205"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==64){
            // color 6
            b11.setBackgroundColor(Color.parseColor("#028A7F"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==128){
            // color 7
            b11.setBackgroundColor(Color.parseColor("#A83EEA"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==256){
            // color 8
            b11.setBackgroundColor(Color.parseColor("#E16D1F"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==512){
            // color 9
            b11.setBackgroundColor(Color.parseColor("#057057"));
            b11.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i11==1028){
            // color 10
            b11.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b11.setTextColor(Color.parseColor("#272727"));
        }
        if (i11==2048){
            // color 11
            b11.setBackgroundColor(Color.parseColor("#000000"));
            b11.setTextColor(Color.parseColor("#E3E3E3"));
        }

        // i12


        if (i12==0){
            // back to normal
            b12.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i12==2){
            // color 1
            b12.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==4){
            // color 2
            b12.setBackgroundColor(Color.parseColor("#51A334"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==8){
            // color 
            b12.setBackgroundColor(Color.parseColor("#02103A"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==16){
            // color 4
            b12.setBackgroundColor(Color.parseColor("#BC3333"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==32){
            // color 5
            b12.setBackgroundColor(Color.parseColor("#B5B205"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==64){
            // color 6
            b12.setBackgroundColor(Color.parseColor("#028A7F"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==128){
            // color 7
            b12.setBackgroundColor(Color.parseColor("#A83EEA"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==256){
            // color 8
            b12.setBackgroundColor(Color.parseColor("#E16D1F"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==512){
            // color 9
            b12.setBackgroundColor(Color.parseColor("#057057"));
            b12.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i12==1028){
            // color 10
            b12.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b12.setTextColor(Color.parseColor("#272727"));
        }
        if (i12==2048){
            // color 12
            b12.setBackgroundColor(Color.parseColor("#000000"));
            b12.setTextColor(Color.parseColor("#E3E3E3"));
        }


        // i13 


        if (i13==0){
            // back to normal
            b13.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i13==2){
            // color 1
            b13.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==4){
            // color 2
            b13.setBackgroundColor(Color.parseColor("#51A334"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==8){
            // color 
            b13.setBackgroundColor(Color.parseColor("#02103A"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==16){
            // color 4
            b13.setBackgroundColor(Color.parseColor("#BC3333"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==32){
            // color 5
            b13.setBackgroundColor(Color.parseColor("#B5B205"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==64){
            // color 6
            b13.setBackgroundColor(Color.parseColor("#028A7F"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==128){
            // color 7
            b13.setBackgroundColor(Color.parseColor("#A83EEA"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==256){
            // color 8
            b13.setBackgroundColor(Color.parseColor("#E16D1F"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==512){
            // color 9
            b13.setBackgroundColor(Color.parseColor("#057057"));
            b13.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i13==1028){
            // color 10
            b13.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b13.setTextColor(Color.parseColor("#272727"));
        }
        if (i13==2048){
            // color 13
            b13.setBackgroundColor(Color.parseColor("#000000"));
            b13.setTextColor(Color.parseColor("#E3E3E3"));
        }


        // i14


        if (i14==0){
            // back to normal
            b14.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i14==2){
            // color 1
            b14.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==4){
            // color 2
            b14.setBackgroundColor(Color.parseColor("#51A334"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==8){
            // color 
            b14.setBackgroundColor(Color.parseColor("#02103A"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==16){
            // color 4
            b14.setBackgroundColor(Color.parseColor("#BC3333"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==32){
            // color 5
            b14.setBackgroundColor(Color.parseColor("#B5B205"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==64){
            // color 6
            b14.setBackgroundColor(Color.parseColor("#028A7F"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==128){
            // color 7
            b14.setBackgroundColor(Color.parseColor("#A83EEA"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==256){
            // color 8
            b14.setBackgroundColor(Color.parseColor("#E16D1F"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==512){
            // color 9
            b14.setBackgroundColor(Color.parseColor("#057057"));
            b14.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i14==1028){
            // color 10
            b14.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b14.setTextColor(Color.parseColor("#272727"));
        }
        if (i14==2048){
            // color 14
            b14.setBackgroundColor(Color.parseColor("#000000"));
            b14.setTextColor(Color.parseColor("#E3E3E3"));
        }
        
        //---------------------------------------------------------------------44



        if (i21==0){
            // back to normal
            b21.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i21==2){
            // color 1
            b21.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==4){
            // color 2
            b21.setBackgroundColor(Color.parseColor("#51A334"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==8){
            // color 
            b21.setBackgroundColor(Color.parseColor("#02103A"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==16){
            // color 4
            b21.setBackgroundColor(Color.parseColor("#BC3333"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==32){
            // color 5
            b21.setBackgroundColor(Color.parseColor("#B5B205"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==64){
            // color 6
            b21.setBackgroundColor(Color.parseColor("#028A7F"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==128){
            // color 7
            b21.setBackgroundColor(Color.parseColor("#A83EEA"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==256){
            // color 8
            b21.setBackgroundColor(Color.parseColor("#E16D1F"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==512){
            // color 9
            b21.setBackgroundColor(Color.parseColor("#057057"));
            b21.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i21==1028){
            // color 10
            b21.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b21.setTextColor(Color.parseColor("#272727"));
        }
        if (i21==2048){
            // color 11
            b21.setBackgroundColor(Color.parseColor("#000000"));
            b21.setTextColor(Color.parseColor("#E3E3E3"));
        }

        // i22


        if (i22==0){
            // back to normal
            b22.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i22==2){
            // color 1
            b22.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==4){
            // color 2
            b22.setBackgroundColor(Color.parseColor("#51A334"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==8){
            // color 
            b22.setBackgroundColor(Color.parseColor("#02103A"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==16){
            // color 4
            b22.setBackgroundColor(Color.parseColor("#BC3333"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==32){
            // color 5
            b22.setBackgroundColor(Color.parseColor("#B5B205"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==64){
            // color 6
            b22.setBackgroundColor(Color.parseColor("#028A7F"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==128){
            // color 7
            b22.setBackgroundColor(Color.parseColor("#A83EEA"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==256){
            // color 8
            b22.setBackgroundColor(Color.parseColor("#E16D1F"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==512){
            // color 9
            b22.setBackgroundColor(Color.parseColor("#057057"));
            b22.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i22==1028){
            // color 10
            b22.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b22.setTextColor(Color.parseColor("#272727"));
        }
        if (i22==2048){
            // color 12
            b22.setBackgroundColor(Color.parseColor("#000000"));
            b22.setTextColor(Color.parseColor("#E3E3E3"));
        }


        // i23 


        if (i23==0){
            // back to normal
            b23.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i23==2){
            // color 1
            b23.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==4){
            // color 2
            b23.setBackgroundColor(Color.parseColor("#51A334"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==8){
            // color 
            b23.setBackgroundColor(Color.parseColor("#02103A"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==16){
            // color 4
            b23.setBackgroundColor(Color.parseColor("#BC3333"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==32){
            // color 5
            b23.setBackgroundColor(Color.parseColor("#B5B205"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==64){
            // color 6
            b23.setBackgroundColor(Color.parseColor("#028A7F"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==128){
            // color 7
            b23.setBackgroundColor(Color.parseColor("#A83EEA"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==256){
            // color 8
            b23.setBackgroundColor(Color.parseColor("#E16D1F"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==512){
            // color 9
            b23.setBackgroundColor(Color.parseColor("#057057"));
            b23.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i23==1028){
            // color 10
            b23.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b23.setTextColor(Color.parseColor("#272727"));
        }
        if (i23==2048){
            // color 13
            b23.setBackgroundColor(Color.parseColor("#000000"));
            b23.setTextColor(Color.parseColor("#E3E3E3"));
        }


        // i24


        if (i24==0){
            // back to normal
            b24.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i24==2){
            // color 1
            b24.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==4){
            // color 2
            b24.setBackgroundColor(Color.parseColor("#51A334"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==8){
            // color 
            b24.setBackgroundColor(Color.parseColor("#02103A"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==16){
            // color 4
            b24.setBackgroundColor(Color.parseColor("#BC3333"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==32){
            // color 5
            b24.setBackgroundColor(Color.parseColor("#B5B205"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==64){
            // color 6
            b24.setBackgroundColor(Color.parseColor("#028A7F"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==128){
            // color 7
            b24.setBackgroundColor(Color.parseColor("#A83EEA"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==256){
            // color 8
            b24.setBackgroundColor(Color.parseColor("#E16D1F"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==512){
            // color 9
            b24.setBackgroundColor(Color.parseColor("#057057"));
            b24.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i24==1028){
            // color 10
            b24.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b24.setTextColor(Color.parseColor("#272727"));
        }
        if (i24==2048){
            // color 14
            b24.setBackgroundColor(Color.parseColor("#000000"));
            b24.setTextColor(Color.parseColor("#E3E3E3"));
        }
        
        //----------------------------------------------------


        if (i31==0){
            // back to normal
            b31.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i31==2){
            // color 1
            b31.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==4){
            // color 2
            b31.setBackgroundColor(Color.parseColor("#51A334"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==8){
            // color 
            b31.setBackgroundColor(Color.parseColor("#02103A"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==16){
            // color 4
            b31.setBackgroundColor(Color.parseColor("#BC3333"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==32){
            // color 5
            b31.setBackgroundColor(Color.parseColor("#B5B205"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==64){
            // color 6
            b31.setBackgroundColor(Color.parseColor("#028A7F"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==128){
            // color 7
            b31.setBackgroundColor(Color.parseColor("#A83EEA"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==256){
            // color 8
            b31.setBackgroundColor(Color.parseColor("#E16D1F"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==512){
            // color 9
            b31.setBackgroundColor(Color.parseColor("#057057"));
            b31.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i31==1028){
            // color 10
            b31.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b31.setTextColor(Color.parseColor("#272727"));
        }
        if (i31==2048){
            // color 11
            b31.setBackgroundColor(Color.parseColor("#000000"));
            b31.setTextColor(Color.parseColor("#E3E3E3"));
        }

        // i32

        if (i32==0){
            // back to normal
            b32.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i32==2){
            // color 1
            b32.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==4){
            // color 2
            b32.setBackgroundColor(Color.parseColor("#51A334"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==8){
            // color 
            b32.setBackgroundColor(Color.parseColor("#02103A"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==16){
            // color 4
            b32.setBackgroundColor(Color.parseColor("#BC3333"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==32){
            // color 5
            b32.setBackgroundColor(Color.parseColor("#B5B205"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==64){
            // color 6
            b32.setBackgroundColor(Color.parseColor("#028A7F"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==128){
            // color 7
            b32.setBackgroundColor(Color.parseColor("#A83EEA"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==256){
            // color 8
            b32.setBackgroundColor(Color.parseColor("#E16D1F"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==512){
            // color 9
            b32.setBackgroundColor(Color.parseColor("#057057"));
            b32.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i32==1028){
            // color 10
            b32.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b32.setTextColor(Color.parseColor("#272727"));
        }
        if (i32==2048){
            // color 12
            b32.setBackgroundColor(Color.parseColor("#000000"));
            b32.setTextColor(Color.parseColor("#E3E3E3"));
        }


        // i33 


        if (i33==0){
            // back to normal
            b33.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i33==2){
            // color 1
            b33.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==4){
            // color 2
            b33.setBackgroundColor(Color.parseColor("#51A334"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==8){
            // color 
            b33.setBackgroundColor(Color.parseColor("#02103A"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==16){
            // color 4
            b33.setBackgroundColor(Color.parseColor("#BC3333"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==32){
            // color 5
            b33.setBackgroundColor(Color.parseColor("#B5B205"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==64){
            // color 6
            b33.setBackgroundColor(Color.parseColor("#028A7F"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==128){
            // color 7
            b33.setBackgroundColor(Color.parseColor("#A83EEA"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==256){
            // color 8
            b33.setBackgroundColor(Color.parseColor("#E16D1F"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==512){
            // color 9
            b33.setBackgroundColor(Color.parseColor("#057057"));
            b33.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i33==1028){
            // color 10
            b33.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b33.setTextColor(Color.parseColor("#272727"));
        }
        if (i33==2048){
            // color 13
            b33.setBackgroundColor(Color.parseColor("#000000"));
            b33.setTextColor(Color.parseColor("#E3E3E3"));
        }


        // i34


        if (i34==0){
            // back to normal
            b34.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i34==2){
            // color 1
            b34.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==4){
            // color 2
            b34.setBackgroundColor(Color.parseColor("#51A334"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==8){
            // color 
            b34.setBackgroundColor(Color.parseColor("#02103A"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==16){
            // color 4
            b34.setBackgroundColor(Color.parseColor("#BC3333"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==32){
            // color 5
            b34.setBackgroundColor(Color.parseColor("#B5B205"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==64){
            // color 6
            b34.setBackgroundColor(Color.parseColor("#028A7F"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==128){
            // color 7
            b34.setBackgroundColor(Color.parseColor("#A83EEA"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==256){
            // color 8
            b34.setBackgroundColor(Color.parseColor("#E16D1F"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==512){
            // color 9
            b34.setBackgroundColor(Color.parseColor("#057057"));
            b34.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i34==1028){
            // color 10
            b34.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b34.setTextColor(Color.parseColor("#272727"));
        }
        if (i34==2048){
            // color 14
            b34.setBackgroundColor(Color.parseColor("#000000"));
            b34.setTextColor(Color.parseColor("#E3E3E3"));
        }
        
        //--------------------------------------------------------


        if (i41==0){
            // back to normal
            b41.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i41==2){
            // color 1
            b41.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==4){
            // color 2
            b41.setBackgroundColor(Color.parseColor("#51A334"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==8){
            // color 
            b41.setBackgroundColor(Color.parseColor("#02103A"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==16){
            // color 4
            b41.setBackgroundColor(Color.parseColor("#BC3333"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==32){
            // color 5
            b41.setBackgroundColor(Color.parseColor("#B5B205"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==64){
            // color 6
            b41.setBackgroundColor(Color.parseColor("#028A7F"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==128){
            // color 7
            b41.setBackgroundColor(Color.parseColor("#A83EEA"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==256){
            // color 8
            b41.setBackgroundColor(Color.parseColor("#E16D1F"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==512){
            // color 9
            b41.setBackgroundColor(Color.parseColor("#057057"));
            b41.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i41==1028){
            // color 10
            b41.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b41.setTextColor(Color.parseColor("#272727"));
        }
        if (i41==2048){
            // color 11
            b41.setBackgroundColor(Color.parseColor("#000000"));
            b41.setTextColor(Color.parseColor("#E3E3E3"));
        }

        // i42

        if (i42==0){
            // back to normal
            b42.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i42==2){
            // color 1
            b42.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==4){
            // color 2
            b42.setBackgroundColor(Color.parseColor("#51A334"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==8){
            // color 
            b42.setBackgroundColor(Color.parseColor("#02103A"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==16){
            // color 4
            b42.setBackgroundColor(Color.parseColor("#BC3333"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==32){
            // color 5
            b42.setBackgroundColor(Color.parseColor("#B5B205"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==64){
            // color 6
            b42.setBackgroundColor(Color.parseColor("#028A7F"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==128){
            // color 7
            b42.setBackgroundColor(Color.parseColor("#A83EEA"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==256){
            // color 8
            b42.setBackgroundColor(Color.parseColor("#E16D1F"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==512){
            // color 9
            b42.setBackgroundColor(Color.parseColor("#057057"));
            b42.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i42==1028){
            // color 10
            b42.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b42.setTextColor(Color.parseColor("#272727"));
        }
        if (i42==2048){
            // color 12
            b42.setBackgroundColor(Color.parseColor("#000000"));
            b42.setTextColor(Color.parseColor("#E3E3E3"));
        }


        // i43 


        if (i43==0){
            // back to normal
            b43.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i43==2){
            // color 1
            b43.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==4){
            // color 2
            b43.setBackgroundColor(Color.parseColor("#51A334"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==8){
            // color 
            b43.setBackgroundColor(Color.parseColor("#02103A"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==16){
            // color 4
            b43.setBackgroundColor(Color.parseColor("#BC3333"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==32){
            // color 5
            b43.setBackgroundColor(Color.parseColor("#B5B205"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==64){
            // color 6
            b43.setBackgroundColor(Color.parseColor("#028A7F"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==128){
            // color 7
            b43.setBackgroundColor(Color.parseColor("#A83EEA"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==256){
            // color 8
            b43.setBackgroundColor(Color.parseColor("#E16D1F"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==512){
            // color 9
            b43.setBackgroundColor(Color.parseColor("#057057"));
            b43.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i43==1028){
            // color 10
            b43.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b43.setTextColor(Color.parseColor("#272727"));
        }
        if (i43==2048){
            // color 13
            b43.setBackgroundColor(Color.parseColor("#000000"));
            b43.setTextColor(Color.parseColor("#E3E3E3"));
        }


        // i44


        if (i44==0){
            // back to normal
            b44.setBackgroundColor(Color.parseColor("#A9030303"));
        }
        if (i44==2){
            // color 1
            b44.setBackgroundColor(Color.parseColor("#0F2DC8"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==4){
            // color 2
            b44.setBackgroundColor(Color.parseColor("#51A334"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==8){
            // color 
            b44.setBackgroundColor(Color.parseColor("#02103A"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==16){
            // color 4
            b44.setBackgroundColor(Color.parseColor("#BC3333"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==32){
            // color 5
            b44.setBackgroundColor(Color.parseColor("#B5B205"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==64){
            // color 6
            b44.setBackgroundColor(Color.parseColor("#028A7F"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==128){
            // color 7
            b44.setBackgroundColor(Color.parseColor("#A83EEA"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==256){
            // color 8
            b44.setBackgroundColor(Color.parseColor("#E16D1F"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==512){
            // color 9
            b44.setBackgroundColor(Color.parseColor("#057057"));
            b44.setTextColor(Color.parseColor("#ffffff"));
        }
        if (i44==1028){
            // color 10
            b44.setBackgroundColor(Color.parseColor("#FFFFFF"));
            b44.setTextColor(Color.parseColor("#272727"));
        }
        if (i44==2048){
            // color 14
            b44.setBackgroundColor(Color.parseColor("#000000"));
            b44.setTextColor(Color.parseColor("#E3E3E3"));
        }
        
    }
}
