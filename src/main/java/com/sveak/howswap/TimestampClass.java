package com.sveak.howswap;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public final class TimestampClass {

    private Class classForCompile;
    private Date timestamp;
    private Collection<String> dependencies = new HashSet<String>();
    private Collection<String> dependent = new HashSet<String>();

    public TimestampClass(final Class classForCompile, final Date timestamp) {
        this.classForCompile = classForCompile;
        this.timestamp = timestamp;
    }

    public Class getClassForCompile() {
        return classForCompile;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<String> getDependent() {
        return dependent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final TimestampClass that = (TimestampClass) o;

        if (classForCompile != null ? !classForCompile.equals(that.classForCompile) : that.classForCompile != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classForCompile != null ? classForCompile.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
