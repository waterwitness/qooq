package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class ArkAppMessage$Config
{
  public Integer autoSize;
  public Integer forward;
  public Integer height;
  public Integer round;
  public Integer width;
  
  public ArkAppMessage$Config()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean fromJson(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            int i = paramJSONObject.optInt("round", -1);
            if (i != -1) {
              this.round = new Integer(i);
            }
            i = paramJSONObject.optInt("forward", -1);
            if (i != -1) {
              this.forward = new Integer(i);
            }
            i = paramJSONObject.optInt("autosize", -1);
            if (i != -1) {
              this.autoSize = new Integer(i);
            }
            paramJSONObject = paramJSONObject.optString("size");
            bool1 = bool2;
          } while (paramJSONObject == null);
          bool1 = bool2;
        } while (paramJSONObject.length() <= 0);
        paramJSONObject = paramJSONObject.split(",");
        bool1 = bool2;
      } while (paramJSONObject == null);
      bool1 = bool2;
    } while (paramJSONObject.length != 2);
    try
    {
      this.width = Integer.decode(paramJSONObject[0]);
      this.height = Integer.decode(paramJSONObject[1]);
      return true;
    }
    catch (Exception paramJSONObject) {}
    return true;
  }
  
  public boolean fromString(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      boolean bool = fromJson(new JSONObject(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.round != null) {
        localJSONObject.put("round", this.round.intValue());
      }
      if (this.forward != null) {
        localJSONObject.put("forward", this.forward.intValue());
      }
      if (this.autoSize != null) {
        localJSONObject.put("autosize", this.autoSize.intValue());
      }
      if ((this.width != null) && (this.height != null)) {
        localJSONObject.put("size", String.format("%d,%d", new Object[] { Integer.valueOf(this.width.intValue()), Integer.valueOf(this.height.intValue()) }));
      }
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String toString()
  {
    JSONObject localJSONObject = toJson();
    if (localJSONObject == null) {
      return null;
    }
    return localJSONObject.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ArkAppMessage$Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */