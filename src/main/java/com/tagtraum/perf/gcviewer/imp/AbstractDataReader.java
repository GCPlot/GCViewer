package com.tagtraum.perf.gcviewer.imp;

import com.tagtraum.perf.gcviewer.model.GCModel;
import com.tagtraum.perf.gcviewer.model.GCResource;

import java.io.*;

/**
 * Baseclass for every {@link DataReader} implementation.
 *
 * @author <a href="mailto:gcviewer@gmx.ch">Joerg Wuethrich</a>
 * <p>created on: 11.01.2014</p>
 *
 */
public abstract class AbstractDataReader implements DataReader {

    /** the resource being read */
    protected GCResource gcResource;
    /** the reader accessing the log file */
    protected LineNumberReader in;

    protected AbstractDataReader(GCResource gcResource, InputStream in) throws UnsupportedEncodingException {
        super();

        this.in = new LineNumberReader(new InputStreamReader(in, "ASCII"), 64 * 1024);
        this.gcResource = gcResource;
    }

    /**
     * Returns a logger instance that logs in the context of the current GCResource being loaded.
     * This logger should always be used, because otherwise the "Logger" tab won't show any
     * log entries written during loading process.
     *
     * @return thread specific logger
     */
    protected org.slf4j.Logger getLogger() {
        return gcResource.getLogger();
    }

    @Override
    public abstract GCModel read() throws IOException;

    /**
     * Returns <code>true</code> as long as read was not cancelled.
     * @return <code>true</code> as long as read was not cancelled
     */
    protected boolean shouldContinue() {
        getLogger().debug("{} read cancelled", gcResource.getResourceName());
        return !gcResource.isReadCancelled();
    }
}
