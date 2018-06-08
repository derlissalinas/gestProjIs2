package is2.is2;

import android.content.Entity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.io.IOUtils;

import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class usuarios extends AppCompatActivity {





    Button btnAddUsuario;
    ListView listViewUsuarios;
    TextView tv_userID, tv_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        btnAddUsuario=findViewById(R.id.btnAddUsuario);
        btnAddUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddUser = new Intent(usuarios.this, Registro.class);
                usuarios.this.startActivity(intentAddUser);
            }
        });

        listViewUsuarios=findViewById(R.id.listViewUsuarios);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpClient httpClient = new DefaultHttpClient();

        HttpGet del =
                new HttpGet("http://10.3.28.29:24925/is2D4/webresources/entidades.usuarios/");

        del.setHeader("Accept", "application/json");
        del.setHeader("Content-type", "application/json");

        try {
            System.out.println("HOLA2222222222");
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());

            System.out.println("RESP: "+ respStr);
            JSONArray respJSON = new JSONArray(respStr);

            String[] usuarios = new String[respJSON.length()];

            System.out.println("Tamanho de resspuesta es: "+respJSON.length());
            for(int i=0; i<respJSON.length(); i++)
            {

                JSONObject obj = respJSON.getJSONObject(i);

                String nombre = obj.getString("nombre");
                String apellido = obj.getString("apellido");
                String usuario = obj.getString("username");


                usuarios[i] = "" + nombre + "-" + apellido + "-" + usuario;

                System.out.println(usuarios[i]);
            }

            //Rellenamos la lista con los resultados

            ArrayAdapter<String> adaptador =
                    new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1, usuarios);

            listViewUsuarios.setAdapter(adaptador);
        }
        catch(Exception ex)
        {
            Log.e("ServicioRest","Error!", ex);
        }
        /*
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://localhost:18111/is2RESTFul/webresources/entidades.usuarios");
        httpGet.setHeader("content-type", "application/json");
        listViewUsuarios = (ListView) findViewById(R.id.listViewUsuarios);

        try
        {
            HttpResponse response = httpClient.execute(httpGet);
            String jsonResult = EntityUtils.toString(response.getEntity());
            JSONArray respuesta = new JSONArray(jsonResult);


            String[] personas = new String[respuesta.length()];

            for (int i=0; i<respuesta.length(); i++)
            {

                JSONObject object = respuesta.getJSONObject(i);
                String nombre = object.getString("nombre");
                String apellido = object.getString("apellido");


                personas[i] = "" + nombre + " " + apellido;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,personas);
            listViewUsuarios.setAdapter(adapter);
        }

        catch (Exception e)
        {
            Log.e("ServicioRest","Error!", e);
        }
        /**ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,usuarios);
        listViewUsuarios.setAdapter(adapter);*/
        //

    }

}
