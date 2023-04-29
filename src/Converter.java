public class Converter {

    int convertToKm(int steps) {
        int distance = steps * 75 / 1000;
        return distance;
    }
    int convertStepsToKkal(int steps) {
        int expendedKkal = steps * 50 / 1000;
        return expendedKkal;
    }
}
