package $package;
import org.crypthing.things.appservice.*;

/**
 * Hello world!
 *
 */
public class App extends Sandbox
{

    @Override
    protected  boolean execute() throws IOException, SQLException
    {
        while(isRunning() && hasWork())
        {
            try {
                doSomething();
                sucess();
            } catch (Exception e) {
                failure();
            }
        }
        quant_work = 10;
        return true;
    } 

    private void doSomething() throws Exception {
        System.out.println( "Hello World!" );
    }

    long quant_work = 10
    private boolean hasWork()
    {
        /** TODO:Criar uma condição pela qual ainda tem trabalho. */
        return quant_work-->0;
    }
    
}