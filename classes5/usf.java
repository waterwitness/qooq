import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;

public class usf
  implements Runnable
{
  public usf(FilterProcessRender paramFilterProcessRender)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    VideoPreviewFaceOutlineDetector.getInstance().doFaceDetect();
    long l2 = SystemClock.elapsedRealtimeNanos();
    PtvFilterTimeStatistics.a((l2 - l1) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[doFaceDetect=" + (l2 - l1) / 1000L + "us]");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */