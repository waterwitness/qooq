import android.os.IBinder.DeathRecipient;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class ggh
  implements IBinder.DeathRecipient
{
  ggh(ggg paramggg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void binderDied()
  {
    if (QLog.isColorLevel()) {
      QLog.e(VideoAppInterface.a, 2, "mobileQQ process exited ,video process exit!");
    }
    this.a.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */