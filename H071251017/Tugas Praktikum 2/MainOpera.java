public class MainOpera {
    public static void main(String[] args) {

        OperaCostume costume1 = new OperaCostume();
        OperaCostume costume2 = new OperaCostume("Phantom Suit", "Black", "XL"
        );

        OperaPerformer p1 = new OperaPerformer("Bae Ro Na", 80, costume1);
        OperaPerformer p2 = new OperaPerformer("Seo Jin", 70, costume2);

        p1.perform();
        System.out.println();

        p2.perform();
        System.out.println();

        p1.singBattle(p2);
    }
}