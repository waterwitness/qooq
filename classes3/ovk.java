import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import mqq.os.MqqHandler;

public class ovk
  implements PhoneContactManager.IPhoneContactListener
{
  public ovk(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt)
  {
    BannerManager.a(this.a).removeMessages(11);
    BannerManager.a(this.a).sendEmptyMessageDelayed(11, 1000L);
  }
  
  public void c(int paramInt) {}
  
  public void d(int paramInt)
  {
    if ((paramInt & 0x1) != 0)
    {
      BannerManager.a(this.a).removeMessages(11);
      BannerManager.a(this.a).sendEmptyMessageDelayed(11, 1000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */