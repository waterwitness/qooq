import android.os.Handler;
import android.os.Message;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qzn
  extends LBSObserver
{
  public qzn(LocationSelectActivity paramLocationSelectActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramLBSInfo != null) {}
    for (paramLBSInfo = paramLBSInfo.a(); Math.abs(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) > 1200L; paramLBSInfo = null)
    {
      this.a.a(paramBoolean, paramLBSInfo);
      return;
    }
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1000);
    localMessage.obj = new Object[] { Boolean.valueOf(paramBoolean), paramLBSInfo };
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1200L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */