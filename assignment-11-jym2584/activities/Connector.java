package activities;

import java.io.*;
import java.net.*;
import java.util.*;

public class Connector {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("swen-123.rit.edu", 33075);
        sock.close();
    }
}
