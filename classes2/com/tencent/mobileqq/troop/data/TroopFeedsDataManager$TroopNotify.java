package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopFeedsDataManager$TroopNotify
{
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public TroopFeedsDataManager$TroopNotify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1;
  }
  
  public static TroopNotify a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (!paramJSONObject.has("msg"))) {
      return null;
    }
    TroopNotify localTroopNotify = new TroopNotify();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("msg");
    localTroopNotify.b = localJSONObject.optString("text_face");
    if (localTroopNotify.b != null) {
      localTroopNotify.b = localTroopNotify.b.replace("&#10;", "<br/>");
    }
    localTroopNotify.jdField_a_of_type_JavaLangString = localJSONObject.optString("title");
    if (localTroopNotify.jdField_a_of_type_JavaLangString != null) {
      localTroopNotify.jdField_a_of_type_JavaLangString = localTroopNotify.jdField_a_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    if ((localTroopNotify.jdField_a_of_type_JavaLangString == null) || (localTroopNotify.b == null)) {
      return null;
    }
    Object localObject = localJSONObject.optJSONArray("pics");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if (localObject != null)
      {
        localTroopNotify.c = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/628");
        localTroopNotify.d = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/");
      }
    }
    if (localJSONObject.has("v"))
    {
      localJSONObject = localJSONObject.optJSONObject("v");
      localTroopNotify.e = localJSONObject.optString("l");
      localTroopNotify.c = localJSONObject.optString("bi");
    }
    localTroopNotify.f = paramJSONObject.optString("u");
    localTroopNotify.g = ContactUtils.f(paramQQAppInterface, paramString, localTroopNotify.f);
    localTroopNotify.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
    localTroopNotify.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
    return localTroopNotify;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedsDataManager$TroopNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */