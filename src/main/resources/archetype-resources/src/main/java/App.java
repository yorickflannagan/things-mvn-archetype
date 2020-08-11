package $package;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import org.crypthing.things.appservice.*;
import org.crypthing.things.config.ConfigException;
import org.crypthing.things.snmp.LifecycleEvent;
import org.crypthing.things.snmp.LifecycleEvent.LifecycleEventType;
import org.crypthing.things.snmp.ProcessingEvent;
import org.crypthing.things.snmp.ProcessingEvent.ProcessingEventType;
import org.crypthing.things.snmp.SignalBean;


/**
 * Hello world sample!
 *
 */
public class App extends Sandbox
{
	private static Logger log = Logger.getLogger(App.class.getName());

	@Override
	public void startup(Properties props) throws ConfigException
	{
		// This method is called when application starts
		// The argument receives configured parameters (see section sandbox)
		// TODO: overrides only if required 
		fire(new LifecycleEvent(LifecycleEventType.start, (new SignalBean(App.class.getName(), "Application thread started")).encode()));
	}
	@Override
	public void release()
	{
		// This method is called when the application finalizes
		// TODO: overrides only if required
		fire(new LifecycleEvent(LifecycleEventType.stop, (new SignalBean(App.class.getName(), "Application thread ended")).encode()));
	}

	@Override
	protected  boolean execute() throws IOException, SQLException
	{
		while(isRunning() && hasWork())
		{
			if (doYourJob()) success();
			else failure();
		}
		return true;
	} 
	private boolean doYourJob()
	{
		// TODO: Your unit of work must be implemented here
		// Return true if it succeeds; otherwise, false. False does not stops working, only signals a failure.
		// If you want to stop execution, you must throw an exception.
		// Throw IOException or SQLException only for transient errors. So, the thread will only sleep.
		// If any other kind of exception is thrown, the thread will die and application stops.
		fire(new ProcessingEvent(ProcessingEventType.info, (new SignalBean(App.class.getName(), "Hello, World!")).encode()));
		log.fine("Hello World!");
		return true;
	}
	private boolean hasWork()
	{
		// TODO: Check if there are more units of work to be done.
		// If you return false, the thread will sleep a little
		return true;
	}
}