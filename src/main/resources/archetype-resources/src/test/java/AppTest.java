package $package;

/**
 * Hello world!
 *
 */
public class AppTest extends org.crypthing.things.appservice.Sandbox
{

    @Override
    protected  boolean execute() throws IOException, SQLException
    {
        System.out.println( "Hello World!" );
        sucess();
        return true;
    }    
}