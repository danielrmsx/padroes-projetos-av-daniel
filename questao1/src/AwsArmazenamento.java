import java.util.concurrent.atomic.AtomicInteger;

public class AwsArmazenamento implements Armazenamento {
    public static final double CUSTO_GB = 0.023;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id;
    private final int gb;

    public AwsArmazenamento(int gb) {
        this.id = "s3://" + SEQUENCIA.incrementAndGet();
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
