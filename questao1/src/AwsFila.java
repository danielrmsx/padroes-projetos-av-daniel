import java.util.concurrent.atomic.AtomicInteger;

public class AwsFila implements Fila {
    public static final double CUSTO_FIXO = 0.40;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id;

    public AwsFila() {
        this.id = "sqs-" + SEQUENCIA.incrementAndGet();
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
