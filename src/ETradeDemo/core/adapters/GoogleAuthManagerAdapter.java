package ETradeDemo.core.adapters;

import ETradeDemo.core.abstracts.GoogleAuthService;
import ETradeDemo.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements GoogleAuthService {

    @Override
    public void send(String gmail, String message) {
        GoogleAuthManager googleAuthManager = new GoogleAuthManager();
        googleAuthManager.send(gmail, message);
    }
}
