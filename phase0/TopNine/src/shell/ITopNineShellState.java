package shell;


import controllers.ILoginController;
import controllers.IUserController;

public interface ITopNineShellState {

    IUserController getUserController();
    ILoginController getLoginController();

    boolean isRunning();
}
