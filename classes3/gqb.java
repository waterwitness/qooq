import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.av.ui.BeautySettingUi;
import com.tencent.av.widget.BidirectionSeekBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gqb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public gqb(BeautySettingUi paramBeautySettingUi)
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */