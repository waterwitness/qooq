package com.tencent.mobileqq.troopreward;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import vvv;
import vvw;
import vvy;
import vvz;
import vwa;
import vwb;
import vwc;

public class TroopRewardDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  protected static final long a = 2000L;
  public static final String a = ".troop.troop_reward.detailActivity";
  protected static final int b = 4;
  public int a;
  public Context a;
  protected View a;
  public FrameLayout a;
  protected ImageView a;
  protected TroopObserver a;
  protected RewardImageDetailView a;
  protected TroopRewardDetailActivity.OrientationDetector a;
  public TroopRewardInfo a;
  protected TroopRewardVideoPlayView a;
  protected QQProgressDialog a;
  public QWalletPayProgressDialog a;
  protected boolean a;
  protected View b;
  protected FrameLayout b;
  public boolean b;
  
  public TroopRewardDetailActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vvw(this);
  }
  
  private void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("system=android");
    localStringBuilder.append("&");
    localStringBuilder.append("version=" + Build.VERSION.RELEASE);
    localStringBuilder.append("&");
    localStringBuilder.append("uintype=1");
    localStringBuilder.append("&");
    localStringBuilder.append("eviluin=" + this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.ownerUin);
    localStringBuilder.append("&");
    localStringBuilder.append("appname=KQQ");
    localStringBuilder.append("&");
    localStringBuilder.append("appid=2400002");
    localStringBuilder.append("&");
    localStringBuilder.append("subapp=troopreward");
    localStringBuilder.append("&");
    localStringBuilder.append("scene=1108");
    localStringBuilder.append("&");
    localStringBuilder.append("srv_para=groupid:" + this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin + "|img:" + this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.clearPicUrl);
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.type == 2) {
      localStringBuilder.append("|vid:" + this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.vid);
    }
    localStringBuilder.append("|rewardid:" + this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.rewardId);
    ThreadManager.a(new vwb(this, localStringBuilder.toString()), 5, null, false);
  }
  
  public CharSequence a(int paramInt)
  {
    for (;;)
    {
      try
      {
        String str2 = String.valueOf(paramInt / 3600);
        String str1 = String.valueOf(paramInt % 3600 / 60);
        if ((str2.equals("0")) && (str1.equals("0")))
        {
          str1 = "1";
          paramInt = Color.parseColor("#f84a50");
          SpannableString localSpannableString = new SpannableString(getString(2131365282, new Object[] { str2, str1 }));
          localSpannableString.setSpan(new ForegroundColorSpan(paramInt), 0, str2.length(), 33);
          ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(paramInt);
          paramInt = str2.length();
          int i = str2.length();
          localSpannableString.setSpan(localForegroundColorSpan, paramInt + 2, str1.length() + (i + 2), 33);
          return localSpannableString;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(".troop.troop_reward.detailActivity", 2, "getPunishTips exp", localException);
        }
        return "";
      }
    }
  }
  
  public String a(int paramInt)
  {
    int i = paramInt / 60;
    paramInt %= 60;
    StringBuilder localStringBuilder = new StringBuilder();
    if (i < 10)
    {
      localObject = "0" + i;
      localStringBuilder = localStringBuilder.append(localObject).append(":");
      if (paramInt >= 10) {
        break label102;
      }
    }
    label102:
    for (Object localObject = "0" + paramInt;; localObject = Integer.valueOf(paramInt))
    {
      return (String)localObject;
      localObject = Integer.valueOf(i);
      break;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131296895));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297886));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297082);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    findViewById(2131297083).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector = new TroopRewardDetailActivity.OrientationDetector(getApplicationContext());
    b();
  }
  
  public void a(String paramString)
  {
    if (isResume()) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramString, 1).b(getTitleBarHeight());
    }
  }
  
  public void a(String paramString, TextView paramTextView, boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300719);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131300717);
    int i;
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (paramString.length() <= 5)
      {
        paramTextView.setTextSize(1, 30.0F);
        i = 18;
        if (paramString.length() < 9) {
          break label225;
        }
        paramString = paramString.substring(0, 8) + "\n" + paramString.substring(8);
        int j = i * 2 + i / 2;
        if (paramBoolean)
        {
          ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
          localLayoutParams.height += DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, j);
          localRelativeLayout.setLayoutParams(localLayoutParams);
        }
        i = j + i + 1;
      }
    }
    label225:
    for (;;)
    {
      if (paramBoolean) {
        localImageView.setPadding(localImageView.getPaddingLeft(), localImageView.getPaddingTop(), localImageView.getPaddingRight(), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, i));
      }
      paramTextView.setText(paramString);
      return;
      paramTextView.setTextSize(1, 24.0F);
      i = 12;
      break;
      paramTextView.setText("");
      return;
    }
  }
  
  protected boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo = ((TroopRewardInfo)getIntent().getSerializableExtra("rewardInfo"));
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo = new TroopRewardInfo();
    }
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege = 100;
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.blurPicUrl = "";
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.clearPicUrl = "";
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.ownerUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.rewardId))) {
      return false;
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (NetworkUtil.e(getApplicationContext())) {
      if (((TroopHandler)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin, this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.ownerUin, this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.rewardId, 4)) {
        b(getString(2131365295));
      }
    }
    for (;;)
    {
      return true;
      QQToast.a(this, getString(2131368805), 1).b(getTitleBarHeight());
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 100) {}
    do
    {
      do
      {
        return true;
        if (paramInt1 != 1) {
          break;
        }
      } while ((paramInt2 != 40) && (paramInt2 != 41));
      return false;
    } while ((paramInt1 != 2) || ((paramInt2 != 40) && (paramInt2 != 41) && (paramInt2 != 0)));
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
    Object localObject1 = findViewById(2131297392);
    ((View)localObject1).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
    Object localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 22)
    {
      this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject2).inflate(2130903933, this.jdField_b_of_type_AndroidWidgetFrameLayout, false);
      localObject5 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300718);
      localObject6 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300721);
      localObject7 = this.jdField_b_of_type_AndroidViewView.findViewById(2131300720);
      localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131300732);
      localObject2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300731);
      localObject4 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300736);
      localObject3 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300733);
      a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.msg, (TextView)localObject5, false);
      if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.type == 2)
      {
        ((TextView)localObject6).setText(a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.videoDuration));
        ((View)localObject7).setVisibility(0);
        localObject5 = getString(2131365277);
        localObject6 = getString(2131365278);
        localObject6 = (String)localObject5 + (String)localObject6;
        localObject7 = new SpannableString((CharSequence)localObject6);
        ((SpannableString)localObject7).setSpan(new vvv(this), ((String)localObject5).length(), ((String)localObject6).length(), 33);
        ((TextView)localObject4).setText((CharSequence)localObject7);
        ((TextView)localObject4).setHighlightColor(0);
        ((TextView)localObject4).setMovementMethod(LinkMovementMethod.getInstance());
        localObject4 = String.format("%.2f", new Object[] { Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.rewardFee / 100.0F) });
        localObject5 = getString(2131365301, new Object[] { localObject4 });
        localObject6 = new SpannableString((CharSequence)localObject5);
        ((SpannableString)localObject6).setSpan(new AbsoluteSizeSpan(15, true), ((String)localObject4).length(), ((String)localObject5).length(), 33);
        ((TextView)localObject2).setText((CharSequence)localObject6);
        if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.payMemberNum <= 0) {
          break label627;
        }
        ((TextView)localObject3).setText(getString(2131365300, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.payMemberNum) }));
        ((TextView)localObject3).setOnClickListener(this);
        label440:
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300735));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        ((View)localObject1).setOnClickListener(this);
      }
    }
    for (;;)
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.type, this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege))
      {
        this.jdField_a_of_type_ComTencentMobileqqTrooprewardRewardImageDetailView = new RewardImageDetailView(this.jdField_a_of_type_AndroidContentContext);
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqTrooprewardRewardImageDetailView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTrooprewardRewardImageDetailView.setOutAnimView(this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqTrooprewardRewardImageDetailView.a(getWindowManager().getDefaultDisplay().getRotation());
        this.jdField_a_of_type_ComTencentMobileqqTrooprewardRewardImageDetailView.a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo);
        if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector != null) {
          this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector.a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardRewardImageDetailView);
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTrooprewardRewardImageDetailView);
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
      }
      return;
      ((View)localObject7).setVisibility(8);
      break;
      label627:
      ((TextView)localObject3).setText("");
      ((TextView)localObject3).setOnClickListener(null);
      break label440;
      if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 0)
      {
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.type == 1)
        {
          this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject2).inflate(2130903932, this.jdField_b_of_type_AndroidWidgetFrameLayout, false);
          ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300729)).setText(getString(2131365284));
          if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector != null) {
            this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector.enable();
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.type == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView = new TroopRewardVideoPlayView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView.setOutTitleBar(this.jdField_a_of_type_AndroidViewView);
          localObject1 = new FrameLayout.LayoutParams(-1, -1);
          this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView.setTroopRewardInfo(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo);
          this.jdField_b_of_type_AndroidViewView = null;
          this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 1) || (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 5) || (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 2))
      {
        this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject2).inflate(2130903930, this.jdField_b_of_type_AndroidWidgetFrameLayout, false);
        localObject1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300718);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300721);
        localObject3 = this.jdField_b_of_type_AndroidViewView.findViewById(2131300720);
        localObject4 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300722);
        localObject5 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300723);
        localObject6 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300724);
        ((TextView)localObject5).setOnClickListener(this);
        a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.msg, (TextView)localObject1, true);
        if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.payMemberNum > 0)
        {
          ((TextView)localObject4).setText(getString(2131365276, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.payMemberNum + "" }));
          ((TextView)localObject4).setVisibility(0);
          label1025:
          if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.type != 2) {
            break label1111;
          }
          ((TextView)localObject2).setText(a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.videoDuration));
          ((View)localObject3).setVisibility(0);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege != 2) {
            break label1120;
          }
          ((TextView)localObject6).setVisibility(0);
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.punishWarningInfo)) {
            break;
          }
          ((TextView)localObject6).setText(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.punishWarningInfo);
          break;
          ((TextView)localObject4).setVisibility(8);
          break label1025;
          label1111:
          ((View)localObject3).setVisibility(8);
        }
        label1120:
        ((TextView)localObject6).setVisibility(8);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 40)
      {
        this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject2).inflate(2130903931, this.jdField_b_of_type_AndroidWidgetFrameLayout, false);
        localObject1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300726);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300727);
        ((TextView)localObject1).setText(getString(2131365280));
        ((TextView)localObject2).setText(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.punishWarningInfo);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f24971"));
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 41)
      {
        this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject2).inflate(2130903934, this.jdField_b_of_type_AndroidWidgetFrameLayout, false);
        localObject1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300726);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300737);
        localObject3 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300727);
        ((TextView)localObject1).setText(getString(2131365280));
        ((TextView)localObject2).setText(a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.punishLeftTime));
        ((TextView)localObject3).setText(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.punishWarningInfo);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f24971"));
      }
    }
  }
  
  protected void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void c()
  {
    String str = "http://qun.qq.com/qunpay/reward/history.html?_wv=1039&_bid=2313&gc=" + this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin + "&id=" + this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.rewardId;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "openPayRecord:" + str);
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo != null)
    {
      String str1 = "";
      if (paramString.equals("Suc_pay")) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.rewardFee + "";
      }
      String str2 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.type == 2) {
        str2 = "1";
      }
      ReportController.b(this.app, "dc00899", "Grp_paypic", "", "Guestpaypic", paramString, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin, str1, str2, "");
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward.detailActivity", 2, "reportClickEvent: opName=" + paramString);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
    ((TroopRewardMgr)this.app.getManager(151)).a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin, this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.rewardId, new vwc(this));
  }
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_2
    //   1: istore 7
    //   3: iload_1
    //   4: bipush 9
    //   6: if_icmpne +260 -> 266
    //   9: iload_2
    //   10: istore 7
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpne +252 -> 266
    //   17: iload_2
    //   18: istore 7
    //   20: aload_3
    //   21: ifnull +245 -> 266
    //   24: aload_3
    //   25: ldc_w 633
    //   28: invokevirtual 637	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull +247 -> 282
    //   38: aload 5
    //   40: invokevirtual 170	java/lang/String:length	()I
    //   43: ifle +239 -> 282
    //   46: new 639	org/json/JSONObject
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 641	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +239 -> 298
    //   62: aload 4
    //   64: ldc_w 643
    //   67: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: pop
    //   71: aload 4
    //   73: ldc_w 648
    //   76: iconst_m1
    //   77: invokevirtual 652	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   80: istore 7
    //   82: aload 4
    //   84: ldc_w 654
    //   87: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 4
    //   92: iload 7
    //   94: istore_2
    //   95: aload 4
    //   97: ifnull +201 -> 298
    //   100: iload 7
    //   102: istore_2
    //   103: aload 4
    //   105: invokevirtual 170	java/lang/String:length	()I
    //   108: ifle +190 -> 298
    //   111: new 639	org/json/JSONObject
    //   114: dup
    //   115: aload 4
    //   117: invokespecial 641	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: astore 4
    //   122: iload 7
    //   124: istore_2
    //   125: aload_0
    //   126: getfield 616	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   129: invokevirtual 657	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   132: iload_2
    //   133: ifne +171 -> 304
    //   136: aload 4
    //   138: ifnull +166 -> 304
    //   141: aload_0
    //   142: getfield 364	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: sipush 151
    //   148: invokevirtual 621	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   151: checkcast 623	com/tencent/mobileqq/troop/utils/TroopRewardMgr
    //   154: aload 5
    //   156: aload_0
    //   157: getfield 364	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   160: invokevirtual 659	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   163: invokevirtual 662	com/tencent/mobileqq/troop/utils/TroopRewardMgr:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_0
    //   167: ldc_w 598
    //   170: invokevirtual 664	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:c	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: iconst_1
    //   175: putfield 666	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:jdField_b_of_type_Boolean	Z
    //   178: aload_0
    //   179: iconst_0
    //   180: putfield 668	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:jdField_a_of_type_Int	I
    //   183: aload_0
    //   184: getfield 364	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   187: bipush 20
    //   189: invokevirtual 369	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   192: checkcast 371	com/tencent/mobileqq/app/TroopHandler
    //   195: aload_0
    //   196: getfield 78	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo	Lcom/tencent/mobileqq/troopreward/TroopRewardInfo;
    //   199: getfield 96	com/tencent/mobileqq/troopreward/TroopRewardInfo:troopUin	Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 78	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo	Lcom/tencent/mobileqq/troopreward/TroopRewardInfo;
    //   206: getfield 83	com/tencent/mobileqq/troopreward/TroopRewardInfo:ownerUin	Ljava/lang/String;
    //   209: aload_0
    //   210: getfield 78	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo	Lcom/tencent/mobileqq/troopreward/TroopRewardInfo;
    //   213: getfield 114	com/tencent/mobileqq/troopreward/TroopRewardInfo:rewardId	Ljava/lang/String;
    //   216: iconst_4
    //   217: invokevirtual 374	com/tencent/mobileqq/app/TroopHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z
    //   220: pop
    //   221: aload_0
    //   222: aload_0
    //   223: ldc_w 669
    //   226: invokevirtual 377	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:getString	(I)Ljava/lang/String;
    //   229: invokevirtual 379	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:b	(Ljava/lang/String;)V
    //   232: aload_0
    //   233: getfield 364	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   236: ldc_w 600
    //   239: ldc_w 671
    //   242: ldc -68
    //   244: ldc_w 673
    //   247: ldc_w 675
    //   250: iconst_0
    //   251: iconst_0
    //   252: ldc -68
    //   254: ldc -68
    //   256: ldc -68
    //   258: ldc -68
    //   260: invokestatic 609	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   263: iload_2
    //   264: istore 7
    //   266: aload_0
    //   267: iload_1
    //   268: iload 7
    //   270: aload_3
    //   271: invokespecial 677	com/tencent/mobileqq/app/BaseActivity:doOnActivityResult	(IILandroid/content/Intent;)V
    //   274: return
    //   275: astore 4
    //   277: aload 4
    //   279: invokevirtual 680	java/lang/Exception:printStackTrace	()V
    //   282: aconst_null
    //   283: astore 4
    //   285: goto -228 -> 57
    //   288: astore 4
    //   290: aload 4
    //   292: invokevirtual 680	java/lang/Exception:printStackTrace	()V
    //   295: iload 7
    //   297: istore_2
    //   298: aconst_null
    //   299: astore 4
    //   301: goto -176 -> 125
    //   304: aload_0
    //   305: aload_0
    //   306: ldc_w 681
    //   309: invokevirtual 377	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:getString	(I)Ljava/lang/String;
    //   312: invokevirtual 682	com/tencent/mobileqq/troopreward/TroopRewardDetailActivity:a	(Ljava/lang/String;)V
    //   315: iload_2
    //   316: istore 7
    //   318: goto -52 -> 266
    //   321: astore 6
    //   323: goto -191 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	TroopRewardDetailActivity
    //   0	326	1	paramInt1	int
    //   0	326	2	paramInt2	int
    //   0	326	3	paramIntent	Intent
    //   55	82	4	localObject1	Object
    //   275	3	4	localException1	Exception
    //   283	1	4	localObject2	Object
    //   288	3	4	localException2	Exception
    //   299	1	4	localObject3	Object
    //   31	124	5	str	String
    //   321	1	6	localException3	Exception
    //   1	316	7	i	int
    // Exception table:
    //   from	to	target	type
    //   46	57	275	java/lang/Exception
    //   111	122	288	java/lang/Exception
    //   125	132	321	java/lang/Exception
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().addFlags(8192);
    }
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2130903929);
    if (!a())
    {
      finish();
      return true;
    }
    a();
    new IntentFilter().addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    c("Exp_guestpay");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector != null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector.disable();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardVideoPlayView.d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector != null) && (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 0) && (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.type == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity$OrientationDetector.enable();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public boolean isSupportScreenShot()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131300732)
    {
      c("Clk_paybut");
      if (!NetworkUtil.e(getApplicationContext())) {
        a(getString(2131368805));
      }
    }
    label362:
    label367:
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        a(getString(2131365292));
        return;
      }
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin))
      {
        paramView = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(getString(2131368978)).setMessage(getString(2131365291));
        paramView.setNegativeButton(getString(2131367262), new vvy(this, paramView));
        paramView.setNegativeButtonContentDescription(getString(2131362032));
        paramView.setPositiveButton(getString(2131365274), new vvz(this));
        paramView.setPositiveButtonContentDescription(getString(2131362031));
        paramView.show();
        return;
      }
      d();
      return;
      if (i == 2131300723)
      {
        if (!NetworkUtil.e(getApplicationContext()))
        {
          a(getString(2131368805));
          return;
        }
        TroopRewardMgr.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin);
        finish();
        return;
      }
      if (i == 2131297083)
      {
        finish();
        return;
      }
      if (i == 2131297392)
      {
        paramView = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
        paramView.c(getString(2131365294));
        paramView.c(getString(2131365293));
        paramView.d(2131367262);
        paramView.a(new vwa(this, paramView));
        paramView.show();
        c("Clk_filter");
        return;
      }
      if (i == 2131300735)
      {
        boolean bool;
        if (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            break label362;
          }
          bool = true;
          this.jdField_a_of_type_Boolean = bool;
          if (!this.jdField_a_of_type_Boolean) {
            break label367;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840188);
        }
        for (;;)
        {
          c("Clk_checkbut");
          return;
          bool = false;
          break;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840189);
        }
      }
    } while (i != 2131300733);
    c();
    c("Clk_paypeople");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopreward\TroopRewardDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */