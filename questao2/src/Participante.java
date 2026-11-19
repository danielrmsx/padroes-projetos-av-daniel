public class Participante implements Interessado {
    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean darLance(Lote lote, double valor) {
        return lote.receberLance(new Lance(this, nome, valor));
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("  [%s] Novo lance no lote %s: R$ %.2f%n", nome, lote.getNome(), lance.getValor());
    }
}
