package com.example.restaurant4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntriPelanggan extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    //DEKLARASI VARIABLE
    EditText tnama_pelanggan;
    Button btn_next;

    public static final String URLINSERT = "http://192.168.202.5/api/web_api_2/insert_pelanggan_2.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entri_pelanggan);

        //MEMANGGIL VARIABLE
        tnama_pelanggan = (EditText) findViewById(R.id.nama_pelanggan);
        btn_next = (Button) findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //UNTUK INSERT
                InsertPelanggan();

                //UNTUK LANJUT KE ENTRI PESANAN
                //Intent intent = new Intent(EntriPelanggan.this, EntriPesanan.class);
                //startActivity(intent);
            }
        });
    }

    void InsertPelanggan() {
        //MEMANGGIL ULANG VARIABLE
        String nama_pelanggan = tnama_pelanggan.getText().toString();

        //UNTUK MENDAPATKAN RESPONSE DARI DATABASE
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLINSERT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(EntriPelanggan.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EntriPelanggan.this, "Data Gagal Disimpan", Toast.LENGTH_SHORT).show();
            }
        }) {
            //UNTUK MERETURN PARAMETER
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("Namapelanggan", nama_pelanggan);
                return params;
            }
        };

        //AGAR INPUT DATA DAPAT MUNCUL DI DATABASE
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}