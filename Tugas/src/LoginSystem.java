import java.util.Scanner; // Mengimpor Scanner untuk input

// Kelas utama untuk menjalankan sistem login
public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data untuk pengguna (Admin dan Mahasiswa)
        String nama = "Bayu Andrea Setyawan";
        String nim  = "202410370110282";

        // Membuat objek Admin dan Mahasiswa
        Admin admin = new Admin(nama, nim);
        Mahasiswa mahasiswa = new Mahasiswa(nama, nim);

        // Menampilkan menu login
        System.out.println("Pilih login:\n1. Admin\n2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = sc.nextInt();
        sc.nextLine(); // Bersihkan newline

        if (pilihan == 1) { //Method perbandingan atau verifikasi
            System.out.print("Masukkan username: ");
            String inputUsername = sc.nextLine().trim();
            System.out.print("Masukkan password: ");
            String inputPassword = sc.nextLine().trim();

            if (admin.login(inputUsername, inputPassword)) {
                admin.displayInfo();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String inputNama = sc.nextLine().trim();
            System.out.print("Masukkan NIM: ");
            String inputNim = sc.nextLine().trim();

            if (mahasiswa.login(inputNama, inputNim)) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        sc.close();
    }
}