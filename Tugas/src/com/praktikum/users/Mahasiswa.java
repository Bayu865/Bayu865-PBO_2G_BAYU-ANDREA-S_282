package com.praktikum.users;
import java.util.Scanner;
import com.praktikum.actions.MahasiswaActions;

public class Mahasiswa extends User implements MahasiswaActions {

    // Konstruktor Mahasiswa menggunakan super() untuk menginisialisasi nama dan nim.
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    // Override method login() untuk memeriksa input nama (ignore case) dan nim.
    @Override
    public boolean login(String input1, String input2) {
        return input1.equalsIgnoreCase(getNama()) && input2.equals(getNim());
    }

    // Override method displayInfo() untuk menampilkan pesan login sukses Mahasiswa.
    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil! Nama: " + getNama() + ", NIM: " + getNim());
    }

    // Override method displayAppMenu() untuk menampilkan menu khusus Mahasiswa.
    @Override
    public void displayAppMenu() {
        Scanner sc = new Scanner(System.in);
        int choice; // Variabel pilihan menu
        do {
            // Menampilkan menu Mahasiswa
            System.out.println("\nMahasiswa Menu:");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");

            choice = sc.nextInt();
            sc.nextLine();  // Konsumsi newline

            if (choice == 1) {
                // Panggil aksi untuk melaporkan barang
                reportItem();
            } else if (choice == 2) {
                // Panggil aksi untuk melihat laporan
                viewReportedItems();
            } else if (choice == 0) {
                System.out.println("Logout Mahasiswa");
            } else {
                System.out.println("Pilihan tidak valid");
            }
        } while (choice != 0);
        // Scanner tidak ditutup di sini agar input tetap dapat dipakai
    }

    // Implementasi method reportItem() dari interface MahasiswaActions.
    @Override
    public void reportItem() {
        Scanner sc = new Scanner(System.in);
        // Meminta input detail barang yang dilaporkan
        System.out.print("Nama barang: ");
        String itemName = sc.nextLine();
        System.out.print("Deskripsi barang: ");
        String desc = sc.nextLine();
        System.out.print("Lokasi: ");
        String location = sc.nextLine();
        System.out.println("Laporan diterima: " + itemName + ", " + desc + ", " + location);
    }

    // Implementasi method viewReportedItems() dari interface MahasiswaActions.
    @Override
    public void viewReportedItems() {
        System.out.println("Fitur lihat laporan belum tersedia");
    }
}