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
	
	//����� ���������� ������� �������
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
	
	//����� ������� ����� get �� �������
	private String getNameFromGetter(String getter) {
		return getter.substring(3, getter.length());
	}
	
	//������������� ����������� ����� ��� ���������� ��������� �� �������
	private void createDocumentModel(Object obj, Element element) throws NoSuchMethodException, 
																		 SecurityException, 
																		 IllegalAccessException, 
																		 IllegalArgumentException, 
																		 InvocationTargetException {
		Class<? extends Object>[] types = null;
		Object[] arguments = new Object[]{};
		Class<? extends Object> c = obj.getClass();
		
		//�������� ��� ������� ������� ����� getClass
		ArrayList<String> getters = getGetters(obj);
		for (String g : getters) {
			
			//������� ������ � �������� �� ����
			Method m = c.getMethod(g, types);
			Object val = m.invoke(obj, arguments);
			if (val != null) {
				if (val instanceof Iterable) {
					
					//������� ������� ��� �������
					Element arrayChild = new Element(getNameFromGetter(g));
					
					//���� ��� ��������� �������� �������� ��� ������� �� ��������
					Iterable<? extends Object> array = (Iterable<?>) val;
					for (Object o : array) {
						Element child = new Element(o.getClass().getSimpleName());
						arrayChild.addContent(child);
						createDocumentModel(o, child);
					}
					element.addContent(arrayChild);
				} else if (val instanceof Comparable) {
					Element child = new Element(getNameFromGetter(g));
					
					//���� ��� ������ ��������� Comparable, ���������� ��� ��������
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
	
	//������������� ����� ��� ��������� ��������� �� �������
	private Document createDocumentModel(Object obj) throws NoSuchMethodException, 
															SecurityException, 
															IllegalAccessException, 
															IllegalArgumentException, 
															InvocationTargetException {
		
		//������� �������� �������
		Element rootElement = new Element(obj.getClass().getSimpleName());
		Document doc = new Document(rootElement);
		
		//��������� �������� �������
		createDocumentModel(obj, rootElement);
		return doc;
	}
	
	//���������� ������� � ������� xml
	public void saveObjectToXml(String xmlPath, Object obj) throws FileNotFoundException, 
																   IOException, 
																   NoSuchMethodException, 
																   SecurityException, 
																   IllegalAccessException, 
																   IllegalArgumentException, 
																   InvocationTargetException {
		
		//������� �������� ��� ������
		Document doc = createDocumentModel(obj);
		
		//��������� Document � xml �����
		Format format = Format.getPrettyFormat();
		format.setEncoding("UTF-8");
		XMLOutputter outputter = new XMLOutputter(format);
		outputter.output(doc, new FileOutputStream(xmlPath));
	}
}
