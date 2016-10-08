package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class UpdateBubbleZip
  extends Step
{
  private static final String a = "classic_emoticon";
  
  protected boolean a()
  {
    TroopNotificationUtils.a();
    FileUtils.a(BaseApplicationImpl.a.getDir("classic_emoticon", 0).getPath());
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\UpdateBubbleZip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */