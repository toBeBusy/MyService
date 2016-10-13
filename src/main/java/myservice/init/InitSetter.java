package myservice.init;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myservice.Util.XmlUtil;
import myservice.entity.ActionEntity;

public class InitSetter {
	
	private Map<String, Map<String, ActionEntity>> instanceMap 
			= new HashMap<String, Map<String, ActionEntity>>();
	
	/**
	 * @return the instanceMap
	 */
	public Map<String, Map<String, ActionEntity>> getInstanceMap() {
		return instanceMap;
	}

	/**
	 * @param instanceMap the instanceMap to set
	 */
	public void setInstanceMap(Map<String, Map<String, ActionEntity>> instanceMap) {
		this.instanceMap = instanceMap;
	}

	public void initInstance(){
		XmlUtil xmlUtil = new XmlUtil();
		File file = new File("src/webapp");
		File[] files = file.listFiles();
		
		for (File f : files) {
			String path = f.getAbsolutePath() + "\\TestAction.xml";
			instanceMap.put(f.getName(), xmlUtil.loadXml(path));
		}
	}
	
	
	
	public static void main(String[] args) {
		InitSetter initSetter = new InitSetter();
		initSetter.initInstance();
		Map<String, Map<String, ActionEntity>> map = initSetter.getInstanceMap();
		Map<String, ActionEntity> miaoshaMap = map.get("miaosha");
		ActionEntity entity = miaoshaMap.get("test");
		//
		try {
			Class.forName(entity.getClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
