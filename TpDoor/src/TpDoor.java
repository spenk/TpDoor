import java.util.HashMap;
import java.util.logging.Logger;

public class TpDoor extends Plugin
{
  Logger log = Logger.getLogger("Minecraft");
  public static String name = "TpDoor";
  public static String version = "1.4";
  public static String author = "Billyoyo & Spenk";
  public TpDoorListener listener = new TpDoorListener();
  public HashMap<Location,Location> locations;

  public void disable(){
	  this.log.info(name + " version " + version +" By "+author+" is Disabled.");
  }

  public void enable() {
	  this.log.info(name + " version " + version +" By "+author+" is Enabled.");
  }

  public void initialize() {
    this.log = Logger.getLogger("Minecraft");
    this.log.info(name + " version " + version +" By "+author+" is initialized.");
    etc.getLoader().addListener(PluginLoader.Hook.COMMAND, this.listener, this, PluginListener.Priority.MEDIUM);
    etc.getLoader().addListener(PluginLoader.Hook.BLOCK_PLACE, this.listener, this, PluginListener.Priority.MEDIUM);
    etc.getLoader().addListener(PluginLoader.Hook.PLAYER_MOVE, this.listener, this, PluginListener.Priority.MEDIUM);
    new TpDoorFiler().createFiles();
  }
}