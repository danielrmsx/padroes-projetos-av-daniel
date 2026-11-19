public class Lance {
    private final Interessado autor;
    private final String nomeParticipante;
    private final double valor;

    public Lance(Interessado autor, String nomeParticipante, double valor) {
        this.autor = autor;
        this.nomeParticipante = nomeParticipante;
        this.valor = valor;
    }

    public Interessado getAutor() {
        return autor;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public double getValor() {
        return valor;
    }
}
