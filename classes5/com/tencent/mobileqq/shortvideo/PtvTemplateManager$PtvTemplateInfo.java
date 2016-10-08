package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class PtvTemplateManager$PtvTemplateInfo
{
  public boolean downloading;
  public String iconurl;
  public String id;
  public String md5;
  public String name;
  public int platform;
  public boolean predownload;
  public String resurl;
  public boolean usable;
  
  public PtvTemplateManager$PtvTemplateInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static List convertFrom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        paramString = convertFrom(new JSONArray(paramString));
        return paramString;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isDevelopLevel());
    paramString.printStackTrace();
    return null;
  }
  
  public static List convertFrom(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    try
    {
      int j = paramJSONArray.length();
      if (j <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)JSONUtils.a(paramJSONArray.getJSONObject(i), PtvTemplateInfo.class);
        if (localPtvTemplateInfo != null) {
          localArrayList.add(localPtvTemplateInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      if (QLog.isDevelopLevel()) {
        paramJSONArray.printStackTrace();
      }
    }
    return null;
  }
  
  public String toString()
  {
    return "PtvTemplateInfo{id='" + this.id + '\'' + ", name='" + this.name + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\PtvTemplateManager$PtvTemplateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */