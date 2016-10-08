import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;

public class uie
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public uie(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (EditActivity.n - (localRect.bottom - localRect.top) > EditActivity.n / 5) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.a.b.setVisibility(0);
      return;
    }
    this.a.b.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */