import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashSet;
import java.util.Iterator;

public final class hso
  implements Runnable
{
  public hso(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (VideoReporter.a == null) {
        return;
      }
      String str = VideoReporter.a();
      Iterator localIterator = VideoReporter.a.iterator();
      while (localIterator.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
        ReportController.b(null, "CliOper", "", "", "0X80069AA", "0X80069AA", 0, 0, this.a, str, "", ReadInJoyUtils.a(localVideoInfo.a, localVideoInfo.g));
        VideoReporter.a(localVideoInfo.g, 0, (int)localVideoInfo.c, localVideoInfo.e, 7, -1);
      }
      VideoReporter.a.clear();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */