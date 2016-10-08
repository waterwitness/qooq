package com.tencent.av.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnManager;

public class GetIsLTUserActivity
  extends BaseActivity
{
  public GetIsLTUserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = new Intent();
    PstnManager localPstnManager;
    if (this.app != null)
    {
      localPstnManager = (PstnManager)this.app.getManager(142);
      if (localPstnManager == null) {}
    }
    for (int i = localPstnManager.a();; i = 0)
    {
      paramBundle.putExtra("pstnGrayFlag", i);
      setResult(-1, paramBundle);
      finish();
      return bool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\GetIsLTUserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */