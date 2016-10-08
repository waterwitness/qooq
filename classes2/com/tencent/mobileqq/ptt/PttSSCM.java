package com.tencent.mobileqq.ptt;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.wstt.SSCM.SSCM;

public class PttSSCM
  extends SSCM
{
  public PttSSCM()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Context paramContext, long paramLong)
  {
    this.b = NetworkUtil.a(BaseApplication.getContext());
    if (!this.a) {
      switch (this.b)
      {
      default: 
        this.c = 4096;
      }
    }
    for (;;)
    {
      if (paramLong < 102400L) {
        this.c *= 4;
      }
      if (paramLong - this.c <= this.c / 2) {
        this.c = ((int)paramLong);
      }
      return this.c;
      this.c = 32768;
      continue;
      this.c = 32768;
      continue;
      this.c = 16384;
      continue;
      this.c = 8192;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\PttSSCM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */