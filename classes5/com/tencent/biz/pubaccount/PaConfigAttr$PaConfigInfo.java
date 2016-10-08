package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class PaConfigAttr$PaConfigInfo
{
  public static final Map a;
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Boolean.TYPE, Integer.valueOf(1));
    jdField_a_of_type_JavaUtilMap.put(Integer.TYPE, Integer.valueOf(2));
    jdField_a_of_type_JavaUtilMap.put(Long.TYPE, Integer.valueOf(3));
    jdField_a_of_type_JavaUtilMap.put(String.class, Integer.valueOf(4));
    jdField_a_of_type_JavaUtilMap.put(Double.TYPE, Integer.valueOf(5));
  }
  
  public PaConfigAttr$PaConfigInfo() {}
  
  public PaConfigAttr$PaConfigInfo(mobileqq_mp.ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_Int = paramConfigInfo.type.get();
    this.jdField_a_of_type_JavaLangString = paramConfigInfo.title.get();
    this.jdField_b_of_type_JavaLangString = paramConfigInfo.content.get();
    this.jdField_c_of_type_Int = paramConfigInfo.event_id.get();
    this.jdField_c_of_type_JavaLangString = paramConfigInfo.url.get();
    this.jdField_d_of_type_Int = paramConfigInfo.state.get();
    this.jdField_e_of_type_Int = paramConfigInfo.state_id.get();
    this.jdField_f_of_type_Int = paramConfigInfo.confirm_flag.get();
    this.jdField_d_of_type_JavaLangString = paramConfigInfo.confirm_tips.get();
  }
  
  public static PaConfigInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    PaConfigInfo localPaConfigInfo = new PaConfigInfo();
    try
    {
      localPaConfigInfo.jdField_a_of_type_Int = paramJSONObject.optInt("type");
      localPaConfigInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
      localPaConfigInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
      localPaConfigInfo.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
      localPaConfigInfo.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
      localPaConfigInfo.jdField_d_of_type_Int = paramJSONObject.optInt("state");
      localPaConfigInfo.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
      localPaConfigInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
      localPaConfigInfo.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
      localPaConfigInfo.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
      localPaConfigInfo.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
      localPaConfigInfo.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
      localPaConfigInfo.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
      localPaConfigInfo.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
      localPaConfigInfo.jdField_g_of_type_Int = paramJSONObject.optInt("width");
      localPaConfigInfo.jdField_h_of_type_Int = paramJSONObject.optInt("height");
      localPaConfigInfo.i = paramJSONObject.optString("icon");
      return localPaConfigInfo;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localPaConfigInfo;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PaConfigAttr$PaConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */