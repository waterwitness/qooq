import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;

public class onw
  implements DialogInterface.OnKeyListener
{
  public onw(BaseActivityView paramBaseActivityView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (this.a.a.c()) && (NetworkUtil.e(this.a.getContext()));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */