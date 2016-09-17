package com.example.rebeca.validationapp.classes;

import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.text.InputType;
import android.view.View;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import com.example.rebeca.validationapp.R;
import listeners.OnClickListenerDatapicker;

public class MainActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.tvName) TextView tvName;
    @BindView(R.id.etName) EditText etName;
    @BindView(R.id.tvDate) TextView tvDate;
    @BindView(R.id.etDate) EditText etDate;
    @BindView(R.id.tvAddress) TextView tvAddress;
    @BindView(R.id.etAddress)EditText etAddress;
    @BindView(R.id.btSubmit) Button btSubmit;

    DatePickerDialog etDataPickerDialog;
    SimpleDateFormat dateFormatter;
    TextValidator textValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //DataPicker
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        etDate.setInputType(InputType.TYPE_NULL);
        setDateTimeField();
        btSubmit.setOnClickListener(this);

    }

    //Date format related
    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        etDataPickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        etDate.setOnClickListener(new OnClickListenerDatapicker(etDataPickerDialog));
    }


    //Validation usage
    @Override
    public void onClick(View view){

        textValidator = new TextValidator();
        Context context = getApplicationContext();

        Log.i(this.toString(), String.valueOf(textValidator.nameValidation(etName.getText().toString())));
        Log.e("onClick", etName.getText().toString());

        if(textValidator.nameValidation(etName.getText().toString()) == true){
            Log.i(this.toString(), textValidator.nameValidation(etName.getText().toString())+"");
            //Toast.makeText(context,"Ok", Toast.LENGTH_SHORT).show();
        }
        else{
            Log.i(this.toString(), textValidator.nameValidation(etName.getText().toString())+"");
            Toast.makeText(context,"Type a valid name", Toast.LENGTH_SHORT).show();

        }

        if(textValidator.nameValidation(etAddress.getText().toString()) == true){
            Log.i(this.toString(), textValidator.nameValidation(etAddress.getText().toString())+"");
            //Toast.makeText(context,"Ok", Toast.LENGTH_SHORT).show();
        }
        else{
            Log.i(this.toString(), textValidator.nameValidation(etAddress.getText().toString())+"");
            Toast.makeText(context,"Type a valid Address", Toast.LENGTH_SHORT).show();
        }
    }

}
