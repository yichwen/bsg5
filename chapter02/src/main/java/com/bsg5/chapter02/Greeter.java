package com.bsg5.chapter02;

import java.io.PrintStream;

public interface Greeter {
    void setPrintStream(PrintStream printStream);
    void greet();
}
