public class SeguroTransporte extends ServicoAdicional {
    public SeguroTransporte(Compra compra) {
        super(compra);
    }

    @Override
    protected String getDescricao() {
        return "Seguro de transporte";
    }

    @Override
    protected double getCusto() {
        return getValorVenda() * 0.015;
    }
}
