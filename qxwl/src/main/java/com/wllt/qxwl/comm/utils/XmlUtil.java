package com.wllt.qxwl.comm.utils;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

/**
   @auth zhaokaikai
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Slf4j
public class XmlUtil {

    public static Map<String,Object> map;
    /**
     * xml转map 不带属性
     *
     * @param xmlStr
     * @param needRootKey 是否需要在返回的map里加根节点键
     * @return
     * @throws DocumentException
     */
    public static Map xml2map(String xmlStr, boolean needRootKey) throws DocumentException {

        if(null == xmlStr || "".equals(xmlStr)) {
            return null;
        }

        Document doc = DocumentHelper.parseText(xmlStr);
        Element root = doc.getRootElement();
        Map<String, Object> map = (Map<String, Object>) xml2map(root);
        if (root.elements().size() == 0 && root.attributes().size() == 0) {
            return map;
        }
        if (needRootKey) {
            //在返回的map里加根节点键（如果需要）
            Map<String, Object> rootMap = new HashMap<String, Object>();
            rootMap.put(root.getName(), map);
            return rootMap;
        }
        return map;
    }

    /**
     * xml转map 带属性
     *
     * @param xmlStr
     * @param needRootKey 是否需要在返回的map里加根节点键
     * @return
     * @throws DocumentException
     */
    public static Map xml2mapWithAttr(String xmlStr, boolean needRootKey) throws DocumentException {

        if(null == xmlStr || "".equals(xmlStr)) {
            return null;
        }

        Document doc = DocumentHelper.parseText(xmlStr);
        Element root = doc.getRootElement();
        Map<String, Object> map = (Map<String, Object>) xml2mapWithAttr(root);
        if (root.elements().size() == 0 && root.attributes().size() == 0) {
            return map; //根节点只有一个文本内容
        }
        if (needRootKey) {
            //在返回的map里加根节点键（如果需要）
            Map<String, Object> rootMap = new HashMap<String, Object>();
            rootMap.put(root.getName(), map);
            return rootMap;
        }
        return map;
    }

    /**
     * xml转map 不带属性
     *
     * @param e
     * @return
     */
    private static Map xml2map(Element e) {
        Map map = new LinkedHashMap();
        List list = e.elements();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if (iter.elements().size() > 0) {
                    Map m = xml2map(iter);
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!(obj instanceof List)) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if (obj instanceof List) {
                            mapList = (List) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        map.put(iter.getName(), m);
                    }
                } else {
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!(obj instanceof List)) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(iter.getText());
                        }
                        if (obj instanceof List) {
                            mapList = (List) obj;
                            mapList.add(iter.getText());
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        map.put(iter.getName(), iter.getText());
                    }
                }
            }
        } else {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    /**
     * xml转map 带属性
     *
     * @param
     * @return
     */
    private static Map xml2mapWithAttr(Element element) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        List<Element> list = element.elements();
        List<Attribute> listAttr0 = element.attributes(); // 当前节点的所有属性的list
        for (Attribute attr : listAttr0) {
            map.put("@" + attr.getName(), attr.getValue());
        }
        if (list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {
                Element iter = list.get(i);
                List mapList = new ArrayList();

                if (iter.elements().size() > 0) {
                    Map m = xml2mapWithAttr(iter);
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!(obj instanceof List)) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if (obj instanceof List) {
                            mapList = (List) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        map.put(iter.getName(), m);
                    }
                } else {

                    List<Attribute> listAttr = iter.attributes(); // 当前节点的所有属性的list
                    Map<String, Object> attrMap = null;
                    boolean hasAttributes = false;
                    if (listAttr.size() > 0) {
                        hasAttributes = true;
                        attrMap = new LinkedHashMap<String, Object>();
                        for (Attribute attr : listAttr) {
                            attrMap.put("@" + attr.getName(), attr.getValue());
                        }
                    }

                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!(obj instanceof List)) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            // mapList.add(iter.getText());
                            if (hasAttributes) {
                                attrMap.put("#text", iter.getText());
                                mapList.add(attrMap);
                            } else {
                                mapList.add(iter.getText());
                            }
                        }
                        if (obj instanceof List) {
                            mapList = (List) obj;
                            // mapList.add(iter.getText());
                            if (hasAttributes) {
                                attrMap.put("#text", iter.getText());
                                mapList.add(attrMap);
                            } else {
                                mapList.add(iter.getText());
                            }
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        // map.put(iter.getName(), iter.getText());
                        if (hasAttributes) {
                            attrMap.put("#text", iter.getText());
                            map.put(iter.getName(), attrMap);
                        } else {
                            map.put(iter.getName(), iter.getText());
                        }
                    }
                }
            }
        } else {
            // 根节点的
            if (listAttr0.size() > 0) {
                map.put("#text", element.getText());
            } else {
                map.put(element.getName(), element.getText());
            }
        }
        return map;
    }

    /**
     * map转xml map中没有根节点的键
     *
     * @param map
     * @param rootName
     * @throws DocumentException
     * @throws IOException
     */
    public static Document map2xml(Map<String, Object> map, String rootName) throws DocumentException, IOException {
        Document doc = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement(rootName);
        doc.add(root);
        map2xml(map, root);
        //System.out.println(doc.asXML());
        //System.out.println(formatXml(doc));
        return doc;
    }

    /**
     * map转xml map中含有根节点的键
     *
     * @param map
     * @throws DocumentException
     * @throws IOException
     */
    public static Document map2xml(Map<String, Object> map) throws DocumentException, IOException {
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        if (entries.hasNext()) { //获取第一个键创建根节点
            Map.Entry<String, Object> entry = entries.next();
            Document doc = DocumentHelper.createDocument();
            Element root = DocumentHelper.createElement(entry.getKey());
            doc.add(root);
            map2xml((Map) entry.getValue(), root);
            //System.out.println(doc.asXML());
            //System.out.println(formatXml(doc));
            return doc;
        }
        return null;
    }

    /**
     * map转xml
     *
     * @param map
     * @param body xml元素
     * @return
     */
    private static Element map2xml(Map<String, Object> map, Element body) {
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = entries.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.startsWith("@")) {    //属性
                body.addAttribute(key.substring(1, key.length()), value.toString());
            } else if (key.equals("#text")) { //有属性时的文本
                body.setText(value.toString());
            } else {
                if (value instanceof List) {
                    List list = (List) value;
                    Object obj;
                    for (int i = 0; i < list.size(); i++) {
                        obj = list.get(i);
                        //list里是map或String，不会存在list里直接是list的，
                        if (obj instanceof Map) {
                            Element subElement = body.addElement(key);
                            map2xml((Map) list.get(i), subElement);
                        } else {
                            body.addElement(key).setText((String) list.get(i));
                        }
                    }
                } else if (value instanceof Map) {
                    Element subElement = body.addElement(key);
                    map2xml((Map) value, subElement);
                } else {
                    body.addElement(key).setText(value.toString());
                }
            }
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return body;
    }

    /**
     * 格式化输出xml
     *
     * @param xmlStr
     * @return
     * @throws DocumentException
     * @throws IOException
     */
    public static String formatXml(String xmlStr) throws DocumentException, IOException {
        Document document = DocumentHelper.parseText(xmlStr);
        return formatXml(document);
    }

    /**
     * 格式化输出xml
     *
     * @param document
     * @return
     * @throws DocumentException
     * @throws IOException
     */
    public static String formatXml(Document document) throws DocumentException, IOException {
        // 格式化输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        //format.setEncoding("UTF-8");
        StringWriter writer = new StringWriter();
        // 格式化输出流
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        // 将document写入到输出流
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }


    /**
     * 3、JDOM解析XML
     * 解析的时候自动去掉CDMA
     *
     * @param xml
     */
    public static Object ParseXml(Class obj, String xml) {
        Object propertiesBean = null;
        try {
            Map xmlResult = xml2mapWithAttr(xml, false);
            propertiesBean = getBean(obj.getName());
            Field[] fields = propertiesBean.getClass().getFields();
            for (Field field : fields) {
                if(null == xmlResult.get(field.getName())) {
                    log.info("属性不存在，fieldName={}",field.getName());
                    continue;
                }
                //更新属性
                if (field.getType().getSimpleName().equals("String[]")) {
                    String[] split = xmlResult.get(field.getName()).toString().split(",");
                    field.set(propertiesBean, split);
                } else if (field.getType().getSimpleName().equals("String")) {
                    field.set(propertiesBean, xmlResult.get(field.getName()).toString());
                } else if (field.getType().getSimpleName().equals("boolean")) {
                    Boolean boolVal = xmlResult.get(field.getName()).toString().toLowerCase().equals("true");
                    field.set(propertiesBean, boolVal);
                } else if (field.getType().getSimpleName().equals("int")) {
                    field.set(propertiesBean, Integer.valueOf(xmlResult.get(field.getName()).toString()));
                }
                log.info("Field Name:" + field.getName() + ", Type:" + field.getType().getSimpleName() + ",Val:" + field.get(propertiesBean));
            }
        } catch (Exception ex) {
            log.error("格式化xml异常",ex);
            ex.printStackTrace();
        }

        return propertiesBean;

    }

    /**
     * 3、JDOM解析XML
     * 解析的时候自动去掉CDMA
     *
     * @param xml
     */
    public static Object ParseSoapXml(Class obj, String xml) {
        Object propertiesBean = null;
        try {
            Map xmlResult = parse(xml);
            propertiesBean = getBean(obj.getName());
            Field[] fields = propertiesBean.getClass().getFields();
            for (Field field : fields) {
                if(null == xmlResult.get(field.getName())) {
                    log.info("属性不存在，fieldName={}",field.getName());
                    continue;
                }
                //更新属性
                if (field.getType().getSimpleName().equals("String[]")) {
                    String[] split = xmlResult.get(field.getName()).toString().split(",");
                    field.set(propertiesBean, split);
                } else if (field.getType().getSimpleName().equals("String")) {
                    field.set(propertiesBean, xmlResult.get(field.getName()).toString());
                } else if (field.getType().getSimpleName().equals("boolean")) {
                    Boolean boolVal = xmlResult.get(field.getName()).toString().toLowerCase().equals("true");
                    field.set(propertiesBean, boolVal);
                } else if (field.getType().getSimpleName().equals("int")) {
                    field.set(propertiesBean, Integer.valueOf(xmlResult.get(field.getName()).toString()));
                }
                log.info("Field Name:" + field.getName() + ", Type:" + field.getType().getSimpleName() + ",Val:" + field.get(propertiesBean));
            }
        } catch (Exception ex) {
            log.error("格式化xml异常",ex);
            ex.printStackTrace();
        }

        return propertiesBean;

    }

    public static Object getBean(String className) throws Exception {
        Class cls = null;
        try {
            cls = Class.forName(className);//对应Spring ->bean -->class
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new Exception("类错误！");
        }

        Constructor[] cons = null;//得到所有构造器
        try {
            cons = cls.getConstructors();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("构造器错误！");
        }
        if (cons == null || cons.length < 1) {
            throw new Exception("没有默认构造方法！");
        }
        //如果上面没错，就有构造方法

        Constructor defCon = cons[0];//得到默认构造器,第0个是默认构造器，无参构造方法
        Object obj = defCon.newInstance();//实例化，得到一个对象 //Spring - bean -id
        return obj;
    }

    public static Map parse(String soap) throws DocumentException {
        map = new HashMap<String,Object>();
        Document doc = DocumentHelper.parseText(soap);//报文转成doc对象
        Element root = doc.getRootElement();//获取根元素，准备递归解析这个XML树
        getCode(root);
        return map;
    }

    public static void getCode(Element root) {
        if (root.elements() != null) {
            //如果当前跟节点有子节点，找到子节点
            List<Element> list = root.elements();
            //遍历每个节点
            for (Element e : list) {
                if (e.elements().size() > 0) {
                    //当前节点不为空的话，递归遍历子节点
                    getCode(e);
                }
                if (e.elements().size() == 0) {
                    map.put(e.getName(), e.getTextTrim());
                    //如果为叶子节点，那么直接把名字和值放入map
                }
            }
        }
    }
}
