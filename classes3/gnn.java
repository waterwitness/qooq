import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.NearbyFlowerManager.NearbyFlowerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.qphone.base.util.QLog;

public class gnn
  implements NearbyFlowerManager.NearbyFlowerListener
{
  public gnn(QQServiceForAV paramQQServiceForAV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onNewMessage flowerMsgVersion: " + paramNearbyFlowerMessage.version);
    }
    if ((paramNearbyFlowerMessage == null) || (!"4".equals(paramNearbyFlowerMessage.version))) {}
    do
    {
      return;
      paramNearbyFlowerMessage = (NearbyFlowerManager)this.a.a.getManager(123);
    } while (paramNearbyFlowerMessage == null);
    paramNearbyFlowerMessage.e();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */