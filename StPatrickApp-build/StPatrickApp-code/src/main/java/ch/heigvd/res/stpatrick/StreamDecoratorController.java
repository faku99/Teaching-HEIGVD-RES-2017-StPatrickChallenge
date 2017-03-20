package ch.heigvd.res.stpatrick;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Lucas Elisei (faku99)
 */
public class StreamDecoratorController implements IStreamDecoratorController {

    @Override
    public Reader decorateReader(Reader inputReader) {
        return new Reader(inputReader) {

            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                int c = inputReader.read(cbuf, off, len);

                // Si le caractère lu est différent de A et a, alors on le lit,
                // sinon, on passe au suivant.
                if(c != (int)'a' && c != (int)'A') {
                    return c;
                }
                else {
                    return inputReader.read(cbuf, off + 1, len);
                }

            }

            @Override
            public void close() throws IOException {
                inputReader.close();
            }

        };
    }

    @Override
    public Writer decorateWriter(Writer outputWriter) {
        return new Writer(outputWriter) {

            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {
                for(int i = off; i < len; ++i) {
                    if(cbuf[i] != 'a' && cbuf[i] != 'A') {
                        outputWriter.write(cbuf[i]);
                    }
                }
            }

            @Override
            public void flush() throws IOException {
                outputWriter.flush();
            }

            @Override
            public void close() throws IOException {
                outputWriter.close();
            }
        };
    }
}
