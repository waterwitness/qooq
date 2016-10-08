package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import friendlist.EAddFriendSourceID;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import klw;
import klx;
import kly;
import klz;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class AutoRemarkActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final String a = "AutoRemarkActivity";
  public static final int b = 1;
  public static final String b = "param_mode";
  static final int jdField_c_of_type_Int = 0;
  public static final String c = "param_return_addr";
  public static final String d = "key_back_from_add_friend";
  public static final String e = "param_return_profilecard_pa";
  private static final String jdField_g_of_type_JavaLangString = "k_msg_key";
  private static final int i = 1001;
  private static final int j = 1002;
  public Dialog a;
  View jdField_a_of_type_AndroidViewView;
  public EditText a;
  public TextView a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public FriendListHandler a;
  public BusinessCardManager a;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver;
  public BusinessCard a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private klz jdField_a_of_type_Klz;
  private View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private View jdField_c_of_type_AndroidViewView;
  public int d;
  private View d;
  int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  public int f;
  public String f;
  int jdField_g_of_type_Int;
  public int h;
  
  public AutoRemarkActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentImageURLImageView = null;
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = null;
    this.jdField_a_of_type_Klz = new klz(this, null);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new klx(this);
  }
  
  private static int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      if (paramString.length % 3 == 0) {
        return paramString.length / 3;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
    return paramString.length / 3 + 1;
  }
  
  public static String a(String paramString)
  {
    while (a(paramString) > 32)
    {
      int k = paramString.length();
      if ((k >= 2) && (Character.isHighSurrogate(paramString.charAt(k - 2)))) {
        paramString = paramString.substring(0, k - 2);
      } else {
        paramString = paramString.substring(0, k - 1);
      }
    }
    return paramString;
  }
  
  private void a(int paramInt)
  {
    Object localObject;
    if (this.jdField_d_of_type_Int == 0)
    {
      localObject = getString(2131369390);
      setTitle((CharSequence)localObject);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131297117);
      this.c = findViewById(2131297119);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297118));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297120));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_f_of_type_Int));
      this.c.setContentDescription("分组：" + a(this.jdField_f_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.c.setOnClickListener(this);
      localObject = "";
      if (d())
      {
        String str = getIntent().getStringExtra("nick_name");
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("AutoRemarkActivity", 2, "initUI remark = " + str + ", source id=" + this.jdField_e_of_type_Int);
          localObject = str;
        }
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject).length());
      }
      b();
      if ((!EAddFriendSourceID.a(this.jdField_e_of_type_Int)) && (this.jdField_e_of_type_Int != 3016)) {
        break label484;
      }
      paramInt = 1;
      label248:
      if (paramInt == 0)
      {
        this.jdField_d_of_type_AndroidViewView = findViewById(2131297126);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        findViewById(2131297130).setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131297127));
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      if (this.jdField_d_of_type_Int != 0) {
        break label489;
      }
      setRightHighlightButton(2131368951, this);
      enableRightHighlight(true);
      setLeftViewName(getIntent());
    }
    for (;;)
    {
      if (AppSetting.j)
      {
        this.leftView.setContentDescription("返回" + this.leftView.getText().toString() + "界面");
        this.jdField_b_of_type_AndroidViewView.setFocusable(true);
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131367739) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(null);
        if (paramInt == 0)
        {
          this.jdField_d_of_type_AndroidViewView.setFocusable(true);
          this.jdField_d_of_type_AndroidViewView.setContentDescription(getResources().getString(2131369386));
          findViewById(2131297130).setFocusable(true);
        }
      }
      return;
      localObject = "好友设置";
      break;
      label484:
      paramInt = 0;
      break label248;
      label489:
      setRightHighlightButton(2131368729, this);
      enableRightHighlight(true);
      setLeftButton(2131367262, this);
      if (this.jdField_d_of_type_Int == 1)
      {
        this.jdField_e_of_type_AndroidViewView = findViewById(2131297128);
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject = (TextView)findViewById(2131297130);
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(2131371904);
        ((TextView)localObject).setContentDescription(getString(2131371904));
        this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131297129));
        if (AppSetting.j)
        {
          this.jdField_e_of_type_AndroidViewView.setContentDescription("收起到不常联系好友 ");
          this.jdField_e_of_type_AndroidViewView.setFocusable(true);
        }
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        this.leftView.setVisibility(8);
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "startAutoRemarkActivity, " + paramString);
    }
    Intent localIntent = new Intent(paramActivity, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 1);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("k_msg_key", paramLong);
    paramActivity.startActivityForResult(localIntent, paramInt);
    paramActivity.overridePendingTransition(2130968793, 2130968589);
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_d_of_type_Int == 0)
    {
      int k = getIntent().getIntExtra("sub_source_id", 0);
      if ((this.jdField_e_of_type_Int != 3026) || (k != 0))
      {
        bool1 = bool2;
        if (!EAddFriendSourceID.a(this.jdField_e_of_type_Int)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0) {}
    while ((paramInt1 == 100) && (!paramBoolean)) {
      return true;
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297121);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297124));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131297125));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(111));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(this.jdField_f_of_type_JavaLangString);
    structmsg.StructMsg localStructMsg;
    Oidb_0x43c.CardInfo localCardInfo;
    if ((this.jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null))
    {
      long l = FriendSystemMsgController.a().b();
      localStructMsg = FriendSystemMsgController.a().a(Long.valueOf(l));
      if ((localStructMsg != null) && (localStructMsg.msg.req_uin_business_card.has()) && (localStructMsg.msg.card_switch.has()) && (localStructMsg.msg.card_switch.get() == 1)) {
        localCardInfo = new Oidb_0x43c.CardInfo();
      }
    }
    try
    {
      localCardInfo.mergeFrom(localStructMsg.msg.req_uin_business_card.get().toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = new BusinessCard();
      BusinessCardServlet.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, localCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId = null;
      c();
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "decode CardInfo failed!");
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 0, 2131367263, null, new klw(this));
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Throwable paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AutoRemarkActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private void c()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company)) {
        break label59;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company;
    }
    for (;;)
    {
      BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_b_of_type_AndroidWidgetTextView, str);
      return;
      label59:
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.descs != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.descs.size() > 0) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.descs.get(0)))) {
        str = (String)this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.descs.get(0);
      } else if (TextUtils.isEmpty(str)) {
        str = "";
      }
    }
  }
  
  private boolean c()
  {
    return (!EAddFriendSourceID.a(this.jdField_e_of_type_Int)) && (this.jdField_e_of_type_Int != 3016) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!this.jdField_f_of_type_JavaLangString.equals(String.valueOf(0L)));
  }
  
  private void d()
  {
    ThreadManager.b().post(new kly(this));
  }
  
  private boolean d()
  {
    return (EAddFriendSourceID.a(this.jdField_e_of_type_Int)) || (this.jdField_e_of_type_Int == 3016) || (this.jdField_e_of_type_Int == 3003);
  }
  
  public String a(int paramInt)
  {
    Groups localGroups = ((FriendsManager)this.app.getManager(50)).a(paramInt + "");
    if (localGroups != null) {
      return localGroups.group_name;
    }
    return "";
  }
  
  public void a()
  {
    Object localObject = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "goBack | retAddr = " + (String)localObject);
    }
    if (localObject != null) {
      try
      {
        localObject = Class.forName((String)localObject);
        Intent localIntent2 = new Intent();
        localIntent2.setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject).getName()));
        if ((localObject.equals(FriendProfileCardActivity.class)) || (localObject.equals(QidianProfileCardActivity.class))) {
          localIntent2.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_f_of_type_JavaLangString, this.g));
        }
        for (;;)
        {
          localIntent2.setFlags(67108864);
          localIntent2.putExtra("key_back_from_add_friend", true);
          startActivity(localIntent2);
          return;
          if (localObject.equals(NearbyPeopleProfileActivity.class))
          {
            localIntent2.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_f_of_type_JavaLangString, 41));
            localIntent2.putExtra("param_mode", 3);
          }
        }
        if (!getIntent().getBooleanExtra("from_newer_guide", false)) {
          break label270;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "goBack | exception = ", localClassNotFoundException);
        }
        localClassNotFoundException.printStackTrace();
        setResult(-1);
        finish();
        return;
      }
    }
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("has_operation", true);
    localIntent1.putExtra("uin", this.jdField_f_of_type_JavaLangString);
    setResult(-1, localIntent1);
    for (;;)
    {
      finish();
      return;
      label270:
      setResult(-1);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (a(paramEditable) > 32)
    {
      int k = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = a(paramEditable);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (k >= paramEditable.length()) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.j) {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131367739) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1001: 
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      this.jdField_f_of_type_Int = paramInt1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramInt1));
      this.c.setContentDescription("分组：" + a(paramInt1));
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("has_local_remark");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(this.jdField_f_of_type_JavaLangString);
    c();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903103);
    setContentBackgroundResource(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    Intent localIntent = getIntent();
    this.jdField_d_of_type_Int = localIntent.getIntExtra("param_mode", 0);
    this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_e_of_type_Int = getIntent().getIntExtra("source_id", 10004);
    this.g = getIntent().getIntExtra("param_return_profilecard_pa", 19);
    a(this.jdField_e_of_type_Int);
    this.app.a(this.jdField_a_of_type_Klz);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    if (((paramBundle == null) || (this.jdField_d_of_type_Int == 1)) && (NetworkUtil.e(this)) && (c())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_Int, getIntent().getIntExtra("sub_source_id", 0));
    }
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      super.doOnDestroy();
      this.app.b(this.jdField_a_of_type_Klz);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this.app.a(), 1, getString(2131368805), 0).b(getTitleBarHeight());
      paramCompoundButton.setOnCheckedChangeListener(null);
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      paramCompoundButton.setOnCheckedChangeListener(this);
    }
    do
    {
      do
      {
        return;
        if (paramCompoundButton != this.jdField_b_of_type_ComTencentWidgetSwitch) {
          break;
        }
        paramCompoundButton = new ArrayList(1);
        paramCompoundButton.add(this.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((short)1, paramCompoundButton, paramBoolean);
        if (this.jdField_b_of_type_ComTencentWidgetSwitch.isChecked()) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004C59", "0X8004C59", 0, 0, "", "", "", "");
        }
      } while ((!this.app.d(true)) || (!paramBoolean) || (this.jdField_a_of_type_ComTencentWidgetSwitch == null));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      return;
    } while (paramCompoundButton != this.jdField_a_of_type_ComTencentWidgetSwitch);
    if (AppSetting.j) {
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getResources().getString(2131369386));
    }
    paramCompoundButton = new Intent("com.tencent.qzone.action.OperateQZonePermission");
    paramCompoundButton.putExtra("qzone_permission_uin", this.jdField_f_of_type_JavaLangString);
    paramCompoundButton.putExtra("qzone_permission_operateType", 1);
    paramCompoundButton.putExtra("qzone_permission_value", paramBoolean);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "QQ空间";
    localPluginParams.b = QzonePluginProxyActivity.a();
    localPluginParams.jdField_a_of_type_JavaLangString = this.app.a();
    localPluginParams.e = "com.qzone.permissionsetting.business.QZonePermissionReciver";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramCompoundButton;
    IPluginManager.a(this.app.a(), localPluginParams);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(this.jdField_f_of_type_JavaLangString);
      setResult(-1);
      finish();
      overridePendingTransition(2130968589, 2130968795);
    case 2131297119: 
    case 2131297126: 
    case 2131297183: 
      label274:
      label481:
      label495:
      do
      {
        return;
        paramView = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_f_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_f_of_type_Int);
        paramView.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
        startActivityForResult(paramView, 1001);
        return;
        paramView = QZoneHelper.UserInfo.a();
        paramView.jdField_a_of_type_JavaLangString = this.app.a();
        paramView.b = this.app.b();
        QZoneHelper.a(this, paramView, Long.valueOf(this.jdField_f_of_type_JavaLangString).longValue(), -1);
        return;
        if (!NetworkUtil.e(this))
        {
          QQToast.a(this.app.a(), 1, getString(2131368805), 0).b(getTitleBarHeight());
          return;
        }
        a(2131368647, 1000L, true);
        if (this.jdField_d_of_type_Int == 0)
        {
          paramView = getIntent();
          int n = paramView.getIntExtra("sub_source_id", 0);
          if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
          {
            if (!a()) {
              break label481;
            }
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin = null;
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindMobile = this.jdField_f_of_type_JavaLangString;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId)) {
              break label495;
            }
            BusinessCardServlet.a(this.app, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, false);
            if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl))) {
              this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(false);
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(this.jdField_f_of_type_JavaLangString);
            int m = paramView.getIntExtra("friend_setting", 0);
            int k = m;
            if (m == 3) {
              k = 100;
            }
            boolean bool = paramView.getBooleanExtra("contact_bothway", false);
            localObject = paramView.getStringExtra("src_name");
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, paramView.getStringExtra("extra"), k, (byte)this.jdField_f_of_type_Int, paramView.getStringExtra("msg"), this.jdField_e_of_type_Int, n, true, paramView.getByteArrayExtra("sig"), bool, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), (String)localObject, paramView.getByteExtra("show_my_card", (byte)0));
            if (a(k, this.jdField_e_of_type_Int, bool)) {
              break;
            }
            ((FriendsManager)this.app.getManager(50)).a(this.jdField_f_of_type_JavaLangString, true);
            return;
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin = this.jdField_f_of_type_JavaLangString;
            break label274;
            BusinessCardServlet.b(this.app, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, false);
          }
        }
      } while (this.jdField_d_of_type_Int != 1);
      a(2131368647, 1000L, true);
      this.h = 0;
      paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin = this.jdField_f_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId))
        {
          BusinessCardServlet.a(this.app, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, false);
          return;
        }
        BusinessCardServlet.b(this.app, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, false);
        return;
      }
      if (paramView.length() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, paramView, false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_f_of_type_JavaLangString, (byte)this.jdField_f_of_type_Int, (byte)0);
      return;
    }
    paramView = new BusinessCard();
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
    }
    Object localObject = new Intent(this, BusinessCardEditActivity.class);
    ((Intent)localObject).putExtra("mode_type", 2);
    paramView.bindUin = this.jdField_f_of_type_JavaLangString;
    ((Intent)localObject).putExtra("cur_card_body", paramView);
    ((Intent)localObject).putExtra("is_edit_mode", true);
    ((Intent)localObject).putExtra("has_local_remark", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
    startActivityForResult((Intent)localObject, 1002);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AutoRemarkActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */