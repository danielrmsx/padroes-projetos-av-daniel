import java.util.concurrent.atomic.AtomicInteger;

public class AzureArmazenamento implements Armazenamento {
    public static final double CUSTO_GB = 0.02;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id;
    private final int gb;

    public AzureArmazenamento(int gb) {
        this.id = "blob://" + SEQUENCIA.incrementAndGet();
        this.gb = gb;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getGb() {
        return gb;
    }

    @Override
    public double getCustoMensal() {
        return gb * CUSTO_GB;
    }
}
