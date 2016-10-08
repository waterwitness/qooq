import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class iad
  implements Runnable
{
  public iad(VideoPlayManager paramVideoPlayManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mUiHandler.postDelayed() addPlayStateButtonToVideo mIsNeedShowLoading = " + VideoPlayManager.a(this.a));
    }
    if ((VideoPlayManager.a(this.a) != null) && (VideoPlayManager.a(this.a))) {
      this.a.b(1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */