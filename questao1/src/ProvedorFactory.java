public interface ProvedorFactory {
    String getNome();

    MaquinaVirtual criarMaquinaVirtual();

    Armazenamento criarArmazenamento(int gb);

    Fila criarFila();

    double getCustoHoraMaquina();

    double getCustoGbArmazenamento();

    double getCustoFixoFila();
}
