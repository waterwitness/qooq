import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager.CUnpublishedFeedsListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.os.MqqHandler;

public class sqe
  extends FreshNewsManager.CUnpublishedFeedsListener
{
  public sqe(FreshNewsHandler paramFreshNewsHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    ThreadManager.a().post(new sqf(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */