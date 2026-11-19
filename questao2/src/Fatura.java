public class Fatura {
    public void imprimir(Compra compra) {
        System.out.println("=== Fatura do comprador ===");
        System.out.println("Lote: " + compra.getNomeLote());
        System.out.printf("Valor de venda: R$ %.2f%n", compra.getValorVenda());
        System.out.print(compra.getDetalhes());
        System.out.printf("Total a pagar: R$ %.2f%n", compra.getTotal());
    }
}
