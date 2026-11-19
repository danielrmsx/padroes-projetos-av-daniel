public interface Observavel {
    void adicionarInteressado(Interessado interessado);

    void removerInteressado(Interessado interessado);

    void notificarInteressados(Lance lance);
}
