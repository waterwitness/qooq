package com.tencent.mobileqq.nearby;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.NearbyFlowerManager.NearbyFlowerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyChatFlowerHelper
  implements NearbyFlowerManager.NearbyFlowerListener
{
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  NearbyFlowerAnimationController jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController;
  
  public NearbyChatFlowerHelper(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  private NearbyFlowerManager a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    return (NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(123);
  }
  
  public NearbyFlowerAnimationController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController = new NearbyFlowerAnimationController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController;
  }
  
  public void a()
  {
    NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() instanceof SplashActivity)) && (SplashActivity.c != 2)) {}
    NearbyFlowerManager localNearbyFlowerManager;
    do
    {
      return;
      localNearbyFlowerManager = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((localNearbyFlowerManager == null) || (localNearbyFlowerManager.b));
    localNearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, a());
    localNearbyFlowerManager.a(this);
    localNearbyFlowerManager.e();
  }
  
  public void a(NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    if (paramNearbyFlowerMessage == null) {}
    label138:
    for (;;)
    {
      return;
      FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      boolean bool2 = false;
      boolean bool1;
      if ((!TextUtils.isEmpty(paramNearbyFlowerMessage.groupCode)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {
        bool1 = paramNearbyFlowerMessage.groupCode.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
      for (;;)
      {
        if (!bool1) {
          break label138;
        }
        paramNearbyFlowerMessage = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramNearbyFlowerMessage == null) {
          break;
        }
        paramNearbyFlowerMessage.e();
        return;
        bool1 = bool2;
        if (TextUtils.isEmpty(paramNearbyFlowerMessage.groupCode)) {
          if (!paramNearbyFlowerMessage.rUin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
          {
            bool1 = bool2;
            if (!paramNearbyFlowerMessage.sUin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public void b()
  {
    NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.a();
    }
    NearbyFlowerManager localNearbyFlowerManager = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localNearbyFlowerManager != null)
    {
      localNearbyFlowerManager.c();
      localNearbyFlowerManager.a();
    }
  }
  
  public void c()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyChatFlowerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */