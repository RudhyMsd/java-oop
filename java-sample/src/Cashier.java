import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double p, String c, String n, int qty) {
        items.add(new Item(c, n, p, qty));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode() == code) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayTotal() {
        System.out.println("------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s\n", "Kode", "Nama Barang", "Harga", "Jumlah", "SubTotal");
        System.out.println("------------------------------------------------");
        double total = 0.0;
        for (Item item : items) {
            int subTotal = item.getSubTotal();
            total += subTotal();
            System.out.printf("%-10s %-20s %-10d %-10d %-10d\n",
            item.getCode(), item.getName(), item.getPrice(), item.getQty(), subTotal);
        }
        System.out.println("%-40s %-10d\n", "Total Belanja:", total);
    }
}
