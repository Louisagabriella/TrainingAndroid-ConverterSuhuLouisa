package id.co.asyst.gabriella.louisa.convertersuhulouisa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etInput;
    TextView tvOutput;
    Spinner sSuhu1, sSuhu2;

    ArrayList<String> listSuhu1 = new ArrayList<>();
    ArrayList<String> listSuhu2 = new ArrayList<>();

    String selectedSuhu1, selectedSuhu2;
    float hasil;
    private final TextWatcher inputSuhu = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            konversi();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.editTextInputSuhu);
        tvOutput = findViewById(R.id.textViewOutputSuhu);
        sSuhu1 = findViewById(R.id.spinnerSuhu1);
        sSuhu2 = findViewById(R.id.spinnerSuhu2);

        sSuhu1.setOnItemSelectedListener(this);
        sSuhu2.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listSuhu1);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listSuhu2);
        listSuhu1.add("Celcius");
        listSuhu1.add("Reamur");
        listSuhu1.add("Fahrenheit");
        listSuhu1.add("Kelvin");
        listSuhu2.add("Celcius");
        listSuhu2.add("Reamur");
        listSuhu2.add("Fahrenheit");
        listSuhu2.add("Kelvin");
        sSuhu1.setAdapter(arrayAdapter);
        sSuhu2.setAdapter(arrayAdapter2);
        etInput.addTextChangedListener(inputSuhu);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedSuhu1 = sSuhu1.getSelectedItem().toString();
        selectedSuhu2 = sSuhu2.getSelectedItem().toString();
        konversi();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void konversi() {
        if (!TextUtils.isEmpty(etInput.getText().toString())) {
            if (selectedSuhu1 == selectedSuhu2) {
                tvOutput.setText(etInput.getText().toString());
            } else {
                float angka = Float.parseFloat(etInput.getText().toString());
                if (selectedSuhu1 == "Celcius") {
                    if (selectedSuhu2 == "Reamur") {
                        hasil = (4 * angka) / 5;
                        tvOutput.setText(hasil + "");
                    } else if (selectedSuhu2 == "Fahrenheit") {
                        hasil = ((9 * angka) / 5) + 32;
                        tvOutput.setText(hasil + "");
                    } else if (selectedSuhu2 == "Kelvin") {
                        hasil = angka + 273;
                        tvOutput.setText(hasil + "");
                    }
                } else if (selectedSuhu1 == "Reamur") {
                    if (selectedSuhu2 == "Celcius") {
                        hasil = (5 * angka) / 4;
                        tvOutput.setText(hasil + "");
                    } else if (selectedSuhu2 == "Fahrenheit") {
                        hasil = ((9 * angka) / 4) + 32;
                        tvOutput.setText(hasil + "");
                    } else if (selectedSuhu2 == "Kelvin") {
                        hasil = ((5 * angka) / 4) + 273;
                        tvOutput.setText(hasil + "");
                    }
                } else if (selectedSuhu1 == "Fahrenheit") {
                    if (selectedSuhu2 == "Celcius") {
                        hasil = (((angka - 32)) * 5) / 9;
                        tvOutput.setText(hasil + "");
                    } else if (selectedSuhu2 == "Reamur") {
                        hasil = (((angka - 32)) * 4) / 9;
                        tvOutput.setText(hasil + "");
                    } else if (selectedSuhu2 == "Kelvin") {
                        hasil = ((((angka - 32)) * 5) / 9) + 273;
                        tvOutput.setText(hasil + "");
                    }
                } else if (selectedSuhu1 == "Kelvin") {
                    if (selectedSuhu2 == "Celcius") {
                        hasil = angka - 273;
                        tvOutput.setText(hasil + "");
                    } else if (selectedSuhu2 == "Reamur") {
                        hasil = ((angka - 273) * 4) / 5;
                        tvOutput.setText(hasil + "");
                    } else if (selectedSuhu2 == "Fahrenheit") {
                        hasil = (((angka - 273) * 9) / 5) + 32;
                        tvOutput.setText(hasil + "");
                    }
                }
            }
        } else {
            tvOutput.setText("");
        }
    }
}
