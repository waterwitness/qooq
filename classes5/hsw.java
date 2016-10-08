import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hsw
  extends PublicAccountObserver
{
  public hsw(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      this.a.f();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */