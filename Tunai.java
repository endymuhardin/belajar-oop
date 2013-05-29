public class Tunai extends Pembayaran {
    private BigDecimal bayar;
    
    public BigDecimal hitungKembalian(){
        return bayar.substract(getJumlah());
    }
}
