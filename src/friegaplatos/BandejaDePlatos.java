package friegaplatos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


public class BandejaDePlatos {
    private final static int LIST_SIZE = 10;
    private ArrayBlockingQueue<Platos> arrayBlockingQueue = new ArrayBlockingQueue<>(LIST_SIZE);
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    public BandejaDePlatos(List<Platos> platos) {
        for (Platos plato: platos) {
            arrayBlockingQueue.add(plato);
        }
    }

    public BandejaDePlatos(){

    }


    protected void añadirBandeja(Platos plato) throws InterruptedException {
        System.out.printf("%s - %s plato nº %d\n", LocalTime.now().format(format), Thread.currentThread().getName(), plato.getNumSerie());
        arrayBlockingQueue.put(plato);

    }

    protected Platos extraerDeLaBandeja() throws InterruptedException {
        Platos plato = null;
        plato = arrayBlockingQueue.take();
        return plato;

    }


}

