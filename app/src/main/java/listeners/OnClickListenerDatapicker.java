package listeners;

import android.app.DatePickerDialog;
import android.view.View;

/**
 * Created by rebeca on 16/09/2016.
 */
public class OnClickListenerDatapicker implements View.OnClickListener{

    DatePickerDialog etDataPickerDialog;

    public OnClickListenerDatapicker(DatePickerDialog etDataPickerDialog) {

        this.etDataPickerDialog = etDataPickerDialog;

    }

    @Override
    public void onClick(View v) {

        etDataPickerDialog.show();

    }
}
