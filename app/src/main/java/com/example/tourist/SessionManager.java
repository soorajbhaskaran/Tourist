package com.example.tourist;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SessionManager {
    private SharedPreferences session;
    private SharedPreferences.Editor editor;
    private Context context;

    final private int PRIVATE_MODE = 0;
    final private String PREF_NAME = "session";
    final private String SERV_PROVIDER = "service_provider";
    final private String TOURIST_EMAIL = "tourist_email";

    SessionManager(Context context){
        this.context = context;
        this.session = context.getSharedPreferences( PREF_NAME, PRIVATE_MODE );
        this.editor = session.edit();
    }

    public void createSession(String email){
        editor.clear();
        Gson gson = new Gson();
        editor.putString(TOURIST_EMAIL, email);
        editor.commit();
    }

    public String getTouristEmail(){
        String json = session.getString(SERV_PROVIDER, "");
        if (!json.isEmpty())
            return session.getString(TOURIST_EMAIL, "");
        else
            return null;
    }
    public void clearSession(){
        editor.clear();
        editor.commit();
    }
}
