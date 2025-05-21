package com.praktikum.users;

import java.util.Scanner;
import java.util.InputMismatchException;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

// Kelas Mahasiswa: turunan dari User dan implementasi dari MahasiswaActions
public class Mahasiswa extends User implements MahasiswaActions {

    // Konstruktor: inisialisasi nama dan nim
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    // Validasi login: periksa apakah input nama (ignore case) dan NIM sesuai
    @Override
    public boolean login(String input1, String input2) {
        return input1.equalsIgnoreCase(getNama()) && input2.equals(getNim());
    }

    // Tampilkan informasi login berhasil untuk mahasiswa
    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil! Nama: " + getNama() + ", NIM: " + getNim());
    }

    // Tampilkan menu khusus Mahasiswa
    @Override
    public void displayAppMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\n=== Mahasiswa Menu ===");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Konsumsi newline
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                sc.nextLine();
                continue;
            }
            if (choice == 1) {
                reportItem();
            } else if (choice == 2) {
                viewReportedItems();
            } else if (choice == 0) {
                System.out.println("Logout Mahasiswa");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } while (choice!= 0);
        // Tidak menutup scanner
    }

    // Aksi pelaporan barang: input detail barang dan simpan ke daftar laporan global
    @Override
    public void reportItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama barang: ");
        String itemName = sc.nextLine();
        System.out.print("Masukkan deskripsi barang: ");
        String desc = sc.nextLine();
        System.out.print("Masukkan lokasi: ");
        String location = sc.nextLine();
        // Buat objek Item dan tambahkan ke daftar laporan global
        Item newItem = new Item(itemName, desc, location);
        LoginSystem.reportedItems.add(newItem);
        System.out.println("Laporan diterima: " + newItem.toString());
        // Scanner tidak ditutup
    }

    // Aksi melihat laporan barang: tampilkan item-item yang berstatus "Reported"
    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else {
            System.out.println("Daftar Laporan Barang:");
            for (Item item : LoginSystem.reportedItems) {
                if (item.getStatus().equals("Reported")) {
                    System.out.println(item.toString());
                }
            }
        }
    }
}