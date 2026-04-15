class OperaPerformer {
    String name;
    int vocalPower;
    OperaCostume costume;

    public OperaPerformer() {
        this.name = "Unknown";
        this.vocalPower = 50;
        this.costume = new OperaCostume();
    }

    public OperaPerformer(String name, int vocalPower) {
            this.name = name;
            this.vocalPower = vocalPower;
            this.costume = new OperaCostume();
        }

    public OperaPerformer(String name, int vocalPower, OperaCostume costume) {
        this.name = name;
        this.vocalPower = vocalPower;
        this.costume = costume;
    }

    void perform() {
        System.out.println(name + " is performing on stage!");
        System.out.println("Vocal Power: " + vocalPower);
        costume.showCostume();
    }

    void singBattle(OperaPerformer opponent) {
        System.out.println(name + " vs " + opponent.name);

        if (this.vocalPower > opponent.vocalPower) {
            System.out.println(name + " wins!");
        } else if (this.vocalPower < opponent.vocalPower) {
            System.out.println(opponent.name + " wins!");
        } else {
            System.out.println("Tie!");
        }
    }
}