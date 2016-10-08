import android.os.Handler;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class qbi
  implements FrameSprite.OnFrameEndListener
{
  public qbi(NearbyFlowerManager paramNearbyFlowerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(NearbyFlowerManager.jdField_a_of_type_JavaLangString, 2, "onFrameEnd");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController == null)) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString;; localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f())
    {
      localObject1 = (List)this.a.d.get(localObject1);
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break;
      }
      try
      {
        NearbyFlowerMessage localNearbyFlowerMessage = (NearbyFlowerMessage)((List)localObject1).remove(0);
        if (QLog.isColorLevel()) {
          QLog.d(NearbyFlowerManager.jdField_a_of_type_JavaLangString, 2, "onFrameEndListener id:" + localNearbyFlowerMessage.pID);
        }
        this.a.jdField_b_of_type_Boolean = false;
        if (((List)localObject1).size() == 0) {
          break label182;
        }
        this.a.e();
        return;
      }
      finally {}
    }
    label182:
    this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
    this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 500L);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.a(null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */