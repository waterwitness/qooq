import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ContextMenuTextView;

public class wll
  implements View.OnClickListener
{
  public wll(ContextMenuTextView paramContextMenuTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131305407)
    {
      paramView = ContextMenuTextView.a(this.a);
      ContextMenuTextView.a(this.a);
      ((ClipboardManager)paramView.getSystemService("clipboard")).setText(this.a.getText().toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */