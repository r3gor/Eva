package eva;

public class Eva {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws Exception {
        Examen Test1 = new Examen(4, "Preguntas.txt");
        Test1.cargaPreguntas();
        Test1.reordenaPreguntas();
        Test1.imprimePreguntas();
    }
}
