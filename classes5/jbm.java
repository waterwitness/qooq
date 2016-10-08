import android.view.View;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;

public class jbm
  implements Runnable
{
  public jbm(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    CustomAccessibilityDelegate localCustomAccessibilityDelegate = new CustomAccessibilityDelegate(this.a.d, this.a);
    this.a.d.setAccessibilityDelegate(localCustomAccessibilityDelegate);
    AccessibilityUtil.a(this.a.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */