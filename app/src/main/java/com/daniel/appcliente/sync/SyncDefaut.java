package com.daniel.appcliente.sync;

import android.content.Context;
import android.util.Log;


import com.daniel.appcliente.modelo.persistencia.BdServidor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SyncDefaut {
    private static String ip = "192.168.0.6";
    private String url;

    public static String getUrl(Context c) {
        BdServidor bd = new BdServidor(c);
        String ip = bd.listar().getIp();
        if (!ip.equals("")) {
            Log.i("[IFMG]", "http://" + ip + ":8089/");
            return "http://" + ip + ":8089/RestauranteServer/";
        } else {
            Log.i("[IFMG]", "http://192.168.0.6:8089/");
            return "http://" + "192.168.0.6" + ":8089/RestauranteServer/";
        }
    }


    public static final Retrofit RETROFIT_RESTAURANTE(Context c) {
        return new Retrofit.Builder().
                baseUrl(getUrl(c)).
                addConverterFactory(GsonConverterFactory.create()).
                build();

    }
}
