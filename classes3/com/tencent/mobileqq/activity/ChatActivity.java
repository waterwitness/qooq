package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;

public class ChatActivity
  extends FragmentActivity
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString;
  
  public ChatActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "Q.aio.ChatActivity";
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null) {
      ((ChatFragment)localFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (!onBackEvent()) {
      super.finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ThreadRegulator.a().a(1);
    StartupTracker.b(null, "AIO_Start_cost");
    PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate strat ");
    }
    ThreadPriorityManager.a(true);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (AIOUtils.a(this, this.app, true, getIntent())) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    paramBundle = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBundle != null)
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.remove(paramBundle);
      localFragmentTransaction.add(16908290, ChatFragment.a(), ChatFragment.class.getName()).commit();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate f != null ");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate end ");
      }
      return true;
      getSupportFragmentManager().beginTransaction().add(16908290, ChatFragment.a(), ChatFragment.class.getName()).commit();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate f == null ");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy ");
    }
    if (QLog.isColorLevel())
    {
      int i = URLDrawable.getPoolSize();
      QLog.i("URLDrawableOptions", 2, "URLDrawableOptions main size " + i);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    ThreadRegulator.a().a(1);
    StartupTracker.b(null, "AIO_Start_cost");
    PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent start ");
    }
    super.doOnNewIntent(paramIntent);
    if (AIOUtils.a(this, this.app, false, getIntent())) {}
    for (;;)
    {
      return;
      super.setIntent(paramIntent);
      paramIntent = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (paramIntent != null)
      {
        paramIntent.c();
        if (!paramIntent.isVisible())
        {
          FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
          localFragmentTransaction.show(paramIntent);
          localFragmentTransaction.commitAllowingStateLoss();
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent !cf.isVisible()");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent cf != null");
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent end");
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent error cf == null");
        }
      }
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnWindowFocusChanged");
    }
    if (paramBoolean)
    {
      ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localChatFragment != null) {
        localChatFragment.b(2);
      }
    }
  }
  
  public void finish()
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.a(2);
    }
    super.finish();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      return localChatFragment.a();
    }
    return false;
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.a(paramInt);
    }
    return null;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.a(paramInt, paramDialog);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  public boolean showPreview()
  {
    SetSplash.a(this, null);
    getWindow().setFeatureInt(7, 2130903247);
    try
    {
      this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131297869).getParent());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */