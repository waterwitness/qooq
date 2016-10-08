import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import mqq.os.MqqHandler;

class pju
  implements DialogInterface.OnClickListener
{
  pju(pjt parampjt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.a().post(new ShortVideoUtils.VideoFileSaveRunnable(this.a.a.d, this.a.a.a, this.a.a.i + ".mp4", true));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */