import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatusEditText;

public class uhz
  implements View.OnKeyListener
{
  public uhz(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (paramKeyEvent.getAction() == 0))
    {
      this.a.b();
      return true;
    }
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && (EditActivity.a(this.a).actionId != 0) && (EditActivity.a(this.a).getSelectionStart() == "[S]".length()))
    {
      EditActivity.a(this.a).actionId = 0;
      EditActivity.a(this.a).actionText = "";
      EditActivity.a(this.a, false);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */