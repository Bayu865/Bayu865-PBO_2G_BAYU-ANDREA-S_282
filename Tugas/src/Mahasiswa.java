// Kelas Mahasiswa mewarisi dari User
public class Mahasiswa extends User {

    // Konstruktor Mahasiswa menggunakan super() untuk menginisialisasi nama dan nim
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }
    // Override login() agar mencocokkan input nama (ignore case) dan nim
    @Override
    public boolean login(String input1, String input2) {
        return input1.equalsIgnoreCase(getNama()) && input2.equals(getNim());
    }
    // Override displayInfo() untuk menampilkan pesan login sukses Mahasiswa
    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}