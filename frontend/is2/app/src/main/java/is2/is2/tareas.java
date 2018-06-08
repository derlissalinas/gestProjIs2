package is2.is2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class tareas extends AppCompatActivity {
    Button btnAddTarea;
    ListView listViewTareas;


    String[] tareas = new String[] {"Reunión con el Cliente", "Exposición de Demo", "Seleccionar programadores"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        btnAddTarea=findViewById(R.id.btnAddTarea);
        btnAddTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddTarea= new Intent(tareas.this, addTareas.class);
                tareas.this.startActivity(intentAddTarea);
            }
        });

        listViewTareas = (ListView) findViewById(R.id.listViewTareas);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,tareas);
        listViewTareas.setAdapter(adapter);
    }
}
