package com.tencent.mobileqq.msf.core.net.b;

import org.json.JSONObject;

public class m
{
  public String a;
  public long b;
  public boolean c;
  
  public m() {}
  
  public m(String paramString, long paramLong, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramBoolean;
  }
  
  public static m a(String paramString)
  {
    try
    {
      paramString = paramString.split("&#&");
      if (paramString.length != 3) {
        return null;
      }
      paramString = new m(paramString[0], Long.parseLong(paramString[1]), Boolean.parseBoolean(paramString[2]));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static m a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new m(paramJSONObject.getString("ssid"), paramJSONObject.getLong("time"), paramJSONObject.getBoolean("available"));
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a).append("&#&");
    localStringBuffer.append(this.b).append("&#&");
    localStringBuffer.append(this.c);
    return localStringBuffer.toString();
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ssid", this.a);
      localJSONObject.put("time", this.b);
      localJSONObject.put("available", this.c);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */