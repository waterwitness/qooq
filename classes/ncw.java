import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.HBCustomizeStrategy;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public class ncw
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private AppInterface a;
  
  public ncw(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramAppInterface;
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    Resources localResources = this.a.getApplication().getResources();
    if (paramRedPacketInfo.jdField_a_of_type_Boolean) {}
    for (int i = 2130841767;; i = 2130841766)
    {
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = CustomizeStrategyFactory.a(localResources, i);
      CustomizeStrategyFactory.a().a(paramRedPacketInfo);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */