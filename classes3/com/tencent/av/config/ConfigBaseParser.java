package com.tencent.av.config;

import android.text.TextUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ConfigBaseParser
{
  public static final String P = "unknown";
  protected String Q;
  
  public ConfigBaseParser(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.Q = paramString;
  }
  
  protected int a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      paramString = a(paramString);
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[0];
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString2;
      paramString1 = a(paramString1);
    } while ((paramString1 == null) || (paramString1.length <= 0));
    return paramString1[0];
  }
  
  public int[] a(String paramString)
  {
    int[] arrayOfInt = null;
    Object localObject = GraphicRenderMgr.getInstance().findConfigValue(this.Q, paramString, "unknown");
    paramString = arrayOfInt;
    if (localObject != null)
    {
      if (!((String)localObject).equalsIgnoreCase("unknown")) {
        break label35;
      }
      paramString = arrayOfInt;
    }
    label35:
    do
    {
      return paramString;
      localObject = ((String)localObject).split(",");
      paramString = arrayOfInt;
    } while (localObject == null);
    int j = localObject.length;
    arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfInt;
      if (i >= j) {
        break;
      }
      try
      {
        arrayOfInt[i] = Integer.parseInt(localObject[i].trim());
        i += 1;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          arrayOfInt[i] = 0;
        }
      }
    }
  }
  
  public String[] a(String paramString)
  {
    paramString = GraphicRenderMgr.getInstance().findConfigValue(this.Q, paramString, "unknown");
    if ((paramString == null) || (paramString.equalsIgnoreCase("unknown"))) {
      return null;
    }
    return paramString.trim().split(",");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\config\ConfigBaseParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */