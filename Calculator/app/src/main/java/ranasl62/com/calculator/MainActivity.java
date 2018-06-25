package ranasl62.com.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;

public class MainActivity extends AppCompatActivity {
    private TextView displayField;
    private int newoperation=0;
    private int oldoperation=0;
    private double number1=0.0f;
    private double number2=0.0f;
    private int signed=0;
    private boolean sign =false;
    private double pi =2*acos(0.0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayField=findViewById(R.id.display);
        Button mod =findViewById(R.id.mod);
        Button sqrtroot =findViewById(R.id.sqrtroot);
        Button sqrts =findViewById(R.id.sqrts);
        Button ce =findViewById(R.id.ce);
        Button c =findViewById(R.id.c);
        Button delete =findViewById(R.id.delete);
        Button division =findViewById(R.id.division);
        Button seven =findViewById(R.id.seven);
        Button eight =findViewById(R.id.eight);
        Button nine =findViewById(R.id.nine);
        Button four =findViewById(R.id.four);
        Button five =findViewById(R.id.five);
        Button six =findViewById(R.id.six);
        Button multiplication =findViewById(R.id.multiplication);
        Button subtraction =findViewById(R.id.subtraction);
        Button one =findViewById(R.id.one);
        Button two =findViewById(R.id.two);
        Button three =findViewById(R.id.three);
        Button addition =findViewById(R.id.addition);
        Button signed =findViewById(R.id.signed);
        Button zero =findViewById(R.id.zero);
        Button decimalpoint =findViewById(R.id.decimalpoint);
        Button equal =findViewById(R.id.equal);
        Button logs =findViewById(R.id.log);
        Button PI =findViewById(R.id.PI);
        Button Sin =findViewById(R.id.sin);
        Button Cos =findViewById(R.id.cos);
        Button Tan =findViewById(R.id.tans);
        mod.setOnClickListener(v -> {mod(v);});
        sqrtroot.setOnClickListener(v -> {sqrtroot(v);});
        sqrts.setOnClickListener(v -> {sqrts(v);});
        ce.setOnClickListener(v -> {ce(v);});
        c.setOnClickListener(v -> {c(v);});
        delete.setOnClickListener(v -> {delete(v);});
        division.setOnClickListener(v -> {division(v);});
        seven.setOnClickListener(v -> {seven(v);});
        eight.setOnClickListener(v -> {eight(v);});
        nine.setOnClickListener(v -> {nine(v);});
        four.setOnClickListener(v -> {four(v);});
        five.setOnClickListener(v -> {five(v);});
        six.setOnClickListener(v -> {six(v);});
        multiplication.setOnClickListener(v -> {multiplication(v);});
        subtraction.setOnClickListener(v -> {subtraction(v);});
        one.setOnClickListener(v -> {one(v);});
        two.setOnClickListener(v -> {two(v);});
        three.setOnClickListener(v -> {three(v);});
        addition.setOnClickListener(v -> {addition(v);});
        signed.setOnClickListener(v -> {signed(v);});
        zero.setOnClickListener(v -> {zero(v);});
        decimalpoint.setOnClickListener(v -> {decimalpoint(v);});
        equal.setOnClickListener(v -> {equal(v);});
        logs.setOnClickListener(v -> {logs(v);});
        PI.setOnClickListener(v -> {PI(v);});
        Tan.setOnClickListener(v -> {Tan(v);});
        Cos.setOnClickListener(v -> {Cos(v);});
        Sin.setOnClickListener(v -> {Sin(v);});

    }

    private void Sin(View v) {
        displayField.setText(sin(Double.parseDouble(displayField.getText().toString())*pi/180)+"");
        sign = true;
        number1=number2=0.0f;
    }

    private void Cos(View v) {
        if(Double.parseDouble(displayField.getText().toString())==90.0)
            displayField.setText("0");
        else
            displayField.setText(cos(Double.parseDouble(displayField.getText().toString())*pi/180)+"");
        sign = true;
        number1=number2=0.0f;
    }

    private void Tan(View v) {
        if(Double.parseDouble(displayField.getText().toString())==90.0)
            displayField.setText("Infinity");
        else
            displayField.setText(tan(Double.parseDouble(displayField.getText().toString())*pi/180)+"");
        sign = true;
        number1=number2=0.0f;
    }

    private void sqrts(View v) {
        double sq ;
        sq = Double.parseDouble(displayField.getText().toString());
        sq = sqrt(sq);
        displayField.setText(sq+"");
        sign = true;
        number1=number2=0.0f;
    }

    private void PI(View v) {
        displayField.setText(pi+"");
        sign = true;
        number1=number2=0.0f;
    }

    private void signed(View v) {
        String a;
        a = displayField.getText().toString();
        if(displayField.getText().charAt(0) != '-' && displayField.getText().charAt(0) != '+'){
            displayField.setText("-"+a);
        }
        else {
            a = displayField.getText().toString();
            if(a.charAt(0)=='-'){
                a = a.replace(a.charAt(0) , '+');
            }
            else
                a = a.replace(a.charAt(0) , '-');
            displayField.setText(a);
        }
    }

    private void logs(View v) {
        displayField.setText(((log( Double.parseDouble ( displayField.getText().toString()) ))/log(10))+"");
        sign = true;
        number1=number2=0.0f;
    }
    private void decimalpoint(View v) {
        if(!displayField.getText().toString().contains(".")){
            if(!"0".equals(displayField.getText()) && sign==false ){
                displayField.setText(displayField.getText()+".");
            }
            else {
                displayField.setText("0.");
                sign =false;
            }
        }
        }

