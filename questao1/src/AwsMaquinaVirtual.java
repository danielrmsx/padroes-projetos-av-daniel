import java.util.concurrent.atomic.AtomicInteger;

public class AwsMaquinaVirtual implements MaquinaVirtual {
    public static final double CUSTO_HORA = 0.10;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id;

    public AwsMaquinaVirtual() {
        this.id = "i-" + SEQUENCIA.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoMensal() {
        return CUSTO_HORA * HORAS_POR_MES;
    }
}
