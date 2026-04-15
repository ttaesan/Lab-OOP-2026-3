class OperaCostume {
    String costumeName;
    String color;
    String size;

    public OperaCostume() {
        this.costumeName = "Basic Costume";
        this.color = "Red";
        this.size = "L";
    }

    public OperaCostume(String costumeName, String color, String newSize) {
        this.costumeName = costumeName;
        this.color = color;
        this.size = newSize;
    }

    void showCostume() {
        System.out.println("Costume: " + costumeName + ", Color: " + color + ", Size: " + size);
    }
}