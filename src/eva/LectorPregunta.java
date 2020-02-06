package eva;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Roger Ramos <yihsic at gmail.com>
 */
public class LectorPregunta {
    private Scanner preguntasReader;
    private Scanner respuestasReader;

    public LectorPregunta(String file_preguntas, String file_respuestas) throws Exception {
        File filePreguntas = new File(file_preguntas);
        File fileRespuestas = new File(file_respuestas);
        if (filePreguntas.exists() && fileRespuestas.exists()) {
            preguntasReader = new Scanner(filePreguntas);
            respuestasReader = new Scanner(fileRespuestas);
            System.out.println("[*] Ficheros cargado. (" + filePreguntas.toString() + ")");
        } else {
            System.out.println("[*] Algun fichero no existe.");
        }
    }

    public String leeRespuesta() {
        String respuesta;
        respuestasReader.skip(Pattern.compile("Rpta:"));
        respuesta = respuestasReader.nextLine();
        System.out.println("respuesta leida:" + respuesta);
        return respuesta.trim();
    }

    public String leeEnunciado() {
        StringBuilder enunciado = new StringBuilder();
        preguntasReader.skip(Pattern.compile("([0-9].)|([0-9][0-9].)"));
        while (!(preguntasReader.hasNext(Pattern.compile("A\\)|a\\)")))) {
            enunciado.append(preguntasReader.nextLine()).append("\n");
        }
        return enunciado.toString().trim();
    }

    public String[] leeClaves() {
        String lineaActual = "";
        StringBuilder textoContieneClaves = new StringBuilder();

        while (!(lineaActual.contains("e)"))) {
            lineaActual = preguntasReader.nextLine();
            textoContieneClaves.append(lineaActual);
        }

        String[] claves = textoContieneClaves.toString().split("a\\)|b\\)|c\\)|d\\)|e\\)");

        claves = Arrays.copyOfRange(claves, 1, 6);
        preguntasReader.useDelimiter("\\.");
        while (!(preguntasReader.hasNextInt()) && preguntasReader.hasNext()) {
            lineaActual = "\n" + preguntasReader.nextLine();
            claves[4] += lineaActual;
        }
        for (int i = 0; i < 5; i++) {
            claves[i] = claves[i].trim();
        }

        preguntasReader.useDelimiter(Pattern.compile(" "));

        return claves;
    }

    public void finLector() {
        System.out.println("[*] fin Scanner, recursos liberados.");
        preguntasReader.close();
    }
}
