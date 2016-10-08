package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import cooperation.qzone.plugin.QZonePluginManger;

public class GetQZoneFeeds
  extends AsyncStep
{
  public static boolean a;
  
  public GetQZoneFeeds()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    jdField_a_of_type_Boolean = true;
    ((QzoneContactsFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(90)).a();
    ((QZonePluginManger)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(174)).a();
    return super.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetQZoneFeeds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */