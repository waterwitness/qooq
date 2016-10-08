package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiJsPlugin$JSONWrapper
{
  JSONObject json;
  
  public EmojiJsPlugin$JSONWrapper(JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.json = paramJSONObject;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.json != null)
    {
      bool = paramBoolean;
      if (this.json.isNull(paramString)) {}
    }
    try
    {
      bool = this.json.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return paramBoolean;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    int i = paramInt;
    if (this.json != null)
    {
      i = paramInt;
      if (this.json.isNull(paramString)) {}
    }
    try
    {
      i = this.json.getInt(paramString);
      return i;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public String getString(String paramString)
  {
    if ((this.json != null) && (!this.json.isNull(paramString))) {
      try
      {
        paramString = this.json.getString(paramString);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\EmojiJsPlugin$JSONWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */