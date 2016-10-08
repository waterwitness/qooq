import android.app.Activity;
import com.tencent.biz.widgets.ShareResultDialog.IShareResultCallback;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class slr
  implements ShareResultDialog.IShareResultCallback
{
  public slr(ForwardSdkBaseOption paramForwardSdkBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (ForwardRecentActivity.class.isInstance(this.a.a)) {
      if (!this.a.a.isFinishing())
      {
        if (!paramBoolean) {
          break label75;
        }
        this.a.a(0, "", "");
      }
    }
    for (;;)
    {
      if (this.a.i) {
        ForwardSdkBaseOption.a(this.a.a, true, "shareToQQ", this.a.b);
      }
      return;
      label75:
      this.a.a(-1, "未知错误!", "未知错误!");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */