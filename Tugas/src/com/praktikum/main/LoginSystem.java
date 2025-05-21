package com.praktikum.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import com.praktikum.data.Item;

// Kelas utama sebagai entry point sistem login dan pengelolaan data
public class LoginSystem {
    // Penyimpanan global untuk daftar user dan laporan barang
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data default sesuai program sebelumnya
        String nama = "Bayu Andrea Setyawan";
        String nim  = "202410370110282";

        // Inisialisasi userList dengan user default (bisa dikembangkan lebih lanjut)
        // Pada login, objek dibuat langsung dengan data default jika diperlukan,
        // sehingga userList mungkin juga dipakai untuk penambahan/hapusan oleh Admin.
        userList.add(new Admin(nama, nim));
        userList.add(new Mahasiswa(nama, nim));

        // Loop utama untuk proses login
        while (true) {
            try {
                System.out.println("\n=== Sistem Login ===");
                System.out.println("Pilih login:");
                System.out.println("1. Admin");
                System.out.println("2. Mahasiswa");
                System.out.println("0. Keluar");
                System.out.print("Pilihan: ");
                int pil = sc.nextInt();
                sc.nextLine(); // Konsumsi newline

                if (pil == 0) {
                    System.out.println("Program selesai. Terima kasih.");
                    break;
                }

                User loggedUser = null;
                if (pil == 1) {
                    // Login Admin menggunakan data default
                    User admin = new Admin(nama, nim);
                    System.out.print("Masukkan username: ");
                    String uname = sc.nextLine().trim();
                    System.out.print("Masukkan password: ");
                    String pwd = sc.nextLine().trim();

                    if (admin.login(uname, pwd)) {
                        loggedUser = admin;
                    } else {
                        System.out.println("Login gagal! Username atau password salah.");
                        continue;
                    }
                } else if (pil == 2) {
                    // Login Mahasiswa menggunakan data default
                    User mhs = new Mahasiswa(nama, nim);
                    System.out.print("Masukkan Nama: ");
                    String inama = sc.nextLine().trim();
                    System.out.print("Masukkan NIM: ");
                    String inim = sc.nextLine().trim();

                    if (mhs.login(inama, inim)) {
                        loggedUser = mhs;
                    } else {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                        continue;
                    }
                } else {
                    System.out.println("Pilihan tidak valid.");
                    continue;
                }

                // Jika login berhasil, tampilkan informasi dan menu sesuai peran
                loggedUser.displayInfo();
                loggedUser.displayAppMenu();

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                sc.nextLine(); // Bersihkan buffer
            }
        }

        sc.close();
    }
}