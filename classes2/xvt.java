import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class xvt
  implements View.OnSystemUiVisibilityChangeListener
{
  public xvt(XPanelContainer paramXPanelContainer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      if (XPanelContainer.a != bool)
      {
        XPanelContainer.a(this.a, true);
        XPanelContainer.a = bool;
      }
      if (QLog.isColorLevel()) {
        QLog.d(XPanelContainer.a(), 2, "onSystemUiVisibilityChange..visibility =  " + paramInt + " context = " + this.a.getContext().getClass().getName());
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */