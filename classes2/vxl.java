import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vxl
  implements Runnable
{
  public vxl(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.a.sendAccessibilityEvent(128);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */