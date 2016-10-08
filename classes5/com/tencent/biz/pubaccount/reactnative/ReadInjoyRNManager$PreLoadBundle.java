package com.tencent.biz.pubaccount.reactnative;

import com.facebook.react.bridge.UiThreadUtil;
import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.bundle.BundleListener;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hwc;

public class ReadInjoyRNManager$PreLoadBundle
  extends BundleListener
{
  public ReadInjoyRNManager$PreLoadBundle()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadSuccess(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInjoyRNManager.a, 2, "onLoadSuccess");
    }
    if ((ReadInjoyRNManager.c) || (ReadInjoyRNManager.b) || (!RNPreDownloadFacade.a())) {
      return;
    }
    UiThreadUtil.runOnUiThread(new hwc(this, paramBundle));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\reactnative\ReadInjoyRNManager$PreLoadBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */