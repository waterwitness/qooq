package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import plh;
import pli;
import plj;
import plk;

public class QQSpecialCareSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "key_friend_uin";
  private static final int jdField_b_of_type_Int = 0;
  public static final String b = "key_is_from_management_activity";
  private static final int jdField_c_of_type_Int = 8193;
  private static final String jdField_c_of_type_JavaLangString = "QQSpecialCareSettingActivity";
  private static final int jdField_d_of_type_Int = 8194;
  private static final int e = 8195;
  public final Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver;
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_d_of_type_JavaLangString;
  
  public QQSpecialCareSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new pli(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new plj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new plk(this);
  }
  
  private void a()
  {
    boolean bool2 = true;
    int j = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.g())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.c.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.globalSwitch == 0)
    {
      bool1 = false;
      ((FormSwitchItem)localObject).setChecked(bool1);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch != 0) {
        break label377;
      }
      bool1 = false;
      label245:
      ((FormSwitchItem)localObject).setChecked(bool1);
      localObject = this.c;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch == 0) {
        bool1 = false;
      }
      ((FormSwitchItem)localObject).setChecked(bool1);
      bool1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!bool1) {
        break label383;
      }
      i = 0;
      label300:
      ((FormSwitchItem)localObject).setVisibility(i);
      localObject = this.c;
      if (!bool1) {
        break label389;
      }
      i = 0;
      label317:
      ((FormSwitchItem)localObject).setVisibility(i);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (!bool1) {
        break label395;
      }
      i = 0;
      label334:
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if ((!bool1) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
        break label401;
      }
    }
    label377:
    label383:
    label389:
    label395:
    label401:
    for (int i = j;; i = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i);
      c();
      return;
      bool1 = true;
      break;
      bool1 = true;
      break label245;
      i = 8;
      break label300;
      i = 8;
      break label317;
      i = 8;
      break label334;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new plh(this));
  }
  
  private void c()
  {
    if (QvipSpecialCareManager.a(this.d, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
        b();
      }
      int i = QvipSpecialCareManager.a(this.d, this.app);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.d + ", soundId: " + i + ", soundName: " + str2);
      }
      FormSimpleItem localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getString(2131368871);
      }
      localFormSimpleItem.setRightText(str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131368871));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904365);
    setTitle(2131371039);
    setLeftViewName(2131367975);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302529));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302530);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302531));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.c = ((FormSwitchItem)findViewById(2131302533));
    this.c.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131302534);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302532));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.d = getIntent().getStringExtra("key_friend_uin");
    if (this.app != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "doOnCreate mFriUin: " + this.d);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  public void finish()
  {
    if (getIntent().getBooleanExtra("key_is_from_management_activity", false)) {
      setResult(-1);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 2;
    boolean bool2 = true;
    boolean bool1 = true;
    int j = 0;
    if (!paramCompoundButton.isPressed()) {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", NOT switched by user.");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", switched by user.");
      }
      if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (NetworkUtil.h(this))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(1, new String[] { this.d }, new boolean[] { paramBoolean });
          paramCompoundButton = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCompoundButton);
          return;
        }
        paramCompoundButton = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
        paramCompoundButton.arg1 = 0;
        paramCompoundButton.arg2 = 2131367256;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCompoundButton);
        paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          return;
        }
      }
    } while ((paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (paramCompoundButton != this.c.a()));
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      label260:
      if (!NetworkUtil.h(this)) {
        break label342;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(i, new String[] { this.d }, new boolean[] { paramBoolean });
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label397;
      }
    }
    label342:
    label397:
    for (i = j;; i = 8)
    {
      paramCompoundButton.setVisibility(i);
      return;
      if (paramCompoundButton != this.c.a()) {
        break;
      }
      i = 3;
      paramCompoundButton = this.c;
      break label260;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
      localMessage.arg1 = 0;
      localMessage.arg2 = 2131367256;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (!paramCompoundButton.a()) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        break;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (int i = 0;; i = paramView.getId()) {
      switch (i)
      {
      default: 
        return;
      }
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", "http://imgcache.qq.com/club/client/specialRing/rel/index.html?_wv=1027&suin=" + this.d + "&uin=" + this.app.a() + "&_bid=279");
    paramView.putExtra("uin", this.d);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\specialcare\QQSpecialCareSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */