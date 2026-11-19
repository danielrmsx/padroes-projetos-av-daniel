import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroAuditoria {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private final LocalDateTime dataHora;
    private final String ambiente;
    private final String provedor;
    private final String resultado;

    public RegistroAuditoria(LocalDateTime dataHora, String ambiente, String provedor, String resultado) {
        this.dataHora = dataHora;
        this.ambiente = ambiente;
        this.provedor = provedor;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return dataHora.format(FORMATO) + " | " + ambiente + " | " + provedor + " | " + resultado;
    }
}
