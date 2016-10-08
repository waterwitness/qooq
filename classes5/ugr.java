import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class ugr
  extends ugs
{
  int a;
  
  ugr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = -1;
  }
  
  public HashMap a(String paramString)
  {
    if ("ShortVideo.Preview".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_uinType", this.b + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_playAction", this.a + "");
      return paramString;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */