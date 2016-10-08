package com.tencent.av.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gyn;

public class SysCallTransparentActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "pstn_dialog_type";
  public static final int b = 2;
  public static final String b = "pstn_guide_title";
  public static final int c = 3;
  public static final String c = "pstn_guide_content";
  public static final String d = "pstn_guide_confirm";
  Handler a;
  public int d;
  public String e;
  public String f;
  public String g;
  
  public SysCallTransparentActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new Handler();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.e = getIntent().getStringExtra("pstn_guide_title");
    this.f = getIntent().getStringExtra("pstn_guide_content");
    this.g = getIntent().getStringExtra("pstn_guide_confirm");
    this.d = getIntent().getIntExtra("pstn_dialog_type", 3);
    this.a.postDelayed(new gyn(this), 300L);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.removeCallbacksAndMessages(null);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\SysCallTransparentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */