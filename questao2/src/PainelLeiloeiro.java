public class PainelLeiloeiro implements Interessado {
    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("  [Painel] Lote %s - maior lance: R$ %.2f | total de lances: %d%n",
                lote.getNome(), lote.getLanceAtual(), lote.getTotalLances());
    }
}
