package test;
import main.PatronSearchNaive;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PatronSearchNaiveTest {

    @Test
    public void input1Test() {

        String T = "En résumé, cet algorithme vérifie de manière séquentielle chaque position possible de la chaîne T " +
                "pour une correspondance complète avec la sous-chaîne P et retourne toutes les positions de départ où " +
                "une telle correspondance est trouvée. C'est une méthode brute-force qui a une complexité temporelle";

        String P = "brute-force";

        ArrayList<Integer> s = PatronSearchNaive.findString(T, P);

        for (int i = 0; i < s.size() ; ++i) {
            for (int j = s.get(i); j < s.get(i) + P.length() ; ++j) {
                System.out.print(T.charAt(j));
            }
        }

    }
}
