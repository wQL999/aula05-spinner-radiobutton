package com.wen.aula05;
/*
 *@author: Wendell Valim Mendes
 * @ra: 1110482413005
 */
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner sp_item;
    private Button btn_calc;
    private TextView txt_ans;
    private RadioButton rdbtn1;
    private RadioButton rdbtn2;
    private RadioButton rdbtn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sp_item = findViewById(R.id.sp_items);
        btn_calc = findViewById(R.id.btn_calc);
        txt_ans = findViewById(R.id.txt_ans);
        rdbtn1 = findViewById(R.id.rdBtn_1);
        rdbtn2 = findViewById(R.id.rdBtn_2);
        rdbtn3 = findViewById(R.id.rdBtn_3);

        rdbtn1.setChecked(true);
        rdbtn2.setChecked(false);
        rdbtn3.setChecked(false);


        preecherSpinner();
        btn_calc.setOnClickListener( e -> calc());

    }

    private void calc() {
        String item = (String) sp_item.getSelectedItem();

        int selected =0;
        if(rdbtn1.isChecked()) {
            selected = 1;
        } else if(rdbtn2.isChecked()) {
            selected = 2;
        } else {
            selected = 3;
        }

        int ans[] = new int[selected];
        for(int i = 0; i < selected; ++i) {

            if(item.equals("D4")) {
                ans[i] = (int)(4*Math.random())+1;
            } else if(item.equals("D6")) {
                ans[i] = (int)(6*Math.random())+1;
            } else if(item.equals("D8")) {
                ans[i] = (int)(8*Math.random())+1;
            } else if(item.equals("D10")) {
                ans[i] = (int)(10*Math.random())+1;
            } else if(item.equals("D12")) {
                ans[i] = (int)(12*Math.random())+1;
            } else if(item.equals("D20")) {
                ans[i] = (int)(20*Math.random())+1;
            } else {
                ans[i] = (int)(100*Math.random())+1;
            }

        }

        StringBuffer ansText = new StringBuffer();
        for(int i = 1; i <= ans.length; i++)
            ansText.append("Dado " + i + ": " + ans[i-1] + "\n");

        txt_ans.setText(ansText.toString());

    }


    private void preecherSpinner() {
        ArrayList<String> items = new ArrayList<>();
        items.add("D4");
        items.add("D6");
        items.add("D8");
        items.add("D10");
        items.add("D12");
        items.add("D20");
        items.add("D100");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_item.setAdapter(adapter);
    }

}