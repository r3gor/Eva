package eva;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Roger Ramos <yihsic at gmail.com>
 */
public class LectorPregunta {
    private Scanner fileReader;

    public LectorPregunta(String filename) throws Exception {
        File fileText = new File(filename);
        if (fileText.exists()) {
            fileReader = new Scanner(fileText);
            System.out.println("[*] Fichero cargado. (" + fileText.toString() + ")");
        } else {
            System.out.println("[*] Fichero no existe.");
        }
    }

    public String leeEnunciado() {
        StringBuilder enunciado = new StringBuilder();
        fileReader.skip(Pattern.compile("([0-9].)|([0-9][0-9].)"));
        while (!(fileReader.hasNext(Pattern.compile("A\\)|a\\)")))) {
            enunciado.append(fileReader.nextLine()).append("\n");
        }
        return enunciado.toString().trim();
    }

    public String[] leeClaves() {
        String lineaActual = "";
        StringBuilder textoContieneClaves = new StringBuilder();

        while (!(lineaActual.contains("e)"))) {
            lineaActual = fileReader.nextLine();
            textoContieneClaves.append(lineaActual);
        }

        String[] claves = textoContieneClaves.toString().split("a\\)|b\\)|c\\)|d\\)|e\\)");

        claves = Arrays.copyOfRange(claves, 1, 6);
        fileReader.useDelimiter("\\.");
        while (!(fileReader.hasNextInt()) && fileReader.hasNext()) {
            lineaActual = "\n" + fileReader.nextLine();
            claves[4] += lineaActual;
        }
        for (int i = 0; i < 5; i++) {
            claves[i] = claves[i].trim();
        }

        fileReader.useDelimiter(Pattern.compile(" "));

        return claves;
    }

    public void finLector() {
        System.out.println("[*] fin Scanner, recursos liberados.");
        fileReader.close();
    }
}
