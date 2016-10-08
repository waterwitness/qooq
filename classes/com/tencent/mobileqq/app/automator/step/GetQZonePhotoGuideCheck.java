package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;

public class GetQZonePhotoGuideCheck
  extends AsyncStep
{
  public static boolean a;
  
  public GetQZonePhotoGuideCheck()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    jdField_a_of_type_Boolean = true;
    QzoneAlbumRedTouchManager localQzoneAlbumRedTouchManager = (QzoneAlbumRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(103);
    if (localQzoneAlbumRedTouchManager != null) {
      localQzoneAlbumRedTouchManager.c();
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetQZonePhotoGuideCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */