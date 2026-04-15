public class main {
    public static void main(String[] args) {
        dompet sabri = new dompet (170868, "Ahmad Sabri",11111111);
        sabri.getinfo();
        sabri.setPIN(123456);
        sabri.setPIN(234567);
        sabri.setor(300000);
        sabri.setor(-50000);
        sabri.tarik(100000);
        sabri.tarik(250000);
        sabri.getinfo();
    }
}
