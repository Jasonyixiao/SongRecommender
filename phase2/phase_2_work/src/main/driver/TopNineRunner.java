//package driver;
//
//import commands.CommandFactory;
//import commands.ICommands;
//import controllers.*;
//import usecases.IGateWay;
//import usecases.NotificationCenter;
//import usecases.SongManager;
//import usecases.UserManager;
//
//import java.io.IOException;
//import java.util.Scanner;
///**
// * This is the Shell that prompts user for input
// */
//public class TopNineRunner {
//
//    public TopNineRunner(){
//
//    }
//
//    public void run() throws IOException {
//        //loadInitialSongs();
//        ShellState shellState = loadCurrentData();
//        Scanner input = new Scanner(System.in);
//        CommandFactory commandFactory = new CommandFactory();
//        while (shellState.getIsRunning()) {
//            // when the user is not logged in, the user only have choices 000(register), 001(login), 003(exit).
//            System.out.println("Enter your command, please refer to the README file for valid inputs.");
//            String userCommand = input.nextLine();
//            ICommands command = commandFactory.getCommand(userCommand);
//            if (command != null) {
//                String result = command.executeCommand(shellState);
//                System.out.println(result);
//            }
//        }
//    }
//
//    private ShellState loadCurrentData(){
//        IGateWay g = new GateWay();
//        NotificationCenter notificationCenter = new NotificationCenter(g);
//        UserManager userManager = new UserManager(g);
//        SongManager songManager = new SongManager(g);
//        userManager.read();
//        songManager.read();
//        notificationCenter.read();
//        SongController songController = new SongController(songManager);
//        UserController userController = new UserController(userManager);
//        LoginController loginController = new LoginController(userController);
//        NotificationController notificationController = new NotificationController(songController,notificationCenter);
//        return new ShellState(loginController, songController, notificationController);
//
//    }
//
//    //Ideally, this method will only get run once, this is just a "hard coded" method for adding the initial songs into
//    //the program.
//    private void loadInitialSongs() throws IOException {
//        GateWay g = new GateWay();
//        SongController songController = new SongController(new SongManager(g));
//        songController.addSong("As It Was",
//                "https://open.spotify.com/album/2pqdSWeJVsXAhHFuVLzuA8?highlight=spotify:track:4LRPiXqCikLlN15c3yImP7", "Harry Styles");
//        songController.addSong("Running Up That Hill", "https://open.spotify.com/track/29d0nY7TzCoi22XBqDQkiP?si=9b050067fe704e83",
//                "Kate Bush");
//        songController.addSong("Me Porto Bonito", "https://open.spotify.com/track/6Sq7ltF9Qa7SNFBsV5Cogx?si=8cbf4d2a2ad3411a", "Bad Bunny, Chencho Corleone");
//        songController.addSong("Glimpse of Us","https://open.spotify.com/track/6xGruZOHLs39ZbVccQTuPZ?si=6b529f649ac04806","Joji" );
//        songController.addSong("Efecto", "https://open.spotify.com/track/5Eax0qFko2dh7Rl2lYs3bx?si=cbd7e80be54f4cf1", "Bad Bunny");
//        songController.addSong("GIVENCHY", "https://open.spotify.com/track/2bbwjxA68m9PHZFWgF1fze?si=ab6bf33bfd224f9f", "Duki");
//        songController.addSong("Bad Habit", "https://open.spotify.com/track/4k6Uh1HXdhtusDW5y8Gbvy?si=af799da49fab456c","Steve Lacy");
//        songController.addSong("I Ain't Worried", "https://open.spotify.com/track/4h9wh7iOZ0GGn8QVp4RAOB?si=3c6cd25339b44b8e", "OneRepublic");
//        songController.addSong("First Class", "https://open.spotify.com/track/0wHFktze2PHC5jDt3B17DC?si=89f658394a5a463e", "Jack Harlow");
//        songController.addSong("Ghost", "https://open.spotify.com/track/6I3mqTwhRpn34SLVafSH7G?si=ff52889f0c3c46b1", "Justin Bieber");
//        songController.addSong("Shivers", "https://open.spotify.com/track/50nfwKoDiSYg8zOCREWAm5?si=3e4ace2ba4364c64", "Ed Sheeran");
//        songController.addSong("Woman", "https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19", "Doja Cat");
//        songController.addSong("Dandelions", "https://open.spotify.com/track/2eAvDnpXP5W0cVtiI0PUxV?si=c8d126f30476471b", "Ruth B.");
//        songController.saveSongData();
//    }
//
//
//}
