import perpustakaan.Buku;
import perpustakaan.Fiksi;
import perpustakaan.Nonfiksi;
import perpustakaan.Anggota;

public class Main { // Titik masuk program
    public static void main(String[] args) {
        Buku bukuNonfiksi = new Nonfiksi("Filosofi Teras", "Henry Manampiring"); // Mmebuat objek buku Nonfiksi
        Buku bukuFiksi = new Fiksi("Laskar Pelangi", "Andrea Hirata"); // Membuat objek buku Fiksi

        // Menampilkan informasi buku
        bukuNonfiksi.displayInfo();
        bukuFiksi.displayInfo();

        // Membuat objek Anggota beserta datanya
        Anggota anggota1 = new Anggota("Bayu Andrea", "G282");
        Anggota anggota2 = new Anggota("Muhammad Dafifu", "G278");

        // Menampilkan informasi anggota
        anggota1.displayAnggota();
        anggota2.displayAnggota();

        // Simulasi Peminjaman buku
        anggota1.pinjamBuku("Filosofi Teras");
        anggota2.pinjamBuku("Laskar Pelangi", 10);

        // Simulasi Pengembalian buku
        anggota1.kembalikanBuku("Filosofi Teras");
        anggota2.kembalikanBuku("Laskar Pelangi");
    }
}