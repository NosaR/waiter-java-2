package com.example.restaurant4;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarInputStream;

public class EntriPesanan extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    //DEKLARASIKAN VARIABLE
    public static final String URL = "http://192.168.1.7/api/web_api_2/select_pelanggan_2.php";
    //public static final String URL = "http://192.168.202.5/api/web_api_2/select_pelanggan_2.php";

    ListView list;
    SwipeRefreshLayout swipe;
    List<Data_2> itemList = new ArrayList<Data_2>();
    DataAdapter2 adapter;
    //Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entri_pesanan);

        //btn_order = (Button) findViewById(R.id.btn_order);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_2);
        list = (ListView) findViewById(R.id.list_2);

        adapter = new DataAdapter2(EntriPesanan.this, itemList);
        list.setAdapter(adapter);

        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(true);
                itemList.clear();
                adapter.notifyDataSetChanged();
                CallVolley();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String idx = itemList.get(position).getL_id();
                DetailPesanan(idx);
                Intent intent = new Intent(EntriPesanan.this, EntriPesanan2.class);
                intent.putExtra("Idpelanggan", idx);
                startActivity(intent);
            }
        });
    }

    public void DetailPesanan(String Idpelanggan) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jobj = new JSONObject(response);
                    String idx = jobj.getString("Idpelanggan");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EntriPesanan.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("Idpelanggan", Idpelanggan);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
    }

    @Override
    public void onRefresh() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        CallVolley();
    }

    public void CallVolley() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Data_2 item = new Data_2();

                        item.setL_id("Id Pelanggan: " + jsonObject.getString("Idpelanggan"));
                        item.setL_nim("Nama Pelanggan: " + jsonObject.getString("Namapelanggan"));

                        itemList.add(item);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                adapter.notifyDataSetChanged();
                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Eror: " + error.getMessage());
                swipe.setRefreshing(false);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}