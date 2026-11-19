public class Solicitacao {
    private final String nomeAmbiente;
    private final String provedor;
    private final int quantidadeMaquinas;
    private final int gbArmazenamento;

    public Solicitacao(String nomeAmbiente, String provedor, int quantidadeMaquinas, int gbArmazenamento) {
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public String getProvedor() {
        return provedor;
    }

    public int getQuantidadeMaquinas() {
        return quantidadeMaquinas;
    }

    public int getGbArmazenamento() {
        return gbArmazenamento;
    }
}
