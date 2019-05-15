package com.example.proyectois20;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Enviar extends AsyncTask<String, Void, Void> {
    Socket s;
    DataOutputStream dt;
    PrintWriter pw;

    protected Void doInBackground(String... Voids)
    {
        String mensaje = Voids[0];
        try{
            s = new Socket("192.168.2.31", 15000);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(mensaje);
            pw.flush();
            pw.close();
            s.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
