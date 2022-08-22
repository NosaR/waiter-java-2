package com.example.restaurant4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WaiterForm extends AppCompatActivity {
    //DEKLARASI VARIABLE
    Button btn_entri_menu, btn_entri_pelanggan, btn_entri_pesanan, btn_laporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter_form);

        //MEMANGGIL VARIABLE
        btn_entri_menu = (Button) findViewById(R.id.btn_entri_menu);
        btn_entri_pelanggan = (Button) findViewById(R.id.btn_entri_pelanggan);
        btn_entri_pesanan = (Button) findViewById(R.id.btn_entri_pesanan);
        btn_laporan = (Button) findViewById(R.id.btn_laporan);

        //ENTRI MENU
        btn_entri_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaiterForm.this, EntriMenu.class);
                startActivity(intent);
            }
        });

        //ENTRI PELANGGAN
        btn_entri_pelanggan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaiterForm.this, EntriPelanggan.class);
                startActivity(intent);
            }
        });

        //ENTRI PESANAN
        btn_entri_pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaiterForm.this, EntriPesanan.class);
                startActivity(intent);
            }
        });

        //LAPORAN
        btn_laporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaiterForm.this, Laporan.class);
                startActivity(intent);
            }
        });
    }
}