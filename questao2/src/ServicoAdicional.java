public abstract class ServicoAdicional implements Compra {
    protected final Compra compra;

    protected ServicoAdicional(Compra compra) {
        this.compra = compra;
    }

    protected abstract String getDescricao();

    protected abstract double getCusto();

    @Override
    public String getNomeLote() {
        return compra.getNomeLote();
    }

    @Override
    public double getValorVenda() {
        return compra.getValorVenda();
    }

    @Override
    public String getDetalhes() {
        return compra.getDetalhes() + String.format("  %s: R$ %.2f%n", getDescricao(), getCusto());
    }

    @Override
    public double getTotal() {
        return compra.getTotal() + getCusto();
    }
}
