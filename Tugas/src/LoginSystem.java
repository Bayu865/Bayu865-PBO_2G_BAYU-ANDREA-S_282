import java.util.Scanner; // Mengimpor kelas Scanner untuk menerima input dari pengguna

// Kelas Admin untuk verifikasi login admin
class Admin {
    private final String username; // Menyimpan username admin
    private final String password; // Menyimpan password admin

    // Konstruktor Admin; menerima parameter tiga digit terakhir NIM
    Admin(String nimLast) {
        username = "Admin" + nimLast; // Menggabungkan string "Admin" dengan nimLast
        password = "Password" + nimLast; // Menggabungkan string "Password" dengan nimLast
    }

    // Metode login untuk memverifikasi username dan password yang dimasukkan
    boolean login(String user, String pass) {
        // Mengembalikan true jika input sesuai dengan data admin, sebaliknya false
        return user.equals(username) && pass.equals(password);
    }
}

// Kelas Mahasiswa untuk verifikasi login dan menampilkan informasi mahasiswa
class Mahasiswa {
    private final String nama; // Menyimpan nama mahasiswa
    private final String nim; // Menyimpan NIM mahasiswa

    // Konstruktor Mahasiswa; menerima parameter nama dan nim
    Mahasiswa(String nama, String nim) {
        this.nama = nama; // Menginisialisasi atribut nama dengan nilai parameter nama
        this.nim = nim;  // Menginisialisasi atribut nim dengan nilai parameter nim
    }

    // Metode login untuk memverifikasi nama dan NIM yang dimasukkan
    boolean login(String inputNama, String inputNim) {
        // Mengembalikan true jika input nama (abaikan kapital) dan NIM cocok, sebaliknya false
        return inputNama.equalsIgnoreCase(nama) && inputNim.equals(nim);
    }

    // Metode untuk menampilkan informasi mahasiswa setelah login berhasil
    void displayInfo() {
        System.out.println("Nama: " + nama); // Menampilkan nama mahasiswa
        System.out.println("NIM: " + nim);  // Menampilkan NIM mahasiswa
    }
}

// Kelas utama untuk menjalankan sistem login
public class LoginSystem {
    public static void main(String[] args) { // Titik masuk program
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input pengguna

        final String nimLast = "282";  // Mendefinisikan tiga digit terakhir NIM
        final String namaMahasiswa = "Bayu Andrea Setyawan"; // Mendefinisikan nama mahasiswa
        final String nimLengkap = "202410370110282";  // Mendefinisikan NIM lengkap mahasiswa

        Admin admin = new Admin(nimLast); // Membuat objek Admin dengan menggunakan nimLast
        Mahasiswa mahasiswa = new Mahasiswa(namaMahasiswa, nimLengkap); // Membuat objek Mahasiswa dengan nama dan nim lengkap

        System.out.println("Pilih login:");       // Menampilkan judul menu login
        System.out.println("1. Admin");           // Menampilkan pilihan login sebagai Admin
        System.out.println("2. Mahasiswa");       // Menampilkan pilihan login sebagai Mahasiswa
        System.out.print("Masukkan pilihan: ");   // Meminta pengguna memasukkan pilihan
        int pilihan = scanner.nextInt();          // Membaca input pilihan sebagai integer
        scanner.nextLine(); // Membersihkan newline yang tertinggal setelah nextInt()

        // Memeriksa pilihan login
        if (pilihan == 1) { // Jika pilihan adalah 1 (login Admin)
            System.out.print("Masukkan username: "); // Meminta input username untuk login Admin
            String user = scanner.nextLine().trim(); // Membaca input username dan menghapus spasi berlebih
            System.out.print("Masukkan password: "); // Meminta input password untuk login Admin
            String pass = scanner.nextLine().trim(); // Membaca input password dan menghapus spasi berlebih

            // Memeriksa kebenaran validasi dengan memanggil metode login dari objek admin
            if (admin.login(user, pass))
                System.out.println("Login Admin berhasil!"); // Menampilkan pesan berhasil jika valid
            else
                System.out.println("Login gagal! Username atau password salah."); // Menampilkan pesan gagal jika tidak valid

        } else if (pilihan == 2) { // Jika pilihan adalah 2 (login Mahasiswa)
            System.out.print("Masukkan Nama: ");      // Meminta input nama untuk login Mahasiswa
            String inputNama = scanner.nextLine().trim(); // Membaca input nama dan membersihkan spasi berlebih
            System.out.print("Masukkan NIM: ");       // Meminta input NIM untuk login Mahasiswa
            String inputNim = scanner.nextLine().trim();  // Membaca input NIM dan membersihkan spasi berlebih

            // Memeriksa kebenaran validasi dengan memanggil metode login dari objek mahasiswa
            if (mahasiswa.login(inputNama, inputNim)) {
                System.out.println("Login Mahasiswa berhasil!"); // Menampilkan pesan berhasil jika valid
                mahasiswa.displayInfo();  // Menampilkan informasi mahasiswa dengan memanggil displayInfo()
            } else {
                System.out.println("Login gagal! Nama atau NIM salah."); // Menampilkan pesan gagal jika tidak valid
            }
        } else { // Jika pilihan tidak valid
            System.out.println("Pilihan tidak valid."); // Menampilkan pesan error untuk pilihan yang salah
        }

        scanner.close(); // Menutup objek Scanner agar tidak terjadi kebocoran sumber daya
    }
}