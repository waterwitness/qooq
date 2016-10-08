package com.tencent.mobileqq.nearby.rn;

import android.os.SystemClock;
import com.facebook.react.bridge.UiThreadUtil;
import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.bundle.BundleListener;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import tpn;

public class NearbyRNAppManager$PreLoadBundle
  extends BundleListener
{
  public NearbyRNAppManager$PreLoadBundle()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadSuccess(String paramString, Bundle paramBundle)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a(NearbyRNAppManager.a, new Object[] { "onLoadSuccess", paramString, Long.valueOf(SystemClock.elapsedRealtime()) });
    }
    if ((!NearbyRNAppManager.b) || (NearbyRNAppManager.c) || (!RNPreDownloadFacade.a())) {
      return;
    }
    UiThreadUtil.runOnUiThread(new tpn(this, paramBundle));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyRNAppManager$PreLoadBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */