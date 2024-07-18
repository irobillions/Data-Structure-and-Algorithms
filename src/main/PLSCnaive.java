package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PLSCnaive {

    public String findPLSC(String s1, String s2) {
        Set<String> set1 = new HashSet<>(buildSequence(s1));
        Set<String> set2 = new HashSet<>(buildSequence(s2));

        String plsc = "";
        for (String seq : set1) {
            if (set2.contains(seq) && seq.length() > plsc.length()) {
                plsc = seq;
            }
        }

        return plsc;
    }

    public ArrayList<String> buildSequence(String seq) {
        ArrayList<String> sequences = new ArrayList<>();
        int n = seq.length();
        // Générer toutes les sous-séquences
        for (int i = 1; i <= (1 << n) - 2; i++) {
            StringBuilder subseq = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subseq.append(seq.charAt(j));
                }
            }
            sequences.add(subseq.toString());
        }
        return sequences;
    }
}
