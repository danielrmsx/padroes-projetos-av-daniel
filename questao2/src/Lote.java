import java.util.ArrayList;
import java.util.List;

public class Lote implements Observavel {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private RegraComissao regraComissao;

    private final List<Interessado> interessados = new ArrayList<>();
    private final List<Lance> lances = new ArrayList<>();

    private boolean aberto = true;
    private boolean vendido = false;
    private double comissao = 0;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.regraComissao = regraComissao;
    }

    public double getLanceAtual() {
        if (lances.isEmpty()) {
            return precoInicial;
        }
        return lances.get(lances.size() - 1).getValor();
    }

    public boolean receberLance(Lance lance) {
        if (!aberto) {
            System.out.printf("Lance de %s recusado: o lote %s está encerrado.%n",
                    lance.getNomeParticipante(), nome);
            return false;
        }
        double minimo = getLanceAtual() * 1.05;
        if (lance.getValor() < minimo) {
            System.out.printf("Lance de R$ %.2f de %s recusado: deve ser pelo menos 5%% maior que o lance atual (mínimo R$ %.2f).%n",
                    lance.getValor(), lance.getNomeParticipante(), minimo);
            return false;
        }
        lances.add(lance);
        notificarInteressados(lance);
        return true;
    }

    @Override
    public void adicionarInteressado(Interessado interessado) {
        interessados.add(interessado);
    }

    @Override
    public void removerInteressado(Interessado interessado) {
        interessados.remove(interessado);
    }

    @Override
    public void notificarInteressados(Lance lance) {
        for (Interessado i : interessados) {
            if (i != lance.getAutor()) {
                i.atualizar(this, lance);
            }
        }
    }

    public void setRegraComissao(RegraComissao regraComissao) {
        if (!aberto) {
            System.out.println("Não é possível trocar a regra: o lote " + nome + " já foi encerrado.");
            return;
        }
        this.regraComissao = regraComissao;
    }

    public void encerrar() {
        aberto = false;
        if (!lances.isEmpty() && getLanceAtual() >= precoReserva) {
            vendido = true;
            comissao = regraComissao.calcular(getLanceAtual());
            System.out.printf("Lote %s encerrado: VENDIDO para %s por R$ %.2f.%n",
                    nome, lances.get(lances.size() - 1).getNomeParticipante(), getLanceAtual());
        } else {
            System.out.printf("Lote %s encerrado: NÃO VENDIDO (reserva de R$ %.2f não atingida).%n",
                    nome, precoReserva);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getTotalLances() {
        return lances.size();
    }

    public boolean isVendido() {
        return vendido;
    }

    public double getValorVenda() {
        return vendido ? getLanceAtual() : 0;
    }

    public double getComissao() {
        return comissao;
    }
}
