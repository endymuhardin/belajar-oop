public class PembelianDetail {
    private Pembelian pembelian;
    private Produk produk;
    private Integer jumlah;
    
    public BigDecimal hitungSubtotal(){
        return produk.getHarga()
                .multiply(new BigDecimal(jumlah));
    }
    
}
