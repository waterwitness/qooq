package com.tencent.proxyinner.utility;

import java.util.HashMap;
import java.util.Map;

public class UtilSchema
{
  public static final String PARAM_FROMID = "fromid";
  public static final String PARAM_MAIN_ACTIVITY_NAME = "mainActivityName";
  public static final String PARAM_PACKAGE_NAME = "packagename";
  public static final String PARAM_PLUGINTYPE = "plugintype";
  public static final String PARAM_ROOMID = "roomid";
  public static final String PARAM_VASNAME = "vasname";
  private static final String TAG = "UtilSchema";
  
  public static Map<String, String> paramMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = schemaParam(paramString);
    if (paramString == null) {
      return localHashMap;
    }
    paramString = paramString.split("[&]");
    int j = paramString.length;
    int i = 0;
    label32:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("[=]");
      if (arrayOfString.length <= 1) {
        break label73;
      }
      localHashMap.put(arrayOfString[0], arrayOfString[1]);
    }
    for (;;)
    {
      i += 1;
      break label32;
      break;
      label73:
      if (arrayOfString[0] != "") {
        localHashMap.put(arrayOfString[0], "");
      }
    }
  }
  
  public static String schemaHead(String paramString)
  {
    String str1 = "";
    String str2 = paramString.trim().toLowerCase();
    String[] arrayOfString = str2.split("[?]");
    paramString = str1;
    if (str2.length() > 0)
    {
      paramString = str1;
      if (arrayOfString.length > 1)
      {
        paramString = str1;
        if (arrayOfString[0] != null) {
          paramString = arrayOfString[0];
        }
      }
    }
    return paramString;
  }
  
  private static String schemaParam(String paramString)
  {
    Object localObject = null;
    String str = paramString.trim().toLowerCase();
    String[] arrayOfString = str.split("[?]");
    paramString = (String)localObject;
    if (str.length() > 1)
    {
      paramString = (String)localObject;
      if (arrayOfString.length > 1)
      {
        paramString = (String)localObject;
        if (arrayOfString[1] != null) {
          paramString = arrayOfString[1];
        }
      }
    }
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\utility\UtilSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */