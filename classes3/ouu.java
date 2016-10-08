import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class ouu
  extends Handler
{
  WeakReference a;
  
  public ouu(ThemeHbFragment paramThemeHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramThemeHbFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ThemeHbFragment localThemeHbFragment = (ThemeHbFragment)this.a.get();
    Bundle localBundle = paramMessage.getData();
    if (localBundle == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      paramMessage = localBundle.getString("wish");
    } while (TextUtils.isEmpty(paramMessage));
    ThemeHbFragment.a(localThemeHbFragment).setText(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ouu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */