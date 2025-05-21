import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Data awal
        daftarBarang.add(new Barang("Buku", 10));
        daftarBarang.add(new Barang("Pulpen", 20));

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            int pilihan = -1;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // clear newline
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // clear invalid input
                continue;
            }

            switch (pilihan) {
                case 1 -> {
                    try {
                        System.out.print("Nama Barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Stok Awal: ");
                        int stok = scanner.nextInt();
                        scanner.nextLine();

                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine();
                    }
                }
                case 2 -> {
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("Daftar Barang:");
                        for (Barang b : daftarBarang) {
                            System.out.println("- " + b);
                        }
                    }
                }
                case 3 -> {
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi.");
                        break;
                    }

                    for (int i = 0; i < daftarBarang.size(); i++) {
                        System.out.println(i + ". " + daftarBarang.get(i));
                    }

                    try {
                        System.out.print("Pilih nomor barang: ");
                        int indeks = scanner.nextInt();
                        System.out.print("Jumlah yang akan dikurangi: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        Barang barang = daftarBarang.get(indeks);
                        if (jumlah > barang.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Nomor barang tidak valid!");
                    } catch (StokTidakCukupException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 0 -> {
                    running = false;
                    System.out.println("Terima kasih!");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}