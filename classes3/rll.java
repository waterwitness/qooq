import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rll
  extends Handler
{
  public rll(EquipmentLockImpl paramEquipmentLockImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */