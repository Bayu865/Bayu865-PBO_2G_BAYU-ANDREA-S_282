package perpustakaan;

// Kelas NonFiksi merupakan subclass dari Buku untuk mewakili buku non-fiksi
public class Nonfiksi extends Buku {

    // Konstruktor NonFiksi menginisialisasi judul dan penulis menggunakan supe
    public Nonfiksi(String judul, String penulis) {
        super(judul, penulis);
    }

    // Menampilkan informasi buku non-fiksi
    @Override
    public void displayInfo() {
        System.out.println("Buku Non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: Filsafat dan Renungan)");
    }
}