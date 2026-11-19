import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas = new ArrayList<>();
    private final Armazenamento armazenamento;
    private final Fila fila;

    public Ambiente(String nome, String regiao, ProvedorFactory fabrica, int quantidadeMaquinas, int gb) {
        this.nome = nome;
        this.regiao = regiao;
        this.provedor = fabrica.getNome();
        for (int i = 0; i < quantidadeMaquinas; i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        this.armazenamento = fabrica.criarArmazenamento(gb);
        this.fila = fabrica.criarFila();
    }

    public double getCustoMensal() {
        double total = 0;
        for (MaquinaVirtual m : maquinas) {
            total += m.getCustoMensal();
        }
        return total + armazenamento.getCustoMensal() + fila.getCustoMensal();
    }

    public String resumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Ambiente: ").append(nome).append(" ===\n");
        sb.append("Provedor: ").append(provedor).append("\n");
        sb.append("Região: ").append(regiao).append("\n");
        for (MaquinaVirtual m : maquinas) {
            sb.append("Máquina virtual: ").append(m.getId()).append("\n");
        }
        sb.append("Armazenamento: ").append(armazenamento.getId())
          .append(" (").append(armazenamento.getGb()).append(" GB)\n");
        sb.append("Fila: ").append(fila.getId()).append("\n");
        sb.append(String.format("Custo mensal estimado: R$ %.2f", getCustoMensal()));
        return sb.toString();
    }
}
