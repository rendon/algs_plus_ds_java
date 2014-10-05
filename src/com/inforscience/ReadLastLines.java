package com.inforscience;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadLastLines {
    public ArrayList<String> lastK(BufferedReader reader, int k)
    {
        if (k < 1) {
            throw new IndexOutOfBoundsException("K must be positive.");
        }

        if (reader == null) {
            throw new NullPointerException();
        }

        try {
            String[] lines = new String[k];
            String line;
            int l = 0;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                lines[l] = line;
                l = (l + 1) % k;
                count++;
            }

            ArrayList<String> result = new ArrayList<String>();
            if (count < k) {
                for (int i = 0; i < count; i++) {
                    result.add(lines[i]);
                }
            } else {
                for (int i = 0; i < k; i++) {
                    result.add(lines[(l+i)%k]);
                }
            }

            return result;
        } catch (IOException ioe) {
            return new ArrayList<String>();
        }
    }
}
