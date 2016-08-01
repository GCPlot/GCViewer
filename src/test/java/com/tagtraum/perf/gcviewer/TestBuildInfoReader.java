package com.tagtraum.perf.gcviewer;

import com.tagtraum.perf.gcviewer.util.BuildInfoReader;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Tests the class {@link BuildInfoReader} - makes sure that the properties from the file
 * can be read. 
 *
 * @author <a href="mailto:gcviewer@gmx.ch">Joerg Wuethrich</a>
 * <p>created on: 05.12.2012</p>
 */
public class TestBuildInfoReader {

    @Test
    public void readVersion() {
        String version = BuildInfoReader.getVersion();
        assertThat("version", version, notNullValue());
        assertThat("must not be empty", version, not(isEmptyOrNullString()));
    }

    @Test
    public void readBuildDate() {
        String buildDate = BuildInfoReader.getBuildDate();
        assertThat("buildDate", buildDate, notNullValue());
        assertThat("must not be empty", buildDate, not(isEmptyOrNullString()));
    }
}
