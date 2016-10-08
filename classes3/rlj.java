import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class rlj
  extends FriendListObserver
{
  public rlj(EquipLockWebImpl paramEquipLockWebImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void c(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramBoolean) {
      EquipmentLockImpl.a().a(paramArrayList);
    }
    for (;;)
    {
      EquipLockWebImpl.a(this.a, false);
      EquipLockWebImpl.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rlj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */