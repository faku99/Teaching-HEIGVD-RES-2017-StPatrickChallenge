package ch.heigvd.res.stpatrick;

/**
 * This class is responsible for providing different types of Stream Processors.
 *
 * @author Olivier Liechti
 */
public class StreamProcessorsFactory implements IStreamProcessorsFactory {

    @Override
    public IStreamProcessor getProcessor() {
        return new BasicStreamProcessor();
    }

    @Override
    public IStreamProcessor getProcessor(String processorName) throws UnknownNameException {
        switch (processorName) {
            case "basic":
                return new BasicStreamProcessor();

            case "e-remover":
                return new ERemoverStreamProcessor();

            default:
                throw new UnknownNameException("The factory does not know any processor called " + processorName);
        }
    }

}
