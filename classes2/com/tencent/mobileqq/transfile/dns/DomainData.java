package com.tencent.mobileqq.transfile.dns;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class DomainData
{
  public static final String a = "n";
  public static final String b = "l";
  public ArrayList a;
  public String c;
  
  public DomainData(String paramString, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = paramString;
    this.a = paramArrayList;
  }
  
  public static String a(HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramHashMap = paramHashMap.values().iterator();
      while (paramHashMap.hasNext())
      {
        DomainData localDomainData = (DomainData)paramHashMap.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("n", localDomainData.c);
        localJSONObject.put("l", IpData.a(localDomainData.a));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      return null;
    }
    return paramHashMap;
  }
  
  public static HashMap a(String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      for (;;)
      {
        paramString = localHashMap;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        String str = paramString.getString("n");
        localHashMap.put(str, new DomainData(str, IpData.a(paramString.getString("l"))));
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\dns\DomainData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */