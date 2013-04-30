package com.wave.openid.springsample;

import org.springframework.dao.DataAccessException;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Runtime exception which is thrown during dao level error
 */
public class CoreDaoException extends DataAccessException
{

    private Throwable cause;

    public CoreDaoException(String msg) {
        super(msg);
    }

    public CoreDaoException(String msg, Throwable cause) {
        super(msg);
        this.cause = cause;
    }

    public Throwable getCause() {
        return cause;
    }

    public void printStackTrace() {
        super.printStackTrace();
        if (cause != null) {
            cause.printStackTrace();
        }
    }

    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        if (cause != null) {
            s.println("Caused by:");
            cause.printStackTrace(s);
        }
    }

    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
        if (cause != null) {
            s.println("Caused by:");
            cause.printStackTrace(s);
        }
    }

    public String getMessage() {
        if (cause == null) {
            return super.getMessage();
        } else {
            return super.getMessage() + " (see below for lower-level details)";
        }
    }


}
