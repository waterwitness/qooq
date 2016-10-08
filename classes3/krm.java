import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class krm
  implements Handler.Callback
{
  public krm(Call paramCall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.a.a.isLogin()) {}
    do
    {
      do
      {
        do
        {
          return true;
          switch (paramMessage.what)
          {
          case 1023: 
          case 1024: 
          case 1026: 
          case 1028: 
          case 1029: 
          default: 
            return false;
          case 1025: 
            Call.b(this.a);
            return true;
          case 1020: 
            Call.c(this.a);
            return true;
          case 1030: 
            Call.d(this.a);
            return true;
          }
        } while (Call.a(this.a) == null);
        Call.a(this.a).a(paramMessage);
        return true;
      } while (Call.a(this.a) == null);
      Call.a(this.a).i();
      return true;
    } while (this.a.a == null);
    this.a.a.x();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */