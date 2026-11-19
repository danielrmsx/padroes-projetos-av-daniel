public class AwsFactory implements ProvedorFactory {
    @Override
    public String getNome() {
        return "Aws";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new AwsMaquinaVirtual();
    }

    @Override
    public Armazenamento criarArmazenamento(int gb) {
        return new AwsArmazenamento(gb);
    }

    @Override
    public Fila criarFila() {
        return new AwsFila();
    }

    @Override
    public double getCustoHoraMaquina() {
        return AwsMaquinaVirtual.CUSTO_HORA;
    }

    @Override
    public double getCustoGbArmazenamento() {
        return AwsArmazenamento.CUSTO_GB;
    }

    @Override
    public double getCustoFixoFila() {
        return AwsFila.CUSTO_FIXO;
    }
}
