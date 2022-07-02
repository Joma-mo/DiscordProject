package responds;

import control.ClientHandler;
import org.json.JSONObject;
import services.Ability;
import services.UserAccount;
import services.UserServer;

public class AddAbilityForMember extends RespondHandler{
    public AddAbilityForMember(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    @Override
    public void Handle() {
        String memberName = json.getString("memberName");
        UserAccount user = data.findUser(memberName);
        String ability = json.getString("ability");
        String serverName = json.getString("serverName");
        UserServer server = data.findServer(serverName);
        server.addAbilityForAdmin(user, Ability.valueOf(ability));

    }
}
