package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoMagicStickUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import lfo;

public class DirectForwardActivity
  extends BaseActivity
{
  public static final String a = "toUin";
  public static final String b = "uinType";
  public static final String c = "troopUin";
  public static final String d = "nickName";
  public static final String e = "openerProc";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
  public String f;
  
  public DirectForwardActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  private void a()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    Object localObject = new Bundle(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a());
    ((Bundle)localObject).putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Bundle)localObject).putBoolean("PhotoConst.IS_FORWARD", true);
    ((Bundle)localObject).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    ((Bundle)localObject).putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localIntent.putExtra("isBack2Root", false);
    localIntent.putExtras((Bundle)localObject);
    localObject = ((Bundle)localObject).getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    PhotoUtils.a(this, localIntent, localArrayList, 0, true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().getString("EditImagePath");
    } while (TextUtils.isEmpty(paramIntent));
    String str = this.app.getAccount();
    PhotoMagicStickUtils.a(paramIntent, this, true, 4, str, this.app.b(), this.app.a(false, str));
    overridePendingTransition(2130968620, 2130968621);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "forward form,DirectForwardActivity doOnCreate()");
    }
    paramBundle = getIntent();
    if ((paramBundle != null) && (this.app.isLogin()))
    {
      this.f = paramBundle.getStringExtra("openerProc");
      String str1 = paramBundle.getStringExtra("toUin");
      String str2 = paramBundle.getStringExtra("troopUin");
      String str3 = paramBundle.getStringExtra("nickName");
      int i = paramBundle.getIntExtra("uinType", 0);
      Bundle localBundle = paramBundle.getExtras();
      if (localBundle != null)
      {
        if (!localBundle.containsKey("uin")) {
          paramBundle.putExtra("uin", str1);
        }
        if (!localBundle.containsKey("troop_uin")) {
          paramBundle.putExtra("troop_uin", str2);
        }
        if (!localBundle.containsKey("uintype")) {
          paramBundle.putExtra("uintype", i);
        }
        if (!localBundle.containsKey("uinname")) {
          paramBundle.putExtra("uinname", str3);
        }
      }
      if ((paramBundle.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (paramBundle.getBooleanExtra("qqfav_extra_from_system_share", false))) {
        overridePendingTransition(0, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(getIntent(), this.app, this);
      i = ForwardAbility.ForwardAbilityType.b.intValue();
      if (AppConstants.au.equals(str1)) {
        i = ForwardAbility.ForwardAbilityType.g.intValue();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(i, paramBundle.getExtras());
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.tencent.process.exit");
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lfo(this);
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        }
        if (BaseApplicationImpl.c > 0L) {
          Log.d("AutoMonitor", "actStartFav, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.c));
        }
        return true;
        if (AppConstants.aj.equals(str1)) {
          i = ForwardAbility.ForwardAbilityType.f.intValue();
        } else if (AppConstants.ak.equals(str1)) {
          i = ForwardAbility.ForwardAbilityType.l.intValue();
        } else if ("-1010".equals(str1)) {
          i = ForwardAbility.ForwardAbilityType.e.intValue();
        }
      }
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.q();
    }
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      super.doOnDestroy();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "qqBaseActivity onNewIntent()");
    }
    boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    boolean bool2 = paramIntent.getBooleanExtra("isFromFavorites", false);
    if ((bool1) && (bool2))
    {
      paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putBoolean("FORWARD_IS_EDITED", true);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("forward_filepath", paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
      a();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\DirectForwardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */