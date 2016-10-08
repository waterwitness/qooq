import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DataAdapter;
import java.util.HashMap;

public class ugv
  extends DataAdapter
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  
  ugv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HashMap a(String paramString)
  {
    if ("actStreamingVideoPlay".equalsIgnoreCase(paramString))
    {
      paramString = new HashMap();
      paramString.put("StreamingVideoSupport", String.valueOf(this.jdField_a_of_type_Boolean));
      paramString.put("FirstBufferTime", String.valueOf(this.jdField_a_of_type_Int));
      paramString.put("PlayProgress", String.valueOf(this.b));
      paramString.put("LoadProgress", String.valueOf(this.c));
      paramString.put("FileDuration", String.valueOf(this.d));
      paramString.put("FileLen", String.valueOf(this.e));
      paramString.put("param_seekTimes", String.valueOf(this.g));
      paramString.put("PlayResult", String.valueOf(this.h));
      paramString.put("param_playTimeCost", String.valueOf(this.jdField_a_of_type_Long));
      return paramString;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("supportProgressive ").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("playReadyTime ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("exitPlayProgress ").append(this.b);
    localStringBuilder.append("exitCacheProgress ").append(this.c);
    localStringBuilder.append("durationTime ").append(this.d);
    localStringBuilder.append("fileSize ").append(this.e);
    localStringBuilder.append("seekTimes ").append(this.g);
    localStringBuilder.append("playResult ").append(this.h);
    localStringBuilder.append("playTimeCost").append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */