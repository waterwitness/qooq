package cooperation.qzone.UndealCount;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneCountInfo
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  
  public QZoneCountInfo()
  {
    this(0, 0, 0L, "", "");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneCountInfo(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static QZoneCountInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localQZoneCountInfo.jdField_a_of_type_Long = paramString.optLong("uCount");
      localQZoneCountInfo.jdField_a_of_type_Int = paramString.optInt("iControl");
      localQZoneCountInfo.jdField_b_of_type_Long = paramString.optLong("friendUin");
      localQZoneCountInfo.jdField_a_of_type_JavaLangString = paramString.optString("friendMsg");
      localQZoneCountInfo.jdField_b_of_type_Int = paramString.optInt("totalFriendUnread");
      localQZoneCountInfo.jdField_b_of_type_JavaLangString = paramString.optString("trace_info");
      return localQZoneCountInfo;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      QLog.e("CountInfo", 2, "JSONException", paramString);
    }
    return localQZoneCountInfo;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uCount", this.jdField_a_of_type_Long);
      localJSONObject.put("iControl", this.jdField_a_of_type_Int);
      localJSONObject.put("friendUin", this.jdField_b_of_type_Long);
      localJSONObject.put("friendMsg", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("totalFriendUnread", this.jdField_b_of_type_Int);
      localJSONObject.put("trace_info", this.jdField_b_of_type_JavaLangString);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        QLog.e("CountInfo", 2, "JSONException", localJSONException);
      }
    }
  }
  
  public boolean a(QZoneCountInfo paramQZoneCountInfo)
  {
    if (paramQZoneCountInfo == null) {}
    while (((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(paramQZoneCountInfo.jdField_b_of_type_JavaLangString))) || ((paramQZoneCountInfo.jdField_b_of_type_JavaLangString != null) && (!paramQZoneCountInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) || (this.jdField_a_of_type_Long != paramQZoneCountInfo.jdField_a_of_type_Long) || (this.jdField_b_of_type_Long != paramQZoneCountInfo.jdField_b_of_type_Long)) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\UndealCount\QZoneCountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */