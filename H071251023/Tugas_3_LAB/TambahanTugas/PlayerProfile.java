public class PlayerProfile {
    // Atribut Private
    private int level;
    private String password;

    // Atribut Protected
    protected String username;

    // Atribut Default
    int healthPoint;

    // Constructor
    public PlayerProfile(String username, String password) {
        this.username = username;
        this.password = password;
        this.level = 1;
        this.healthPoint = 100;
    }

    // Getter Methods
    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    // Setter Method untuk Password
    public void setPassword(String passwordBaru) {
        if (passwordBaru.length() >= 8) {
            this.password = passwordBaru;
            System.out.println("Password berhasil diperbarui");
        } else {
            System.out.println("Error: Password harus minimal 8 karakter");
        }
    }

    // Method Utama
    public void levelUp() {
        level++;
        System.out.println("Level Up!");
        saveData();
    }

    public void receiveDamage(int damage) {
        System.out.println("Player menerima damage " + damage);
        healthPoint -= damage;
        if (healthPoint <= 0) {
            System.out.println("Player Mati");
        }
    }

    // Method Internal Private
    private void saveData() {
        System.out.println("Sistem: Progress otomatis disimpan ke server");
    }
    }
    