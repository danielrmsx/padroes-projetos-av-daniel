import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuracao {
    private static final Configuracao INSTANCIA = new Configuracao();

    private final String regiao;
    private final double orcamentoMaximo;

    private Configuracao() {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler config.properties", e);
        }
        this.regiao = props.getProperty("regiao.padrao");
        this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento.maximo"));
    }

    public static Configuracao getInstancia() {
        return INSTANCIA;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getOrcamentoMaximo() {
        return orcamentoMaximo;
    }
}
