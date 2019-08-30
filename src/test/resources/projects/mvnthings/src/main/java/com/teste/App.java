package com.teste;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import org.crypthing.things.appservice.*;
import org.crypthing.things.config.ConfigException;
import org.crypthing.things.snmp.ProcessingEvent;
import org.crypthing.things.snmp.ProcessingEvent.ProcessingEventType;

/**
 * Hello world sample!
 *
 */
public class App extends Sandbox
{
    private static Logger log = Logger.getLogger(App.class.getName());


    @Override
    public void startup(Properties props) throws ConfigException {
        /* Inicialização da thread. Recebe as propriedades específicas do projeto */
        fire(new ProcessingEvent(ProcessingEventType.info, "Thread started."));
        log.info(props.getProperty("hello"));
    }

    @Override
    protected  boolean execute() throws IOException, SQLException
    {
        while(isRunning() && hasWork())
        {
            try {
                doSomething();
                success();
            } catch (Exception e) {
                failure();
            }
        }
        quant_work = 10;
        return true;
    } 

    private void doSomething() throws Exception {
        log.fine("Hello World!");
    }

    long quant_work = 10;
    private boolean hasWork()
    {
        /* TODO:Criar uma condição. */
        return quant_work-->0;
    }
    
}