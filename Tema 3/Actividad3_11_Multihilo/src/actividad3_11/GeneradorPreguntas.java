package actividad3_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class GeneradorPreguntas {

    private final Map<String, String> preguntasRespuestas;
    private final Random random;

    public GeneradorPreguntas() {
        preguntasRespuestas = new HashMap<>();
        random = new Random();
        llenarMapa();
    }

    private void llenarMapa() {
        preguntasRespuestas.put("¿Cual es la capital de Francia?", "Paris");
        preguntasRespuestas.put("¿En que ano se descubrio America?", "1492");
        preguntasRespuestas.put("¿Quien escribio 'Don Quijote de la Mancha'?", "Miguel de Cervantes");
    }

    public Map.Entry<String, String> obtenerPreguntaAleatoria() {
        int index = random.nextInt(preguntasRespuestas.size());
        int i = 0;
        for (Map.Entry<String, String> entry : preguntasRespuestas.entrySet()) {
            if (i == index) {
                return entry;
            }
            i++;
        }
        return null;
    }
}
