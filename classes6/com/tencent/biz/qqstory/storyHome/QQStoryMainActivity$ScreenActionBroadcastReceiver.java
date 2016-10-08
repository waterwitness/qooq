package com.tencent.biz.qqstory.storyHome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQStoryMainActivity$ScreenActionBroadcastReceiver
  extends BroadcastReceiver
{
  protected static final long a = 120000L;
  
  protected QQStoryMainActivity$ScreenActionBroadcastReceiver(QQStoryMainActivity paramQQStoryMainActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(120000L);
      SLog.d("Q.qqstory.home.QQStoryMainActivity", "screen off , preloader stop");
    }
    while (!paramContext.equals("android.intent.action.SCREEN_ON")) {
      return;
    }
    ((PreloadDownloaderManager)SuperManager.a(6)).c();
    SLog.d("Q.qqstory.home.QQStoryMainActivity", "screen on , preloader start");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\QQStoryMainActivity$ScreenActionBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */