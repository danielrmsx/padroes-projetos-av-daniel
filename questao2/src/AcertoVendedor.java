public class AcertoVendedor {
    public void imprimir(Lote lote) {
        System.out.println("=== Acerto do vendedor ===");
        System.out.println("Lote: " + lote.getNome());
        System.out.printf("Valor de venda: R$ %.2f%n", lote.getValorVenda());
        System.out.printf("Comissão cobrada: R$ %.2f%n", lote.getComissao());
        System.out.printf("Valor líquido a repassar: R$ %.2f%n", lote.getValorVenda() - lote.getComissao());
    }
}
