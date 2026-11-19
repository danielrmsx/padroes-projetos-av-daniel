public class ComissaoArte implements RegraComissao {
    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.20;
    }
}
