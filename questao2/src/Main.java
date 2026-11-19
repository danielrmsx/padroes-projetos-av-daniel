public class Main {
    public static void main(String[] args) {
        Lote quadro = new Lote("Quadro Abstrato", "Arte", 1000.00, 3000.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletrônicos", 2000.00, 10000.00, new ComissaoEletronicos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        for (Lote lote : new Lote[] {quadro, notebook}) {
            lote.adicionarInteressado(ana);
            lote.adicionarInteressado(bruno);
            lote.adicionarInteressado(carla);
            lote.adicionarInteressado(painel);
            lote.adicionarInteressado(auditor);
        }

        System.out.println("--- Lances no lote Quadro Abstrato ---");
        ana.darLance(quadro, 1500.00);
        bruno.darLance(quadro, 1550.00);
        bruno.darLance(quadro, 1600.00);
        carla.darLance(quadro, 2000.00);

        System.out.println("--- Ana deixa de acompanhar o Quadro Abstrato ---");
        quadro.removerInteressado(ana);
        bruno.darLance(quadro, 3500.00);

        System.out.println("--- Lances no lote Notebook Gamer ---");
        carla.darLance(notebook, 2500.00);
        ana.darLance(notebook, 3000.00);

        System.out.println("--- Campanha: Quadro Abstrato passa a usar a regra de Eletrônicos ---");
        quadro.setRegraComissao(new ComissaoEletronicos());

        System.out.println("--- Encerramento ---");
        quadro.encerrar();
        notebook.encerrar();
        carla.darLance(quadro, 5000.00);

        Compra compra = new CompraBase(quadro);
        compra = new SeguroTransporte(compra);
        compra = new CertificadoAutenticidade(compra);
        compra = new EmbalagemEspecial(compra);
        compra = new EmbalagemEspecial(compra);

        System.out.println();
        new Fatura().imprimir(compra);
        System.out.println();
        new AcertoVendedor().imprimir(quadro);
    }
}
