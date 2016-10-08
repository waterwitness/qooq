package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qjl;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private HotChatObserver a;
  
  public GetJoinedHotChatListStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b)) {
      return 7;
    }
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(35);
    localHotChatHandler.b();
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new qjl(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    localHotChatHandler.a();
    return 2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetJoinedHotChatListStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */