import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class gkw
  extends gkt
{
  public String b;
  public int x;
  public int y;
  
  gkw(RandomWebProtocol paramRandomWebProtocol)
  {
    super(paramRandomWebProtocol);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.x = -1;
    this.y = -1;
  }
  
  void a(String paramString)
  {
    super.a(paramString);
    if ((2 == this.s) && (this.a != null)) {}
    try
    {
      if (this.a.has("ismask")) {
        this.x = this.a.getInt("ismask");
      }
      if (this.a.has("groupids")) {
        this.jdField_b_of_type_JavaLangString = this.a.getString("groupids");
      }
      if (this.a.has("businessid")) {
        this.y = this.a.getInt("businessid");
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  void b(String paramString)
  {
    super.b(paramString);
    if (2 == this.s) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("groupids")) {
        this.jdField_b_of_type_JavaLangString = paramString.getString("groupids");
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */