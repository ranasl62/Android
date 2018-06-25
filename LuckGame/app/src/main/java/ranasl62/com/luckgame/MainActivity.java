package ranasl62.com.luckgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    public long win;
    public long lose;
    public long value=0;
    public long index=0;
    ImageView view ;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.lamp);
        textView=findViewById(R.id.winLose);
        win=0;
        value=0;
        Button onButton = findViewById(R.id.lampOn);
        Button offButton = findViewById(R.id.lampOff);

        view.setImageResource(R.drawable.off);

        onButton.setOnClickListener(v -> {LampOn(v);});
        offButton.setOnClickListener(v -> {LampOff(v);});
    }

    private void Reset(View v) {
        textView.setText("");
        win=0;
        lose=0;
    }

/*
    public void puzzle(){
        Thread t =new Thread(){
            @Override
            public void run(){
                while(!isInterrupted()){
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                value = (long) (Math.random() + 0.5);
                                if (value == 0) {
                                    view.setImageResource(R.drawable.off);
                                }
                                else {
                                    view.setImageResource(R.drawable.on);
                                }
                                Log.d("Ra", "run: ");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }*/

    public void LampOn(View v){
        index++;
         value = (long) (Math.random() + 0.5);
        if (value == 0) {
            lose++;
            view.setImageResource(R.drawable.off);
            textView.setText("Step : "+index+" Wrong Answer");/*for(int i=0;i<100000000;i++);
            textView.setText("");*/
        }
        else {
            view.setImageResource(R.drawable.on);
            textView.setText("Step : "+index+" Right Answer");/*for(int i=0;i<100000000;i++);
            textView.setText("");*/
            win++;
        }
        if(index>=10){
            textView.setText("Your are "+win*10+"% Lucky");
            view.setImageResource(R.drawable.off);
            win=0;
            lose=0;
            index=0;
        }
    }


    public void LampOff(View v){
        index++;
        value = (long) (Math.random() + 0.5);
        if (value == 0) {
            win++;
            textView.setText("Step : "+index+" Right Answer");/*for(int i=0;i<100000000;i++);
            textView.setText("");*/
            view.setImageResource(R.drawable.off);
        }
        else {
            textView.setText("Step : "+index+" Wrong Answer");/*for(int i=0;i<100000000;i++);
            textView.setText("");*/
            view.setImageResource(R.drawable.on);
            lose++;
        }
        if(index>=10){
            textView.setText("Your are "+win*10+"% Lucky");
            view.setImageResource(R.drawable.on);
            win=0;lose=0;
            index=0;


        }

    }

}



