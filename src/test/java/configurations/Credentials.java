package configurations;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:credentials.prorerties")
public interface Credentials extends org.aeonbits.owner.Config {

    @Key("login")
    String login();

    @Key("password")
    String password();
}
