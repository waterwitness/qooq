import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.List;

public class vpp
  extends Handler
{
  public vpp(TroopFileManager paramTroopFileManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (List)arrayOfObject[0];
      boolean bool = ((Boolean)arrayOfObject[1]).booleanValue();
      String str = (String)arrayOfObject[2];
      long l = ((Long)arrayOfObject[3]).longValue();
      this.a.a(paramMessage, bool, str, l);
      return;
    case 2: 
      paramMessage = (TroopFileInfo)arrayOfObject[0];
      this.a.f(paramMessage);
      return;
    case 3: 
      paramMessage = (TroopFileInfo)arrayOfObject[0];
      this.a.g(paramMessage);
      return;
    case 4: 
      paramMessage = (TroopFileInfo)arrayOfObject[0];
      this.a.h(paramMessage);
      return;
    case 5: 
      int i = paramMessage.arg1;
      this.a.a(i);
      return;
    }
    paramMessage = (TroopFileInfo)arrayOfObject[0];
    this.a.j(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */