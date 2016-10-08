import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kaw
  extends SecSvcObserver
{
  public kaw(DeviceMsgHandle paramDeviceMsgHandle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (paramInt == 1)
      {
        EquipmentLockImpl.a().a(this.a.b, BaseApplicationImpl.a(), this.a.b.a(), true);
        return;
      }
      EquipmentLockImpl.a().a(this.a.b, BaseApplicationImpl.a(), this.a.b.a(), false);
      return;
    }
    EquipmentLockImpl.a().a(this.a.b, BaseApplicationImpl.a(), this.a.b.a(), false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */