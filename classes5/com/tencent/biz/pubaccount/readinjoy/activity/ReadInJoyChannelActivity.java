package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyHelper;
import hwo;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "channel_id";
  public static final String b = "channel_name";
  public static final String c = "channel_type";
  public static final String d = "is_channel_activity";
  public ReadInJoyBaseViewController a;
  
  public ReadInJoyChannelActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    Object localObject = (ViewStub)findViewById(2131299933);
    ((ViewStub)localObject).inflate();
    ((ViewStub)localObject).setVisibility(0);
    localObject = (ViewGroup)findViewById(2131299962);
    this.a = new ReadInJoyChannelViewController(this);
    this.a.a((ViewGroup)localObject);
    this.a.a();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    VideoVolumeControl.a().a(this);
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130903751);
    getWindow().setBackgroundDrawable(null);
    ((ReadInJoyLogicManager)this.app.getManager(162)).a();
    setClickableTitle(getIntent().getStringExtra("channel_name"), new hwo(this));
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.d();
    ((ReadInJoyLogicManager)this.app.getManager(162)).b();
    VideoVolumeControl.a().b(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.a.g();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.a.h();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ReadInJoyHelper.a(getAppRuntime());
    this.a.e();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.a.f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\activity\ReadInJoyChannelActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */