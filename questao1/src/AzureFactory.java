public class AzureFactory implements ProvedorFactory {
    @Override
    public String getNome() {
        return "Azure";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new AzureMaquinaVirtual();
    }

    @Override
    public Armazenamento criarArmazenamento(int gb) {
        return new AzureArmazenamento(gb);
    }

    @Override
    public Fila criarFila() {
        return new AzureFila();
    }

    @Override
    public double getCustoHoraMaquina() {
        return AzureMaquinaVirtual.CUSTO_HORA;
    }

    @Override
    public double getCustoGbArmazenamento() {
        return AzureArmazenamento.CUSTO_GB;
    }

    @Override
    public double getCustoFixoFila() {
        return AzureFila.CUSTO_FIXO;
    }
}
