package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import kic;
import kid;
import kie;
import kif;
import kig;
import kih;
import kii;
import kij;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "k_uin_type";
  public static final int b = 2;
  public static String b;
  public static final int c = 3;
  public static final String c = "stat_option";
  public static final int d = 4;
  private static final String d = "last_activity";
  private static final int jdField_e_of_type_Int = 0;
  private static final int jdField_f_of_type_Int = 1;
  public DialogInterface.OnClickListener a;
  public DialogInterface.OnDismissListener a;
  public Handler a;
  protected OpenIdObserver a;
  protected QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private kij jdField_a_of_type_Kij;
  public boolean a;
  public DialogInterface.OnClickListener b;
  private QQCustomDialog b;
  private String jdField_e_of_type_JavaLangString;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private int h;
  private int i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = "";
  }
  
  public AddFriendLogicActivity()
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new kie(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new kif(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new kig(this);
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new kii(this);
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent(paramContext, AddFriendLogicActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("k_uin_type", paramInt1);
    localIntent.putExtra("extra", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("sub_source_id", paramInt3);
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = AutoRemarkActivity.a(paramString3);
    }
    localIntent.putExtra("nick_name", paramString1);
    paramString1 = paramString4;
    if (paramString4 != null)
    {
      paramString1 = paramString4;
      if (paramString4.length() > 30) {
        paramString1 = paramString4.substring(0, 28);
      }
    }
    localIntent.putExtra("msg", paramString1);
    localIntent.putExtra("param_return_addr", paramString5);
    localIntent.putExtra("last_activity", paramString6);
    localIntent.putExtra("src_name", paramString7);
    if (paramInt2 == 10004)
    {
      paramString2 = new HashMap(4);
      paramString2.put("act", paramContext.getClass().getSimpleName());
      if (BaseActivity.sTopActivity != null) {
        break label308;
      }
    }
    label308:
    for (paramString1 = "null";; paramString1 = BaseActivity.sTopActivity.toString())
    {
      paramString2.put("top", paramString1);
      if ((paramContext instanceof Activity))
      {
        paramString1 = ((Activity)paramContext).getIntent();
        if (paramString1 != null)
        {
          paramString2.put("intent", paramString1.toString());
          paramString1 = paramString1.getExtras();
          if (paramString1 != null) {
            paramString2.put("extra", paramString1.toString());
          }
        }
      }
      StatisticCollector.a(paramContext).a(null, "addFriendSource", true, 0L, 0L, paramString2, null);
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startAddFriend Extras = " + localIntent.getExtras().toString());
      }
      return localIntent;
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramContext = new Intent(paramContext, AddFriendLogicActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("k_uin_type", 4);
    paramContext.putExtra("group_option", paramShort);
    paramContext.putExtra("troop_question", paramString3);
    paramContext.putExtra("troop_answer", paramString4);
    paramContext.putExtra("nick_name", paramString2);
    paramContext.putExtra("stat_option", paramInt);
    paramContext.putExtra("param_return_addr", paramString5);
    paramContext.putExtra("last_activity", paramString6);
    paramContext.putExtra("authKey", paramString7);
    return paramContext;
  }
  
  private boolean a()
  {
    Object localObject1 = getIntent();
    this.h = ((Intent)localObject1).getIntExtra("source_id", 10004);
    this.jdField_g_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("extra");
    if (!a(this.jdField_g_of_type_Int, this.f)) {
      return false;
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.h == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)))
    {
      localObject1 = this.app.a().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).a(TroopMemberInfo.class, new String[] { this.jdField_g_of_type_JavaLangString, this.f });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).a();
    }
    this.jdField_a_of_type_Kij = new kij(this, null);
    addObserver(this.jdField_a_of_type_Kij);
    if (this.jdField_g_of_type_Int == 1) {
      ((FriendListHandler)this.app.a(1)).a("OidbSvc.0x476_147", Long.parseLong(this.f), 147);
    }
    for (;;)
    {
      return true;
      if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        c();
      } else {
        b();
      }
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      finish();
      return false;
    case 1: 
      if (paramString.equals(this.app.a()))
      {
        QQToast.a(this, 2131368622, 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      try
      {
        Long.parseLong(paramString);
        if (((FriendsManager)this.app.getManager(50)).b(paramString))
        {
          QQToast.a(this.app.getApplication(), 2131368623, 0).b(getTitleBarHeight());
          finish();
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
    case 2: 
      if (this.h == 10004)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.h = 3006;
      }
      break;
    }
    while (!NetworkUtil.e(this))
    {
      QQToast.a(this.app.getApplication(), 2131369008, 0).b(getTitleBarHeight());
      finish();
      return false;
      if (this.h == 10004)
      {
        this.h = 3016;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "openId source id is default!");
        }
      }
    }
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    int j = getIntent().getIntExtra("sub_source_id", 0);
    localFriendListHandler.a(this.f, this.h, j, this.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368627);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new kic(this));
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private boolean b()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    int j = ((Intent)localObject).getShortExtra("group_option", (short)2);
    if (((TroopManager)this.app.getManager(51)).a(str) != null)
    {
      QQToast.a(this.app.getApplication(), 2131368625, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    if (j == 3)
    {
      localObject = getIntent().getStringExtra("nick_name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131367291);
      }
      QQToast.a(this.app.getApplication(), 2131368626, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    localObject = new Intent(this, AddFriendVerifyActivity.class);
    ((Intent)localObject).putExtras(getIntent());
    ((Intent)localObject).putExtra("friend_setting", 9);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      ((Intent)localObject).putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    startActivityForResult((Intent)localObject, 1);
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    OpenID localOpenID;
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      localOpenID = this.app.a().a(this.jdField_g_of_type_JavaLangString);
      if ((localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368627);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kid(this), 3000L);
        this.app.a(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
        this.app.a().d(this.jdField_g_of_type_JavaLangString);
      }
    }
    else
    {
      return;
    }
    if (!jdField_b_of_type_JavaLangString.equals(localOpenID.openID))
    {
      a();
      return;
    }
    b();
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.i != 0))
    {
      localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.i);
      if (localObject1 == null) {
        break label501;
      }
    }
    label207:
    label227:
    label331:
    label418:
    label430:
    label454:
    label465:
    label501:
    for (Object localObject1 = ((Bundle)localObject1).getString("AlertTitle");; localObject1 = null)
    {
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.i);
      if (localObject2 != null) {}
      for (Object localObject4 = ((Bundle)localObject2).getString("AlertText");; localObject4 = null)
      {
        localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.i);
        if (localObject2 != null) {}
        for (localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");; localObject2 = null)
        {
          Object localObject3 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.i);
          if (localObject3 != null) {}
          for (localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");; localObject3 = null)
          {
            Object localObject5 = localObject1;
            int j;
            if (localObject1 == null)
            {
              if (this.i == 1)
              {
                j = 2131367238;
                localObject5 = getString(j);
              }
            }
            else
            {
              localObject1 = localObject4;
              if (localObject4 == null)
              {
                if (this.i != 1) {
                  break label331;
                }
                localObject1 = getString(2131367240);
              }
              if (localObject2 != null) {
                break label430;
              }
              if (this.i != 1) {
                break label418;
              }
              this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
              localObject4 = localObject2;
              if (localObject3 != null) {
                break label465;
              }
              if (this.i != 1) {
                break label454;
              }
              localObject2 = getString(2131367246);
            }
            for (;;)
            {
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject5);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject4, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton((String)localObject2, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
              if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
                this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131297852).setVisibility(8);
              }
              return;
              j = 2131367239;
              break;
              if (this.i == 2)
              {
                localObject1 = getString(2131367241);
                break label207;
              }
              if (this.i == 3)
              {
                localObject1 = getString(2131367242);
                break label207;
              }
              if (this.i == 4)
              {
                localObject1 = getString(2131367243);
                break label207;
              }
              if (this.i == 5)
              {
                localObject1 = getString(2131367244);
                break label207;
              }
              localObject1 = getString(2131367245);
              break label207;
              localObject4 = getString(2131367247);
              break label227;
              localObject4 = localObject2;
              if (!TextUtils.isEmpty(((String)localObject2).trim())) {
                break label227;
              }
              this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
              localObject4 = localObject2;
              break label227;
              localObject2 = getString(2131367248);
              continue;
              if (TextUtils.isEmpty(((String)localObject3).trim())) {
                this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = null;
              }
              localObject2 = localObject3;
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131364481);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131364602);
    kih localkih = new kih(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131367262, localkih);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131364482, localkih);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList paramArrayList, Class paramClass)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtras(getIntent());
    paramClass.putExtra("param_mode", 0);
    paramClass.putExtra("friend_setting", paramInt);
    paramClass.putExtra("contact_bothway", paramBoolean);
    paramClass.putExtra("user_question", paramArrayList);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(paramClass);
      finish();
      return;
    }
    startActivityForResult(paramClass, 1);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("k_uin_type", 0);
    this.f = paramBundle.getStringExtra("uin");
    this.e = paramBundle.getStringExtra("last_activity");
    if ((this.f == null) || (this.f.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "uin should not be null, activity finish");
      }
      super.finish();
      return false;
    }
    if (this.jdField_g_of_type_Int == 4) {
      return b();
    }
    return a();
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_Kij != null) {
      removeObserver(this.jdField_a_of_type_Kij);
    }
    if (this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    }
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  protected String setLastActivityName()
  {
    if (this.e != null) {
      return this.e;
    }
    return super.setLastActivityName();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AddFriendLogicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */