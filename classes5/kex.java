import android.os.Handler;
import android.os.Message;
import com.tencent.gamecenter.common.util.ReportInfoManager;
import com.tencent.gamecenter.common.util.TrafficStatistics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kex
  extends Handler
{
  public kex(ReportInfoManager paramReportInfoManager, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    TrafficStatistics.a("post report", this.jdField_a_of_type_Long, (short)1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */