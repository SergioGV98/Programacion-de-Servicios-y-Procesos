package cllienteservidormonohilofecha;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GeneradorPreguntas {

    Map<String, String> preguntas = new HashMap<>();

    public void agregarPregunta(String pregunta, String respuesta) {
        preguntas.put(pregunta, respuesta);
    }

    public Map<String, String> getPreguntaRandom() {
        Random r = new Random();

        String[] preguntasArray = preguntas.keySet().toArray(new String[0]);
        String preguntaAleatoria = preguntasArray[r.nextInt(preguntas.size())];
        String respuesta = preguntas.get(preguntaAleatoria);
        
        Map<String, String> preguntaElegida = new HashMap<>();
        preguntaElegida.put(preguntaAleatoria, respuesta);
        
        return preguntaElegida;
    }
}
