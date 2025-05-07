package com.praktikum.users;

public abstract class User {
    private String nama; // Nama pengguna
    private String nim;  // NIM pengguna

    // Konstruktor menginisialisasi nama dan nim
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk nim
    public String getNim() {
        return nim;
    }

    // Method abstract untuk proses login
    public abstract boolean login(String input1, String input2);

    // Method abstract untuk menampilkan informasi dasar pengguna
    public abstract void displayInfo();

    // Method abstract untuk menampilkan menu aplikasi sesuai peran
    public abstract void displayAppMenu();
}