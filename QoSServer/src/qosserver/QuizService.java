package qosserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class QuizService extends Thread {

    File file;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    StringBuffer sb = new StringBuffer();
    public QuizService(Socket socket, File file, int quizNumber) {
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            dos.writeUTF("Successful.");
            
            ArrayList<String> answers = new ArrayList<>();

            Charset charset = Charset.forName("US-ASCII");
            Path path = file.toPath();
            try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    dos.writeUTF("Question");
                    dos.writeUTF(line);
                    String answer = dis.readUTF();
                    answers.add(answer);
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
            dos.writeUTF("TheEnd");
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                String encryptSalt = request + String.valueOf(quizNumber);
                md.update(encryptSalt.getBytes());
                byte byteData[] = md.digest();
                for (int i = 0; i < byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
            }
            PrintWriter writer = new PrintWriter("Answers-" + request + "-" + sb + ".txt", "UTF-8");
            String str = "";
            for(int i=0;i<answers.size();i++){
                str += "" + i + "  " + answers.get(i) + "\r\n";
            }
            writer.write(str);
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(QuizService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
