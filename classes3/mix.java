import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mix
  implements View.OnClickListener
{
  mix(miw parammiw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)this.a.a.getSystemService("clipboard")).setText(RegisterQQNumberActivity.a(this.a.a) + "");
      return;
    }
    ((android.content.ClipboardManager)this.a.a.getSystemService("clipboard")).setText(RegisterQQNumberActivity.a(this.a.a) + "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */