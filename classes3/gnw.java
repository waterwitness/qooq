import android.telephony.PhoneStateListener;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gnw
  extends PhoneStateListener
{
  public gnw(BaseSmallScreenService paramBaseSmallScreenService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    this.a.a(paramInt, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */