class Cashier {
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
            if (item.getCode().equals(code)) {  // Gunakan equals() untuk membandingkan String
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
            total += item.getSubTotal();  // Menggunakan subtotal
        }
        System.out.println("Total belanja: " + total);
    }

    public void processPayment(int payment) {
        double total = items.stream().mapToDouble(Item::getSubTotal).sum();  // Hitung total belanja
        double change = payment - total;  // Hitung kembalian atau kekurangan
        System.out.println("Total bayar: " + total);
        System.out.println("Dibayar: " + payment);

        if (payment < total) {
            double shortage = total - payment;
            System.out.println("Kekurangan bayar: " + shortage);
        } else {
            System.out.println("Kembalian: " + change);
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
