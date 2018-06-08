package is2.is2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class addTareas extends AppCompatActivity implements View.OnClickListener {
    Spinner tareaResponsables, tareaPrioridad, tareaEstado;
    String[] responsables = {"Félix", "Derlis","Admin"};
    String[] prioridades = {"Baja", "Media", "Alta"};
    String[] estados = {"No comenzada", "En proceso", "Completada", "Postergada", "En espera"};

    Button btn_fechaInicio,btn_horaInicio, btn_fechaVenc, btn_horaVenc;
    EditText editTextFechaInicio, editTextHoraInicio, editTextFechaVenc, editTextHoraVenc;
    private int dia, mes, anho, hora, minuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtareas);

        tareaResponsables = (Spinner)findViewById(R.id.tareaResponsables);
        ArrayAdapter<String> adapterResponsables = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, responsables);
        tareaResponsables.setAdapter(adapterResponsables);

        tareaPrioridad = (Spinner)findViewById(R.id.tareaPrioridad);
        ArrayAdapter<String> adapterPrioridades = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, prioridades);
        tareaPrioridad.setAdapter(adapterPrioridades);

        tareaEstado = (Spinner)findViewById(R.id.tareaEstado);
        ArrayAdapter<String> adapterEstado = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estados);
        tareaEstado.setAdapter(adapterEstado);

        btn_fechaInicio = (Button)findViewById(R.id.btn_fechaInicio);
        btn_horaInicio = (Button)findViewById(R.id.btn_horaInicio);
        editTextFechaInicio = (EditText)findViewById(R.id.editTextFechaInicio);
        editTextHoraInicio = (EditText)findViewById(R.id.editTextHoraInicio);

        btn_fechaInicio.setOnClickListener(this);
        btn_horaInicio.setOnClickListener(this);

        btn_fechaVenc = (Button)findViewById(R.id.btn_fechaVenc);
        btn_horaVenc = (Button)findViewById(R.id.btn_horaVenc);
        editTextFechaVenc = (EditText)findViewById(R.id.editTextFechaVenc);
        editTextHoraVenc = (EditText)findViewById(R.id.editTextHoraVenc);

        btn_fechaVenc.setOnClickListener(this);
        btn_horaVenc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_fechaInicio){
            final Calendar cal =Calendar.getInstance();
            dia = cal.get(Calendar.DAY_OF_MONTH);
            mes = cal.get(Calendar.MONTH);
            anho = cal.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    editTextFechaInicio.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            ,anho, mes, dia);
            datePickerDialog.show();
        }
        if (v==btn_horaInicio){
            final Calendar cal =Calendar.getInstance();
            hora = cal.get(Calendar.HOUR_OF_DAY);
            minuto = cal.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    editTextHoraInicio.setText(hourOfDay+":"+minute);
                }
            },hora,minuto,false);
            timePickerDialog.show();
        }

        if(v==btn_fechaVenc){
            final Calendar cal =Calendar.getInstance();
            dia = cal.get(Calendar.DAY_OF_MONTH);
            mes = cal.get(Calendar.MONTH);
            anho = cal.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    editTextFechaVenc.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    ,anho, mes, dia);
            datePickerDialog.show();
        }

        if (v==btn_horaVenc){
            final Calendar cal =Calendar.getInstance();
            hora = cal.get(Calendar.HOUR_OF_DAY);
            minuto = cal.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    editTextHoraVenc.setText(hourOfDay+":"+minute);
                }
            },hora,minuto,false);
            timePickerDialog.show();
        }
    }
}
