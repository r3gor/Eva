package eva;

/**
 * @author Roger Ramos <yihsic at gmail.com>
 */

public class Pregunta {
    private String enunciado;
    private String[] claves = {"", "", "", "", ""};

    public Pregunta(String enunciado, String[] claves) {
        this.enunciado = enunciado;
        this.claves = claves;
    }

    public Pregunta() {
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getClaves() {
        return claves;
    }

    public void setClaves(String[] claves) {
        this.claves = claves;
    }

    @Override
    public String toString() {
        StringBuilder val = new StringBuilder("Pregunta:\n" + enunciado);
        val.append("\nClaves:");
        for (String clave : claves) {
            val.append("\n");
            val.append(clave);
        }
        return val.toString();
    }


}
