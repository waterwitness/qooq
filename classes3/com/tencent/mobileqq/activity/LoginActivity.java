package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ClearableEditText.OnTextClearedListener;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SoftInputResizeLayout;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lsm;
import lso;
import lsq;
import lsr;
import lss;
import lsu;
import lsv;
import lsw;
import lsx;
import lsy;
import lsz;
import ltb;
import ltc;
import ltd;
import lte;
import ltg;
import lth;
import lti;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class LoginActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, ClearableEditText.OnTextClearedListener, InputMethodRelativeLayout.onSizeChangedListenner
{
  static final int jdField_a_of_type_Int = 1;
  private static LoginActivity jdField_a_of_type_ComTencentMobileqqActivityLoginActivity;
  public static final String a = "from_register_guide";
  public static final int b = 20140107;
  public static final String b = "jump_action_from_h5";
  public static final int c = 20140319;
  public static final String c = "package_from_h5";
  public static final int d = 20140325;
  static final String jdField_d_of_type_JavaLangString = "!@#ewaGbhkc$!!=";
  private static final String jdField_f_of_type_JavaLangString = "LoginActivity";
  private static final int jdField_g_of_type_Int = 0;
  private static final String jdField_g_of_type_JavaLangString = "INPUT_TYPE_ON_START";
  private static final int jdField_h_of_type_Int = 2;
  private static final int jdField_i_of_type_Int = 3;
  private static final int j = 1;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener;
  public View a;
  public AlphaAnimation a;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public AutoCompleteTextView a;
  Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public CustomSafeEditText a;
  public DropdownView a;
  public InputMethodRelativeLayout a;
  public PadQQCheckBox a;
  public SimpleAccount a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public List a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  public TextWatcher b;
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  public String e;
  private boolean e;
  public final int f;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private boolean jdField_i_of_type_Boolean;
  
  public LoginActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
    this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new lsy(this);
    this.jdField_f_of_type_Int = 2000;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    this.jdField_a_of_type_MqqObserverAccountObserver = new lso(this);
    this.jdField_a_of_type_AndroidTextTextWatcher = new lsr(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new lsu(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new lsv(this);
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
    {
      QQToast.a(this, 2131367488, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
    if ((str == null) || (str.length() < 1))
    {
      QQToast.a(this, 2131367491, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, 2);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
    {
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      int k = 0;
      if (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(k) == null) || (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k)).getUin() == null)) {}
        while (!((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k)).getUin().equals(str))
        {
          k += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("userguide", 2, "login");
    }
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      com.tencent.common.app.BaseApplicationImpl.jdField_d_of_type_Boolean = false;
      showDialog(0);
      this.app.login(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
    }
    for (;;)
    {
      AlbumUtil.b();
      return;
      com.tencent.common.app.BaseApplicationImpl.jdField_d_of_type_Boolean = true;
      try
      {
        showDialog(0);
        getAppRuntime().login(paramView, arrayOfByte, null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void a(Button paramButton)
  {
    if (paramButton == null) {
      return;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).r()))
    {
      paramButton.setText(getString(2131369342));
      return;
    }
    paramButton.setText(getString(2131367466));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    RecentDataListManager.a().a(paramQQAppInterface, paramQQAppInterface.a(), false);
    try
    {
      StatisticCollector.a(paramQQAppInterface.a()).a(paramString);
      Common.OnLogin(paramQQAppInterface.getApplication().getApplicationContext(), paramString);
      if (QLog.isColorLevel()) {
        QLog.d("login", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      SharedPreUtils.a(paramQQAppInterface.getApplication().getApplicationContext(), paramString, true);
      paramQQAppInterface.getApplication().refreAccountList();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("login", 2, "loginSuccess throwable: " + localThrowable);
        }
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.b(paramSimpleAccount.getUin()));
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("!@#ewaGbhkc$!!=");
          a(paramSimpleAccount.getUin());
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str = paramIntent.getString("uin");
        if ((str != null) && (str.length() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_b_of_type_Boolean = true;
    if (bool)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramString);
      setResult(-1, (Intent)localObject);
      return true;
    }
    if (JumpActivity.jdField_a_of_type_Boolean)
    {
      setResult(-1);
      return true;
    }
    paramString = getIntent().getStringExtra("scheme_content");
    if (getIntent().getBooleanExtra("isActionSend", false))
    {
      setResult(-1);
      return true;
    }
    Object localObject = getIntent().getStringExtra("pkg_name");
    if ((paramString != null) && (paramString.length() > 0))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, paramString);
      if (((localObject != null) && (((String)localObject).length() > 0)) || ("web".equals(localJumpAction.a("src_type"))) || (localJumpAction.f()))
      {
        localJumpAction.b((String)localObject);
        if ((("share".equals(localJumpAction.ft)) && ("to_qzone".equals(localJumpAction.fu))) || (localJumpAction.f())) {
          this.jdField_b_of_type_Boolean = false;
        }
        localJumpAction.b();
        return true;
      }
      if (("h5".equalsIgnoreCase(localJumpAction.a("jump_from"))) && (localJumpAction.c()))
      {
        getIntent().putExtra("package_from_h5", "pakage_from_h5");
        getIntent().putExtra("jump_action_from_h5", paramString);
        e();
        return true;
      }
    }
    return false;
  }
  
  private boolean b()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if ((localObject != null) && ((((String)localObject).startsWith("mqqopensdkapi://bizAgent/")) || (((String)localObject).startsWith("http://qm.qq.com/cgi-bin/")) || (((String)localObject).startsWith("mqq://shop/")) || (((String)localObject).startsWith("mqqapi://wallet/open")) || (((String)localObject).startsWith("mqqmdpass://wallet/modify_pass")) || (((String)localObject).startsWith("mqqapi://qqdataline/openqqdataline")) || (((String)localObject).startsWith("mqqapi://dating/")) || (((String)localObject).startsWith("mqqapi://qlink/openqlink")) || (((String)localObject).startsWith("mqqapi://qqc2b/callc2bphone"))))
    {
      localObject = JumpParser.a(this.app, this, (String)localObject);
      if (localObject != null)
      {
        ((JumpAction)localObject).b(str);
        ((JumpAction)localObject).b();
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_d_of_type_AndroidViewView = findViewById(2131296896);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131298432));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131362072));
    Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject != null) {
      ((Bundle)localObject).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText = ((CustomSafeEditText)findViewById(2131298433));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setContentDescription(getString(2131362073));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298435));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131362075));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298437));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(getString(2131368534) + getString(2131369793));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    findViewById(2131298439).setOnClickListener(this);
    findViewById(2131298436).setOnClickListener(this);
    localObject = findViewById(2131298438);
    ViewCompat.setImportantForAccessibility((View)localObject, 2);
    ((View)localObject).setContentDescription(getString(2131368534) + getString(2131369793));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetButton);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298441));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131362077));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131298427));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298429);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131298428);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296814));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131298440));
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131367470));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setLongClickable(false);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((this.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.mSystemBarComp.init();
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298431);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextClearedListener(this);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    d();
    if (getIntent().getBooleanExtra("reason_for_upgrade", false)) {
      showDialog(2);
    }
    if ((getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)))
    {
      ((TextView)findViewById(2131297139)).setText(2131371180);
      localObject = getString(2131371180);
      ((TextView)findViewById(2131297139)).setContentDescription((CharSequence)localObject);
      setTitle(getString(2131371180));
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(getIntent().getStringExtra("key_uin_to_login"));
    }
    localObject = (ViewGroup)findViewById(2131298430);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    if (this.g) {
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams2.addRule(3, 2131296896);
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
        ((LinearLayout)this.jdField_c_of_type_AndroidViewView).setOrientation(1);
        localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams2.addRule(3, 2131298428);
        localLayoutParams2.addRule(14, -1);
        localLayoutParams2.topMargin = AIOUtils.a(15.0F, getResources());
        localLayoutParams2.leftMargin = AIOUtils.a(15.0F, getResources());
        localLayoutParams2.rightMargin = AIOUtils.a(15.0F, getResources());
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
        ((ViewGroup)localObject).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
        {
          localLayoutParams1.setMargins(0, ImmersiveUtils.a(this), 0, 0);
          this.mSystemBarComp.a(true, 0);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject = (TextView)findViewById(2131297183);
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText("取消");
        ((TextView)localObject).setOnClickListener(this);
        findViewById(2131297139).setVisibility(0);
        localObject = (TextView)findViewById(2131297139);
        ((TextView)localObject).setText(2131367495);
        ((TextView)localObject).setContentDescription(getString(2131367495));
        setTitle(getString(2131367495));
        this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
      }
    }
    do
    {
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        localLayoutParams1.setMargins(0, ImmersiveUtils.a(this), 0, 0);
        this.mSystemBarComp.a(true, 0);
        ((LinearLayout.LayoutParams)((ViewGroup)localObject).getLayoutParams()).topMargin = (AIOUtils.a(68.0F, getResources()) + ImmersiveUtils.a(this));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367975);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      break;
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
        {
          this.mSystemBarComp.a(true, 0);
          localLayoutParams1.setMargins(0, ImmersiveUtils.a(this), 0, 0);
        }
        findViewById(2131297139).setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367975);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        return;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    } while ((!this.mNeedStatusTrans) || (ImmersiveUtils.isSupporImmersive() != 1));
    this.mSystemBarComp.a(false, 0);
    localLayoutParams1.setMargins(0, 0, 0, 0);
  }
  
  private void c(String paramString)
  {
    OpenProxy.a().a(paramString);
    int k;
    if ((getIntent().getFlags() & 0x100000) != 0)
    {
      k = 1;
      if (!b()) {
        break label47;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        finish();
      }
      return;
      k = 0;
      break;
      label47:
      if (((k != 0) || (!a(paramString))) && (!d()) && (!a()) && (!c())) {
        if (getIntent().getParcelableExtra("shortcut_jump_key") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("shortcut_jump_key");
          paramString.setClass(this, ShortcutRouterActivity.class);
          startActivity(paramString);
        }
        else if (getIntent().getBooleanExtra("jump_shortcut_dataline", false))
        {
          paramString = new Intent();
          paramString.putExtras(getIntent().getExtras());
          paramString.setClass(this, qfileJumpActivity.class);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("QLINK_SHORTCUT_JUMP_KEY") != null)
        {
          paramString = new Intent(this, JumpActivity.class);
          paramString.putExtra("_goto_qlink_when_login_suc_", true);
          paramString.putExtra("IS_LOGIN_SUC_CALL", true);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("QFILE_SHORTCUT_JUMP_KEY") != null)
        {
          paramString = new Intent(this, JumpActivity.class);
          paramString.putExtra("_goto_qfile_when_login_suc_", true);
          paramString.putExtra("IS_LOGIN_SUC_CALL", true);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("qlink_share_intent_data") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("qlink_share_intent_data");
          paramString.putExtra("qlink_share_login_suc_flag", true);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("QREADER_SHORTCUT_JUMP_KEY") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("QREADER_SHORTCUT_JUMP_KEY");
          Intent localIntent = new Intent(this, QRBridgeActivity.class);
          localIntent.putExtras(paramString);
          startActivity(localIntent);
        }
        else if (!e())
        {
          setResult(-1);
          if (!this.g) {
            e();
          }
        }
      }
    }
  }
  
  private boolean c()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if (QLog.isColorLevel()) {
      QLog.d("ODProxy", 2, "handleODJumpAction: schemeStr:" + (String)localObject + "pkgName :" + str);
    }
    if ((localObject != null) && (((String)localObject).startsWith("mqqapi://od")))
    {
      localObject = JumpParser.a(this.app, this, (String)localObject);
      ((JumpAction)localObject).b(str);
      ((JumpAction)localObject).b();
      return true;
    }
    return false;
  }
  
  private void d()
  {
    View localView = findViewById(2131297082);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = findViewById(2131296896);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = findViewById(2131297083);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private boolean d()
  {
    boolean bool = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (bool)
    {
      Intent localIntent = new Intent(this, ContactSyncJumpActivity.class);
      localIntent.putExtra("key_req_from_switch_account", true);
      localIntent.putExtra("key_change", true);
      localIntent.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      startActivity(localIntent);
      moveTaskToBack(true);
      finish();
    }
    return bool;
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("k_from_login", true);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      if (localBundle.containsKey("tab_index")) {
        localIntent.putExtra("tab_index", getIntent().getExtras().getInt("tab_index"));
      }
      if (localBundle.containsKey("main_tab_id")) {
        localIntent.putExtra("main_tab_id", localBundle.getInt("main_tab_id"));
      }
      if (localBundle.containsKey("jump_action_from_h5")) {
        localIntent.putExtra("jump_action_from_h5", getIntent().getExtras().getString("jump_action_from_h5"));
      }
      if (localBundle.containsKey("package_from_h5")) {
        localIntent.putExtra("package_from_h5", getIntent().getExtras().getString("package_from_h5"));
      }
    }
    startActivity(localIntent);
    overridePendingTransition(2130968646, 0);
  }
  
  private boolean e()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if (QLog.isColorLevel()) {
      QLog.d("schedule", 2, "handleScheduleJumpAction: schemeStr:" + (String)localObject + "pkgName :" + str);
    }
    if ((localObject != null) && (((String)localObject).startsWith("mqqapi://schedule/showDetail?")))
    {
      localObject = JumpParser.a(this.app, this, (String)localObject);
      ((JumpAction)localObject).b(str);
      ((JumpAction)localObject).b();
      return true;
    }
    return false;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return this.app.a(paramString, (byte)3, false);
  }
  
  public void a()
  {
    libsafeedit.clearPassBuffer();
    getAppRuntime().stopPCActivePolling("clearPassInput");
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText() == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null)) {}
    label65:
    Object localObject;
    label114:
    do
    {
      return;
      int k = 0;
      SimpleAccount localSimpleAccount;
      if (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
        if (localSimpleAccount != null) {
          break label114;
        }
      }
      while (!((String)localObject).equals(this.app.b(localSimpleAccount.getUin())))
      {
        k += 1;
        break label65;
        break;
      }
      this.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
      OpenProxy.a().b((String)localObject);
      this.jdField_e_of_type_JavaLangString = null;
      this.app.getApplication().refreAccountList();
      localObject = getAppRuntime().getApplication().getAllAccounts();
    } while ((localObject == null) || (this.jdField_a_of_type_JavaUtilList == null));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
  }
  
  public void a(String paramString)
  {
    ThreadManager.a().post(new lsz(this, paramString));
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "onSizeChange isOpen:" + paramBoolean + " preH:" + paramInt1 + " curH:" + paramInt2);
    }
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_AndroidWidgetCheckBox.getLocationInWindow(arrayOfInt);
      paramInt1 = arrayOfInt[1];
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.getLocationInWindow(arrayOfInt);
      int k = arrayOfInt[1];
      paramInt2 = paramInt1 - k + this.jdField_a_of_type_AndroidWidgetCheckBox.getHeight() - paramInt2;
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onSizeChange tosChbY:" + paramInt1 + " layoutY:" + k + " paddingY:" + paramInt2);
      }
      if (paramInt2 > 0) {
        this.jdField_c_of_type_AndroidViewView.setPadding(this.jdField_c_of_type_AndroidViewView.getPaddingLeft(), this.jdField_c_of_type_AndroidViewView.getPaddingTop() - paramInt2, this.jdField_c_of_type_AndroidViewView.getPaddingRight(), this.jdField_c_of_type_AndroidViewView.getPaddingBottom());
      }
      if ((this.g) && (this.jdField_h_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
  }
  
  protected boolean a()
  {
    Intent localIntent = getIntent();
    if ("webview".equals(localIntent.getStringExtra("action_name")))
    {
      localIntent = new Intent(localIntent);
      localIntent.setClass(this, QQBrowserActivity.class);
      startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_h_of_type_JavaLangString = null;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131367474);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131367475);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new lsw(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new lsx(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.i = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.a().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_h_of_type_JavaLangString = paramCharSequence.toString();
  }
  
  protected void checkUnlockForSpecial()
  {
    if ((this.g) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.a()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      getWindow().setBackgroundDrawableResource(2130838673);
      setTitle(getString(2131369818));
      boolean bool1 = getIntent().getBooleanExtra("from_register_guide", false);
      boolean bool2 = getIntent().getBooleanExtra("isActionSend", false);
      if ((!bool1) && (!bool2))
      {
        paramBundle = getAppRuntime().getApplication().getAllAccounts();
        if ((paramBundle == null) || (paramBundle.isEmpty()))
        {
          paramBundle = getIntent();
          paramBundle.setClass(this, RegisterGuideActivity.class);
          paramBundle.addFlags(67108864);
          startActivity(paramBundle);
          overridePendingTransition(0, 0);
          finish();
        }
      }
      super.setContentView(2130903398);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        SoftInputResizeLayout.a(this);
      }
      if (jdField_a_of_type_ComTencentMobileqqActivityLoginActivity != null) {
        jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.finish();
      }
      jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = this;
      if (this.app != null)
      {
        this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
        this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_f_of_type_Boolean = getIntent().getBooleanExtra("is_change_account", false);
        this.g = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
        this.jdField_h_of_type_Boolean = getIntent().getBooleanExtra("login_from_account_change", false);
        c();
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label513;
        }
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramBundle = getAppRuntime().getApplication().getAllAccounts();
        if (paramBundle != null) {
          this.jdField_a_of_type_JavaUtilList.addAll(paramBundle);
        }
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label741;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setAdapter(new lti(this, this));
        if ((this.g) && (!this.jdField_f_of_type_Boolean)) {
          break label597;
        }
        paramBundle = getIntent().getStringExtra("uin");
        str = getIntent().getStringExtra("befault_uin");
        if ((!this.jdField_f_of_type_Boolean) || (paramBundle == null) || (paramBundle.length() <= 0)) {
          break label721;
        }
        k = 0;
        for (m = -1;; m = i1)
        {
          if (k >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label579;
          }
          localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
          i1 = m;
          if (localSimpleAccount != null)
          {
            if (localSimpleAccount.getUin() != null) {
              break;
            }
            i1 = m;
          }
          k += 1;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      int m;
      for (;;)
      {
        String str;
        int k;
        SimpleAccount localSimpleAccount;
        int i1;
        getWindow().setBackgroundDrawableResource(2131427483);
        continue;
        paramBundle = getAppRuntime();
        if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface)))
        {
          this.app = ((QQAppInterface)paramBundle);
          this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
          this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
          continue;
          label513:
          this.jdField_a_of_type_JavaUtilList.clear();
          continue;
          int n = m;
          if (str != null)
          {
            n = m;
            if (str.equals(localSimpleAccount.getUin())) {
              n = k;
            }
          }
          i1 = n;
          if (paramBundle.equals(localSimpleAccount.getUin()))
          {
            a(localSimpleAccount);
            i1 = n;
          }
        }
      }
      label579:
      if (m != -1) {
        this.jdField_a_of_type_JavaUtilList.remove(m);
      }
    }
    for (;;)
    {
      label597:
      if ((getIntent().getBooleanExtra("logout_intent", false)) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null))
      {
        SharedPreUtils.a(this.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), false);
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
      }
      if ((this.g) && (this.jdField_h_of_type_Boolean)) {
        ReportController.b(this.app, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
      }
      if (getIntent().getBooleanExtra("reason_for_checkAuth", false)) {
        showDialog(3);
      }
      return true;
      label721:
      a((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(0));
      continue;
      label741:
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = null;
    this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.app.a(getClass());
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_b_of_type_Boolean = true;
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    this.jdField_e_of_type_Int = paramBundle.getInt("position", -1);
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
    if (NotificationActivity.a != null)
    {
      NotificationActivity.a.finish();
      NotificationActivity.a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("main", 2, "onResume in LoginActivity");
    }
    if (this.app != null) {
      this.app.a(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putInt("position", this.jdField_e_of_type_Int);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean) && ((!this.g) || (!this.jdField_h_of_type_Boolean)))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.post(new lsm(this));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!isFinishing())
      {
        try
        {
          dismissDialog(0);
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("LoginActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
        }
        finish();
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("login", 1, "LoginActivity onAccountChanged");
    this.app.a(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      String str = this.app.a();
      if (!this.jdField_e_of_type_JavaLangString.equalsIgnoreCase(str)) {
        SharedPreUtils.a(this.app.getApplication().getApplicationContext(), this.jdField_e_of_type_JavaLangString, true);
      }
      PatternLockUtils.d(this, this.jdField_e_of_type_JavaLangString, true);
    }
    if (PhoneNumLoginImpl.a().a()) {
      return;
    }
    ThreadManager.a(new lsq(this), null, false);
    c(this.app.getAccount());
    if (!isFinishing()) {}
    try
    {
      dismissDialog(0);
      PatternLockUtils.d(this, this.app.getAccount(), true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    QLog.d("login", 1, "LoginActivity onAccoutChangeFailed");
  }
  
  protected boolean onBackEvent()
  {
    boolean bool1 = getIntent().getBooleanExtra("is_change_account", false);
    boolean bool2 = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    boolean bool3 = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    boolean bool4 = getIntent().getBooleanExtra("login_from_account_change", false);
    if (bool3) {
      if (bool2)
      {
        moveTaskToBack(true);
        finish();
      }
    }
    do
    {
      return true;
      this.app.b(false);
      break;
      if ((!bool1) && (!bool2)) {
        break label122;
      }
      if (bool1) {
        setResult(-1);
      }
      finish();
    } while ((!bool2) || (!bool4));
    overridePendingTransition(2130968589, 2130968593);
    return true;
    label122:
    finish();
    this.app.b(false);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131298437) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramCompoundButton.isChecked());
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_e_of_type_Int != -1)
    {
      paramDialogInterface = new QQProgressDialog(this, getTitleBarHeight());
      paramDialogInterface.d(true);
      paramDialogInterface.setContentView(2130904920);
      paramDialogInterface.b(2131368307);
      paramDialogInterface.show();
      lti locallti = (lti)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      String str1 = locallti.b(this.jdField_e_of_type_Int);
      String str2 = locallti.a(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_e_of_type_Int);
      this.jdField_e_of_type_Int = -1;
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) || (str2.equals(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString())))
      {
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
      }
      locallti.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equalsIgnoreCase(str1))) {
        this.jdField_e_of_type_JavaLangString = null;
      }
      ThreadManager.a(new lss(this, str1, paramDialogInterface), 8, null, false);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
    case 2131298435: 
    case 2131298441: 
      do
      {
        return;
        a(paramView);
        return;
      } while (!this.jdField_e_of_type_Boolean);
      if ((this.g) && (this.jdField_h_of_type_Boolean)) {
        ReportController.b(this.app, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        Intent localIntent = new Intent(this, RegisterPhoneNumActivity.class);
        localIntent.putExtra("key_register_now_account", paramView);
        startActivity(localIntent);
        this.jdField_e_of_type_Boolean = false;
        new Handler().postDelayed(new lth(this), 1000L);
        return;
        ReportController.b(this.app, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
      }
    case 2131298440: 
      if ((this.g) && (this.jdField_h_of_type_Boolean)) {
        ReportController.b(this.app, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
      }
      b();
      return;
    case 2131297083: 
    case 2131297183: 
      onBackEvent();
      return;
    case 2131298439: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("ba_is_login", false);
      paramView.putExtra("url", "http://ti.qq.com/agreement/index.html");
      paramView.putExtra("hide_more_button", true);
      startActivity(paramView);
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      bool = true;
    }
    paramView.setChecked(bool);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return null;
        localObject1 = new QQProgressDialog(this);
        ((QQProgressDialog)localObject1).a(getString(2131367478));
        return (Dialog)localObject1;
      } while (!isResume());
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject1 = getLayoutInflater().inflate(2130903295, null);
      return DialogUtil.a(this, 230).setTitle(getString(2131367496)).setPositiveButton(2131367499, this).setNegativeButton(2131367510, new ltb(this)).addView((View)localObject1);
    case 2: 
      localObject1 = getIntent();
      str1 = ((Intent)localObject1).getStringExtra("StrTitle");
      str2 = ((Intent)localObject1).getStringExtra("StrUpgradeDesc");
      ((Intent)localObject1).getStringExtra("StrUrl");
      localObject1 = DialogUtil.a(this, 230).setTitle(str1).setMessage(str2);
      ((QQCustomDialog)localObject1).setPositiveButton("升级", new ltc(this));
      ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131368071));
      ((QQCustomDialog)localObject1).setNegativeButton("取消", new ltd(this));
      return (Dialog)localObject1;
    }
    Object localObject3 = getIntent();
    Object localObject2 = ((Intent)localObject3).getStringExtra("StrTitle");
    String str3 = ((Intent)localObject3).getStringExtra("StrUpgradeDesc");
    Object localObject1 = ((Intent)localObject3).getStringExtra("StrButton");
    String str1 = ((Intent)localObject3).getStringExtra("StrClientUrl");
    String str2 = ((Intent)localObject3).getStringExtra("StrH5Url");
    localObject3 = ((Intent)localObject3).getStringExtra("StrCode");
    localObject2 = DialogUtil.a(this, 230).setTitle((String)localObject2).setMessage(str3);
    ((QQCustomDialog)localObject2).setPositiveButton((String)localObject1, new lte(this, str1, str2, (String)localObject3));
    ((QQCustomDialog)localObject2).setNegativeButton("取消", new ltg(this));
    ReportController.a(this.app, "dc00898", "", "", "0X8006795", "0X8006795", 0, 0, "", "", "", "");
    return (Dialog)localObject2;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131297586);
      String str = getString(2131367497);
      lti locallti = (lti)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      if (this.jdField_e_of_type_Int != -1) {
        localTextView.setText(str.replace("${account}", locallti.a(this.jdField_e_of_type_Int)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131298017));
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        this.app.getApplication().refreAccountList();
      }
      a(null);
      if ((this.jdField_h_of_type_JavaLangString == null) || (this.jdField_h_of_type_JavaLangString.length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != this.jdField_h_of_type_JavaLangString.length() + 1))
        {
          this.app.getApplication().refreAccountList();
          return;
        }
        if ((!paramCharSequence.substring(0, this.jdField_h_of_type_JavaLangString.length()).equals(this.jdField_h_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(this.jdField_h_of_type_JavaLangString.length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(1);
    }
    this.jdField_h_of_type_JavaLangString = null;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing()) {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.g) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.a()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */