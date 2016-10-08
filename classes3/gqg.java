import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.av.ui.BeautyToolbar;
import com.tencent.av.widget.BidirectionSeekBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gqg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public gqg(BeautyToolbar paramBeautyToolbar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    if ((this.a.b) && (this.a.a != null) && (this.a.a.getWidth() > 0))
    {
      this.a.b = false;
      this.a.a(this.a.a.getProgress());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */