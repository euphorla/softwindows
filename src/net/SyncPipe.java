package net;

import java.io.InputStream;
import java.io.OutputStream;

public class SyncPipe implements Runnable {
    private final OutputStream ostrm;
    private final InputStream istrm;

    public SyncPipe(InputStream istrm, OutputStream ostrm) {
        this.ostrm = ostrm;
        this.istrm = istrm;
    }

    public void run() {
        try {
            final byte[] buffer = new byte[1024];
            for (int length = 0; (length = istrm.read(buffer)) != -1; ) {
                ostrm.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





