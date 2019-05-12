package com.example.proyectois20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.net.*;
import java.io.*;
import static java.lang.System.in;
public class MainActivity extends AppCompatActivity {
    private EditText texto1;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto1= (EditText) findViewById(R.id.columna_titulo);
        resultado = (TextView) findViewById(R.id.txt_resultado);
    }

    //este metodo realiza la comunicaion
    public void busquedaPorTitulo(View view)
    {

        String columna = texto1.getText().toString();
        String HOST = "192.168.2.23";
        int puerto = 15000;
        DataInputStream in;
        DataOutputStream out;

        try {
            System.out.println("h");

            Socket sc = new Socket(HOST, puerto);
            resultado.setText(columna);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(columna);
            String res = in.readUTF();
            sc.close();
            resultado.setText(res);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }


}
