package com.tencent.mobileqq.ark.debug;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.ark.ArkAppCenterTest;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import qry;
import qrz;
import qsa;

public class ArkDebugSettingActivity
  extends IphoneTitleBarActivity
{
  public ArkDebugSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void a()
  {
    Button localButton1 = (Button)findViewById(2131301302);
    Button localButton2 = (Button)findViewById(2131301303);
    Button localButton3 = (Button)findViewById(2131301304);
    localButton1.setOnClickListener(new qry(this));
    localButton2.setOnClickListener(new qrz(this));
    localButton3.setOnClickListener(new qsa(this));
  }
  
  void a(String paramString)
  {
    int i = this.mContentView.getHeight();
    QQToast.a(this, "设置成功", 0).b(i - 20);
  }
  
  public void b()
  {
    ArkLocalAppMgr.d();
    a("设置成功");
  }
  
  public void c()
  {
    ArkLocalAppMgr.b();
    a("设置成功");
  }
  
  public void d()
  {
    ArkAppCenterTest.a(this.app);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\debug\ArkDebugSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */