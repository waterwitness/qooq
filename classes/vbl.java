import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile;

public class vbl
  implements DeviceProfileManager.DPCObserver
{
  public vbl(RichMediaStrategy.OldEngineDPCProfile paramOldEngineDPCProfile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name());
      this.a.a(str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */