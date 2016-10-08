import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.RichMediaStrategy;

public class vbh
  implements DeviceProfileManager.DPCObserver
{
  public vbh(ProtoReqManager paramProtoReqManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      RichMediaStrategy.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */