import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TpDoorFiler {
	PropertiesFile file;
	
	public void createFiles(){
		new File("plugins/config/TpDoor").mkdirs();
		file = new PropertiesFile("plugins/config/TpDoor/tpdoor.txt");
	}
	
	public void saveTpDoor(ArrayList<String> arrayList, ArrayList<String> arrayList2, Location location){
		file = new PropertiesFile("plugins/config/TpDoor/tpdoor.txt");
		String groups = "";
		
		for (String group : arrayList2){
			if (groups.equals("")){
				groups = group;
			}else{
				groups = groups+","+group;
			}
		}
		
		String to = location.x+","+location.y+","+location.z+","+location.rotX+","+location.rotY+","+location.getWorld().getName()+","+location.dimension;
		for (String loc : arrayList){
		file.setString(loc, to+":"+groups);
		}
	}
	
	public void deleteTpDoor(ArrayList<String> arrayList){
		file = new PropertiesFile("plugins/config/TpDoor/tpdoor.txt");
		for (String location : arrayList){
		if (file.containsKey(location)){
			file.removeKey(location);
		}
		}
	}
	
	public boolean isTpDoor(String location){
		file = new PropertiesFile("plugins/config/TpDoor/tpdoor.txt");
		if (file.containsKey(location)){
			return true;
		}
		return false;
	}
	
	public boolean mayPlayerAcess(String location, String group){
		file = new PropertiesFile("plugins/config/TpDoor/tpdoor.txt");
		if (file.containsKey(location)){
			if (file.getString(location).contains(":")){
			List<String> groups = Arrays.asList(file.getString(location).split(":")[1].split(","));
			if (!groups.isEmpty()){
				if (groups.contains(group)){
					return false;
					}
				}
			}
		}
		return true;
	}
	
	public String getLocation(String location){
		file = new PropertiesFile("plugins/config/TpDoor/tpdoor.txt");
		if (file.containsKey(location)){
			return file.getProperty(location);
		}
		return null;
	}
	
}
