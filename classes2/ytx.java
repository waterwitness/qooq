import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class ytx
  extends Handler
{
  public ytx(TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131365137, 0).a();
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131365136, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131365138, 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ytx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */