package com.tencent.biz.troopgift;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jep;
import jeq;
import jes;
import jet;
import jeu;
import jev;
import jew;

public class TroopGiftPanel
  extends LinearLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, TabBarView.OnTabChangeListener
{
  protected static final int a = 5;
  protected static final String a = "?_bid=2204&_wvSb=1&from=7&troopUin=%s";
  public static String[] a;
  public static final int b = 0;
  public static final int c = 1;
  protected Context a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected TroopGiftAioItemData a;
  public TroopGiftAioPanelData a;
  public TroopGiftPanel.OnShowOrHideListerner a;
  protected SessionInfo a;
  public TroopChatPie a;
  protected TabBarView a;
  public WeakReference a;
  protected boolean a;
  protected GridListViewPager[] a;
  protected RadioViewPager[] a;
  protected View b;
  public TextView b;
  protected String b;
  public boolean b;
  public String c = "0";
  protected int d;
  public int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "选择对象赠送 ", "立即赠送" };
  }
  
  public TroopGiftPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public TroopGiftPanel(Context paramContext, TroopGiftPanel.OnShowOrHideListerner paramOnShowOrHideListerner)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner = paramOnShowOrHideListerner;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "赠送", "赠送" };
  }
  
  public TroopGiftPanel(Context paramContext, TroopChatPie paramTroopChatPie)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
  }
  
  public int a()
  {
    int j = 0;
    CharSequence localCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    int i = j;
    try
    {
      if (!TextUtils.isEmpty(localCharSequence)) {
        i = Integer.parseInt(localCharSequence.toString().substring(1));
      }
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.d("zivonchen", 2, "error sendNum = " + localCharSequence);
    }
    return 0;
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_AndroidContentContext;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    AppInterface localAppInterface;
    do
    {
      return paramString;
      localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localAppInterface == null);
    Object localObject = (TroopManager)localAppInterface.getManager(51);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(a());
      if (localObject != null) {
        if (((TroopInfo)localObject).isTroopOwner(localAppInterface.a())) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      return paramString.replace("$GCODE$", a()).replace("$CLIENTVER$", "android6.5.5").replace("$UIN$", localAppInterface.a()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
      if (((TroopInfo)localObject).isAdmin())
      {
        localObject = "1";
      }
      else
      {
        localObject = "2";
        continue;
        localObject = "2";
      }
    }
  }
  
  public void a()
  {
    inflate(getContext(), 2130903903, this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt2;
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[paramInt1].setVisibility(8);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[paramInt2].setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(jdField_a_of_type_ArrayOfJavaLangString[paramInt2]);
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt2 == 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Int != -1))
    {
      localObject1 = (TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Int);
      if (localObject1 != null)
      {
        if (((TroopGiftAioItemData)localObject1).jdField_b_of_type_Int != 0) {
          break label242;
        }
        a(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)localObject1);
      if (paramInt2 != 0) {
        break label251;
      }
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
      return;
      localObject1 = localObject2;
      if (paramInt2 != 1) {
        break;
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) {
        break;
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_Int == -1) {
        break;
      }
      localObject1 = (TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_Int);
      break;
      label242:
      a(8);
    }
    label251:
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forall", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo)
  {
    a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131300605));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getResources().getString(2131365217));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getResources().getString(2131365218));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight((int)getResources().getDimension(2131493588));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectColor(Color.parseColor("#ff5984"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setBackgroundColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setWidth(100);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setWidth(300);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.d, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager = new RadioViewPager[2];
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[2];
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[0] = ((RadioViewPager)findViewById(2131300609));
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[1] = ((RadioViewPager)findViewById(2131300610));
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[i] = ((GridListViewPager)this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[i].a());
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[i].setOnItemClickListener(this);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[i].setVisibility(8);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[this.d].setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300613));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(jdField_a_of_type_ArrayOfJavaLangString[this.d]);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300614));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299438);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300611));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131300612).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300606);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300607));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ThreadManager.a(new jep(this), 5, null, true);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("x" + paramString);
  }
  
  public void b()
  {
    String str = String.format(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.c + "?_bid=2204&_wvSb=1&from=7&troopUin=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString });
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", a(str));
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968592, 0);
  }
  
  public void b(int paramInt)
  {
    a("1");
    a(8);
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.d, false);
  }
  
  public void b(String paramString)
  {
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (TroopGiftManager)((AppInterface)localObject).getManager(112);
    TroopGiftAioItemData localTroopGiftAioItemData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
    int i = localTroopGiftAioItemData.jdField_b_of_type_Int;
    if (localTroopGiftAioItemData.jdField_b_of_type_Int == 0) {
      i = a();
    }
    String str = a();
    long l = Long.parseLong(paramString);
    int k = localTroopGiftAioItemData.c;
    if (localTroopGiftAioItemData.jdField_b_of_type_Int == 0) {}
    for (int j = 1;; j = 0)
    {
      ((TroopGiftManager)localObject).a(str, 2, i, l, k, j, localTroopGiftAioItemData.jdField_a_of_type_Int, new jew(this));
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = null;
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.jdField_b_of_type_JavaLangString));
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968592, 0);
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_opr", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
  }
  
  protected void d()
  {
    Intent localIntent = TroopMemberListActivity.a(BaseApplication.getContext(), a(), 14);
    localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131365212));
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      localIntent.putExtra("troop_gift_from", ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a());
    }
    if (!this.jdField_b_of_type_Boolean) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 12006);
    }
  }
  
  public void e()
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {
      return;
    }
    ((TroopGiftManager)localAppInterface.getManager(112)).a(a(), 2, new jeq(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131299438: 
    default: 
    case 2131300613: 
    case 2131300612: 
    case 2131300606: 
    case 2131300607: 
      do
      {
        return;
        if (1 == this.d) {
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forall_send", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
        }
        Object localObject;
        int i;
        for (;;)
        {
          paramView = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((paramView == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData == null)) {
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
          i = ((TroopGiftAioItemData)localObject).jdField_b_of_type_Int;
          if (((TroopGiftAioItemData)localObject).jdField_b_of_type_Int == 0) {
            i = a();
          }
          if (this.e >= i) {
            break label445;
          }
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
          DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, paramView.getString(2131365226), paramView.getString(2131365227), paramView.getString(2131367262), paramView.getString(2131365228), new jet(this), new jeu(this)).show();
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_payremind", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
          return;
          if (this.d == 0) {
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forone_send", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
          }
        }
        if (1 == this.d)
        {
          ((TroopGiftManager)paramView.getManager(112)).a(a(), 2, i, 1, ((TroopGiftAioItemData)localObject).jdField_a_of_type_Int, new jev(this));
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.a();
          }
        }
        else if (this.d == 0)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.a();
            b(this.jdField_b_of_type_JavaLangString);
            return;
          }
          d();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.aX();
        return;
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.c)))
        {
          paramView = String.format(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.c + "?_bid=2204&_wvSb=1&from=7&troopUin=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString });
          localObject = new Intent(a(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("hide_more_button", true);
          ((Intent)localObject).putExtra("hide_operation_bar", true);
          ((Intent)localObject).putExtra("url", a(paramView));
          a().startActivityForResult((Intent)localObject, 12007);
          a().overridePendingTransition(2130968592, 0);
        }
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_pay", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
        return;
      } while ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.jdField_b_of_type_JavaLangString)));
      c();
      return;
    case 2131300614: 
    case 2131300617: 
      label445:
      new TroopGiftPanel.GiftNumInputDialog(this, a()).a();
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.a();
      }
      for (;;)
      {
        Settings.System.putInt(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "accelerometer_rotation", 0);
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_num", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.aX();
      }
    }
    d();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView.getTag() instanceof GridListAdapter.Holder))
    {
      paramView = ((GridListAdapter.Holder)paramView.getTag()).jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      if ((!paramView.jdField_a_of_type_Boolean) && ((paramAdapterView.getAdapter() instanceof GridListAdapter)))
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = paramView;
        paramView.jdField_a_of_type_Boolean = true;
        if (this.d != 0) {
          break label226;
        }
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.size())) {
          ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Int)).jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Int = paramView.e;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[0].a();
      }
    }
    while (paramView.jdField_b_of_type_Int == 0)
    {
      a(0);
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
      return;
      label226:
      if (this.d == 1)
      {
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size())) {
          ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_Int)).jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_Int = paramView.e;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[1].a();
      }
    }
    a(8);
  }
  
  public void setGiftData(TroopGiftAioPanelData paramTroopGiftAioPanelData, boolean paramBoolean)
  {
    if (paramTroopGiftAioPanelData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = paramTroopGiftAioPanelData;
    Object localObject;
    if ((paramTroopGiftAioPanelData != null) && (paramTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo != null))
    {
      if (!TextUtils.isEmpty(paramTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.a))
      {
        localObject = URLDrawable.getDrawable(paramTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.a, URLDrawable.URLDrawableOptions.obtain());
        ((URLDrawable)localObject).setDownloadListener(new jes(this));
        ((URLDrawable)localObject).setBounds(0, 0, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F), (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 14.0F));
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        ((URLDrawable)localObject).startDownload();
      }
      if (!TextUtils.isEmpty(paramTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_b_of_type_JavaLangString))
      {
        localObject = paramTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[0].setGridGiftIcon((String)localObject);
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[1].setGridGiftIcon((String)localObject);
      }
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.a)))
    {
      localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.a;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject, localURLDrawableOptions));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (paramBoolean)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_opr", 0, 0, a(), "", this.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), a()));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.size() >= 2)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Int = 1;
        localObject = (TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.get(1);
        ((TroopGiftAioItemData)localObject).jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)localObject);
      }
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[0].setData(paramTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList);
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() >= 1)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_Int = 0;
        ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[1].setData(paramTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList);
      return;
      i = 8;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\TroopGiftPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */