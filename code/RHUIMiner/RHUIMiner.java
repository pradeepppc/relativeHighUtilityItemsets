import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class RHUIMiner {

  public static int countLinesOld(String filename) throws IOException {
    InputStream is = new BufferedInputStream(new FileInputStream(filename));
    try {
        byte[] c = new byte[1024];
        int count = 0;
        int readChars = 0;
        boolean empty = true;
        while ((readChars = is.read(c)) != -1) {
            empty = false;
            for (int i = 0; i < readChars; ++i) {
                if (c[i] == '\n') {
                    ++count;
                }
            }
        }
        return (count == 0 && !empty) ? 1 : count;
    } finally {
        is.close();
    }
}

public static void main(String[] args) throws IOException {
    String inputfile = args[0];
    String outputfile = args[1];
    float minutility_ratio;
    int minutility;
    minutility = Integer.parseInt(args[2]);
    minutility_ratio = Float.parseFloat(args[3]);
    int number_of_lines = countLinesOld(inputfile);
    AlgoEFIMRation p = new AlgoEFIMRation();
    p.runAlgorithm(minutility, minutility_ratio, inputfile, outputfile, true, number_of_lines, true);
    p.printStats();
  }
}
