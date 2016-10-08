import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;

public class pua
  implements View.OnSystemUiVisibilityChangeListener
{
  public pua(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    boolean bool2 = true;
    SystemBarCompact localSystemBarCompact;
    if (paramInt == 0)
    {
      bool1 = false;
      BaseActivity.mIsInMultiScreen = bool1;
      if (this.a.mSystemBarComp != null)
      {
        localSystemBarCompact = this.a.mSystemBarComp;
        if (BaseActivity.mIsInMultiScreen) {
          break label98;
        }
      }
    }
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localSystemBarCompact.a(bool1, 0);
      if (QLog.isDevelopLevel()) {
        QLog.d("qqBaseActivity", 4, "onSystemUiVisibilityChange:" + paramInt + ",Activity name:" + getClass().getName());
      }
      return;
      bool1 = true;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */