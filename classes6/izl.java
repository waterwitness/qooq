import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.video.decode.ShortVideoSoLoad;

public class izl
{
  static final String a = "trim_process_pic";
  static final String b = "trim_process_pie";
  static final String c = "AVCodec";
  
  izl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "trim_process_pie";; str = "trim_process_pic") {
      return ShortVideoSoLoad.getShortVideoSoPath(paramContext) + str;
    }
  }
  
  public static String b(Context paramContext)
  {
    paramContext = ShortVideoSoLoad.getShortVideoSoPath(paramContext);
    String str = ShortVideoSoLoad.getLibActualName("AVCodec");
    return paramContext + str;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */