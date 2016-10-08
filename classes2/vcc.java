import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;

public class vcc
  implements Runnable
{
  public vcc(ShortVideoUploadProcessor paramShortVideoUploadProcessor, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    Object localObject = ShortVideoUtils.a(localFile);
    if (localObject == null) {
      return;
    }
    long l2 = Long.valueOf(localObject.split("\\|")[0]).longValue();
    long l3 = Long.valueOf(localObject.split("\\|")[1]).longValue();
    long l4 = SystemClock.uptimeMillis();
    localObject = new HashMap();
    ((HashMap)localObject).put("param_moovOffset", l2 + "");
    ((HashMap)localObject).put("param_moovSize", l3 + "");
    ((HashMap)localObject).put("param_videoLen", localFile.length() + "");
    DecimalFormat localDecimalFormat = new DecimalFormat("##.000");
    ((HashMap)localObject).put("param_moovPosition", localDecimalFormat.format(l2 * 1.0D / localFile.length()) + "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actShortVideoMoov", false, l4 - l1, -1L, (HashMap)localObject, "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */