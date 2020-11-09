package projeto_ag;

import java.util.Comparator;

public class Comparador implements Comparator<Individuo> {

    @Override
    public int compare(Individuo o1, Individuo o2) {
        if(o1.getAptidao()<o2.getAptidao())
            return -1;
        else if (o1.getAptidao()>o2.getAptidao())
            return 1;
        else
            return 0;
    }
    
}
