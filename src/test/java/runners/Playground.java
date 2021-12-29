package runners;

import org.junit.Test;
import utilities.ServerManager;

public class Playground {
    @Test
    public void run() {
        ServerManager serverManager = new ServerManager();
        serverManager.startAppiumServer();
        serverManager.stopAppiumServer();
    }
}
