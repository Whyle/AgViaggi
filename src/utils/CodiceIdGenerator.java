package utils;

public class CodiceIdGenerator {
    /**
     * Metodo che genera un codice identificativo univoco per le prenotazioni
     * degli alloggi
     * @return un codice identificativo univoco
     */
    public static int generaCodiceId() {
        long currentTimestampMillis = System.currentTimeMillis();
        return (int) currentTimestampMillis;
    }
}
