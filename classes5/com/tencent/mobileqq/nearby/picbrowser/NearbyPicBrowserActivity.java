package com.tencent.mobileqq.nearby.picbrowser;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyPicBrowserActivity
  extends PicBrowserActivity
{
  public NearbyPicBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected String getModuleId()
  {
    return "module_nearby";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\picbrowser\NearbyPicBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */