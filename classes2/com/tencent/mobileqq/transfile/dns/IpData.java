package com.tencent.mobileqq.transfile.dns;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class IpData
{
  public static final String a = "i";
  public static final String b = "p";
  public static final String c = "f";
  public int a;
  public int b;
  public String d;
  
  public IpData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IpData(String paramString, int paramInt1, int paramInt2)
  {
    this.d = paramString;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static String a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IpData localIpData = (IpData)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("i", localIpData.d);
        if (localIpData.a != 0) {
          localJSONObject.put("p", localIpData.a);
        }
        if (localIpData.b != 0) {
          localJSONObject.put("f", localIpData.b);
        }
        localJSONArray.put(localJSONObject);
      }
      paramList = localJSONArray.toString();
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    return paramList;
  }
  
  public static ArrayList a(String paramString)
  {
    int i = 0;
    try
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray = new JSONArray(paramString);
      for (;;)
      {
        paramString = localArrayList;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        localArrayList.add(new IpData(paramString.getString("i"), paramString.optInt("p", 0), paramString.optInt("f", 0)));
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\dns\IpData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */