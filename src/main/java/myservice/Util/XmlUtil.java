package myservice.Util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import myservice.entity.ActionEntity;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {

	@SuppressWarnings("unchecked")
	public Map<String ,ActionEntity> loadXml(String path) {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(new File(
					"src/main/java/myservice/Util/TestAction.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement().element("actions");
		Iterator<Element> it = root.elementIterator("action");
		Map<String ,ActionEntity> entityMap = new HashMap<String ,ActionEntity>();
		while (it.hasNext()) {
			Element action = it.next();
			ActionEntity actionEntity = new ActionEntity();
			actionEntity.setId(action.attributeValue("id"));
			actionEntity.setClassName(action.attributeValue("class"));
			actionEntity.setMethod(action.attributeValue("method"));
			entityMap.put(actionEntity.getId(), actionEntity);
		}
		return entityMap;
	}

	public static void main(String[] args) {
		XmlUtil util = new XmlUtil();
		util.loadXml("");
	}

}
