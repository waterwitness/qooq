package com.tencent.av.ui;

import com.tencent.av.funchat.magicface.MagicfaceViewControllerForAV.OnMagicPlayEnd;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AVActivity$MagicPlayListener
  implements MagicfaceViewControllerForAV.OnMagicPlayEnd
{
  public AVActivity$MagicPlayListener(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    AVActivity localAVActivity = this.a;
    localAVActivity.q -= 1;
    if (this.a.q <= 0) {
      this.a.q = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\AVActivity$MagicPlayListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */