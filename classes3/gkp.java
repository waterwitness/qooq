import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class gkp
{
  static final int jdField_a_of_type_Int = 0;
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 2;
  static final int d = 3;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  String jdField_c_of_type_JavaLangString;
  public String d;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  public int f;
  
  public gkp(RandomWebProtocol paramRandomWebProtocol)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_JavaLangString = "client";
    this.jdField_e_of_type_Int = 0;
    String str = paramRandomWebProtocol.a.getAccount();
    paramRandomWebProtocol = (TicketManager)paramRandomWebProtocol.a.getManager(2);
    this.jdField_a_of_type_JavaLangString = "6.5.5";
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(str);
      this.b = paramRandomWebProtocol.getSkey(str);
      this.f = -1;
      this.jdField_a_of_type_OrgJsonJSONObject = null;
      this.c = null;
      this.d = null;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] init Req error: failed parse self_uin: " + str);
        }
      }
    }
  }
  
  gkp(RandomWebProtocol paramRandomWebProtocol, gkp paramgkp)
  {
    this.jdField_e_of_type_JavaLangString = "client";
    this.jdField_e_of_type_Int = paramgkp.jdField_e_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramgkp.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramgkp.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Long = paramgkp.jdField_a_of_type_Long;
    this.b = paramgkp.b;
    this.f = paramgkp.f;
    this.jdField_a_of_type_OrgJsonJSONObject = paramgkp.jdField_a_of_type_OrgJsonJSONObject;
    this.c = paramgkp.c;
    this.d = paramgkp.d;
    this.jdField_e_of_type_JavaLangString = paramgkp.jdField_e_of_type_JavaLangString;
  }
  
  String a()
  {
    if (this.jdField_e_of_type_Int == 0) {
      return "";
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("reqtype", this.jdField_e_of_type_Int);
      ((JSONObject)localObject).put("qqversion", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("isdebug", this.jdField_a_of_type_Boolean);
      ((JSONObject)localObject).put("self_uin", this.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("self_skey", this.b);
      ((JSONObject)localObject).put("self_gender", this.f);
      ((JSONObject)localObject).put("reqbody", this.jdField_a_of_type_OrgJsonJSONObject);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  String b()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("uin", this.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("sessionkey", this.b);
      ((JSONObject)localObject).put("qqVersion", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("from", this.jdField_e_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */