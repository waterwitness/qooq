package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kgn;
import kgo;
import kgq;
import kgs;
import kgt;
import kgu;
import kgv;
import kgw;
import kgy;
import kgz;
import kha;
import khb;
import khd;
import khf;
import khg;
import khi;
import khj;
import khl;
import khn;
import kho;
import khp;
import khq;
import khr;
import khs;
import kht;
import khv;
import khw;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 9876;
  public static final String a = "IS_ADD_ACCOUNT";
  public static final boolean a = true;
  public static final int b = 5000;
  public static final String b = "is_change_account";
  public static final int c = 999;
  public static final String c = "login_from_account_change";
  public static final int d = 34;
  private static final String jdField_d_of_type_JavaLangString = "AccountManageActivity";
  public static final int e = 250;
  private static final String jdField_e_of_type_JavaLangString = "0X8004001";
  private static final int jdField_f_of_type_Int = 2010;
  private static final String jdField_f_of_type_JavaLangString = "0X8004002";
  private static final String jdField_g_of_type_JavaLangString = "0X8004456";
  private static final String h = "0X8004457";
  public float a;
  long jdField_a_of_type_Long;
  public Dialog a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  public View a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public SimpleAccount a;
  public ActionSheet a;
  public List a;
  private khw jdField_a_of_type_Khw;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private float jdField_b_of_type_Float;
  public Dialog b;
  SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean b;
  private float jdField_c_of_type_Float;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private View jdField_c_of_type_AndroidViewView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean c;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean d;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_e_of_type_Boolean;
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private String i;
  
  public AccountManageActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqOsMqqHandler = new kgn(this);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new khp(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new khq(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new kgo(this);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new kgs(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new kgt(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new kgu(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new kgv(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_Khw = new khw(this);
    this.jdField_a_of_type_MqqObserverAccountObserver = new kgy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new khg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new khi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new khj(this);
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131296816);
    }
    return null;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.i, new khv(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.i);
    }
    if (paramBoolean) {
      NearbyProxy.a(paramString);
    }
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131296828);
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject3 = (SubAccountManager)this.app.getManager(60);
    int n = ((SubAccountManager)localObject3).a();
    Object localObject1 = (LinearLayout)findViewById(2131296832);
    int k = 0;
    int m = 0;
    int j;
    Object localObject2;
    boolean bool;
    if (paramBoolean)
    {
      j = m;
      if (!this.g)
      {
        j = m;
        if (n == 0)
        {
          if (!DBUtils.a().a()) {
            break label560;
          }
          if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5000)) {
            break label533;
          }
          j = m;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("AccountManagerActivity.refreshSubAccount() isAccount2Bind=");
        if (n <= 0) {
          break label566;
        }
        bool = true;
        label115:
        QLog.d("AccountManageActivity", 2, bool);
      }
      k = j;
      if (n == 0)
      {
        ThreadManager.a(new kho(this), 8, null, false);
        k = j;
      }
    }
    if ((k == 0) && (n == 1)) {
      if (DBUtils.a().a(this.app.a())) {
        j = k;
      }
    }
    for (;;)
    {
      label189:
      label231:
      Object localObject4;
      switch (j)
      {
      default: 
        if (((LinearLayout)localObject1).getVisibility() != 8) {
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if (((LinearLayout)localObject1).getVisibility() == 0) {
          ((LinearLayout)localObject1).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        }
        localObject2 = null;
        localObject1 = null;
        if (n == 1)
        {
          localObject4 = ((SubAccountManager)localObject3).a("sub.uin.default");
          localObject2 = localObject1;
          if (localObject4 != null)
          {
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(((SubAccountInfo)localObject4).subuin))
            {
              localObject1 = ((SubAccountInfo)localObject4).subname;
              localObject3 = ContactUtils.c(this.app, ((SubAccountInfo)localObject4).subuin, true);
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if (!TextUtils.isEmpty(((SubAccountInfo)localObject4).subname))
                {
                  localObject2 = localObject1;
                  if (((String)localObject3).equals(((SubAccountInfo)localObject4).subname)) {}
                }
                else
                {
                  ((SubAccountInfo)localObject4).subname = ((String)localObject3);
                  localObject2 = localObject3;
                }
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (localObject4 != null) {
              localObject1 = ((SubAccountInfo)localObject4).subuin;
            }
          }
          label372:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("refreshSubAccount() uin=").append(this.app.a()).append(" isAccountChanged=").append(paramBoolean).append(" isAccount1Bind=").append(this.g).append(" account2BindedNum=").append(n).append(" final action=").append(j).append(" sAccountName=");
            if (((String)localObject2).length() != 0) {
              break label868;
            }
            localObject1 = "_empty_";
          }
        }
        break;
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject2);
        if (AppSetting.j) {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号" + (String)localObject2);
        }
        return;
        label533:
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          j = m;
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
            break;
          }
        }
        j = 2;
        break;
        label560:
        j = 1;
        break;
        label566:
        bool = false;
        break label115;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 4)) {
          break label938;
        }
        j = 3;
        break label189;
        DBUtils.a().a(true);
        d();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5000, 1000L);
        if (((LinearLayout)localObject1).getVisibility() == 8) {
          break label231;
        }
        ((LinearLayout)localObject1).setVisibility(8);
        break label231;
        ReportController.b(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        ((LinearLayout)localObject1).setTag("0X8004001");
        localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131296834);
        localObject4 = getString(2131370574);
        ((TextView)localObject2).setText((CharSequence)localObject4);
        if (AppSetting.j) {
          ((LinearLayout)localObject1).setContentDescription((CharSequence)localObject4);
        }
        if (((LinearLayout)localObject1).getVisibility() != 0) {
          ((LinearLayout)localObject1).setVisibility(0);
        }
        d();
        break label231;
        ((LinearLayout)localObject1).setTag("0X8004456");
        localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131296834);
        localObject4 = getString(2131370575);
        ((TextView)localObject2).setText((CharSequence)localObject4);
        if (AppSetting.j) {
          ((LinearLayout)localObject1).setContentDescription((CharSequence)localObject4);
        }
        if (((LinearLayout)localObject1).getVisibility() != 0)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
          ((LinearLayout)localObject1).setVisibility(0);
        }
        d();
        break label231;
        localObject1 = localObject2;
        if (n <= 1) {
          break label372;
        }
        localObject1 = n + "个";
        break label372;
        label868:
        if ((((String)localObject2).length() == 1) || (((String)localObject2).length() == 2)) {
          localObject1 = localObject2;
        } else if (((String)localObject2).length() > 2) {
          localObject1 = ((String)localObject2).substring(0, 2) + "|" + ((String)localObject2).length();
        } else {
          localObject1 = localObject2;
        }
      }
      label938:
      j = k;
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    TextView localTextView = null;
    for (;;)
    {
      try
      {
        if (this.app == null) {
          break label461;
        }
        localObject1 = (FriendsManager)this.app.getManager(50);
        if (localObject1 == null) {
          break label461;
        }
        localObject1 = ((FriendsManager)localObject1).a(this.app.a());
      }
      catch (Exception localException)
      {
        Object localObject1;
        localException.printStackTrace();
        localObject2 = localTextView;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AccountManageActivity", 2, "showLogoutDialog getCard Exception! ");
        localObject2 = localTextView;
        continue;
        FriendProfileCardActivity.jdField_a_of_type_Long = 30L;
        continue;
        if (((Card)localObject2).lLoginDays < FriendProfileCardActivity.jdField_a_of_type_Long) {
          continue;
        }
        localObject2 = String.format(getString(2131369635), new Object[] { Integer.valueOf((int)((Card)localObject2).lLoginDays) });
        continue;
        localObject2 = String.format(getString(2131369636), new Object[0]);
        continue;
        localObject2 = String.format(getString(2131369636), new Object[0]);
        continue;
        this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
        this.jdField_b_of_type_AndroidAppDialog.setContentView(2130903236);
        localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297840);
        if (localTextView == null) {
          continue;
        }
        localTextView.setText(getString(2131369631));
        localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296852);
        if (localTextView == null) {
          continue;
        }
        localTextView.requestFocus();
        localTextView.setText((CharSequence)localObject2);
        localTextView.setContentDescription((CharSequence)localObject2);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297843);
        if (localObject2 == null) {
          continue;
        }
        ((TextView)localObject2).setText(2131367262);
        ((TextView)localObject2).setOnClickListener(new khr(this));
        localObject2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297844);
        if (localObject2 == null) {
          continue;
        }
        ((TextView)localObject2).setText(2131369633);
        ((TextView)localObject2).setOnClickListener(new khs(this));
        this.jdField_b_of_type_AndroidAppDialog.show();
        return;
      }
      if (localObject1 != null) {
        if (((Card)localObject1).lQQMasterLogindays > 0L)
        {
          FriendProfileCardActivity.jdField_a_of_type_Long = ((Card)localObject1).lQQMasterLogindays;
          if ((((Card)localObject1).lLoginDays != 1L) && ((((Card)localObject1).lLoginDays <= 1L) || (((Card)localObject1).lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long))) {
            continue;
          }
          localObject1 = String.format(getString(2131369634), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.jdField_a_of_type_Long - ((Card)localObject1).lLoginDays)) });
          if (this.jdField_b_of_type_AndroidAppDialog == null) {
            continue;
          }
          localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296852);
          if (localTextView != null)
          {
            localTextView.requestFocus();
            localTextView.setText((CharSequence)localObject1);
            localTextView.setContentDescription((CharSequence)localObject1);
          }
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
      }
      label461:
      Object localObject2 = null;
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903052);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852)).setText(getString(2131368307));
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
  }
  
  private void k()
  {
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      getAppRuntime().getApplication().refreAccountList();
      localObject2 = getAppRuntime().getApplication().getAllAccounts();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initAccountList list=").append(localObject2).append(", size=");
        if (localObject2 == null) {
          break label215;
        }
        localObject1 = Integer.valueOf(((List)localObject2).size());
        label84:
        QLog.i("AccountManageActivity", 2, localObject1);
      }
      if (localObject2 != null) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("initAccountList accountList=").append(this.jdField_a_of_type_JavaUtilList).append(", size=");
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label222;
        }
      }
    }
    label215:
    label222:
    for (Object localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size());; localObject1 = "null")
    {
      QLog.i("AccountManageActivity", 2, localObject1);
      l();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      localObject1 = "null";
      break label84;
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "bindAccountListView i=" + j + ", account=" + this.jdField_a_of_type_JavaUtilList.get(j));
      }
      View localView;
      if (this.jdField_a_of_type_JavaUtilList.get(j) == null)
      {
        localView = getLayoutInflater().inflate(2130903046, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296825));
        localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        localView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      for (;;)
      {
        j += 1;
        break;
        localView = getLayoutInflater().inflate(2130903047, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if (j == 0) {
          localView.setBackgroundResource(2130838357);
        }
        localView.setTag(Integer.valueOf(j));
        ((ImageView)localView.findViewById(2131296790)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((Button)localView.findViewById(2131296817)).setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localView.findViewById(2131296827)).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    m();
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "updateAccountListView accountListLinearLayout is null or size is 0.");
      }
    }
    int j;
    label78:
    View localView;
    Object localObject;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        if (QLog.isColorLevel()) {
          QLog.i("AccountManageActivity", 2, "updateAccountListView account size=" + k);
        }
        j = 0;
        if (j >= k) {
          break;
        }
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject = localView.getTag();
        if (QLog.isColorLevel()) {
          QLog.i("AccountManageActivity", 2, "updateAccountListView i=" + j + ", view tag=" + localObject);
        }
      } while (localObject == null);
      int m = ((Integer)localObject).intValue();
      localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    } while (localObject == null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131296831);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131296790);
    TextView localTextView1 = (TextView)localView.findViewById(2131296829);
    TextView localTextView2 = (TextView)localView.findViewById(2131296830);
    localImageView1.clearAnimation();
    if ((((SimpleAccount)localObject).getUin() != null) && (((SimpleAccount)localObject).getUin().length() > 0) && (((SimpleAccount)localObject).getUin().equals(this.app.a())) && (!this.jdField_b_of_type_Boolean)) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      ThreadManager.a(new kgq(this, (SimpleAccount)localObject, ContactUtils.i(this.app, ((SimpleAccount)localObject).getUin()), localImageView2, localTextView1, localTextView2, localView, localImageView1), null, true);
      j += 1;
      break label78;
      break;
      localImageView1.setVisibility(8);
    }
  }
  
  private void n()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("login_from_account_change", true);
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    }
    localIntent.putExtra("befault_uin", this.app.a());
    startActivityForResult(localIntent, 9876);
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "onlogout");
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    startActivity(localIntent);
    finish();
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968581);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968582);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
  }
  
  public long a(AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online) {}
    do
    {
      return 11L;
      if (paramStatus == AppRuntime.Status.invisiable) {
        return 41L;
      }
    } while (paramStatus != AppRuntime.Status.away);
    return 31L;
  }
  
  public void a()
  {
    p();
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131368747);
    localTextView.setOnClickListener(new khb(this));
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2130903234, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(8.0F * this.mDensity));
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131368729);
    this.rightHighLView.setOnClickListener(new khl(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296836));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296838));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296289));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    a(this.app.a());
    this.jdField_c_of_type_AndroidViewView = findViewById(2131296845);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new khn(this));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296837));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    j();
    localObject = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float - 110.0F * this.mDensity);
    if (AppSetting.j)
    {
      localTextView.setContentDescription("编辑按钮");
      this.rightHighLView.setContentDescription("完成");
      this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131369631));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号");
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2131230747);
      int j = 0;
      while (j < arrayOfString.length)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(arrayOfString[j], 1);
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_Khw.a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_Khw);
      localObject = getString(2131367497).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)localObject);
    } while (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = ((SimpleAccount)localObject).getUin();
    String str2 = this.app.a();
    this.i = str1;
    if (str1.equals(str2)) {
      a(this, this.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    a(this.i, paramBoolean);
    HistoryChatMsgSearchKeyUtil.a(str1);
    this.jdField_a_of_type_JavaUtilList.remove(localObject);
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(60);
    if ((localSubAccountManager != null) && (localSubAccountManager.a(str1)))
    {
      SubAccountControll.a(this.app, (byte)0, str1);
      localSubAccountManager.e(str1);
      localSubAccountManager.a(str1, null, true);
      localSubAccountManager.a(str1, 2);
      SubAccountControll.a(this.app, str1, 7);
      int j = 1 - this.app.a().a(str1, 7000);
      if (j != 0) {
        this.app.a().c(str1, 7000, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "deleteAccount() hint need to verify,msg num=1, subUin=" + str1);
      }
    }
    GesturePWDUtils.clearGestureData(getActivity(), ((SimpleAccount)localObject).getUin());
    if (str1.equals(str2))
    {
      this.app.getApplication().refreAccountList();
      localObject = getAppRuntime().getApplication().getAllAccounts();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (((SimpleAccount)localObject).isLogined()) {
          getAppRuntime().startPCActivePolling(((SimpleAccount)localObject).getUin(), "delAccount");
        }
      }
    }
    ThreadManager.a(new kgw(this, paramBoolean, str1, paramInt), 8, null, true);
  }
  
  public void a(long paramLong)
  {
    AppRuntime.Status localStatus = AppRuntime.Status.offline;
    if (paramLong == 11L) {
      localStatus = AppRuntime.Status.online;
    }
    for (;;)
    {
      a(localStatus);
      return;
      if (paramLong == 41L) {
        localStatus = AppRuntime.Status.invisiable;
      } else if (paramLong == 31L) {
        localStatus = AppRuntime.Status.away;
      }
    }
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.a);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.a();
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
    int j = QQSettingUtil.a(paramActivity, paramQQAppInterface.a());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.a(), j + 1);
    startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    finish();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new kht(this, paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.a().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void a(AppRuntime.Status paramStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "updateOnlineStatusFlag status=" + paramStatus);
    }
    if (paramStatus == AppRuntime.Status.online)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130843464), DisplayUtil.a(this, 18.5F), DisplayUtil.a(this, 13.0F));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.j)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367734) + getString(2131371280));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367736) + getString(2131371281));
      }
    }
    do
    {
      do
      {
        return;
        if (paramStatus != AppRuntime.Status.invisiable) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130843464), DisplayUtil.a(this, 18.5F), DisplayUtil.a(this, 13.0F));
      } while (!AppSetting.j);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367734) + getString(2131371281));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367736) + getString(2131371280));
      return;
    } while (paramStatus != AppRuntime.Status.away);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    label30:
    View localView;
    if (j < k)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
      if (localView.getTag() != null) {
        break label107;
      }
      if (!paramBoolean) {
        break label84;
      }
      localView.setOnClickListener(null);
      localView.setBackgroundResource(2130843277);
      localView.setEnabled(false);
    }
    for (;;)
    {
      j += 1;
      break label30;
      break;
      label84:
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setBackgroundResource(2130838352);
      localView.setEnabled(true);
      continue;
      label107:
      ImageView localImageView = (ImageView)localView.findViewById(2131296831);
      TextView localTextView = (TextView)localView.findViewById(2131296829);
      if (j == 0)
      {
        if (paramBoolean)
        {
          localView.setOnClickListener(null);
          localView.setBackgroundResource(2130843292);
          localImageView.setImageResource(2130843464);
        }
        else
        {
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localView.setBackgroundResource(2130838357);
          localImageView.setImageResource(2130843465);
        }
      }
      else if (paramBoolean)
      {
        localView.setOnClickListener(null);
        localView.setBackgroundResource(2130843286);
        localImageView.setImageResource(2130843464);
      }
      else
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setBackgroundResource(2130838355);
        localImageView.setImageResource(2130843465);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    label30:
    Object localObject2;
    if (j < k)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
      localObject1 = ((View)localObject2).getTag();
      if (localObject1 != null) {
        break label69;
      }
    }
    label69:
    ImageView localImageView1;
    ImageView localImageView2;
    RelativeLayout localRelativeLayout;
    ImageView localImageView3;
    for (;;)
    {
      j += 1;
      break label30;
      break;
      localImageView1 = (ImageView)((View)localObject2).findViewById(2131296831);
      localImageView2 = (ImageView)((View)localObject2).findViewById(2131296790);
      localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131296828);
      localImageView3 = (ImageView)((View)localObject2).findViewById(2131296827);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131296826);
      if ((localImageView2.getTag() == null) || (localRelativeLayout.getTag() == null))
      {
        localImageView2.setTag("left");
        localRelativeLayout.setTag("left");
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label242;
      }
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2130968577, 5);
      }
      localImageView3.setVisibility(0);
      ((ImageView)localObject2).setVisibility(0);
      localImageView3.setImageResource(2130842934);
      a(localImageView3, 2130968578, 4);
      a((View)localObject2, 2130968578, 4);
      a(localImageView2, 2130968582, 0);
      a(localRelativeLayout, 2130968582, 0);
    }
    label242:
    localImageView3.setVisibility(8);
    ((ImageView)localObject2).setVisibility(8);
    int m = ((Integer)localObject1).intValue();
    Object localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    if ((localObject1 != null) && (((SimpleAccount)localObject1).getUin() != null) && (((SimpleAccount)localObject1).getUin().length() > 0) && (((SimpleAccount)localObject1).getUin().equals(this.app.a()))) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2130968578, 4);
      }
      a(localImageView3, 2130968577, 5);
      a((View)localObject2, 2130968577, 5);
      a(localImageView2, 2130968581, 1);
      a(localRelativeLayout, 2130968581, 1);
      break;
      localImageView1.setVisibility(8);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int j;
    label29:
    Object localObject2;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        j = 0;
        if (j >= k) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int m = ((Integer)localObject2).intValue();
      localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    } while (localObject2 == null);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131296831);
    if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.a())) && (!this.jdField_b_of_type_Boolean)) {
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      j += 1;
      break label29;
      break;
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5000);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2010) {}
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 == 1000))
      {
        k();
        return;
      }
    } while ((paramInt2 != -1) || (paramInt1 != 9876));
    k();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903048);
    setTitle(2131370956);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    setContentBackgroundResource(2130837958);
    a();
    k();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    sendBroadcast(new Intent("before_account_change"));
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.a(getClass());
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    d();
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b(false);
    m();
    g();
  }
  
  public void e()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131370492)).setMessage(getString(2131370503));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131370505), new kgz(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131367262), new kha(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369840);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  public void g()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  void h()
  {
    long l = System.currentTimeMillis();
    String str;
    if (ProfileActivity.a(this.jdField_a_of_type_Long, l))
    {
      this.jdField_a_of_type_Long = l;
      str = ((TicketManager)this.app.getManager(2)).getStweb(this.app.a());
      if ((str != null) && (str.length() != 0)) {
        break label64;
      }
      a(2131370024, 1);
    }
    label64:
    do
    {
      return;
      str = String.format("http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka", new Object[] { this.app.a(), str, "19", "" });
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQLevelWeb() url = " + str);
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 23, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, "getClientKey() time = " + System.currentTimeMillis());
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "onAccountChanged zsw");
    }
    super.onAccountChanged();
    com.tencent.mobileqq.servlet.CliNotifyPush.h = 0;
    this.app.a(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      m();
    }
    for (;;)
    {
      ThreadManager.a(new khd(this), null, true);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "onAccountChanged2");
      }
      b(true);
      LoginActivity.a(this.app, this.app.a());
      TroopNotificationHelper.a();
      QvipSpecialCareManager.a(true);
      OpenProxy.a().a(this.app.a());
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new khf(this), 500L);
      PatternLockUtils.d(this, this.app.a(), true);
      return;
      k();
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    g();
    this.jdField_e_of_type_Boolean = false;
    n();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "zsw onLogout");
      }
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if ((this.mNeedStatusTrans) && (this.mSystemBarComp != null))
    {
      int j = getResources().getColor(2131428295);
      this.mSystemBarComp.a(j);
      this.mSystemBarComp.b(j);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AccountManageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */