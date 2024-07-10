package com.example.tictactoe;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    // X-0
    //O-1
    //null-2
    String Winner;
  Boolean gameActive = true;
   int[][] winPosition ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer =2;
    int[] gameState ={2,2,2,2,2,2,2,2,2};

public void playerTap(View view){
    ImageView img = (ImageView) view;
    int tappedImage = Integer.parseInt(img.getTag().toString());
    if (gameState[tappedImage]==2 /*&& gameActive*/)
    {
        gameState[tappedImage]=activePlayer;
        if(activePlayer==0){
            activePlayer=1;
           // img.setTranslationY(-1000f);
            img.setImageResource(R.drawable.x);
          /*  TextView status = findViewById(R.id.main);
            status.setText("X's Turn");*/
        }
        else{
            activePlayer=0;
            img.setImageResource(R.drawable.o);
           /* TextView status = findViewById(R.id.main);
            status.setText("O's Turn");
*/
        }

    }
  //  img.animate().translationYBy(1000f).setDuration(300);

    for(int[] winningPosition:winPosition){
        if(gameState[winningPosition[0]]==gameState[winningPosition[1]]
            && gameState[winningPosition[1]]==gameState[winningPosition[2]]
                && gameState[winningPosition[0]]!= 2){
          if(gameState[winningPosition[0]]==1){
               Winner ="o won the match.";
          }
          else{
              Winner = "X won the match.";
          }
          gameActive=false;
        }

    }
}
public void gameReset (View view){
    gameActive=true;
    activePlayer=0;
    for(int i=0;i< gameState.length; i++){
        gameState[i]=2;
    }
    ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
}