package com.praktikum.users;
import java.util.Scanner;
import com.praktikum.actions.AdminActions;

public class Admin extends User implements AdminActions {
    private String username, password; // Data login Admin

    // Konstruktor Admin menggunakan super() untuk menginisialisasi nama dan nim.
    // Username dan password dibentuk dari tiga digit terakhir NIM.
    public Admin(String nama, String nim) {
        super(nama, nim);
        String nimLast = nim.substring(nim.length() - 3); // Tiga digit terakhir NIM
        username = "Admin" + nimLast;
        password = "Password" + nimLast;
    }

    // Override method login() untuk memeriksa kecocokan username dan password.
    @Override
    public boolean login(String input1, String input2) {
        return input1.equals(username) && input2.equals(password);
    }

    // Override method displayInfo() untuk menampilkan pesan login sukses Admin.
    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil! Nama: " + getNama() + ", NIM: " + getNim());
    }

    // Override method displayAppMenu() untuk menampilkan menu khusus Admin.
    @Override
    public void displayAppMenu() {
        Scanner sc = new Scanner(System.in);
        int choice; // Variabel untuk pilihan menu
        do {
            // Menampilkan menu Admin
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");

            choice = sc.nextInt();
            sc.nextLine();  // Konsumsi newline sisa input

            if (choice == 1) {
                // Panggil aksi untuk kelola laporan barang
                manageItems();
            } else if (choice == 2) {
                // Panggil aksi untuk kelola data mahasiswa
                manageUsers();
            } else if (choice == 0) {
                System.out.println("Logout Admin");
            } else {
                System.out.println("Pilihan tidak valid");
            }
        } while (choice != 0);
        // Tidak menutup scanner di sini agar System.in tetap terbuka.
    }

    // Implementasi method dari AdminActions untuk mengelola laporan barang.
    @Override
    public void manageItems() {
        System.out.println("Fitur Kelola Laporan Barang belum tersedia");
    }

    // Implementasi method dari AdminActions untuk mengelola data mahasiswa.
    @Override
    public void manageUsers() {
        System.out.println("Fitur Kelola Data Mahasiswa belum tersedia");
    }
}