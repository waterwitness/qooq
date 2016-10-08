package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.DisplayMode;
import com.tencent.mobileqq.gesturelock.LockPatternView.OnPatternListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import lns;
import lnt;
import lnu;
import lnv;
import lnw;
import lnx;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class GesturePWDUnlockActivity
  extends BaseActivity
  implements View.OnClickListener, Animation.AnimationListener, LockPatternView.OnPatternListener
{
  public static final int a = 3;
  public static final String a = "key_gesture_unlock_failed";
  public static final String b = "key_gesture_from_jumpactivity";
  private static final int jdField_c_of_type_Int = 9999;
  public static final String c = "key_gesture_from_authority";
  private static final int jdField_d_of_type_Int = 5;
  public static final String d = "key_req_by_contact_sync";
  public static final String g = "com.tencent.mobileqq.gestureunlock";
  private static final String i = "Q.gesturelock.unlock";
  private float jdField_a_of_type_Float;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public LockPatternView a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private long[] jdField_a_of_type_ArrayOfLong;
  int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  String jdField_f_of_type_JavaLangString;
  private int g;
  private String h;
  
  public GesturePWDUnlockActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 5;
    this.h = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Long = 0L;
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new lnw(this);
    this.g = 5;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lnx(this);
  }
  
  private void a(View paramView)
  {
    this.jdField_f_of_type_Int = 0;
    this.g = 5;
    this.jdField_a_of_type_ArrayOfLong = new long[] { 50L, 100L, 100L, 100L, 100L };
    this.jdField_a_of_type_ArrayOfInt = new int[] { (int)(-20.0F * this.jdField_a_of_type_Float), (int)(20.0F * this.jdField_a_of_type_Float), (int)(-15.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), 0 };
    this.jdField_a_of_type_AndroidViewView = paramView;
    f();
  }
  
  private void g()
  {
    this.h = getString(2131370255);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_gesture_from_jumpactivity", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("scheme_content");
      this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("pkg_name");
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_e_of_type_Int = GesturePWDUtils.getGestureUnlockFailedTime(getActivity(), this.app.a());
  }
  
  private void h()
  {
    setTitle(2131370241);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298317));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298318));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131298319));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298316));
    Object localObject1;
    if ((this.app != null) && (this.app.a() != null))
    {
      localObject1 = this.app.a(this.app.a(), (byte)3, false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298321));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.jdField_a_of_type_Float <= 1.0D)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(this.jdField_a_of_type_Float * 240.0F));
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(this.jdField_a_of_type_Float * 240.0F));
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if ((this.jdField_e_of_type_Int > 0) && (this.jdField_e_of_type_Int < 5))
    {
      this.jdField_b_of_type_Int = (5 - this.jdField_e_of_type_Int);
      Object localObject2 = MessageFormat.format(this.h, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427996));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_b_of_type_Int + "";
      int j = ((String)localObject2).indexOf((String)localObject1);
      localObject2 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject2).setSpan(new StyleSpan(1), j, ((String)localObject1).length() + j, 18);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
    if (this.jdField_e_of_type_Int == 5)
    {
      this.jdField_b_of_type_Int = 0;
      d();
    }
  }
  
  public void a() {}
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      String str1 = GesturePWDUtils.getGesturePWD(this, this.app.a());
      String str2 = MD5.toMD5(GesturePWDUtils.patternToString(paramList));
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.app.a());
      if ((str1 != null) && (((str2 != null) && (str2.equals(str1))) || ((paramList != null) && (paramList.equals(str1)))))
      {
        BaseActivity.isUnLockSuccess = true;
        if (this.jdField_b_of_type_Boolean)
        {
          paramList = new Intent(this, ContactSyncJumpActivity.class);
          paramList.putExtra("key_req_from_lock_screen", true);
          paramList.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
          startActivity(paramList);
          moveTaskToBack(true);
        }
        for (;;)
        {
          finish();
          GesturePWDUtils.setGestureLocking(this, false);
          if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
          {
            paramList = JumpParser.a(this.app, getActivity(), this.jdField_e_of_type_JavaLangString);
            paramList.b(this.jdField_f_of_type_JavaLangString);
            paramList.b();
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.gesturelock.unlock", 2, "unlock success.");
          }
          this.jdField_b_of_type_Int = 5;
          QWalletPushManager.a(this.app, true);
          return;
          setResult(-1);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
      this.jdField_b_of_type_Int -= 1;
      if (this.jdField_b_of_type_Int > 0)
      {
        c();
        return;
      }
      d();
      return;
    }
    QQToast.a(this, 1, getString(2131370246), 0).b(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    this.jdField_b_of_type_Int -= 1;
    if (this.jdField_b_of_type_Int > 0)
    {
      c();
      return;
    }
    d();
  }
  
  public void b() {}
  
  public void b(List paramList) {}
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedInRange");
    }
    Object localObject = MessageFormat.format(this.h, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427996));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = this.jdField_b_of_type_Int + "";
    int j = ((String)localObject).indexOf(str);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new StyleSpan(1), j, str.length() + j, 18);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    BaseApplicationImpl.a.postDelayed(new lns(this), 500L);
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedOutRange");
    }
    BaseApplicationImpl.a.postDelayed(new lnt(this), 500L);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 231, getString(2131370257), getString(2131370258), new lnu(this), null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new lnv(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 9999)
    {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    else {
      return;
    }
    setResult(0);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onCreate begin.");
    }
    getWindow().setFlags(1024, 1024);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903371);
    g();
    h();
    GesturePWDUtils.setGestureLocking(this, true);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = new Intent();
    paramBundle.setAction("com.tencent.mobileqq.gestureunlock");
    paramBundle.putExtra("timeid", this.jdField_a_of_type_Long);
    sendBroadcast(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.gestureunlock");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.d = false;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    GesturePWDUtils.setGestureUnlockFailedTime(getActivity(), this.app.a(), 5 - this.jdField_b_of_type_Int);
  }
  
  public void e()
  {
    this.jdField_b_of_type_Int = 5;
    GesturePWDUtils.setGesturePWDState(this, this.app.a(), 0);
    GesturePWDUtils.setGesturePWDMode(this, this.app.a(), 21);
    GesturePWDUtils.setGestureUnlockFailed(this, this.app.a());
    Object localObject = getAppRuntime().getApplication().getAllAccounts();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
          this.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
        }
      }
      getAppRuntime().getApplication().refreAccountList();
    }
    GesturePWDUtils.setGestureLocking(this, false);
    if (QQPlayerService.a())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      sendBroadcast((Intent)localObject);
    }
    this.app.logout(true);
    localObject = new Intent(this, LoginActivity.class);
    if (this.jdField_c_of_type_Boolean)
    {
      ((Intent)localObject).putExtra("key_gesture_from_authority", true);
      GesturePWDUtils.setGestureLocking(this, false);
      startActivityForResult((Intent)localObject, 9999);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
      ((Intent)localObject).putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      startActivity((Intent)localObject);
    }
    for (;;)
    {
      finish();
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("key_gesture_unlock_failed", true);
        ((Intent)localObject).putExtra("tab_index", MainFragment.a);
        startActivity((Intent)localObject);
      }
      else if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
      {
        ((Intent)localObject).putExtra("scheme_content", this.jdField_e_of_type_JavaLangString);
        ((Intent)localObject).putExtra("pkg_name", this.jdField_f_of_type_JavaLangString);
        startActivity((Intent)localObject);
      }
    }
  }
  
  void f()
  {
    int j = 0;
    if ((this.jdField_f_of_type_Int < this.g) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length >= this.g) && (this.jdField_a_of_type_ArrayOfLong != null) && (this.jdField_a_of_type_ArrayOfLong.length >= this.g))
    {
      if (this.jdField_f_of_type_Int > 0) {
        j = this.jdField_a_of_type_ArrayOfInt[(this.jdField_f_of_type_Int - 1)];
      }
      int k = this.jdField_a_of_type_ArrayOfInt[this.jdField_f_of_type_Int];
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(j, k, 0.0F, 0.0F);
      localTranslateAnimation.setAnimationListener(this);
      localTranslateAnimation.setDuration(this.jdField_a_of_type_ArrayOfLong[this.jdField_f_of_type_Int]);
      this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
      this.jdField_f_of_type_Int += 1;
      return;
    }
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968589, 2130968621);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    f();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean))
    {
      setResult(0);
      return super.onBackEvent();
    }
    moveTaskToBack(true);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    e();
    GesturePWDUtils.setGestureUnlockFailedType(this, 0);
    StatisticCollector.a(getBaseContext()).a(this.app, this.app.a(), "Gesture_pwd", "click_forgive", 0, 1, "0", null, null, null, null);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\GesturePWDUnlockActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */