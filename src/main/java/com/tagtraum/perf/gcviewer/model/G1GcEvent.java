package com.tagtraum.perf.gcviewer.model;

/**
 * G1GcEvent may contain lots of detail information which provide information about the
 * different steps of the garbage collection. It is not just information about different
 * generations as with e.g. CMS collector.
 * 
 * @author <a href="mailto:jwu@gmx.ch">Joerg Wuethrich</a>
 * <p>created on: 26.10.2011</p>
 */
public class G1GcEvent extends GCEvent {
    private GCEvent lastYoung;

    public GCEvent getLastYoung() {
        return lastYoung;
    }
    
    public void setLastYoung(GCEvent lastYoung) {
        this.lastYoung = lastYoung;
    }

    @Override
    public String getTypeAsString() {
        return getExtendedType().getName();
    }

    @Override
    public void toStringBuffer(StringBuffer sb) {
        super.toStringBuffer(sb);
    }

    @Override
    public boolean isG1Event() {
        return true;
    }


}
