package com.tencent.mobileqq.activity.recent.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DingdongPluginRecentUserMsg
  implements IRecentUserMsg
{
  public static final String a = "DingdongPluginRecentUserMsg";
  private static final String f = "_source_type_";
  private static final String g = "_source_id_";
  private static final String h = "_from_uin_";
  private static final String i = "_msg_brief_";
  private static final String j = "_feed_id_";
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public DingdongPluginRecentUserMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
      this.a = paramArrayOfByte.getInt("_source_type_");
      this.b = paramArrayOfByte.getString("_source_id_");
      this.c = paramArrayOfByte.getString("_from_uin_");
      this.d = paramArrayOfByte.getString("_msg_brief_");
      this.e = paramArrayOfByte.getString("_feed_id_");
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      QLog.e("DingdongPluginRecentUserMsg", 1, "deSerialize error:" + paramArrayOfByte.toString());
    }
  }
  
  public byte[] a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("_source_type_", this.a);
      localJSONObject.put("_source_id_", this.b);
      localJSONObject.put("_from_uin_", this.c);
      localJSONObject.put("_msg_brief_", this.d);
      localJSONObject.put("_feed_id_", this.e);
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("DingdongPluginRecentUserMsg", 1, "serialize error:" + localJSONException.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\msg\DingdongPluginRecentUserMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */