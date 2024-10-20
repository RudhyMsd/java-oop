import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double p, String c, String n) {
        items.add(new Item(c, n, p));
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
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        System.out.println("Total belanja: " + total);
    }
     public void processPayment(int payment) {
        int total = items.stream().mapToInt(Item::getSubTotal).sum();
        int change = payment - total;.
        System.out.println("Total bayar: " + total);
        System.out.println("Dibayar: " + payment);

        if (payment < total) {
            int shortage = total - payment;
            System.out.println("Kekurangan bayar: " + shortage);
        } else {.
            System.out.println("Kembalian: " + change);
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
