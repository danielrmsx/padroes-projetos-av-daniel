import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements Interessado {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance) {
        String registro = String.format("%s | %s | %s | R$ %.2f",
                LocalDateTime.now().format(FORMATO), lote.getNome(), lance.getNomeParticipante(), lance.getValor());
        registros.add(registro);
        System.out.println("  [Auditor] " + registro);
    }
}
