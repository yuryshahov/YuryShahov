package by.epam.model.loading;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XmlSaver {
	
	//метод возвращает геттеры объекта
	private ArrayList<String> getGetters(Object obj) {
		ArrayList<String> getters = new ArrayList<String>();
		Class<? extends Object> c = obj.getClass();
		Method[] mds = c.getMethods();
		for (Method m : mds) {
			String mName = m.getName();
			if ((mName.startsWith("get")) && (!mName.equals("getClass"))&& (!mName.equals("get"))) {
				getters.add(mName);
			}
		}
		return getters;
	}
	
	//метод убирает слово get из геттера
	private String getNameFromGetter(String getter) {
		return getter.substring(3, getter.length());
	}
	
	//универсальный рекурсивный метод для построения документа из объекта
	private void createDocumentModel(Object obj, Element element) throws NoSuchMethodException, 
																		 SecurityException, 
																		 IllegalAccessException, 
																		 IllegalArgumentException, 
																		 InvocationTargetException {
		Class<? extends Object>[] types = null;
		Object[] arguments = new Object[]{};
		Class<? extends Object> c = obj.getClass();
		
		//получаем все геттеры объекта кроме getClass
		ArrayList<String> getters = getGetters(obj);
		for (String g : getters) {
			
			//полуаем геттер и значение из него
			Method m = c.getMethod(g, types);
			Object val = m.invoke(obj, arguments);
			if (val != null) {
				if (val instanceof Iterable) {
					
					//создаем елемент для массива
					Element arrayChild = new Element(getNameFromGetter(g));
					
					//если это коллекция вызываем рекурсию для каждого ее элемента
					Iterable<? extends Object> array = (Iterable<?>) val;
					for (Object o : array) {
						Element child = new Element(o.getClass().getSimpleName());
						arrayChild.addContent(child);
						createDocumentModel(o, child);
					}
					element.addContent(arrayChild);
				} else if (val instanceof Comparable) {
					Element child = new Element(getNameFromGetter(g));
					
					//если это объект реализует Comparable, записываем его значение
					child.setText(val.toString());
					element.addContent(child);
				} else {
					
					Element child = new Element(val.getClass().getSimpleName());
					element.addContent(child);
					createDocumentModel(val, child);
				}
			}
		}
	}
	
	//универсальный метод для постройки документа из объекта
	private Document createDocumentModel(Object obj) throws NoSuchMethodException, 
															SecurityException, 
															IllegalAccessException, 
															IllegalArgumentException, 
															InvocationTargetException {
		
		//создаем корневой елемент
		Element rootElement = new Element(obj.getClass().getSimpleName());
		Document doc = new Document(rootElement);
		
		//заполняем корневой елемент
		createDocumentModel(obj, rootElement);
		return doc;
	}
	
	//сохранение объекта в формате xml
	public void saveObjectToXml(String xmlPath, Object obj) throws FileNotFoundException, 
																   IOException, 
																   NoSuchMethodException, 
																   SecurityException, 
																   IllegalAccessException, 
																   IllegalArgumentException, 
																   InvocationTargetException {
		
		//создаем документ для модели
		Document doc = createDocumentModel(obj);
		
		//сохраняем Document в xml файле
		Format format = Format.getPrettyFormat();
		format.setEncoding("UTF-8");
		XMLOutputter outputter = new XMLOutputter(format);
		outputter.output(doc, new FileOutputStream(xmlPath));
	}
}
