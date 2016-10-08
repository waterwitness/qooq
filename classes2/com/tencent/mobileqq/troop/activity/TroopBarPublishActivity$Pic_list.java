package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishActivity$Pic_list
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_H = "h";
  protected static final String JSON_KEY_TYPE = "type";
  protected static final String JSON_KEY_TYPE_INFO = "type_info";
  protected static final String JSON_KEY_URL = "url";
  protected static final String JSON_KEY_W = "w";
  protected static final long serialVersionUID = 10008L;
  public int h;
  public String type;
  public String url;
  public int w;
  
  public TroopBarPublishActivity$Pic_list()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopBarPublishActivity$Pic_list(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.url = paramString1;
    this.w = paramInt1;
    this.h = paramInt2;
    this.type = paramString2;
  }
  
  public TroopBarPublishActivity$Pic_list(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.url = paramJSONObject.optString("url", "");
    this.w = paramJSONObject.optInt("w", -1);
    this.h = paramJSONObject.optInt("h", -1);
    paramJSONObject = paramJSONObject.optJSONObject("type_info");
    if (paramJSONObject != null) {
      this.type = paramJSONObject.optString("type", "");
    }
  }
  
  public JSONObject getJsonObject()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("url", this.url);
      localJSONObject1.put("w", this.w);
      localJSONObject1.put("h", this.h);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", this.type);
      localJSONObject1.put("type_info", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.url = paramObjectInput.readUTF();
    this.w = paramObjectInput.readInt();
    this.h = paramObjectInput.readInt();
    this.type = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.url);
    paramObjectOutput.writeInt(this.w);
    paramObjectOutput.writeInt(this.h);
    paramObjectOutput.writeUTF(this.type);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarPublishActivity$Pic_list.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */