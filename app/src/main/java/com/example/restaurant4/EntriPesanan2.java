package com.example.restaurant4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EntriPesanan2 extends AppCompatActivity {
    TextView id_pelanggan;
    String t_id_pelanggan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entri_pesanan_2);

        id_pelanggan = (TextView) findViewById(R.id.textView);

        t_id_pelanggan = getIntent().getStringExtra("Idpelanggan");

        id_pelanggan.setText(t_id_pelanggan);
    }
}