package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iyz;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonORM
{
  public static final int a = 0;
  private static final Map a = new IdentityHashMap();
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Object a(JSONObject paramJSONObject, Class paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null)) {
      throw new IllegalArgumentException("both jsonObject and clazz should not be null");
    }
    Object localObject2 = (iyz[])a.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a(paramClass);
      a.put(paramClass, localObject1);
    }
    try
    {
      localObject2 = paramClass.newInstance();
      j = localObject1.length;
      i = 0;
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        int j;
        int i;
        k = paramClass.jdField_a_of_type_Int;
        switch (k)
        {
        default: 
          i += 1;
        }
      }
      catch (IllegalAccessException paramJSONObject)
      {
        throw new JsonORM.JsonParseException("access field failed : " + paramClass.jdField_a_of_type_JavaLangReflectField.getName(), paramJSONObject);
      }
      paramJSONObject = paramJSONObject;
      throw new JsonORM.JsonParseException("create class instance failed : " + paramClass.getName(), paramJSONObject);
    }
    if (i < j)
    {
      paramClass = localObject1[i];
      for (;;)
      {
        int k;
        paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, Boolean.valueOf(paramJSONObject.optBoolean(paramClass.jdField_a_of_type_JavaLangString)));
        continue;
        paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, Integer.valueOf(paramJSONObject.optInt(paramClass.jdField_a_of_type_JavaLangString)));
        continue;
        paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, Long.valueOf(paramJSONObject.optLong(paramClass.jdField_a_of_type_JavaLangString)));
        continue;
        paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, Double.valueOf(paramJSONObject.optDouble(paramClass.jdField_a_of_type_JavaLangString)));
        continue;
        paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, paramJSONObject.optString(paramClass.jdField_a_of_type_JavaLangString));
        continue;
        Object localObject3 = paramJSONObject.optJSONArray(paramClass.jdField_a_of_type_JavaLangString);
        if (localObject3 != null)
        {
          paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, a((JSONArray)localObject3, paramClass.jdField_a_of_type_JavaLangReflectField.getType().getComponentType()));
          continue;
          localObject3 = paramJSONObject.optJSONObject(paramClass.jdField_a_of_type_JavaLangString);
          if (localObject3 != null) {
            paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, a((JSONObject)localObject3, paramClass.jdField_a_of_type_JavaLangReflectField.getType()));
          }
        }
      }
    }
    return localObject2;
  }
  
  private static void a(Class paramClass, ArrayList paramArrayList)
  {
    paramClass = paramClass.getDeclaredFields();
    int j = 0;
    while (j != paramClass.length)
    {
      Field localField = paramClass[j];
      JsonORM.Column localColumn = (JsonORM.Column)localField.getAnnotation(JsonORM.Column.class);
      if (localColumn == null)
      {
        j += 1;
      }
      else
      {
        Class localClass = localField.getType();
        int i;
        if (localClass == String.class) {
          i = 0;
        }
        for (;;)
        {
          paramArrayList.add(new iyz(localColumn.a(), i, localField));
          break;
          if (localClass == Boolean.TYPE) {
            i = 1;
          } else if (localClass == Integer.TYPE) {
            i = 2;
          } else if (localClass == Long.TYPE) {
            i = 3;
          } else if (localClass == Double.TYPE) {
            i = 4;
          } else if (localClass.isArray()) {
            i = 6;
          } else {
            i = 5;
          }
        }
      }
    }
  }
  
  private static iyz[] a(Class paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      a(paramClass, localArrayList);
      paramClass = paramClass.getSuperclass();
    }
    paramClass = new iyz[localArrayList.size()];
    localArrayList.toArray(paramClass);
    return paramClass;
  }
  
  public static Object[] a(JSONArray paramJSONArray, Class paramClass)
  {
    if ((paramJSONArray == null) || (paramClass == null)) {
      throw new IllegalArgumentException("both jsonArray and clazz should not be null");
    }
    int j = paramJSONArray.length();
    Object[] arrayOfObject = (Object[])Array.newInstance(paramClass, j);
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null)
      {
        arrayOfObject[i] = a(localJSONObject, paramClass);
        i += 1;
      }
      else
      {
        throw new JsonORM.JsonParseException("can not get json object from array by index = " + i);
      }
    }
    return arrayOfObject;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\JsonORM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */