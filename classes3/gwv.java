import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gwv
  extends VideoObserver
{
  public gwv(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong)
  {
    super.a(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin:" + paramLong + ", mRelationId = " + this.a.a);
    }
    if ((paramLong != 0L) && (paramLong == this.a.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoEnterPage", 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin matched");
      }
      MultiVideoEnterPageActivity.d(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */