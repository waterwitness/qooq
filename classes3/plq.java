import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class plq
{
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
  public String f;
  public String g;
  public String h;
  public String i;
  
  plq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static plq a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new plq();
    }
    plq localplq = new plq();
    try
    {
      localplq.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localplq.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localplq.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localplq.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localplq.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localplq.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localplq.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localplq.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localplq.g = paramJSONObject.getString("classifyName");
      localplq.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localplq.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localplq.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localplq.h = paramJSONObject.getString("trialstartday");
      localplq.i = paramJSONObject.getString("trialendday");
      return localplq;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localplq;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\plq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */