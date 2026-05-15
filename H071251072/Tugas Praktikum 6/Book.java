public class Book extends LibraryItem {
    String author;

    public Book(String title, int itemId, boolean isBorrowed, String author) {
        super(title, itemId, isBorrowed);
        this.author = author;
    }

    @Override
    String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Maksimal peminjaman adalah 14 hari");
        }

        if (isBorrowed) {
            throw new IllegalArgumentException("Item sedang dipinjam");
        }

        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}