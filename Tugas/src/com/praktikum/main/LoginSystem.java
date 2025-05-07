package com.praktikum.main;
import java.util.Scanner;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Membuat Scanner untuk input
        String nama = "Bayu Andrea Setyawan";   // Data default nama
        String nim  = "202410370110282";         // Data default nim

        // Tampilkan menu pilihan login
        System.out.println("Pilih login:\n1. Admin\n2. Mahasiswa");
        System.out.print("Pilihan: ");
        int pil = sc.nextInt();
        sc.nextLine();  // Konsumsi newline

        User user = null;  // Variabel referensi untuk objek User

        if (pil == 1) {
            // Jika pilih Admin, buat objek Admin
            user = new Admin(nama, nim);
            System.out.print("Masukkan username: ");
            String uname = sc.nextLine().trim();
            System.out.print("Masukkan password: ");
            String pwd = sc.nextLine().trim();

            // Proses login untuk Admin
            if (user.login(uname, pwd)) {
                user.displayInfo();
                user.displayAppMenu();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pil == 2) {
            // Jika pilih Mahasiswa, buat objek Mahasiswa
            user = new Mahasiswa(nama, nim);
            System.out.print("Masukkan Nama: ");
            String inama = sc.nextLine().trim();
            System.out.print("Masukkan NIM: ");
            String inim = sc.nextLine().trim();

            // Proses login untuk Mahasiswa
            if (user.login(inama, inim)) {
                user.displayInfo();
                user.displayAppMenu();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        sc.close(); // Menutup Scanner setelah selesai
    }
}