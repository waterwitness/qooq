package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public class NowLoadApkActivity
  extends ContainerActivity
{
  public NowLoadApkActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.flags |= 0x10;
    localLayoutParams.flags |= 0x8;
    localLayoutParams.flags |= 0x80;
    paramBundle.addFlags(16);
    paramBundle.addFlags(8);
    localLayoutParams.alpha = 0.0F;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle = (BaseApplicationImpl)MobileQQ.getContext();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\NowLoadApkActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */