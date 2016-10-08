import android.os.AsyncTask;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongCalendarSyncUtil;

public final class yam
  extends AsyncTask
{
  public yam(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(DingdongPluginBizObserver.ScheduleMoreSummaryData... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    DingdongCalendarSyncUtil.b(this.a, paramVarArgs);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */