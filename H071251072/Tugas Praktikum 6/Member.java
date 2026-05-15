import java.util.ArrayList;

public class Member {
    String name;
    int memberId;
    ArrayList <LibraryItem> borrowedItems;


    public Member(String name, int memberId, ArrayList<LibraryItem> borrowedItems) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = borrowedItems;
    }

    void borrow (LibraryItem item, int days){
        try {
            String pesan = item.borrowItem(days);
            borrowedItems.add(item);
            System.out.println(pesan);
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal meminjam: " + e.getMessage());
        }
    }

    void returnItem(LibraryItem item, int daysLate) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);

            double fine = 0;
            if (daysLate > 0) {
                fine = item.calculateFine(daysLate);
            }

            String result = item.returnItem();

            System.out.println(result);
            if (fine > 0) {
                System.out.println("Denda: Rp" + fine);
            } else {
                System.out.println("Tidak ada denda");
            }

        } else {
            System.out.println("Item tidak ditemukan dalam daftar pinjaman");
        }
    }

    void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang sedang dipinjam");
            return;
        }

        System.out.println("==============================");
        System.out.printf("| %-3s | %-20s |\n", "ID", "Judul");
        System.out.println("==============================");

        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-3d | %-20s |\n", item.itemId, item.title);
        }

        System.out.println("==============================");
    }
    
}