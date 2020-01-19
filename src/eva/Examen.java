package eva;

/**
 * @author Roger Ramos <yihsic at gmail.com>
 */

public class Examen {
    private Pregunta[] preguntas;
    private LectorPregunta lectorPreguntas;
    private int n_preguntas;

    public Examen(int n_preguntas, String file) throws Exception {
        this.n_preguntas = n_preguntas;
        preguntas = new Pregunta[n_preguntas];
        lectorPreguntas = new LectorPregunta(file);
    }

    public void cargaPreguntas() {
        for (int i = 0; i < n_preguntas; i++) {
            preguntas[i] = new Pregunta();
            preguntas[i].setEnunciado(lectorPreguntas.leeEnunciado());
            preguntas[i].setClaves(lectorPreguntas.leeClaves());
        }
        lectorPreguntas.finLector();
    }

    public void imprimePreguntas() {
        for (int i = 0; i < n_preguntas; i++) {
            System.out.println(preguntas[i].toString());
            System.out.println("---------------------");
        }
    }

}
