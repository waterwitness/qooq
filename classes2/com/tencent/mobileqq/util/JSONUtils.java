package com.tencent.mobileqq.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils
{
  public JSONUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Object a(JSONObject paramJSONObject, Class paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null)) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject1 = paramClass.newInstance();
        if (localObject1 == null) {
          continue;
        }
        paramClass = paramClass.getDeclaredFields();
        int j = paramClass.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            Object localObject4 = paramClass[i];
            String str1 = ((Field)localObject4).getName();
            String str2 = ((Field)localObject4).getType().getSimpleName();
            try
            {
              if (!paramJSONObject.has(str1)) {
                break label232;
              }
              ((Field)localObject4).setAccessible(true);
              if (str2.equals("int")) {
                ((Field)localObject4).set(localObject1, Integer.valueOf(paramJSONObject.getInt(str1)));
              } else if (str2.equals("boolean")) {
                ((Field)localObject4).set(localObject1, Boolean.valueOf(paramJSONObject.getBoolean(str1)));
              }
            }
            catch (JSONException paramJSONObject)
            {
              if (!QLog.isDevelopLevel()) {
                break;
              }
              paramJSONObject.printStackTrace();
              return null;
              if (!str2.equals("long")) {
                break label179;
              }
              ((Field)localObject4).set(localObject1, Long.valueOf(paramJSONObject.getLong(str1)));
            }
            catch (IllegalAccessException paramJSONObject) {}
            if (!QLog.isDevelopLevel()) {
              break;
            }
            paramJSONObject.printStackTrace();
            return null;
            label179:
            if (str2.equals("double"))
            {
              ((Field)localObject4).set(localObject1, Double.valueOf(paramJSONObject.getDouble(str1)));
              break label232;
            }
            if (!str2.equals("String")) {
              break label232;
            }
            ((Field)localObject4).set(localObject1, paramJSONObject.getString(str1));
            break label232;
          }
          return localObject1;
          label232:
          i += 1;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Object localObject3 = null;
        }
      }
    }
  }
  
  public static JSONObject a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    if ((arrayOfField == null) || (arrayOfField.length <= 0)) {
      return localJSONObject;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localField = arrayOfField[i];
          str1 = localField.getName();
          str2 = localField.getType().getSimpleName();
          if (str2.equals("int")) {
            localJSONObject.put(str1, localField.getInt(paramObject));
          } else if (str2.equals("boolean")) {
            localJSONObject.put(str1, localField.getBoolean(paramObject));
          }
        }
      }
      catch (IllegalAccessException paramObject)
      {
        if (QLog.isDevelopLevel()) {
          ((IllegalAccessException)paramObject).printStackTrace();
        }
        return localJSONObject;
        if (str2.equals("long")) {
          localJSONObject.put(str1, localField.getLong(paramObject));
        }
      }
      catch (JSONException paramObject)
      {
        Field localField;
        String str1;
        String str2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        ((JSONException)paramObject).printStackTrace();
        continue;
        if (str2.equals("double")) {
          localJSONObject.put(str1, localField.getDouble(paramObject));
        } else if (str2.equals("String")) {
          localJSONObject.put(str1, (String)localField.get(paramObject));
        }
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\JSONUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */