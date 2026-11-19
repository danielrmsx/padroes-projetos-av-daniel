public class ProvisionadorAmbiente {
    private final ProvedorFactory fabrica;

    public ProvisionadorAmbiente(ProvedorFactory fabrica) {
        this.fabrica = fabrica;
    }

    public void provisionar(Solicitacao solicitacao) {
        Configuracao config = Configuracao.getInstancia();
        Auditoria auditoria = Auditoria.getInstancia();

        double custoEstimado =
                solicitacao.getQuantidadeMaquinas() * fabrica.getCustoHoraMaquina() * MaquinaVirtual.HORAS_POR_MES
                + solicitacao.getGbArmazenamento() * fabrica.getCustoGbArmazenamento()
                + fabrica.getCustoFixoFila();

        if (custoEstimado > config.getOrcamentoMaximo()) {
            String resultado = String.format(
                    "RECUSADO - custo estimado R$ %.2f ultrapassa o orçamento de R$ %.2f",
                    custoEstimado, config.getOrcamentoMaximo());
            auditoria.registrar(solicitacao.getNomeAmbiente(), fabrica.getNome(), resultado);
            System.out.println("Ambiente " + solicitacao.getNomeAmbiente() + ": " + resultado);
            return;
        }

        Ambiente ambiente = new Ambiente(solicitacao.getNomeAmbiente(), config.getRegiao(), fabrica,
                solicitacao.getQuantidadeMaquinas(), solicitacao.getGbArmazenamento());
        auditoria.registrar(solicitacao.getNomeAmbiente(), fabrica.getNome(), "ACEITO");
        System.out.println(ambiente.resumo());
    }
}
