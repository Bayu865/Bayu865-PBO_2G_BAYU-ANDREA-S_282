// Kelas Hewan
class Hewan {
    String Nama; // Atribut Nama
    String Jenis; // Atribut Jenis
    String Suara; // Atribut Suara

    // Constructor untuk inisialisasi atribut
    Hewan(String Nama, String Jenis, String Suara) {
        this.Nama = Nama;
        this.Jenis = Jenis;
        this.Suara = Suara;
    }

    // Metode untuk menampilkan informasi Hewan
    void tampilkanInfo(String hewanID) {
        System.out.println("Nama " + hewanID + ": " + Nama);
        System.out.println("Jenis " + hewanID + ": " + Jenis);
        System.out.println("Suara " + hewanID + ": " + Suara);
        System.out.println(); // Baris kosong untuk pemisah
    }
}

// Kelas Main
public class Main {
    public static void main(String[] args) {
        // Membuat objek Hewan pertama
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");

        // Membuat objek Hewan kedua
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        // Memanggil metode tampilkanInfo() untuk kedua objek
        hewan1.tampilkanInfo("hewan1");
        hewan2.tampilkanInfo("hewan2");
    }
}
