package ch.heigvd.res.stpatrick;


/**
 * @author Olivier Liechti
 * @author Lucas Elisei (faku99)
 */
public class Application {

    IStreamDecoratorController decoratorController = new StreamDecoratorController();
    IStreamProcessorsFactory processorsFactory = new StreamProcessorsFactory();

    public IStreamProcessorsFactory getStreamProcessorsFactory() {
        return processorsFactory;
    }

    IStreamDecoratorController getStreamDecoratorController() {
        return decoratorController;
    }
}
