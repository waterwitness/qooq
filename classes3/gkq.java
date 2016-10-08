import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class gkq
  extends gkp
{
  static final String f = "[d] RequestDouble";
  static final int g = 0;
  static final int h = 1;
  static final int i = 2;
  boolean jdField_b_of_type_Boolean;
  int j;
  int k;
  
  public gkq(RandomWebProtocol paramRandomWebProtocol, gkp paramgkp, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramRandomWebProtocol, paramgkp);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 1;
    this.c = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.k = paramInt1;
    this.j = paramInt2;
    this.d = "[d] RequestDouble";
  }
  
  String a()
  {
    this.a = null;
    try
    {
      this.a = new JSONObject();
      this.a.put("peer_gender", this.j);
      this.a.put("session_type", this.k);
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
        localJSONObject.put("sessionType", this.k);
        localJSONObject.put("sex", this.j);
        localJSONObject.put("gender", this.f);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */