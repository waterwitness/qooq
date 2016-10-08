import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.CallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jaj
  implements Runnable
{
  public jaj(CustomAccessibilityDelegate paramCustomAccessibilityDelegate)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (CustomAccessibilityDelegate.a(this.a) != null) {
      CustomAccessibilityDelegate.a(this.a).b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */