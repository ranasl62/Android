package ranasl62.com.luck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class congratulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congratulation);
        TextView textView =findViewById(R.id.res);
        textView.setText("Congratulations");

    }

}
