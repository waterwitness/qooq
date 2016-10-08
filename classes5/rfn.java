import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicBoolean;

public class rfn
  implements Runnable
{
  public rfn(HotChatFlashPicActivity paramHotChatFlashPicActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (HotChatFlashPicActivity.a(this.a)) {
      HotChatFlashPicActivity.c(this.a, HotChatFlashPicActivity.d(this.a));
    }
    HotChatFlashPicActivity.a(this.a).set(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */