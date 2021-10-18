package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private double memory;

    private EditText display;
    private TextView additional_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        additional_display = findViewById(R.id.textView);

        display.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString()))
                {
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd)
    {

        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (display.getText().toString().length() < 11) {

            if (getString(R.string.display).equals(display.getText().toString())) {

                display.setText(strToAdd);

            } else {

                display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            }

            display.setSelection(cursorPos + 1);
        }

    }

    public void zeroBTN(View view){
        String strToAdd = "0";
        updateText(strToAdd);
    }

    public void oneBTN(View view){
        String strToAdd = "1";
        updateText(strToAdd);
    }

    public void twoBTN(View view){
        String strToAdd = "2";
        updateText(strToAdd);
    }

    public void threeBTN(View view){
        String strToAdd = "3";
        updateText(strToAdd);
    }

    public void fourBTN(View view){
        String strToAdd = "4";
        updateText(strToAdd);
    }

    public void fiveBTN(View view){
        String strToAdd = "5";
        updateText(strToAdd);
    }

    public void sixBTN(View view){
        String strToAdd = "6";
        updateText(strToAdd);
    }

    public void sevenBTN(View view){
        String strToAdd = "7";
        updateText(strToAdd);
    }

    public void eightBTN(View view){
        String strToAdd = "8";
        updateText(strToAdd);
    }

    public void nineBTN(View view){
        String strToAdd = "9";
        updateText(strToAdd);
    }

    public void plus_minusBTN(View view){
        String strToAdd = "*(-1)";
        String userExp = display.getText().toString();

        userExp = userExp + strToAdd;
        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void clearBTN(View view){
        additional_display.setText(display.getText().toString());
        display.setText("0");

    }
    public void percentBTN(View view){
        String strToAdd = "%";
        updateText(strToAdd);
    }

    public void dividerBTN(View view){
        String strToAdd = "÷";
        updateText(strToAdd);
    }

    public void multipleBTN(View view){
        String strToAdd = "*";
        updateText(strToAdd);
    }

    public void minusBTN(View view){
        String strToAdd = "-";
        updateText(strToAdd);
    }

    public void plusBTN(View view){
        String strToAdd = "+";
        updateText(strToAdd);
    }

    public void memPlusBTN(View view){
        String strToAdd = "M+";
        changeMemory(strToAdd);
    }

    public void memMinusBTN(View view){
        String strToAdd = "M-";
        changeMemory(strToAdd);
    }

    //commit number currently on screen to memory
    public void changeMemory(String strToAdd){
        String displayText = display.getText().toString();

        if (displayText.equals("")
                || displayText.contains("+")
                || displayText.contains("*")
                || displayText.contains("/")
                || displayText.contains("%"))
        {
            return;
        }

        if (strToAdd.equals("M+")){

            memory += Double.parseDouble(displayText);

        } else {

            memory -= Double.parseDouble(displayText);
        }

        display.setSelection(displayText.length());

    }
    //show the current memory value
    public void showMemory(View sender){
        display.setText(String.valueOf(memory));
        display.setSelection(display.getText().toString().length());
    }

    //reset memory value to 0
    public void clearMemory(View sender){
        memory = 0;
    }

    public void equalBTN(View view){
        String userExp = display.getText().toString();
        String oldStr = userExp;

        userExp = userExp.replaceAll(" ", "");
        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("%", "/100");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        additional_display.setText(oldStr);

        display.setText(result);
        display.setSelection(result.length());

    }

    public void pointBTN(View view){
        String strToAdd = ".";
        updateText(strToAdd);
    }

    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        String oldStr = display.getText().toString();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        } else {
            additional_display.setText(oldStr);
            display.setText("0");
        }
    }

}


//
//package com.example.myapplication;
//
//        import androidx.appcompat.app.AlertDialog;
//        import androidx.appcompat.app.AppCompatActivity;
//        import org.mariuszgromada.math.mxparser.*;
//        import android.os.Bundle;
//        import android.os.Message;
//        import android.text.SpannableStringBuilder;
//        import android.view.View;
//        import android.widget.EditText;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
//
//public class MainActivity extends AppCompatActivity {
//
//    String data;
//
//    private EditText display;
//    private TextView additional_display;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        display = findViewById(R.id.input);
//        display.setShowSoftInputOnFocus(false);
//
//        additional_display = findViewById(R.id.textView);
//
//        display.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//                if (getString(R.string.display).equals(display.getText().toString()))
//                {
//                    display.setText("");
//                }
//            }
//        });
//    }
//
//    private void updateText(String strToAdd)
//    {
//
//        String oldStr = display.getText().toString();
//        int cursorPos = display.getSelectionStart();
//        String leftStr = oldStr.substring(0, cursorPos);
//        String rightStr = oldStr.substring(cursorPos);
//
//
//        if (getString(R.string.display).equals(display.getText().toString())){
//            display.setText(strToAdd);
//        }
//        else {
//            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
//        }
//
//        display.setSelection(cursorPos + 1);
//
//    }
//
//    public void zeroBTN(View view){
//        String strToAdd = "0";
//        updateText(strToAdd);
//    }
//
//    public void oneBTN(View view){
//        String strToAdd = "1";
//        updateText(strToAdd);
//    }
//
//    public void twoBTN(View view){
//        String strToAdd = "2";
//        updateText(strToAdd);
//    }
//
//    public void threeBTN(View view){
//        String strToAdd = "3";
//        updateText(strToAdd);
//    }
//
//    public void fourBTN(View view){
//        String strToAdd = "4";
//        updateText(strToAdd);
//    }
//
//    public void fiveBTN(View view){
//        String strToAdd = "5";
//        updateText(strToAdd);
//    }
//
//    public void sixBTN(View view){
//        String strToAdd = "6";
//        updateText(strToAdd);
//    }
//
//    public void sevenBTN(View view){
//        String strToAdd = "7";
//        updateText(strToAdd);
//    }
//
//    public void eightBTN(View view){
//        String strToAdd = "8";
//        updateText(strToAdd);
//    }
//
//    public void nineBTN(View view){
//        String strToAdd = "9";
//        updateText(strToAdd);
//    }
//
//    public void plus_minusBTN(View view){
//        String strToAdd = "*(-1)";
//        String userExp = display.getText().toString();
//        String oldStr = userExp;
//
//        userExp = userExp + strToAdd;
//        Expression exp = new Expression(userExp);
//
//        String result = String.valueOf(exp.calculate());
//
//        display.setText(result);
//        display.setSelection(result.length());
//    }
//
//    public void clearBTN(View view){
//        additional_display.setText(display.getText().toString());
//        display.setText("Empty");
//
//    }
//    public void percentBTN(View view){
//        String strToAdd = "%";
//        updateText(strToAdd);
//    }
//
//    public void dividerBTN(View view){
//        String strToAdd = "÷";
//        updateText(strToAdd);
//    }
//
//    public void multipleBTN(View view){
//        String strToAdd = "*";
//        updateText(strToAdd);
//    }
//
//    public void minusBTN(View view){
//        String strToAdd = "-";
//        updateText(strToAdd);
//    }
//
//    public void plusBTN(View view){
//        String strToAdd = "+";
//        updateText(strToAdd);
//    }
//
//    public void equalBTN(View view){
//        String userExp = display.getText().toString();
//        String oldStr = userExp;
//
//        userExp = userExp.replaceAll("÷", "/");
//        userExp = userExp.replaceAll("%", "/100");
//        userExp = userExp.replaceAll("×", "*");
//
//        Expression exp = new Expression(userExp);
//
//        String result = String.valueOf(exp.calculate());
//
//        additional_display.setText(oldStr);
//
//        display.setText(result);
//        display.setSelection(result.length());
//
//
//    }
//
//    public void pointBTN(View view){
//        String strToAdd = ".";
//        updateText(strToAdd);
//    }
//
//    public void backspaceBTN(View view){
//        int cursorPos = display.getSelectionStart();
//        int textLen = display.getText().length();
//        String oldStr = display.getText().toString();
//
//        if (cursorPos != 0 && textLen != 0){
//            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
//            selection.replace(cursorPos - 1, cursorPos, "");
//            display.setText(selection);
//            display.setSelection(cursorPos - 1);
//        } else {
//            additional_display.setText(oldStr);
//            display.setText("Empty");
//        }
//    }
//
//}
