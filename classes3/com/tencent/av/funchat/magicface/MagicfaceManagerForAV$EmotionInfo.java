package com.tencent.av.funchat.magicface;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class MagicfaceManagerForAV$EmotionInfo
{
  int jdField_a_of_type_Int;
  public String a;
  public boolean a;
  String b;
  String c;
  String d;
  public String e;
  public String f;
  String g;
  String h;
  
  public MagicfaceManagerForAV$EmotionInfo(MagicfaceManagerForAV paramMagicfaceManagerForAV, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    if (paramJSONObject == null)
    {
      paramMagicfaceManagerForAV.d("EmotionInfo init failed. info is null");
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("id");
      this.b = paramJSONObject.getString("text");
      this.jdField_a_of_type_Int = paramJSONObject.getInt("vip_level");
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("predownload");
      this.c = paramJSONObject.getString("icon_url");
      this.e = paramJSONObject.getString("res_url");
      this.f = paramJSONObject.getString("res_md5");
      if (paramJSONObject.has("res_password")) {
        this.h = paramJSONObject.getString("res_password");
      }
      this.d = this.c.substring(this.c.lastIndexOf('/') + 1);
      this.g = this.e.substring(this.e.lastIndexOf('/') + 1);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      paramMagicfaceManagerForAV.d("EmotionInfo init failed. info = " + paramJSONObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\funchat\magicface\MagicfaceManagerForAV$EmotionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */