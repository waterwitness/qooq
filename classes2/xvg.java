import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.TipsPopupWindow;

public class xvg
  implements Runnable
{
  public xvg(TipsPopupWindow paramTipsPopupWindow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TipsPopupWindow.a(this.a);
    TipsPopupWindow.a(this.a, false);
    TipsPopupWindow.b(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */