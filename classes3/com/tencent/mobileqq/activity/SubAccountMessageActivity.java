package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.adapter.SubAccountMessageAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mmw;
import mmx;
import mmy;
import mmz;
import mna;
import mnb;
import mnc;
import mnd;
import mne;
import mnf;
import mng;
import mnh;
import mni;
import mnj;
import mnk;
import mnm;
import mnn;
import mno;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;

public class SubAccountMessageActivity
  extends SubAccountBaseActivity
  implements DragFrameLayout.OnDragModeChangedListener, Observer
{
  public static final int a = 1011;
  private static final String jdField_c_of_type_JavaLangString = "0X8004458";
  private static final String jdField_d_of_type_JavaLangString = "0X8004459";
  private static final String e = "0X800445A";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private SubAccountMessageAdapter jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver;
  private SubAccountInfo jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private String f;
  
  public SubAccountMessageActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "Q.subaccount.SubAccountMessageActivity";
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new mmw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new mni(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mnj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new mnk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new mnn(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new mmx(this);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    int i = 2131367263;
    String str = getString(2131368409);
    switch (paramInt)
    {
    }
    for (paramInt = i;; paramInt = 2131367265)
    {
      a(str, paramString1, 2131367262, paramInt, new mmz(this, paramString2), new mna(this));
      return;
      str = getString(2131368142);
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new mnb(this), paramLong);
  }
  
  private void a(SubAccountControll paramSubAccountControll, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + paramString);
    }
    if ((paramSubAccountControll == null) || (paramString == null) || (paramString.length() <= 4)) {}
    for (;;)
    {
      return;
      if ((isResume()) && (SubAccountControll.a(this.app, paramString)))
      {
        a();
        paramString = paramSubAccountControll.a(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)paramString.get(i);
          paramSubAccountControll.a(this.app, this, localPair, new mnm(this, paramSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 2131367262, 2131367263, new mmy(this), null);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
    {
      SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(60);
      if (localSubAccountManager != null)
      {
        if (paramBoolean) {
          localSubAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        }
        localSubAccountManager.f(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    SubAccountControll.a(this.app, paramString, false);
  }
  
  private void a(boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (paramBoolean) {
      localActionSheet.a(getResources().getString(2131370530), 1);
    }
    localActionSheet.a(getResources().getString(2131370514), 1);
    localActionSheet.a(getResources().getString(2131370521), 3);
    localActionSheet.d(2131367262);
    localActionSheet.a(new mnc(this, paramBoolean, localActionSheet));
    localActionSheet.show();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    if (paramBoolean1)
    {
      localActionSheet.a(2131370517);
      localActionSheet.a(2131367263, 3);
    }
    for (;;)
    {
      localActionSheet.d(2131367262);
      localActionSheet.a(new mnd(this, localActionSheet, paramBoolean1, paramBoolean2));
      localActionSheet.show();
      return;
      if (paramBoolean2)
      {
        localActionSheet.a(2131370518);
        localActionSheet.a(2131370516, 3);
      }
    }
  }
  
  private boolean c()
  {
    if (!d()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
    {
      String str = ContactUtils.c(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, true);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 4, "initData:set subaccount nickname=" + this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        }
      }
    }
    h();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter = new SubAccountMessageAdapter(this.app, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter);
    i();
    this.f = this.app.a();
    return true;
  }
  
  private boolean d()
  {
    String str = getIntent().getStringExtra("subAccount");
    Object localObject = (SubAccountManager)this.app.getManager(60);
    if (localObject != null) {}
    for (localObject = ((SubAccountManager)localObject).a(str);; localObject = null)
    {
      if ((localObject != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = new SubAccountInfo();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.cloneTo((SubAccountInfo)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshAccountInfo: set subaccount nickname=" + this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
          localObject = FaceDrawable.a(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return true;
          localObject = ContactUtils.b(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, false);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          } else {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "subaccount refreshAccountInfo but mSubAccountInfo is null??");
      }
      a(this.app.a().getString(2131370534));
      if (str != null) {
        SubAccountControll.c(this.app, str);
      }
      finish();
      return false;
    }
  }
  
  private void e()
  {
    setTitle(2131370492);
    d();
    ImageView localImageView = this.rightViewImg;
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130838587);
    localImageView.setOnClickListener(new mng(this));
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_AndroidViewView = localLayoutInflater.inflate(2130905026, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305070));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305071));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305072));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131305069));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131305068));
    if (AppSetting.j) {
      localImageView.setContentDescription(getText(2131370572));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131305066));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837958);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void f()
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(60);
    int i = localSubAccountManager.a();
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) && (i == 1) && (!DBUtils.a().a(this.app.a())))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (AppSetting.j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription("还可再关联1个QQ号，立即体验吧");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new mnh(this, localSubAccountManager));
      ReportController.b(this.app, "CliOper", "", "", "0X8004458", "0X8004458", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = getAppRuntime().getApplication().getAllAccounts();
    } while (localObject == null);
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (SimpleAccount)localIterator.next();
    } while (!((SimpleAccount)localObject).getUin().equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin));
    for (;;)
    {
      if (localObject != null)
      {
        this.jdField_d_of_type_Boolean = true;
        sendBroadcast(new Intent("before_account_change"));
        this.app.switchAccount((SimpleAccount)localObject, null);
        return;
      }
      a();
      return;
      localObject = null;
    }
  }
  
  private void h()
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(60);
    if (localSubAccountManager != null) {}
    for (int i = localSubAccountManager.d(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);; i = 0)
    {
      if (i > 0)
      {
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshMessageList:refreshMessageList");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)))
    {
      localObject = (SubAccountManager)this.app.getManager(60);
      if (localObject == null) {
        break label177;
      }
    }
    label177:
    for (Object localObject = ((SubAccountManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);; localObject = null)
    {
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter.notifyDataSetChanged();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "refreshMessageList:refreshMessageList.finish");
        return;
        localObject = new SubAccountMessage();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("fromsubaccount", true);
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    }
    localIntent.putExtra("befault_uin", this.app.a());
    startActivityForResult(localIntent, 1011);
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "dologoutWhenSwitch:onlogout");
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("fromsubaccount", true);
    localIntent.putExtra("logout_intent", true);
    startActivity(localIntent);
    finish();
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin;
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout) {}
  
  public void d()
  {
    if (this.leftView != null)
    {
      Object localObject = this.app.a();
      if (localObject == null) {
        break label148;
      }
      int k = ((QQMessageFacade)localObject).e();
      int j = 0;
      localObject = this.app.a();
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
          i = ((ConversationFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, 7000);
        }
      }
      i = k - i;
      if (i > 0)
      {
        localObject = Integer.toString(i);
        if (i > 99) {
          localObject = "99+";
        }
        this.leftView.setText(getString(2131367566) + "(" + (String)localObject + ")");
      }
    }
    else
    {
      return;
    }
    this.leftView.setText(getString(2131367566));
    return;
    label148:
    this.leftView.setText(getString(2131367566));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130905024);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    e();
    if (!c()) {
      return true;
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    this.app.a().addObserver(this);
    SubAccountAssistantForward.b(this.app);
    SubAccountAssistantForward.a(this.app);
    SubAccountAssistantForward.e(this.app);
    SubAccountAssistantForward.c(this.app);
    a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    i();
    f();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (DBUtils.a().a(this.app.a()))) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "onAccountChanged() click2switch=" + this.jdField_d_of_type_Boolean);
    }
    super.onAccountChanged();
    com.tencent.mobileqq.servlet.CliNotifyPush.h = 0;
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if (this.jdField_d_of_type_Boolean) {
      ThreadManager.a(new mno(this, this.f), 8, null, true);
    }
    if (this.app != null) {
      this.app.getApplication().refreAccountList();
    }
    a();
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.a);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  protected void onAccoutChangeFailed()
  {
    a();
    j();
    this.jdField_d_of_type_Int = 0;
  }
  
  protected boolean onBackEvent()
  {
    this.app.a().c(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, 7000);
    Object localObject = (SubAccountManager)this.app.getManager(60);
    if (localObject != null) {
      ((SubAccountManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    }
    if (this.jdField_c_of_type_Boolean) {
      ((MessageHandler)this.app.a(0)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, null);
    }
    localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.a);
    ((Intent)localObject).setFlags(67108864);
    startActivity((Intent)localObject);
    return super.onBackEvent();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    a();
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onLogout:zsw onLogout");
      }
      k();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      if (!((MessageRecord)paramObject).isSendFromLocal()) {
        runOnUiThread(new mne(this));
      }
    }
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!AppConstants.ah.equals(paramObservable[0])));
    runOnUiThread(new mnf(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SubAccountMessageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */