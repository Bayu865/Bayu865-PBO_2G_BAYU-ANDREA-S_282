package com.praktikum.data;

// Kelas Item untuk menyimpan detail barang yang dilaporkan
public class Item {
    private String itemName;
    private String description;
    private String location;
    private String status; // "Reported" atau "Claimed"

    // Konstruktor: inisialisasi item dengan status default "Reported"
    public Item(String itemName, String description, String location) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = "Reported";
    }

    // Getter methods
    public String getItemName() {
        return itemName;
    }
    public String getDescription() {
        return description;
    }
    public String getLocation() {
        return location;
    }
    public String getStatus() {
        return status;
    }

    // Setter untuk mengubah status, misalnya dari "Reported" menjadi "Claimed"
    public void setStatus(String status) {
        this.status = status;
    }

    // Representasi string dari Item
    @Override
    public String toString(){
        return "Nama Barang: " + itemName + ", Deskripsi: " + description +
                ", Lokasi: " + location + ", Status: " + status;
    }
}
