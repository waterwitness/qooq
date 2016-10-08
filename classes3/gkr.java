import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class gkr
  extends gkp
{
  static final String f = "[m] RequestMulti";
  boolean jdField_b_of_type_Boolean;
  int g;
  
  public gkr(RandomWebProtocol paramRandomWebProtocol, gkp paramgkp, String paramString, boolean paramBoolean, int paramInt)
  {
    super(paramRandomWebProtocol, paramgkp);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 2;
    this.c = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.g = paramInt;
    this.d = "[m] RequestMulti";
  }
  
  String a()
  {
    this.a = null;
    try
    {
      this.a = new JSONObject();
      this.a.put("session_type", this.g);
      return super.a();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  String b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(super.b());
      if (this.jdField_b_of_type_Boolean) {
        localJSONObject.put("ismask", 1);
      }
      for (;;)
      {
        localJSONObject.put("sessionType", this.g);
        localJSONObject.put("sex", 0);
        return localJSONObject.toString();
        localJSONObject.put("ismask", 0);
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */