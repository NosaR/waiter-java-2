package com.example.restaurant4;

public class Data {
    //DARI LIST.XML
    private String id, nim, nama, alamat, telpon, total;

    //DARI LIST!.XML
    private String id_list_1, tv_nama_menu, tv_harga;

    public Data() {
    }

    //MEMANGGIL CONSTRUCTOR
    public Data(String id, String nim, String nama, String alamat, String telpon, String total, String id_list_1, String tv_nama_menu, String tv_harga) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.telpon = telpon;
        this.total = total;
        this.id_list_1 = id_list_1;
        this.tv_nama_menu = tv_nama_menu;
        this.tv_harga = tv_harga;
    }

    //MEMANGGIL GETTER AND SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId_list_1() {
        return id_list_1;
    }

    public void setId_list_1(String id_list_1) {
        this.id_list_1 = id_list_1;
    }

    public String getTv_nama_menu() {
        return tv_nama_menu;
    }

    public void setTv_nama_menu(String tv_nama_menu) {
        this.tv_nama_menu = tv_nama_menu;
    }

    public String getTv_harga() {
        return tv_harga;
    }

    public void setTv_harga(String tv_harga) {
        this.tv_harga = tv_harga;
    }
}

