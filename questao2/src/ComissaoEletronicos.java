public class ComissaoEletronicos implements RegraComissao {
    @Override
    public double calcular(double valorVenda) {
        return Math.max(valorVenda * 0.12, 50.00);
    }
}
