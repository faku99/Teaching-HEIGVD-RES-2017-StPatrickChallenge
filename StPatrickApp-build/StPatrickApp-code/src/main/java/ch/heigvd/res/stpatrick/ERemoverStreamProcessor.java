package ch.heigvd.res.stpatrick;

import java.io.*;

/**
 * @author Lucas Elisei (faku99)
 */
public class ERemoverStreamProcessor implements IStreamProcessor {
    private int forbiddenLowerCase = (int)'e';
    private int forbiddenUpperCase = (int)'E';

    @Override
    public void process(Reader in, Writer out) throws IOException {
        BufferedReader br = new BufferedReader(in);
        BufferedWriter bw = new BufferedWriter(out);
        int c = br.read();
        while (c != -1) {
            if(c != forbiddenLowerCase && c != forbiddenUpperCase) {
                bw.write(c);
            }

            c = br.read();
        }
        bw.flush();
    }
}
