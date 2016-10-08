import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.widget.QQToast;

public class ocy
  extends Handler
{
  public ocy(TroopChatPie paramTroopChatPie, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          return;
          this.a.a(null, false);
          return;
          paramMessage = paramMessage.obj;
        } while (!(paramMessage instanceof TroopGagMgr.SelfGagInfo));
        this.a.a((TroopGagMgr.SelfGagInfo)paramMessage);
        return;
        boolean bool = ((Boolean)paramMessage.obj).booleanValue();
        this.a.h(bool);
        return;
      } while (TroopChatPie.i(this.a) == null);
      TroopChatPie.j(this.a).a();
      return;
    case 5: 
      String str = (String)paramMessage.obj;
      int i = paramMessage.arg1;
      QQToast.a(this.a.a, str, i).b(this.a.a.getTitleBarHeight());
      return;
    case 6: 
      this.a.aN();
      return;
    }
    this.a.aH();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ocy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */