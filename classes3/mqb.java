import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mqb
  implements Runnable
{
  public mqb(TroopDisbandActivity paramTroopDisbandActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.a.app.a(20);
      if (localTroopHandler != null)
      {
        long l = Long.parseLong(this.a.b);
        localTroopHandler.a(l, 0L, 5, null, 6, 1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(l));
        localTroopHandler.a(localArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.disband", 2, localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */