// Main method untuk testing
    public static void main(String[] args) {
        PlayerProfile player = new PlayerProfile("Vicky", "password123");
        
        // Menampilkan data awal
        System.out.println("Username: " + player.getUsername());
        System.out.println("Level: " + player.getLevel());
        System.out.println();

        // Memanggil levelUp
        player.levelUp();
        System.out.println();

        // Memanggil receiveDamage dengan nilai 120
        player.receiveDamage(120);
        System.out.println();

        // Mengubah password dengan yang kurang dari 8 karakter
        player.setPassword("abc123");
        
        // Mengubah password dengan yang valid
        player.setPassword("passwordbaru");
    }
