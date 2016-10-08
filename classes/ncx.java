import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.HBCustomizeStrategy;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ncx
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private AppInterface a;
  
  public ncx(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramAppInterface;
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    ThreadManager.a(new ncy(this, paramRedPacketInfo), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */