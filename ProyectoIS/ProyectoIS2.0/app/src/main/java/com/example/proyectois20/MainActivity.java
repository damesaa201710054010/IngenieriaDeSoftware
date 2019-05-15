package com.example.proyectois20;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.net.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {
    private EditText busquedaPorTitulo;
    private EditText busquedaServicio;
    private EditText busquedaPorAutor;
    private TextView resultadoLibros;
    private  TextView resultadoServicio;
    private TextView viewResultado;
    private static Socket s;
    private  static Socket s2;
    private static InputStreamReader isr;
    private static BufferedReader br;
    private static PrintWriter printWriter;
    private static PrintWriter printWriter2;
    private static String resultadoFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        busquedaPorTitulo = (EditText) findViewById(R.id.busquedaTitulo);
        busquedaPorAutor = (EditText) findViewById(R.id.busquedaAutor);
        busquedaServicio = (EditText) findViewById(R.id.busquedaServicio);
        resultadoLibros = (TextView) findViewById(R.id.resultadoLibros);
        resultadoServicio = (TextView) findViewById(R.id.resultadoServicio);
        viewResultado = (TextView) findViewById(R.id.viewReferencia);
    }

    class myTask extends AsyncTask<Void, Void, Void> {
        String clave;
        String tipoBusqueda;
        public void setClave(String clave) {
            this.clave = clave;
        }

        public void setTipoBusqueda(String tipoBusqueda)
        {
            this.tipoBusqueda = tipoBusqueda;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                s = new Socket("192.168.42.113", 30000);
                s2 = new Socket("192.168.42.113", 40000);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
                DataInputStream in = new DataInputStream(s.getInputStream());
                printWriter = new PrintWriter(s.getOutputStream());
                printWriter2 = new PrintWriter(s2.getOutputStream());
                printWriter.write(clave);
                //resultadoLibros.setText(tipoBusqueda);
                printWriter2.write(tipoBusqueda);
                //resultadoFinal = in.readUTF();
                printWriter.flush();
                printWriter.close();
                printWriter2.flush();
                printWriter2.close();
                resultadoFinal = entrada.readLine().toString();
                s.close();
                s2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    public void busquedaPorTitulo(View view)
    {
        String keyWord = busquedaPorTitulo.getText().toString();
        myTask my = new myTask();
        my.setClave(keyWord);
        my.setTipoBusqueda("Titulo");
        my.execute();
        resultadoLibros.setText(resultadoFinal);
    }

    public void busquedaPorAutor(View view)
    {
        String keyWord = busquedaPorAutor.getText().toString();
        myTask my = new myTask();
        my.setClave(keyWord);
        my.setTipoBusqueda("Autor");
        my.execute();
        resultadoLibros.setText(keyWord);
    }

    public void busquedaPorServicio(View view)
    {
        String keyWord = busquedaServicio.getText().toString();
        myTask my = new myTask();
        my.setClave(keyWord);
        my.execute();
        resultadoServicio.setText(keyWord);
    }

}
