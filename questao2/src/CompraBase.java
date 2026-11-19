public class CompraBase implements Compra {
    private final String nomeLote;
    private final double valorVenda;

    public CompraBase(Lote lote) {
        if (!lote.isVendido()) {
            throw new IllegalStateException("Só é possível comprar um lote vendido.");
        }
        this.nomeLote = lote.getNome();
        this.valorVenda = lote.getValorVenda();
    }

    @Override
    public String getNomeLote() {
        return nomeLote;
    }

    @Override
    public double getValorVenda() {
        return valorVenda;
    }

    @Override
    public String getDetalhes() {
        return "";
    }

    @Override
    public double getTotal() {
        return valorVenda;
    }
}
