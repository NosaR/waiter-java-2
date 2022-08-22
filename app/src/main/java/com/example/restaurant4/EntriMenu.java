package com.example.restaurant4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class EntriMenu extends AppCompatActivity {
    //DEKLARASI VARIABLE
    //LOCALHOST DIGANTI MENYESUAIKAN DENGAN IP ADDRESS
    public static final String URLINSERT = "http://192.168.1.7/api/web_api_2/insert_menu_2.php";
    //public static final String URLINSERT = "http://192.168.202.5/api/web_api_2/insert_menu_2.php";

    EditText tnama_menu, tharga;
    Button btn_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entri_menu);

        //MEMANGGIL VARIABLE
        tnama_menu = (EditText) findViewById(R.id.nama_menu);
        tharga = (EditText) findViewById(R.id.harga);
        btn_simpan = (Button) findViewById(R.id.btn_simpan);

        //SIMPAN
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputData();
            }
        });
    }

    //FUNCTION UNTUK MENYIMPAN INPUT DATA
    void InputData() {
        //MEMANGGIL ULANG VARIABLE
        String nama_menu = tnama_menu.getText().toString();
        String harga = tharga.getText().toString();

        //UNTUK MENDAPATKAN RESPONSE DARI DATABASE
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLINSERT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(EntriMenu.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EntriMenu.this, "Data Gagal Disimpan", Toast.LENGTH_SHORT).show();
            }
        }) {
            //UNTUK MERETURN PARAMETER
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("Namamenu", nama_menu);
                params.put("Harga", harga);
                return params;
            }
        };

        //AGAR INPUT DATA DAPAT MUNCUL DI DATABASE
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}