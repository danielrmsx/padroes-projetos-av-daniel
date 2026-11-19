public class ComissaoImoveis implements RegraComissao {
    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + 1500.00;
    }
}
