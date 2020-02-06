package eva;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Roger Ramos <yihsic at gmail.com>
 */

public class Examen {
    private Pregunta[] preguntas;
    private LectorPregunta lectorPreguntas;
    private int n_preguntas;
    private int cantidadCorrectas;
    private int cantidadIncorrectas;

    public Examen(int n_preguntas, String file_preguntas, String file_respuestas) throws Exception {
        this.n_preguntas = n_preguntas;
        preguntas = new Pregunta[n_preguntas];
        lectorPreguntas = new LectorPregunta(file_preguntas, file_respuestas);
    }

    public void cargaPreguntas() {
        for (int i = 0; i < n_preguntas; i++) {
            preguntas[i] = new Pregunta();
            preguntas[i].setEnunciado(lectorPreguntas.leeEnunciado());
            preguntas[i].setClaves(lectorPreguntas.leeClaves());
            preguntas[i].setClaveCorrecta(lectorPreguntas.leeRespuesta());
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

    public void tomarExamen() {
        Scanner lectorRespuestasAlumno = new Scanner(System.in);
        for (Pregunta pregunta : preguntas) {
            System.out.println(pregunta.toString());
            System.out.println("Escriba la alternativa correcta: ");
            pregunta.setClaveSeleccionada(lectorRespuestasAlumno.nextLine().trim());
            if (pregunta.esCorrecto()) {
                cantidadCorrectas++;
            } else {
                cantidadIncorrectas++;
            }
        }
    }

    public String getResultados() {
        String resultados = "";
        resultados += "Correctas: " + cantidadCorrectas + "\n";
        resultados += "Incorrectas: " + cantidadIncorrectas;
        return resultados;
    }
}
