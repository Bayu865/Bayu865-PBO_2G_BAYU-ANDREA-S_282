// Kelas Admin mewarisi dari User dan menambahkan username dan password
public class Admin extends User {
    private String username, password;

    // Konstruktor Admin menggunakan super() untuk menginisialisasi nama dan nim
    // Username dan password dibentuk dari tiga digit terakhir NIM
    public Admin(String nama, String nim) {
        super(nama, nim);
        String nimLast = nim.substring(nim.length() - 3);
        this.username = "Admin" + nimLast;
        this.password = "Password" + nimLast;
    }
    // Override login() untuk memeriksa kecocokan username dan password
    @Override
    public boolean login(String input1, String input2) {
        return input1.equals(username) && input2.equals(password);
    }
    // Override displayInfo() untuk menampilkan pesan login sukses Admin
    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}