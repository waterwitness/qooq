import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.BubblePopupWindow;

public final class wae
  extends TextView
{
  public wae(Context paramContext, BubblePopupWindow paramBubblePopupWindow)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    this.a.b();
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */