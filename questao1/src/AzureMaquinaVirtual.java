import java.util.concurrent.atomic.AtomicInteger;

public class AzureMaquinaVirtual implements MaquinaVirtual {
    public static final double CUSTO_HORA = 0.12;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id;

    public AzureMaquinaVirtual() {
        this.id = "vm-" + SEQUENCIA.incrementAndGet();
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
