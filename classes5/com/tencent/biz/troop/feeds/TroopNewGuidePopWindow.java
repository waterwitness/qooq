package com.tencent.biz.troop.feeds;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.utils.TroopAioADManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import jdn;
import jdo;
import jdp;
import jdq;
import jds;
import jdt;
import jdu;
import jdv;
import jdw;
import jdx;
import org.json.JSONObject;

public class TroopNewGuidePopWindow
  extends QQCustomDialog
  implements View.OnClickListener, Observer
{
  public static final int a = 1001;
  public static final String a = "TroopTipsPopWindow";
  public static final String d = "qbiz_host_ip_map";
  public static final String e = "http://gdynamic.qpic.cn/gdynamic/";
  public Handler a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  public LinearLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public URLImageView a;
  TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  public BaseActivity a;
  public QQAppInterface a;
  public TroopFeedsDataManager.TroopNotify a;
  public TroopFeedsDataManager.TroopNotifyAd a;
  protected TroopFeedsDataManager a;
  TroopFeedsCenterLogic jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic;
  public BounceScrollView a;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  protected String b;
  public boolean b;
  public int c;
  View c;
  public TextView c;
  public String c;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean;
  protected View e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean;
  
  public TroopNewGuidePopWindow(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopFeedsCenterLogic paramTroopFeedsCenterLogic, String paramString)
  {
    super(paramBaseActivity, 2131558973);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = null;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new jdx(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (((paramBaseActivity instanceof SplashActivity)) || ((paramBaseActivity instanceof ChatActivity)))
    {
      paramBaseActivity = ((FragmentActivity)paramBaseActivity).getChatFragment();
      if ((paramBaseActivity != null) && ((paramBaseActivity.a() instanceof TroopChatPie))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = ((TroopChatPie)paramBaseActivity.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = paramTroopFeedsCenterLogic;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      paramQQAppInterface = (TroopInfoManager)paramQQAppInterface.getManager(36);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = paramQQAppInterface.a(Long.valueOf(Long.parseLong(paramString)), true);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
      this.jdField_c_of_type_JavaLangString = paramString;
      a();
      return;
      dismiss();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopTipsPopWindow", 2, paramQQAppInterface.toString());
        }
      }
    }
  }
  
  public static String a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l2 = 60L * 60L;
    long l3 = 24L * l2;
    Date localDate = new Date(1000L * paramLong);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(localDate);
    long l1;
    Calendar localCalendar2;
    Object localObject4;
    try
    {
      l1 = NetConnInfoCenter.getServerTime();
      Object localObject1 = new Date(1000L * l1);
      localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime((Date)localObject1);
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
      localObject4 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
      localObject1 = null;
      try
      {
        localObject2 = ((SimpleDateFormat)localObject2).parse((String)localObject4);
        localObject1 = localObject2;
        localObject4 = new Date(((Date)localObject2).getTime() - 1000L * l3);
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      catch (Exception localException2)
      {
        Object localObject3;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "get today failed! msg = " + localException2.getMessage());
          }
          localObject3 = null;
        }
        localObject4 = new SimpleDateFormat("HH:mm");
        l1 -= paramLong;
        paramLong = l1;
        if (l1 >= 0L) {
          break label239;
        }
        paramLong = 0L;
        if (paramLong >= 60L) {
          break label250;
        }
        return "刚刚";
        if (paramLong >= l2) {
          break label302;
        }
        l1 = ((float)paramLong / (float)60L + 0.5F);
        paramLong = l1;
        if (l1 != 0L) {
          break label282;
        }
        paramLong = 1L;
        return paramLong + "分钟前";
        if (paramLong >= l3) {
          break label419;
        }
        if (localDate.getDate() == localException1.getDate()) {
          break label355;
        }
        if (!paramBoolean1) {
          break label352;
        }
        return "昨天 " + ((SimpleDateFormat)localObject4).format(localDate);
        return "昨天";
        if (!paramBoolean3) {
          break label386;
        }
        return "今天" + ((SimpleDateFormat)localObject4).format(localDate);
        paramLong = ((float)paramLong / (float)l2 + 0.5D);
        return paramLong + "小时前";
        if ((!paramBoolean2) || (paramLong >= 72L * l2) || (((Date)localObject3).getTime() - localDate.getTime() > 1000L * l3)) {
          break label488;
        }
        if (!paramBoolean1) {
          break label485;
        }
        return "前天 " + ((SimpleDateFormat)localObject4).format(localDate);
        return "前天";
        if ((paramLong >= 48L * l2) || (localException1.getTime() - localDate.getTime() > 1000L * l3)) {
          break label553;
        }
        if (!paramBoolean1) {
          break label550;
        }
        return "昨天 " + ((SimpleDateFormat)localObject4).format(localDate);
        return "昨天";
        if (localCalendar1.get(1) != localCalendar2.get(1)) {
          break label629;
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
        if (!paramBoolean1) {
          break label621;
        }
        return localSimpleDateFormat.format(localDate) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return localSimpleDateFormat.format(localDate);
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        return "unknown";
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        l1 = System.currentTimeMillis() / 1000L;
      }
    }
    label239:
    label250:
    label282:
    label302:
    label352:
    label355:
    label386:
    label419:
    label485:
    label488:
    label550:
    label553:
    label621:
    label629:
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
  
  public static String a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qbiz_host_ip_map", 0).getString(paramString, "");
  }
  
  private boolean a(JSONObject paramJSONObject, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify != null) {
        break label35;
      }
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify  is null.");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify == null)
    {
      dismiss();
      return false;
      label35:
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.e)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(Html.fromHtml(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(Html.fromHtml(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_b_of_type_JavaLangString), 8));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Long, true, true, false));
    this.jdField_c_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new jdp(this));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_c_of_type_JavaLangString)) {
      c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_c_of_type_JavaLangString);
    }
    if (AppSetting.j) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131365246, new Object[] { Html.fromHtml(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_JavaLangString).toString(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.g, a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Long, true, true, false), Html.fromHtml(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_b_of_type_JavaLangString).toString() });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_Int == 1)) {
      c();
    }
    for (;;)
    {
      if (paramInt == 2) {
        BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).edit().putBoolean(this.jdField_c_of_type_JavaLangString, false).commit();
      }
      return true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
  }
  
  public static void b(String paramString)
  {
    ThreadManager.a(new jdo(paramString), 5, null, false);
  }
  
  private void c(String paramString)
  {
    localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    i = (int)(localDisplayMetrics.widthPixels - DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 60.0F));
    int j = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    try
    {
      URL localURL = new URL(paramString);
      String str2 = a(localURL.getHost());
      localObject = paramString;
      if (!TextUtils.isEmpty(str2)) {
        localObject = new URL("http", str2, localURL.getFile()).toString();
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject;
        float f1;
        float f2;
        localMalformedURLException.printStackTrace();
        String str1 = paramString;
        continue;
        float f3 = i;
        i = (int)(f1 / f2 * f3);
        continue;
        paramString.setURLDrawableListener(new jds(this, localDisplayMetrics));
        continue;
        i = 0;
      }
    }
    paramString = URLDrawable.getDrawable((String)localObject, i, j);
    if (paramString.getStatus() == 1)
    {
      f1 = paramString.getIntrinsicHeight();
      f2 = paramString.getIntrinsicWidth();
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (f2 == 0.0F) {
        break label293;
      }
      if (f1 > DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F))
      {
        i = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
        if (i > 0)
        {
          ((ViewGroup.LayoutParams)localObject).height = i;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131365250));
        return;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903941, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297468);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297138);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297559));
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new jdn(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131300184));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300756));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300758));
    this.jdField_a_of_type_AndroidWidgetTextView.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300716));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300753));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300754));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300752));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300751));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131365248));
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131365249));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300757));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300755);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300759);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131300761));
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setCancelable(true);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager == null);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b(1003);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b(1004);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().heightPixels - this.jdField_b_of_type_Int * 2);
  }
  
  public void a(TroopFeedsDataManager.TroopNotifyAd paramTroopNotifyAd)
  {
    if ((paramTroopNotifyAd != null) && (!TextUtils.isEmpty(paramTroopNotifyAd.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramTroopNotifyAd.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
      localObject = URLDrawable.getDrawable(paramTroopNotifyAd.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new jdu(this));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new jdv(this, paramTroopNotifyAd));
      return;
    }
    a(false, "json data null------");
  }
  
  void a(String paramString)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", paramString, 0, 0, this.jdField_c_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Int, "", "");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    ThreadManager.a(new jdq(this, paramJSONObject, paramInt), 8, null, true);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      QLog.i("zivonchen", 2, "changAdLayoutVisible show = " + paramBoolean + ", from = " + paramString);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.v())) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = ((int)(((DisplayMetrics)localObject).widthPixels - DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setMinimumHeight((int)(((DisplayMetrics)localObject).heightPixels * 0.65D));
      label85:
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localObject = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).gravity = 48;
      int i = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10.0F);
      ((WindowManager.LayoutParams)localObject).y = (this.jdField_b_of_type_Int + i);
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new jdt(this, i));
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.v())) {
        super.show();
      }
      a("exp_bulletin");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Int == 2) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.e)) {
        break label324;
      }
      a("exp_vid");
    }
    for (;;)
    {
      try
      {
        localObject = (QQText)this.jdField_a_of_type_AndroidWidgetTextView.getText();
        localObject = (QQText.LinkSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), QQText.LinkSpan.class);
        if ((localObject == null) || (localObject.length == 0)) {
          break;
        }
        a("exp_link");
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopTipsPopWindow", 2, "report exp pattern link");
      return;
      this.jdField_a_of_type_AndroidViewView.setMinimumHeight((int)(localException.heightPixels * 0.5D));
      break label85;
      label324:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_c_of_type_JavaLangString)) {
        a("exp_pic");
      }
    }
  }
  
  public void c()
  {
    TroopFeedsDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, new jdw(this));
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.deleteObserver(this);
    }
    Object localObject = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
    if (localObject != null) {}
    for (boolean bool = ((TroopGiftManager)localObject).a(this.jdField_c_of_type_JavaLangString);; bool = false)
    {
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.v()))
      {
        TroopGiftManager.a = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.g(true);
      }
      localObject = ChatActivityUtils.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((localObject != null) && (-1 == ((Integer)localObject).intValue())) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (!bool) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(1006);
        }
        localObject = (TroopAioADManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
        if (localObject != null) {
          ((TroopAioADManager)localObject).b(this.jdField_c_of_type_JavaLangString);
        }
        super.dismiss();
        return;
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((AppSetting.j) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_e_of_type_Boolean))
    {
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_JavaLangString);
      this.jdField_e_of_type_Boolean = true;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300184: 
      a("clk_iKnow");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Int == 2) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "Clk_iknow", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      }
      dismiss();
      return;
    case 2131297138: 
    case 2131300751: 
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_c_of_type_JavaLangString);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localObject1 != null) && (localObject2 != null)) {
        if (!((String)localObject2).equals(((TroopInfo)localObject1).troopowneruin)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      paramView.putExtra("url", "http://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=" + this.jdField_c_of_type_JavaLangString + "&role=" + i + "&actionIcon=1");
      paramView.putExtra("webStyle", "noBottomBar");
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      a("clk_history");
      return;
      if ((((TroopInfo)localObject1).Administrator != null) && (((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2)))
      {
        i = 1;
        continue;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.e))
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.e);
          paramView.putExtra("webStyle", "noBottomBar");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
          a("clk_vid");
          return;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.d)) {
          break;
        }
        localObject2 = new ArrayList();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.d;
        try
        {
          URL localURL = new URL((String)localObject1);
          String str = a(localURL.getHost());
          paramView = (View)localObject1;
          if (!TextUtils.isEmpty(str)) {
            paramView = new URL("http", str, localURL.getFile()).toString();
          }
        }
        catch (MalformedURLException paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
            paramView = (View)localObject1;
          }
        }
        ((ArrayList)localObject2).add(paramView);
        TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, (ArrayList)localObject2, true, "", -1);
        a("clk_pic");
        return;
      }
      i = 2;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.v())) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof Integer));
        paramObservable = (Integer)paramObject;
        if (paramObservable.intValue() != 106) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_OrgJsonJSONObject == null);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_OrgJsonJSONObject, 2);
      return;
    } while ((paramObservable.intValue() != 1007) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b == null));
    a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troop\feeds\TroopNewGuidePopWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */