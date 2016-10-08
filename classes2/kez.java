import com.tencent.kingkong.Common;
import com.tencent.kingkong.Common.Log;
import com.tencent.kingkong.DataReport;
import com.tencent.kingkong.ReportThread;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class kez
  extends Thread
{
  public kez()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      Common.a.a(2088, 0, 0, "");
      Common.Log.a("KingKongCommon", "QQ Login " + DataReport.o());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */