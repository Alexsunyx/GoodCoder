package model;

import parser.FloatParser;
import parser.IntegerParser;
import parser.StringParser;
import parser.UnreliableParser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowResult {
    private List<List<Object>> rowResult;
    private List<Class> classes;
    private Map<Class, Class> classMap;
    private int colNum;
    public void addResult(List<Object> row, Object value) {
        row.add(value);
        try {
            classes.get(row.size() - 1).cast(value);
        } catch (NumberFormatException ex) {
            row.set(row.size() - 1, null);
        }

    }

    public RowResult() {
        rowResult = new ArrayList<List<Object>>();
        classes = new ArrayList<Class>();
        classMap = new HashMap<Class, Class>();
        /*
        classes.add(Integer.class);
        classes.add(String.class);
        classes.add(Float.class);
        classes.add(UnreliableNumber.class);
        */
        classMap.put(Integer.class, IntegerParser.class);
        classMap.put(String.class, StringParser.class);
        classMap.put(Float.class, FloatParser.class);
        classMap.put(UnreliableNumber.class, UnreliableParser.class);
    }


    private void readTypes(List<String> types) {
        colNum = types.size();
        System.out.println(colNum);
        for(String type : types) {
            if (type.equals("int"))
                classes.add(Integer.class);
            else if (type.equals("float"))
                classes.add(Float.class);
            else if (type.equals("string"))
                classes.add(String.class);
            else if (type.equals("unreal"))
                classes.add(UnreliableNumber.class);
        }
    }

    public void generate(List<String> list, List<String> types) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<Object> arrayList = new ArrayList<Object>();
        readTypes(types);
        for (int i = 0; i < list.size(); i++) {
            Class clazz = classMap.get(classes.get(i % colNum));
            Class clazz1 = classes.get(i % colNum);
            Method method = clazz.getMethod("parse", String.class);
            Object obj = method.invoke(clazz.newInstance(), list.get(i));
            arrayList.add(obj);
            if ((i + 1) % colNum == 0) {
                rowResult.add(arrayList);
                arrayList = new ArrayList<Object>();
            }
        }
    }

    public List<List<Object>> getRowResult() {
        return rowResult;
    }

    public void setRowResult(List<List<Object>> rowResult) {
        this.rowResult = rowResult;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
