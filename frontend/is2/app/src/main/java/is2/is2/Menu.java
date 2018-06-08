package is2.is2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {
    ImageButton imbtn_users;
    ImageButton imbtn_tareas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        imbtn_users=findViewById(R.id.imbtn_users);
        imbtn_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUsers = new Intent(Menu.this, usuarios.class);
                Menu.this.startActivity(intentUsers);
            }
        });

        imbtn_tareas=findViewById(R.id.imbtn_tareas);
        imbtn_tareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTareas= new Intent(Menu.this, tareas.class);
                Menu.this.startActivity(intentTareas);
            }
        });

    }
}
