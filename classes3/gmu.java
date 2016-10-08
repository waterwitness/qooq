import com.tencent.av.report.VideoConnRateReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gmu
  implements Runnable
{
  public gmu(VideoConnRateReport paramVideoConnRateReport)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a.a)
    {
      VideoConnRateReport.a(this.a);
      VideoConnRateReport.b(this.a);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */