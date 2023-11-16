package com.example.myapplication;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIConnection {

    public byte[] get(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200) {
                InputStream inputStream = urlConnection.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];

                int cant = 0;

                while((cant = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, cant);
                }

                inputStream.close();

                return outputStream.toByteArray();
            }
            else {
                Log.d("Error", "Paso algo");
            }
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            Log.d("Error", e.getMessage());
        }

        return null;
    }

}
