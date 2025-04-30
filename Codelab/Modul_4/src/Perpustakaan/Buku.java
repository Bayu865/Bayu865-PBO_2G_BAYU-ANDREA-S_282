package perpustakaan;

// Abstract class untuk buku secara umum.
public abstract class Buku {
    protected String judul;
    protected String penulis;

    // Konstruktor untuk inisialisasi judul dan penulis
    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    // Method abstrak untuk menampilkan informasi buku
    public abstract void displayInfo();
}