import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarConfig;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qsd
  implements DeviceProfileManager.DPCObserver
{
  public qsd(DynamicAvatarManager paramDynamicAvatarManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (DynamicAvatarManager.a(this.a) != null) && (DynamicAvatarManager.a(this.a).a)) {}
    synchronized (DynamicAvatarManager.a(this.a))
    {
      DynamicAvatarManager.a(this.a).a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "---onDpcPullFinished---|mDynamicAvatarConfig:" + DynamicAvatarManager.a(this.a));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "---onDpcPullFinished---|isSuccess:" + paramBoolean);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */