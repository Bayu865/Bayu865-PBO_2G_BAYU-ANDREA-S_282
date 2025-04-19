// Superclass yang menyimpan data dasar pengguna
public abstract class User {
    private String nama; // Nama pengguna
    private String nim;  // NIM pengguna

    // Konstruktor menginisialisasi nama dan nim
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    // Getter dan setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    // Method abstract untuk pewarisan di subclass
    public abstract boolean login(String input1, String input2);
    public abstract void displayInfo();
}
