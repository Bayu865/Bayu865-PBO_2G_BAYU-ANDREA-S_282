package perpustakaan;

// Kelas Fiksi merupakan subclass dari Buku untuk mewakili buku fiksi
public class Fiksi extends Buku {

    // Konstruktor Fiksi menginisialisasi judul dan penulis menggunakan super
    public Fiksi(String judul, String penulis) {
        super(judul, penulis);
    }

    // Menampilkan informasi buku fiksi
    @Override
    public void displayInfo() {
        System.out.println("Buku Fiksi: " + judul + " karya " + penulis + " (Genre: Novel Inspiratif)");
    }
}
