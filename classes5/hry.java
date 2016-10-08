import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hry
  implements Runnable
{
  public hry(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "mHandler.postDelayed() startShowLoading() mIsNeedShowLoading=" + VideoPlayMgr.a(this.a));
    }
    if (!VideoPlayMgr.a(this.a)) {
      return;
    }
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */