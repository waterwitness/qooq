import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class wfv
  implements Runnable
{
  wfv(wfu paramwfu)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = VipVideoPlayActivity.a(this.a.a);
    this.a.a.a("play_success", 0, 0, l1 - l2, "");
    if (VipVideoPlayActivity.a(this.a.a) != null) {
      VipVideoPlayActivity.a(this.a.a).start();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */