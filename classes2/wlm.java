import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ContextMenuTextView;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class wlm
  implements BubblePopupWindow.OnDismissListener
{
  wlm(ContextMenuTextView paramContextMenuTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 16) {
      ContextMenuTextView.a(this.a, null);
    }
    for (;;)
    {
      this.a.a = null;
      return;
      ContextMenuTextView.b(this.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */