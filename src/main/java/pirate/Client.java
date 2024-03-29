package pirate;


import java.io.*;
import java.net.Socket;
import java.io.BufferedReader;

public class Client {
    private Socket socket;
    private ObjectInputStream dIn;
    private ObjectOutputStream dOut;
    private BufferedReader reader;
    private Player player;

    public static void main(String[] args) {
        Client client = new Client(3111);
        System.out.println("Client main");
        client.start();
    }
    public Client(int portId) {
        try {
            socket = new Socket("localhost", portId);
            dOut =  new ObjectOutputStream(socket.getOutputStream());
            // server input
            dIn = new ObjectInputStream(socket.getInputStream());
            // read from user input
            reader = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Client Constructor");
        } catch (IOException ex) {
            System.out.println(ex);
            System.out.println("Client failed to open");
        }
    }
    public void start(){
        try{
            System.out.println("Client start");
            boolean initializePlayer = false;
            String input = "qsx cxc";
            while(true){
                if(!initializePlayer){
                    player = (Player) dIn.readObject();
                    System.out.println("Welcome Player "+player.getId());
                    initializePlayer = true;
                }else{
                    input = (String)dIn.readObject();
                }

                String res;
                if(input!=null && input.equals("true")){
                    System.out.println("PLayer 1 please start the game (Enter s): ");
                    res = reader.readLine();
                    while(res == null || !res.equals("s")){
                        System.out.println("PLayer 1 please start the game (Enter s): ");
                        res = reader.readLine();
                    }
                    dOut.writeObject(res);
                    dOut.flush();
//                    System.out.println("CHECK true");
                    break;
                }else if(input.equals("false")){
                    System.out.println("wait for player 1 to start the game");
//                    System.out.println("CHECK false");
                    break;
                }
            }

            while(true){
                String s="";
                if(!s.equals("END"))System.out.println("waiting to start your turn");
                  s = (String) dIn.readObject();
//                System.out.println("received");
//                System.out.println(s);
                if(s.equals("turn")){
                    System.out.println("before turn starts");
                    player.play((String)dIn.readObject());
                    System.out.println("after turn ends");
                    System.out.println("You obtained "+player.getInfo()[0] + " scores in this turn");
                    System.out.println("Now wait for other players");
                    dOut.writeObject(player.getInfo());
                    dOut.flush();
                    player.reset();
                }else if(s.equals("END")){
//                    System.out.println(s);
                    break;
                }else{
                    System.out.println(s);
                }
            }
        }catch(IOException exp){
            System.err.println("IOE exp found");
            exp.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("class not found");
        }
    }
}