    private void equal(View v) {
        int len;
        do{
            number2  = Double.parseDouble(displayField.getText().toString());
            len = displayField.getText().length();
        }while(len==0);
        switch (newoperation){
            case 1 :
                displayField.setText((number1+number2)+"");
                break;
            case 2 :
                displayField.setText((number1-number2)+"");

                break;
            case 3 :
                displayField.setText((number1*number2)+"");
                break;
            case 4 :
                displayField.setText((number1/number2)+"");
                break;
            case 5 :
                displayField.setText((pow(number1,number2))+"");
                break;
        }
        newoperation = 0;
    }

    private void zero(View v) {
        if(!"0".equals(displayField.getText())&& sign==false){
            displayField.setText(displayField.getText()+"0");
        }
        else{
            displayField.setText("0");
            sign = false;
        }
    }
    private void addition(View v) {
        if(newoperation==0){
            newoperation =1;
            number1=Double.parseDouble(displayField.getText().toString());
            sign=true;
        }
        else if(sign==false)
        {
            switch (newoperation){
                case 1 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1+number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
                case 2 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1-number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());

                } break;
                case 3 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1*number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
                case 4 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1/number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
            }
            sign =true;
        }
        newoperation=1;
        newoperation=1;
    }

    private void three(View v) {
        if(!"0".equals(displayField.getText()) && sign==false ){
            displayField.setText(displayField.getText()+"3");
        }
        else {
            displayField.setText("3");
            sign =false;
        }
    }

    private void two(View v) {
        if(!"0".equals(displayField.getText()) && sign==false ){
            displayField.setText(displayField.getText()+"2");
        }
        else {
            displayField.setText("2");
            sign =false;
        }
    }

    private void one(View v) {
        if(!"0".equals(displayField.getText().toString()) && sign ==false ){
            displayField.setText(displayField.getText().toString()+"1");
        }
        else {
            displayField.setText("1");
            sign=false;
        }
    }

    private void subtraction(View v) {
        if(newoperation==0){
            newoperation =2;
            number1=Double.parseDouble(displayField.getText().toString());
            sign=true;
        }
        else if(sign==false)
        {
            switch (newoperation){
                case 1 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1+number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
                case 2 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1-number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());

                } break;
                case 3 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1*number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
                case 4 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1/number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
            }
            sign =true;
        }
        newoperation=2;
    }

    private void multiplication(View v) {
        if(newoperation==0){
            newoperation =3;
            number1=Double.parseDouble(displayField.getText().toString());
            sign=true;
        }
        else if(sign==false)
        {
            switch (newoperation){
                case 1 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1+number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
                case 2 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1-number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());

                } break;
                case 3 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1*number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
                case 4 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1/number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
            }
            sign =true;
        }
        newoperation=3;
    }

    private void six(View v) {
        if(!"0".equals(displayField.getText()) && sign==false ){
            displayField.setText(displayField.getText()+"6");
        }
        else {
            displayField.setText("6");
            sign =false;
        }
    }

    private void five(View v) {
        if(!"0".equals(displayField.getText()) && sign==false ){
            displayField.setText(displayField.getText()+"5");
        }
        else {
            displayField.setText("5");
            sign =false;
        }
    }

    private void four(View v) {
        if(!"0".equals(displayField.getText()) && sign==false ){
            displayField.setText(displayField.getText()+"4");
        }
        else {
            displayField.setText("4");
            sign =false;
        }
    }

    private void nine(View v) {
        if(!"0".equals(displayField.getText()) && sign==false ){
            displayField.setText(displayField.getText()+"9");
        }
        else {
            displayField.setText("9");
            sign =false;
        }
    }

    private void eight(View v) {
        if(!"0".equals(displayField.getText()) && sign==false ){
            displayField.setText(displayField.getText()+"8");
        }
        else {
            displayField.setText("8");
            sign =false;
        }
    }

    private void seven(View v) {
        if(!"0".equals(displayField.getText()) && sign==false ){
            displayField.setText(displayField.getText()+"7");
        }
        else {
            displayField.setText("7");
            sign =false;
        }
    }

    private void division(View v) {
        if(newoperation==0){
            newoperation =4;
            number1=Double.parseDouble(displayField.getText().toString());
            sign=true;
        }
        else if(sign==false)
        {
            switch (newoperation){
                case 1 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1+number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
                case 2 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1-number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());

                } break;
                case 3 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1*number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
                case 4 :{
                    number2=Double.parseDouble(displayField.getText().toString());
                    displayField.setText((number1/number2)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                } break;
            }
            sign =true;
        }
        newoperation=4;
    }

    private void delete(View v) {
    }

    private void c(View v) {
        int len = displayField.getText().length();
        if(displayField.getText().equals("NaN") || displayField.getText().equals("Infinity") )
            displayField.setText("0");
        else if(len>0){
            displayField.setText(displayField.getText().toString().substring(0, len-1) );
        }
        if(--len<=0)
            displayField.setText("0");
    }

    private void ce(View v) {
        displayField.setText("0");
        newoperation=0;
        oldoperation=0;
        number1=0.0f;
        number2=0.0f;
        signed=0;
        sign = false;
    }


    private void sqrtroot(View v) {
    }

    private void mod(View v) {
        if(newoperation!=0){
            number2=Double.parseDouble(displayField.getText().toString());
            switch (newoperation) {
                case 1:
                    displayField.setText((number1+number1*number2/100.0)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                    break;
                case 2:
                    displayField.setText((number1-number1*number2/100.0)+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                    break;
                case 3:
                    displayField.setText((number1*(number2/100.0))+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                    break;
                case 4:
                    displayField.setText((number1/((number1*number2)/100.0))+"");
                    number1=Double.parseDouble(displayField.getText().toString());
                    break;
            }

        }
        newoperation = 0;
        sign = false;
    }

}
