package responds;

import control.ClientHandler;
import org.json.JSONObject;
import services.Ability;
import services.UserAccount;
import services.UserServer;

public class AddAbilityForMember extends RespondHandler{
    /**
     * constructor.
     * @param json receives a Jsonobject
     * @param client receives a clientHandler object
     */
    public AddAbilityForMember(JSONObject json, ClientHandler client) {
        super(json, client);
    }

    /**
     * receiving member name, ability and server name from Json Object,
     * adding ability for the specified member.
     */
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
