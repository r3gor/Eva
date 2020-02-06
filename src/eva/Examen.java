package eva;

import java.util.Random;

/**
 * @author Roger Ramos <yihsic at gmail.com>
 */

public class Examen {
    private Pregunta[] preguntas;
    private LectorPregunta lectorPreguntas;
    private int n_preguntas;
    private int cantidadCorrectas;
    private int cantidadIncorrectas;

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

    public void reordenaPreguntas() {
        Pregunta aux;
        Random aleatorio = new Random(4234);
        int random_index;
        for (int i = 0; i < n_preguntas; i++) {
            random_index = aleatorio.nextInt(preguntas.length);
            aux = preguntas[i];
            preguntas[i] = preguntas[random_index];
            preguntas[random_index] = aux;
        }
    }

    public void imprimePreguntas() {
        for (int i = 0; i < n_preguntas; i++) {
            System.out.println((i + 1) + ". " + preguntas[i].toString());
            System.out.println("---------------------");
        }
    }

}
