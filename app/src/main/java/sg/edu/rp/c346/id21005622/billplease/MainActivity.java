package sg.edu.rp.c346.id21005622.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText etMoney;
    EditText etPax;
    ToggleButton tbServiceCharge;
    ToggleButton tbGST;
    EditText etDiscount;
    RadioGroup rgPMethod;
    Button btSplit;
    Button btReset;
    RadioButton rbCash;
    RadioButton rbPN;
    TextView tvTotal;
    TextView tvEach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMoney = findViewById(R.id.etAmount);
        etPax = findViewById(R.id.etPpl);
        tbServiceCharge = findViewById(R.id.tbSC);
        tbGST = findViewById(R.id.tbGST);
        etDiscount = findViewById(R.id.etDiscount);
        rgPMethod = findViewById(R.id.rgMethod);
        btSplit = findViewById(R.id.btnSplit);
        btReset = findViewById(R.id.btReset);
        rbCash = findViewById(R.id.rbCash);
        rbPN = findViewById(R.id.rbPayNow);
        tvTotal = findViewById(R.id.tvTotal);
        tvEach = findViewById(R.id.tvEach);


        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            etMoney.setText("");
            etPax.setText("");
            etDiscount.setText("");
            rbCash.toggle();
            }
        });


        btSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double amount = Double.parseDouble(etMoney.getText().toString());
                double pax = Double.parseDouble(etPax.getText().toString());
                double discount = Double.parseDouble(etDiscount.getText().toString());


                double total = amount;
                double gst = 1.07;
                double SC = 1.10;
                discount = discount / 100;

                if(tbGST.isChecked()){
                    total = amount * gst  ;
                }
                if(tbServiceCharge.isChecked()){
                    total = amount * SC;
                }
                total = total - (total * discount);
                double each = total / pax;

                tvTotal.setText("Total Bill: $"+total);
                if(rbCash.isChecked()){
                    tvEach.setText("Each Pays: $"+each+" in Cash");
                }
                else{
                    tvEach.setText("Each Pays: $"+each+" via PayNow to 91234567");
                }

            }
        });


    }
}