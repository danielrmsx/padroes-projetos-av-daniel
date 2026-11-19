import java.util.concurrent.atomic.AtomicInteger;

public class AzureFila implements Fila {
    public static final double CUSTO_FIXO = 0.50;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id;

    public AzureFila() {
        this.id = "sb-" + SEQUENCIA.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoMensal() {
        return CUSTO_FIXO;
    }
}
