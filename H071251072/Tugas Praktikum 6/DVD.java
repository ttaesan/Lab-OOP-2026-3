public class DVD extends LibraryItem {
    int duration;

    public DVD(String title, int itemId, boolean isBorrowed, int duration) {
        super(title, itemId, isBorrowed);
        this.duration = duration;
    }

    @Override
    String getDescription() {
        return "DVD: " + title + ", Durasi: " + duration + ", ID: " + itemId;
    }

    @Override
    String borrowItem(int days) {
        if (days > 7) {
            throw new IllegalArgumentException ("Maksimal peminjaman adalah 7 hari");
        }

        if (isBorrowed) {
            throw new IllegalArgumentException ("DVD sedang dipinjam");
        }

        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
    
}
