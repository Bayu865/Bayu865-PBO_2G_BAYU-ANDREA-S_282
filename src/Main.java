import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String NIM_TERAKHIR = "282"; // Ganti dengan 3 digit terakhir NIM Anda
        String NAMA = "Bayu Andrea Setyawan"; // Ganti dengan nama Anda
        String NIM_LENGKAP = "20241037011282"; // Ganti dengan NIM lengkap Anda

        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine(); // Membersihkan newline

        if (pilihan == 1) {
            // Login Admin
            System.out.print("Masukkan username: ");
            String username = input.nextLine().trim();
            System.out.print("Masukkan password: ");
            String password = input.nextLine().trim();

            String usernameBenar = "Admin" + NIM_TERAKHIR;
            String passwordBenar = "Password" + NIM_TERAKHIR;

            if (username.equals(usernameBenar) && password.equals(passwordBenar)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (pilihan == 2) {
            // Login Mahasiswa
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine().trim();
            System.out.print("Masukkan NIM: ");
            String nim = input.nextLine().trim();

            if (nama.equalsIgnoreCase(NAMA) && nim.equals(NIM_LENGKAP)) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + nama);
                System.out.println("NIM: " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        input.close();
    }
}