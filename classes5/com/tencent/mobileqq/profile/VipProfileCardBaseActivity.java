package com.tencent.mobileqq.profile;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tuz;
import tva;
import tvc;
import tvd;
import tve;
import tvf;
import tvg;
import tvh;

public class VipProfileCardBaseActivity
  extends IphoneTitleBarActivity
{
  public static final int A = 29;
  public static final int E = 1;
  public static final int F = 2;
  public static final String a = "ProfileCard.VipProfileCardBaseActivity";
  public static final String b = "ExternAid";
  public static final String d = "CurrentTemplateId";
  public static final String e = "CurrentBackgroundId";
  public static final int f = 1;
  public static final String f = "CurrentBackgroundUrl";
  public static final int g = 2;
  public static final String g = "CurrentBackgroundColor";
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 6;
  public static final int l = 7;
  public static final int m = 8;
  public static final int n = 9;
  public static final int o = 16;
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 20;
  public static final int s = 21;
  public static final int t = 22;
  public static final int u = 23;
  public static final int v = 24;
  public static final int w = 25;
  public static final int x = 26;
  public static final int y = 27;
  public static final int z = 28;
  public int B;
  public int C;
  public int D;
  public int G;
  public int H;
  public int I;
  protected int J;
  protected float a;
  public int a;
  public long a;
  public Context a;
  public DialogInterface.OnClickListener a;
  public Handler a;
  public CardHandler a;
  protected CardObserver a;
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  public Runnable a;
  protected ArrayList a;
  protected boolean a;
  protected int b;
  public DialogInterface.OnClickListener b;
  protected QQCustomDialog b;
  protected boolean b;
  protected int c;
  public DialogInterface.OnClickListener c;
  protected String c;
  public int d;
  public DialogInterface.OnClickListener d;
  protected int e;
  public String h;
  
  public VipProfileCardBaseActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.e = 1;
    this.B = 2;
    this.C = -1;
    this.D = -1;
    this.G = 30000;
    this.jdField_a_of_type_AndroidOsHandler = new tuz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new tva(this);
    this.jdField_a_of_type_JavaLangRunnable = new tvc(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new tvd(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new tve(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new tvf(this);
    this.d = new tvg(this);
  }
  
  protected int a()
  {
    View localView = getWindow().getDecorView();
    if (localView == null) {}
    int i1;
    do
    {
      return 0;
      i1 = localView.getBottom() - localView.getTop();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "mScreenHeight : " + this.H + " realHeight : " + i1);
      }
    } while ((i1 == 0) || (i1 >= this.H));
    return this.H - i1;
  }
  
  public int a(String paramString, DownloadListener paramDownloadListener)
  {
    if (ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString)) {
      return 19;
    }
    paramString = new DownloadTask(paramString, new File(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString)));
    if (paramDownloadListener != null) {
      paramString.a(paramDownloadListener);
    }
    paramString.f = "profileCardDownload";
    paramString.e = "VIP_profilecard";
    return DownloaderFactory.a(paramString, this.app);
  }
  
  public ArrayList a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList = ProfileCardUtil.a(this.app, false, false);
      ProfileCardUtil.a(this.app);
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  protected void a() {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, null, 0);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131370908);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.app.a(new tvh(this, paramLong1, paramLong2, paramString, paramInt));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.G);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(ProfileCardBackground paramProfileCardBackground)
  {
    if (paramProfileCardBackground == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
    } while ((paramProfileCardBackground.d != 1) || (l1 >= paramProfileCardBackground.f) || (l1 <= paramProfileCardBackground.e));
    paramProfileCardBackground.jdField_c_of_type_Int = 1;
  }
  
  public void a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
    } while ((paramProfileCardTemplate.h != 1) || (l1 >= paramProfileCardTemplate.j) || (l1 <= paramProfileCardTemplate.jdField_i_of_type_Int));
    paramProfileCardTemplate.g = "1";
  }
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    Card localCard = localFriendsManager.a(this.app.a());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  protected boolean a(ProfileCardTemplate paramProfileCardTemplate, ProfileCardBackground paramProfileCardBackground, boolean paramBoolean)
  {
    if ((paramProfileCardTemplate != null) && (paramProfileCardBackground != null))
    {
      if (paramProfileCardTemplate.jdField_i_of_type_Long == 0L) {
        return true;
      }
      int i3 = Integer.valueOf(paramProfileCardTemplate.g).intValue();
      int i1 = paramProfileCardBackground.jdField_c_of_type_Int;
      boolean bool = ProfileCardUtil.a(paramProfileCardBackground);
      if (bool) {
        i1 = paramProfileCardTemplate.o;
      }
      if (i3 >= i1)
      {
        this.jdField_c_of_type_Int = 1;
        if (i3 == i1) {
          this.jdField_c_of_type_Int = 2;
        }
      }
      for (int i2 = i3;; i2 = i1)
      {
        this.jdField_b_of_type_Int = i2;
        if ((i2 != 0) && (i2 != 1)) {
          break;
        }
        return true;
        this.jdField_c_of_type_Int = 0;
      }
      if (i2 == 2)
      {
        if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Int = 1;
          if (bool) {
            this.jdField_c_of_type_JavaLangString = "mvip.gongneng.android.mingpian_zidingyi";
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
            }
            if (paramBoolean) {
              d();
            }
            return false;
            if (this.e == 1) {
              this.jdField_c_of_type_JavaLangString = ProfileCardUtil.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, i3, i1, this.jdField_a_of_type_Int);
            } else {
              this.jdField_c_of_type_JavaLangString = ProfileCardUtil.a(3);
            }
          }
        }
      }
      else if (i2 == 4)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Int = 2;
          if (bool) {
            this.jdField_c_of_type_JavaLangString = "mvip.gongneng.android.mingpian_zidingyi";
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
            }
            if (paramBoolean) {
              d();
            }
            return false;
            if (this.e == 1) {
              this.jdField_c_of_type_JavaLangString = ProfileCardUtil.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, i3, i1, this.jdField_a_of_type_Int);
            } else {
              this.jdField_c_of_type_JavaLangString = ProfileCardUtil.a(6);
            }
          }
        }
      }
      else if (i2 == 5) {
        return true;
      }
    }
    return true;
  }
  
  public long[] a()
  {
    ArrayList localArrayList = a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new long[localArrayList.size()];
        int i1 = 0;
        while (i1 < localArrayList.size())
        {
          localObject1[i1] = ((ProfileCardTemplate)localArrayList.get(i1)).jdField_i_of_type_Long;
          i1 += 1;
        }
      }
    }
    return (long[])localObject1;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    finally
    {
      localObject = finally;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      throw ((Throwable)localObject);
    }
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = VipUtils.a(this.app);
    this.jdField_a_of_type_Boolean = VipUtils.b(this.app);
  }
  
  public void d()
  {
    e();
    String str2;
    String str1;
    if (this.jdField_a_of_type_Int == 2)
    {
      str2 = getString(2131370876);
      if (this.jdField_c_of_type_Int == 2) {
        str1 = getString(2131370890);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, str2, str1, 2131370891, 2131370892, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        str1 = getString(2131370886);
      }
      else
      {
        str1 = getString(2131370888);
        continue;
        str2 = getString(2131370878);
        if (this.jdField_c_of_type_Int == 2) {
          str1 = getString(2131370889);
        } else if (this.jdField_c_of_type_Int == 1) {
          str1 = getString(2131370885);
        } else {
          str1 = getString(2131370887);
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getResources().getDisplayMetrics();
    this.I = paramBundle.widthPixels;
    this.H = paramBundle.heightPixels;
    this.J = paramBundle.densityDpi;
    this.jdField_a_of_type_Float = paramBundle.density;
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    e();
    b();
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void f()
  {
    ReportController.b(this.app, "CliOper", "", "", "Shop_templatetips", "0X8005B91", 0, 0, "", "", "", "");
    g();
    String str1 = getString(2131370881);
    String str2 = getString(2131370882);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, str1, str2, 2131370884, 2131370883, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.d);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void h()
  {
    Object localObject2 = null;
    Intent localIntent = getIntent();
    Object localObject1 = localObject2;
    if (localIntent != null)
    {
      localObject1 = localObject2;
      if (localIntent.hasExtra("ExternAid")) {
        localObject1 = localIntent.getStringExtra("ExternAid");
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = this.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 2)
      {
        VasH5PayUtil.a(this.app, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 3, "1450000516", "CJCLUBT", getString(2131371097), "svip");
        ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044E0", "0X80044E0", 0, 0, "", "", "", VipUtils.a(this.app, this.app.a()));
        return;
      }
      VasH5PayUtil.a(this.app, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 3, "1450000515", "LTMCLUB", getString(2131370893), "vip");
      ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044DF", "0X80044DF", 0, 0, "", "", "", VipUtils.a(this.app, this.app.a()));
      return;
    }
  }
  
  public void i()
  {
    Card localCard = ((FriendsManager)this.app.getManager(50)).a(this.app.a());
    if (localCard != null)
    {
      if (localCard.templateRet == 0) {
        break label114;
      }
      this.jdField_a_of_type_Long = 0L;
      this.C = -1;
      this.D = 1;
      this.h = null;
    }
    label114:
    label251:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, String.format("readInfofromDB , mCurrentStyleId : %s , mCurrentBackgroundId : %s , mCurrentBackgroundColor : %s , mCurrentBackgroundUrl : %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.C), Integer.valueOf(this.D), this.h }));
      }
      return;
      Intent localIntent = getIntent();
      if (localIntent == null)
      {
        this.jdField_a_of_type_Long = ((int)localCard.lCurrentStyleId);
        this.C = ((int)localCard.lCurrentBgId);
        this.h = localCard.backgroundUrl;
        this.D = ((int)localCard.backgroundColor);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Long != -1L) {
          break label251;
        }
        this.jdField_a_of_type_Long = 0L;
        break;
        if (!localIntent.hasExtra("CurrentTemplateId")) {
          this.jdField_a_of_type_Long = ((int)localCard.lCurrentStyleId);
        }
        if (!localIntent.hasExtra("CurrentBackgroundId")) {
          this.C = ((int)localCard.lCurrentBgId);
        }
        if (!localIntent.hasExtra("CurrentBackgroundUrl")) {
          this.h = localCard.backgroundUrl;
        }
        if (!localIntent.hasExtra("CurrentBackgroundColor")) {
          this.D = ((int)localCard.backgroundColor);
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
    {
      String str = null;
      if (paramIntent.hasExtra("result"))
      {
        Object localObject = paramIntent.getStringExtra("result");
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultStr : " + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            localObject = new JSONObject((String)localObject);
            if (localObject == null) {
              return;
            }
            localObject = ((JSONObject)localObject).get("payState");
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, stateObj : " + localObject);
            }
            if ((localObject == null) || (!"0".equals(String.valueOf(localObject)))) {
              return;
            }
            if (paramIntent.hasExtra("callbackSn")) {
              str = paramIntent.getStringExtra("callbackSn");
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, callbackSn : " + str);
            }
            if ("svip".equals(str)) {
              this.jdField_b_of_type_Boolean = true;
            }
            for (;;)
            {
              a();
              return;
              this.jdField_a_of_type_Boolean = true;
            }
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
            return;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, data contain no result key.");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\VipProfileCardBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */