package perpustakaan;

// Interface Peminjaman mendefinisikan operasi dasar peminjaman buku
public interface Peminjaman {
    // Method untuk meminjam buku tanpa durasi
    void pinjamBuku(String judul);

    // Overloaded method untuk meminjam buku dengan durasi tertentu
    void pinjamBuku(String judul, int durasi);

    // Method untuk mengembalikan buku
    void kembalikanBuku(String judul);
}