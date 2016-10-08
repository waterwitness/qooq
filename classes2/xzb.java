import android.telephony.PhoneStateListener;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BTakePhotoActivity;

public class xzb
  extends PhoneStateListener
{
  public xzb(C2BTakePhotoActivity paramC2BTakePhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    Log.e("tag", "onCallStateChanged state=" + paramInt);
    if (paramInt == 1)
    {
      if (this.a.b) {
        this.a.d();
      }
      this.a.h();
      C2BTakePhotoActivity.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */