public class Main {
    public static void main(String[] args) throws InterruptedException {
        Solicitacao web = new Solicitacao("ambiente-web", "Aws", 2, 100);
        Solicitacao dados = new Solicitacao("ambiente-dados", "Aws", 1, 500);
        Solicitacao api = new Solicitacao("ambiente-api", "Azure", 2, 200);
        Solicitacao ml = new Solicitacao("ambiente-ml", "Azure", 4, 1000);

        Thread t1 = new Thread(() -> provisionar(web));
        Thread t2 = new Thread(() -> provisionar(dados));
        Thread t3 = new Thread(() -> provisionar(api));
        Thread t4 = new Thread(() -> provisionar(ml));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        Auditoria.getInstancia().imprimirHistorico();
    }

    private static void provisionar(Solicitacao solicitacao) {
        ProvedorFactory fabrica = escolherProvedor(solicitacao.getProvedor());
        new ProvisionadorAmbiente(fabrica).provisionar(solicitacao);
    }

    private static ProvedorFactory escolherProvedor(String provedor) {
        switch (provedor) {
            case "Aws":
                return new AwsFactory();
            case "Azure":
                return new AzureFactory();
            default:
                throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
    }
}
