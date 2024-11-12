package edu.example.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimplyUnixPathTest {
    String path;
    SimplyUnixPath simplyUnixPath;
    @Before
    public void setup(){
        path = "/usr/local/bin";
        simplyUnixPath = new SimplyUnixPath();
    }

    @Test
    public void simplifyPathTest() {
        simplyUnixPath.simplifyPath(path);
    }
}