import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class ugq
  extends ugs
{
  long a;
  long b;
  
  ugq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 0L;
    this.jdField_b_of_type_Long = -1L;
  }
  
  public HashMap a(String paramString)
  {
    if ("ShortVideo.FullscreenPreview".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_uinType", this.jdField_b_of_type_Int + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_duration", this.a + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_playTimeCost", this.jdField_b_of_type_Long + "");
      return paramString;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */