package perpustakaan;

// Kelas Anggota yang mengimplementasikan interface Peminjaman
public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;

    // Konstruktor untuk inisialisasi anggota
    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    // Method untuk menampilkan identitas anggota
    public void displayAnggota() {
        System.out.println("Nama Anggota: " + nama + " (ID: " + idAnggota + ")");
    }

    // Implementasi peminjaman buku tanpa durasi
    @Override
    public void pinjamBuku(String judul) {
        System.out.println(nama + " meminjam buku berjudul: " + judul);
    }

    // Overloaded method: Implementasi peminjaman buku dengan durasi
    @Override
    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " meminjam buku berjudul: " + judul + " selama " + durasi + " hari");
    }

    // Implementasi pengembalian buku
    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " mengembalikan buku berjudul: " + judul);
    }
}