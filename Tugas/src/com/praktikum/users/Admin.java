package com.praktikum.users;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

// Kelas Admin: turunan dari User dan implementasi dari AdminActions
public class Admin extends User implements AdminActions {
    private String username, password; // Kredensial login Admin

    // Konstruktor: inisialisasi nama dan nim; kredensial dibentuk dari tiga digit terakhir NIM
    public Admin(String nama, String nim) {
        super(nama, nim);
        String nimLast = nim.substring(nim.length() - 3); // Contoh: "282" untuk nim "202410370110282"
        username = "Admin" + nimLast;
        password = "Password" + nimLast;
    }

    // Validasi login: cek apakah input sesuai dengan username dan password
    @Override
    public boolean login(String input1, String input2) {
        return input1.equals(username) && input2.equals(password);
    }

    // Menampilkan informasi login Admin
    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil! Nama: " + getNama() + ", NIM: " + getNim());
    }

    // Menampilkan menu khusus Admin
    @Override
    public void displayAppMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        do {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
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
                manageItems();
            } else if (choice == 2) {
                manageUsers();
            } else if (choice == 0) {
                System.out.println("Logout Admin");
            } else {
                System.out.println("Pilihan tidak valid");
            }
        } while (choice != 0);
        // Tidak menutup scanner agar System.in tetap aktif
    }

    // Implementasi aksi admin: mengelola laporan barang
    @Override
    public void manageItems() {
        Scanner sc = new Scanner(System.in);
        int pilihan = -1;
        do {
            System.out.println("\n=== Kelola Laporan Barang ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali ke Menu Admin");
            System.out.print("Pilihan: ");
            try {
                pilihan = sc.nextInt();
                sc.nextLine(); // Konsumsi newline
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                sc.nextLine();
                continue;
            }
            if (pilihan == 1) {
                // Tampilkan semua laporan barang
                if (LoginSystem.reportedItems.isEmpty()) {
                    System.out.println("Belum ada laporan barang.");
                } else {
                    System.out.println("Daftar Laporan Barang:");
                    int idx = 0;
                    for (Item item : LoginSystem.reportedItems) {
                        System.out.println("[" + idx + "] " + item.toString());
                        idx++;
                    }
                }
            } else if (pilihan == 2) {
                // Proses penandaan barang dari "Reported" menjadi "Claimed"
                int idx = 0;
                boolean found = false;
                System.out.println("Barang dengan status 'Reported':");
                for (Item item : LoginSystem.reportedItems) {
                    if (item.getStatus().equals("Reported")) {
                        System.out.println("[" + idx + "] " + item.toString());
                        found = true;
                    }
                    idx++;
                }
                if (!found) {
                    System.out.println("Tidak ada barang dengan status 'Reported'.");
                } else {
                    System.out.print("Masukkan indeks barang yang ingin diubah status: ");
                    try {
                        int index = sc.nextInt();
                        sc.nextLine();
                        if (index < 0 || index >= LoginSystem.reportedItems.size()) {
                            System.out.println("Indeks tidak valid.");
                        } else {
                            Item selected = LoginSystem.reportedItems.get(index);
                            if (!selected.getStatus().equals("Reported")) {
                                System.out.println("Barang tidak dalam status 'Reported'.");
                            } else {
                                selected.setStatus("Claimed");
                                System.out.println("Barang '" + selected.getItemName() + "' telah ditandai sebagai diambil.");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        sc.nextLine();
                    }
                }
            } else if (pilihan == 0) {
                System.out.println("Kembali ke Menu Admin.");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        // Tidak menutup scanner
    }

    // Implementasi aksi admin: mengelola data mahasiswa
    @Override
    public void manageUsers() {
        Scanner sc = new Scanner(System.in);
        int pilihan = -1;
        do {
            System.out.println("\n=== Kelola Data Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali ke Menu Admin");
            System.out.print("Pilihan: ");
            try {
                pilihan = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                sc.nextLine();
                continue;
            }
            if (pilihan == 1) {
                System.out.print("Masukkan nama mahasiswa: ");
                String nama = sc.nextLine();
                System.out.print("Masukkan NIM mahasiswa: ");
                String nim = sc.nextLine();
                // Tambah mahasiswa baru ke dalam userList global
                LoginSystem.userList.add(new Mahasiswa(nama, nim));
                System.out.println("Mahasiswa berhasil ditambahkan.");
            } else if (pilihan == 2) {
                System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                String nim = sc.nextLine();
                boolean removed = false;
                // Cari dan hapus mahasiswa berdasarkan NIM
                for (java.util.Iterator<User> it = LoginSystem.userList.iterator(); it.hasNext();) {
                    User u = it.next();
                    if (u instanceof Mahasiswa && u.getNim().equals(nim)) {
                        it.remove();
                        removed = true;
                        System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                    }
                }
                if (!removed) {
                    System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
                }
            } else if (pilihan == 0) {
                System.out.println("Kembali ke Menu Admin.");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        // Tidak menutup scanner
    }
}