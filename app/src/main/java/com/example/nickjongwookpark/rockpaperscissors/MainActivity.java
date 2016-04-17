package com.example.nickjongwookpark.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;
    TextView textViewResult;
    Button btnScissors, btnRock, btnPaper;
    ImageView imageViewMe, imageViewComputer;

    String me = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        btnPaper = (Button) findViewById(R.id.btnPaper);
        btnScissors = (Button) findViewById(R.id.btnScissors);
        btnRock = (Button) findViewById(R.id.btnRock);
        imageViewMe = (ImageView) findViewById(R.id.imageViewMe);
        imageViewComputer = (ImageView) findViewById(R.id.imageViewComputer);

        btnScissors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Scissors selected",
                        Toast.LENGTH_SHORT).show();
                me = "scissors";
                setMeImage(me);
                btnScissors.setEnabled(false);
                btnRock.setEnabled(true);
                btnPaper.setEnabled(true);
            }
        });
        btnRock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Rock selected",
                        Toast.LENGTH_SHORT).show();
                me = "rock";
                setMeImage(me);
                btnRock.setEnabled(false);
                btnScissors.setEnabled(true);
                btnPaper.setEnabled(true);
            }
        });
        btnPaper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Paper selected",
                        Toast.LENGTH_SHORT).show();
                me = "paper";
                setMeImage(me);
                btnPaper.setEnabled(false);
                btnScissors.setEnabled(true);
                btnPaper.setEnabled(true);
            }
        });


        btnPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String computer = randomComputer();
                setComputerImage(computer);
                whoWon(me, computer);
            }
        });
    }

    public void setMeImage(String me){
        if(me.equals("scissors")){
            imageViewMe.setImageResource(R.drawable.left_scissors);
        } else if(me.equals("rock")){
            imageViewMe.setImageResource(R.drawable.left_rock);
        } else if(me.equals("paper")){
            imageViewMe.setImageResource(R.drawable.left_paper);
        }
    }

    public void setComputerImage(String computer){
        if(computer.equals("scissors")){
            imageViewComputer.setImageResource(R.drawable.right_scissors);
        } else if(computer.equals("rock")){
            imageViewComputer.setImageResource(R.drawable.right_rock);
        } else if(computer.equals("paper")){
            imageViewComputer.setImageResource(R.drawable.right_paper);
        }
    }

    public String randomComputer(){
        String computer = "";
        Random rand = new Random();
        int random = rand.nextInt(3);
        if(random==0){
            computer = "scissors";
        } else if (random==1){
            computer = "rock";
        } else if(random==2){
            computer = "paper";
        } else {
            computer = "error";
        }
        return computer;
    }

    public void showToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void whoWon(String me, String computer){
        String result = ""; //결과를 저장할 변수
        if(me.equals("scissors")){
            //내가 가위를 내면...
            if(computer.equals("scissors")){
                result = "draw!";
            } else if (computer.equals("rock")){
                result = "lose!";
            } else if (computer.equals("paper")){
                result = "win!";
            } else {
                result = "typo!";
            }
        } else if (me.equals("rock")) {
            //내가 바위를 내면...
            if(computer.equals("scissors")){
                result = "win!";
            } else if (computer.equals("rock")){
                result = "draw!";
            } else if (computer.equals("paper")){
                result = "lose!";
            } else {
                result = "typo!";
            }
        } else if(me.equals("paper")){
            //내가 가위를 내면...
            if(computer.equals("scissors")){
                result = "lose!";
            } else if (computer.equals("rock")){
                result = "win!";
            } else if (computer.equals("paper")){
                result = "draw!";
            } else {
                result = "typo!";
            }
        } else {
            result = "가위 바위 보를 선택해 주세요!";
        }
        showToast(me + " vs " + computer);
        showResult(result);
    }

    //textViewResult 의 값을 변경해준다
    public void showResult(String result){
        textViewResult.setText(result);
    }
}
