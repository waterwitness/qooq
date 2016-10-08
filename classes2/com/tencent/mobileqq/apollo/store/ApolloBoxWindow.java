package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloBoxWindow
  extends RelativeLayout
  implements View.OnClickListener, Runnable, BusinessObserver
{
  static float jdField_a_of_type_Float = 0.0F;
  private static final String jdField_a_of_type_JavaLangString = "ApolloBoxWindow";
  static float jdField_b_of_type_Float = 0.0F;
  private static final int jdField_b_of_type_Int = 0;
  private static final String jdField_b_of_type_JavaLangString = "主页君正在玩命加载";
  private static final int jdField_c_of_type_Int = 1;
  private static final String jdField_c_of_type_JavaLangString = "来晚一步，贴纸刚被主人领走啦~";
  private static final int jdField_d_of_type_Int = 2;
  private static final String jdField_d_of_type_JavaLangString = "apollo_interact.thank_zan";
  private static final int jdField_e_of_type_Int = 3;
  private static final String jdField_e_of_type_JavaLangString = "apollo_interact.take_chips";
  private static final int jdField_f_of_type_Int = 4;
  private static final int jdField_g_of_type_Int = -469762048;
  private static final int jdField_h_of_type_Int = 1;
  private static final int jdField_i_of_type_Int = 2;
  private static final int jdField_j_of_type_Int = 3;
  private static final int k = 4;
  private static final int l = 5;
  private static final int m = 6;
  private static final int n = 7;
  private static final int o = 8;
  private static final int p = 9;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ApolloBoxData jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData;
  private ApolloBoxWindow.ApolloCardLayout jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private String jdField_g_of_type_JavaLangString;
  private String jdField_h_of_type_JavaLangString;
  private String jdField_i_of_type_JavaLangString;
  private String jdField_j_of_type_JavaLangString;
  private int q;
  private int r;
  private int s;
  private int t;
  
  public ApolloBoxWindow(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public static void a()
  {
    jdField_a_of_type_Float = FontSettingManager.a() / 16.0F;
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = 1.0F;
    }
    jdField_b_of_type_Float = DeviceInfoUtil.a() / jdField_a_of_type_Float;
    if (jdField_b_of_type_Float == 0.0F) {
      jdField_b_of_type_Float = DeviceInfoUtil.a();
    }
  }
  
  private void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("6.5.5");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.thank_zan");
        if (!TextUtils.isEmpty(paramString1)) {
          break label220;
        }
        paramString1 = "android";
        ((JSONObject)localObject).put("from", paramString1);
        ((JSONObject)localObject).put("touin", Long.parseLong(paramString2));
        ((JSONObject)localObject).put("chestid", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.j);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString1 = new NewIntent(this.jdField_a_of_type_AndroidContentContext, WebSSOAgentServlet.class);
        paramString1.putExtra("extra_cmd", "apollo_interact.thank_zan");
        paramString1.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramString1.setObserver(this);
        paramAppInterface.startServlet(paramString1);
        return;
      }
      catch (Exception paramAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ApolloBoxWindow", 2, "addFlower failed ", paramAppInterface);
      return;
      label220:
      paramString1 = "android." + paramString1;
    }
  }
  
  private void b()
  {
    a();
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject2 = new View(this.jdField_a_of_type_AndroidContentContext);
    ((View)localObject2).setBackgroundColor(-469762048);
    super.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843457);
    localObject2 = new RelativeLayout.LayoutParams(ApolloUtil.a(50.0F, jdField_b_of_type_Float), ApolloUtil.a(52.0F, jdField_b_of_type_Float));
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = ApolloUtil.a(5.0F, jdField_b_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ApolloUtil.a(25.0F, jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(17.0F / jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369134);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    super.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(17.0F / jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.h = "主页君正在玩命加载";
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.h);
    localLayoutParams.bottomMargin = ApolloUtil.a(25.0F, jdField_b_of_type_Float);
    ((LinearLayout)localObject2).addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(ApolloUtil.a(250.0F, jdField_b_of_type_Float) * ApolloWrapperCardView.jdField_b_of_type_Float));
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    URLDrawable localURLDrawable = ApolloImageDownloader.a("apollo_error.png", null, ApolloImageDownloader.a("apollo_error.png"));
    localURLDrawable.setTargetDensity(((Resources)localObject1).getDisplayMetrics().densityDpi / 2);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
    ((LinearLayout)localObject2).addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = ApolloUtil.a(66.0F, jdField_b_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ApolloUtil.a(129.0F, jdField_b_of_type_Float);
    super.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838323);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout = new ApolloBoxWindow.ApolloCardLayout(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = ApolloUtil.a(66.0F, jdField_b_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ApolloUtil.a(129.0F, jdField_b_of_type_Float);
    super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout, (ViewGroup.LayoutParams)localObject1);
    this.s = ((int)Math.min(DeviceInfoUtil.g(), DeviceInfoUtil.f()));
    this.s = (this.s - ApolloUtil.a(40.0F, jdField_b_of_type_Float) >> 1);
    this.s = Math.min(this.s, ApolloUtil.a(150.0F, jdField_b_of_type_Float));
    this.t = ApolloUtil.a(44.0F, jdField_b_of_type_Float);
    localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject1).setOrientation(0);
    ((LinearLayout)localObject1).setGravity(17);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ApolloUtil.a(60.0F, jdField_b_of_type_Float);
    super.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(this.s, this.t);
    this.d = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.d.setGravity(17);
    this.d.setTextSize(18.0F / jdField_a_of_type_Float);
    this.d.setTextColor(-1);
    this.d.setText("送花谢谢ta");
    this.d.setOnClickListener(this);
    ((LinearLayout.LayoutParams)localObject2).rightMargin = ApolloUtil.a(10.0F, jdField_b_of_type_Float);
    ((LinearLayout)localObject1).addView(this.d, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(this.s, this.t);
    this.c = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.c.setGravity(17);
    this.c.setTextSize(18.0F / jdField_a_of_type_Float);
    this.c.setTextColor(-1);
    this.c.setText("查看我的任务进度");
    this.c.setOnClickListener(this);
    ((LinearLayout)localObject1).addView(this.c, (ViewGroup.LayoutParams)localObject2);
    super.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this, (int)DeviceInfoUtil.h(), (int)DeviceInfoUtil.i(), true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
  }
  
  public void a(View paramView, String paramString1, String paramString2, AppInterface paramAppInterface, PopupWindow.OnDismissListener paramOnDismissListener)
  {
    if ((paramView == null) || (paramAppInterface == null) || (paramString1 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.j = paramString2;
    this.f = paramString1;
    this.g = paramAppInterface.a();
    this.jdField_a_of_type_Int = 0;
    this.r = 8;
    this.jdField_a_of_type_Boolean = false;
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("6.5.5");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.take_chips");
        if (!TextUtils.isEmpty(paramString2)) {
          continue;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("dstuin", Long.parseLong(paramString1));
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString2 = new NewIntent(this.jdField_a_of_type_AndroidContentContext, WebSSOAgentServlet.class);
        paramString2.putExtra("extra_cmd", "apollo_interact.take_chips");
        paramString2.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramString2.putExtra("extra_callbackid", paramString1);
        paramString2.setObserver(this);
        paramAppInterface.startServlet(paramString2);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, 0, 0);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
      }
      catch (Exception paramView)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloBoxWindow", 2, "OpenPandora failed ", paramView);
        continue;
      }
      super.post(this);
      return;
      paramString2 = "android." + paramString2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout.a();
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = 2;
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C8", this.q, 0, new String[] { String.valueOf(this.r) });
    }
    label307:
    label339:
    label362:
    do
    {
      do
      {
        return;
        if (paramView == this.c)
        {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
          if ((!TextUtils.isEmpty(this.g)) && (this.g.equals(this.f)))
          {
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_AndroidContentContext, VasWebviewConstants.APOLLO_MY_TASK_URL + "&adtag=floatlayer", -1L, paramView, false, -1);
            VipUtils.a(null, "cmshow", "Apollo", "checkmyself", 0, 0, new String[0]);
            return;
          }
          if (this.d.getVisibility() == 0) {}
          for (;;)
          {
            VipUtils.a(null, "cmshow", "Apollo", "goout", i2, 0, new String[] { String.valueOf(this.r) });
            return;
            i2 = 1;
          }
        }
        if (paramView != this.d) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData == null);
      int i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Boolean)
      {
        i1 = i2;
        if (!this.jdField_a_of_type_Boolean)
        {
          if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) {
            break label339;
          }
          this.jdField_a_of_type_Boolean = true;
          a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.j, this.f);
          i1 = 1;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.i != 0L) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.h == -501031L))
      {
        i2 = 1;
        if (i2 == 0) {
          break label362;
        }
      }
      for (paramView = "5";; paramView = "2")
      {
        VipUtils.a(null, "cmshow", "Apollo", "sendflower", i1, 0, new String[] { paramView });
        return;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "网络出错啦，请稍候再试试", 0).a();
        break;
        i2 = 0;
        break label307;
      }
    } while (this != paramView);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    long l1;
    label222:
    label229:
    do
    {
      return;
      i1 = paramBundle.getInt("extra_result_code");
      localObject1 = paramBundle.getString("extra_callbackid");
      localObject2 = paramBundle.getString("extra_cmd");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBoxWindow", 2, "OpenPandora onReceive type:" + paramInt + ", isSuccess: " + paramBoolean + ", svrRet: " + i1 + ", uin:" + (String)localObject1);
      }
      this.jdField_a_of_type_Long = Long.MIN_VALUE;
      this.i = null;
      if (!paramBoolean) {
        break label1134;
      }
      for (;;)
      {
        try
        {
          paramBundle = paramBundle.getByteArray("extra_data");
          if (paramBundle == null) {
            break label222;
          }
          localObject3 = new WebSSOAgent.UniSsoServerRsp();
          ((WebSSOAgent.UniSsoServerRsp)localObject3).mergeFrom(paramBundle);
          l1 = ((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get();
          if (!"apollo_interact.thank_zan".equals(localObject2)) {
            break;
          }
          if (l1 == 0L) {
            break label229;
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Int = 3;
          super.post(this);
          return;
        }
        catch (Exception paramBundle)
        {
          if (this.jdField_a_of_type_Long != -501028L) {
            break label1125;
          }
        }
        this.h = "来晚一步，贴纸被主人领走啦~";
        this.jdField_a_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.e("ApolloBoxWindow", 2, paramBundle.getMessage());
        }
        super.post(this);
        return;
        this.jdField_a_of_type_Int = 4;
      }
      if ("apollo_interact.take_chips".equals(localObject2)) {
        this.jdField_a_of_type_Long = l1;
      }
    } while ((!TextUtils.isEmpty(this.f)) && (!this.f.equals(localObject1)));
    long l2;
    long l3;
    short s1;
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long == -501030L) || (this.jdField_a_of_type_Long == -501027L) || (this.jdField_a_of_type_Long == -501040L) || (this.jdField_a_of_type_Long == -501031L) || (this.jdField_a_of_type_Long == -501028L))
    {
      this.jdField_a_of_type_Int = 2;
      this.i = ((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.get();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBoxWindow", 2, "onReceive retCode->" + this.jdField_a_of_type_Long + " respStr->" + this.i);
      }
      localObject2 = new JSONObject(this.i).optJSONObject("data");
      l1 = ((JSONObject)localObject2).optLong("checkpoint");
      l2 = ((JSONObject)localObject2).optLong("master");
      l3 = ((JSONObject)localObject2).optLong("chestid");
      s1 = (short)((JSONObject)localObject2).optInt("chipnum");
      paramBundle = ((JSONObject)localObject2).optString("nick");
      if (!TextUtils.isEmpty(paramBundle)) {
        break label1047;
      }
    }
    label483:
    ArrayList localArrayList;
    for (paramBundle = "TA";; paramBundle = paramBundle + "...")
    {
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("apollo_uin", String.valueOf(l2));
      ((Bundle)localObject3).putLong("apollo_checkPoint", l1);
      ((Bundle)localObject3).putShort("apollo_hadStolen", (short)1);
      localObject3 = DataFactory.a("ipc_apollo_update_apollopandora", "", ApolloJsPlugin.sResponseKey, (Bundle)localObject3);
      WebIPCOperator.a().b((Bundle)localObject3);
      localObject3 = new ApolloBoxData();
      ((ApolloBoxData)localObject3).jdField_c_of_type_JavaLangString = paramBundle;
      ((ApolloBoxData)localObject3).i = ((JSONObject)localObject2).optLong("firstcode");
      localArrayList = new ArrayList(4);
      ((ApolloBoxData)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject1);
      ((ApolloBoxData)localObject3).j = l3;
      ((ApolloBoxData)localObject3).jdField_a_of_type_JavaLangString = this.g;
      ((ApolloBoxData)localObject3).h = this.jdField_a_of_type_Long;
      localObject1 = ((JSONObject)localObject2).optJSONArray("tooklist");
      i1 = -1;
      if (((ApolloBoxData)localObject3).i != 0L) {
        break label1188;
      }
      if (((ApolloBoxData)localObject3).h != -501031L) {
        break label1193;
      }
      break label1188;
      label656:
      paramInt = i1;
      if (this.jdField_a_of_type_Long == -501040L) {
        break label1198;
      }
      paramInt = i1;
      if (localObject1 == null) {
        break label1198;
      }
      paramInt = i1;
      if (((JSONArray)localObject1).length() <= 0) {
        break label1198;
      }
      i1 = 0;
      int i2;
      for (paramInt = -1; i1 < ((JSONArray)localObject1).length(); paramInt = i2)
      {
        localObject2 = (JSONObject)((JSONArray)localObject1).get(i1);
        ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = new ApolloBoxData.ApolloBoxDataItem();
        localApolloBoxDataItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("name");
        localApolloBoxDataItem.jdField_a_of_type_Long = ((JSONObject)localObject2).optLong("uin");
        localApolloBoxDataItem.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("id");
        localApolloBoxDataItem.jdField_c_of_type_Long = ((JSONObject)localObject2).optLong("ts");
        localApolloBoxDataItem.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("grade");
        localApolloBoxDataItem.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("nick");
        localApolloBoxDataItem.d = ((JSONObject)localObject2).optString("head");
        localApolloBoxDataItem.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("viplevel");
        if ((localApolloBoxDataItem.jdField_b_of_type_Long == localApolloBoxDataItem.jdField_a_of_type_Long) && (TextUtils.isEmpty(localApolloBoxDataItem.jdField_c_of_type_JavaLangString))) {
          localApolloBoxDataItem.jdField_c_of_type_JavaLangString = paramBundle;
        }
        if (TextUtils.isEmpty(localApolloBoxDataItem.jdField_c_of_type_JavaLangString)) {
          localApolloBoxDataItem.jdField_c_of_type_JavaLangString = "TA";
        }
        localApolloBoxDataItem.jdField_a_of_type_Short = ((short)((JSONObject)localObject2).optInt("type"));
        localApolloBoxDataItem.jdField_b_of_type_Short = s1;
        localApolloBoxDataItem.jdField_b_of_type_Long = l2;
        localApolloBoxDataItem.jdField_b_of_type_Boolean = paramBoolean;
        i2 = paramInt;
        if (!TextUtils.isEmpty(this.g))
        {
          i2 = paramInt;
          if (this.g.equals(String.valueOf(localApolloBoxDataItem.jdField_a_of_type_Long))) {
            i2 = ((JSONObject)localObject2).optInt("zanmark");
          }
        }
        localApolloBoxDataItem.jdField_a_of_type_Boolean = localApolloBoxDataItem.a(this.g);
        localArrayList.add(localApolloBoxDataItem);
        i1 += 1;
      }
      if (this.jdField_a_of_type_Long == -501028L)
      {
        this.h = "来晚一步，贴纸刚被主人领走啦~";
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData = new ApolloBoxData();
        super.post(this);
        return;
      }
      this.h = "主页君正在玩命加载";
      this.jdField_a_of_type_Int = 1;
      break;
      label1047:
      if (CharacterUtil.a(paramBundle) <= 12) {
        break label1185;
      }
      paramBundle = CharacterUtil.a(paramBundle, 0, 12);
    }
    for (;;)
    {
      label1088:
      ((ApolloBoxData)localObject3).jdField_a_of_type_Boolean = paramBoolean;
      Collections.sort(localArrayList);
      ((ApolloBoxData)localObject3).jdField_a_of_type_JavaUtilList = localArrayList;
      ((ApolloBoxData)localObject3).a();
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData = ((ApolloBoxData)localObject3);
      break label222;
      label1125:
      label1134:
      label1185:
      label1188:
      label1193:
      label1198:
      do
      {
        paramBoolean = false;
        break label1088;
        this.h = "主页君正在玩命加载";
        break;
        if ("apollo_interact.thank_zan".equals(localObject2))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Int = 3;
          super.post(this);
          return;
        }
        if (!"apollo_interact.take_chips".equals(localObject2)) {
          break label222;
        }
        this.h = "主页君正在玩命加载";
        this.jdField_a_of_type_Int = 1;
        break label222;
        break label483;
        paramBoolean = true;
        break label656;
        paramBoolean = false;
        break label656;
      } while (paramInt != 0);
      paramBoolean = true;
    }
  }
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 1: 
    case 0: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          do
          {
            return;
            this.r = 9;
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.h);
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          } while (this.jdField_a_of_type_Long == Long.MIN_VALUE);
          VipUtils.a(null, "cmshow", "Apollo", "0X80066F2", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_Long) });
          return;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while (this.d.getVisibility() != 0);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "出错啦，关闭页面再试试", 0).a();
        return;
      } while (this.d.getVisibility() != 0);
      this.d.setBackgroundDrawable(new RoundRectColorDrawable(-1446932, 10.0F, this.s, this.t));
      this.d.setTextColor(-3355444);
      this.d.setText("送花成功");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData == null)
    {
      this.jdField_a_of_type_Int = 1;
      this.r = 9;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.h);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    Object localObject;
    label484:
    int i1;
    if ((!TextUtils.isEmpty(this.g)) && (this.g.equals(this.f)))
    {
      localObject = new RoundRectColorDrawable(-7707920, 10.0F, (int)DeviceInfoUtil.h() * 2 / 3, this.t);
      this.c.setBackgroundDrawable((Drawable)localObject);
      this.c.setText("查看我的任务进度");
      localObject = new LinearLayout.LayoutParams((int)DeviceInfoUtil.h() * 2 / 3, this.t);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.d.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!"drawer".equals(this.j)) {
        break label800;
      }
      this.q = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList == null) {
        break label829;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList.size();
      label507:
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.i == 0L) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.h != -501031L)) {
        break label866;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Int <= 0) {
        break label834;
      }
      this.r = 5;
      label548:
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C6", 2, 0, new String[] { "0", String.valueOf(i1) });
    }
    label800:
    label829:
    label834:
    label866:
    label1293:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow$ApolloCardLayout.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData);
      return;
      this.c.setText("继续抢");
      localObject = new RoundRectColorDrawable(-7707920, 10.0F, this.s, this.t);
      this.c.setBackgroundDrawable((Drawable)localObject);
      localObject = new LinearLayout.LayoutParams(this.s, this.t);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Boolean)
        {
          this.d.setBackgroundDrawable(new RoundRectColorDrawable(-1028016, 10.0F, this.s, this.t));
          this.d.setTextColor(-1);
          this.d.setText("送花谢谢ta");
        }
        for (;;)
        {
          this.d.setVisibility(0);
          break;
          this.d.setBackgroundDrawable(new RoundRectColorDrawable(-1446932, 10.0F, this.s, this.t));
          this.d.setTextColor(-3355444);
          this.d.setText("送花成功");
        }
      }
      this.d.setVisibility(8);
      break;
      if ("friendcard".equals(this.j))
      {
        this.q = 1;
        break label484;
      }
      this.q = 2;
      break label484;
      i1 = 0;
      break label507;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.i == -501030L)
      {
        this.r = 6;
        break label548;
      }
      this.r = 7;
      break label548;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Int > 0) {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_b_of_type_JavaLangString)))
        {
          this.r = 1;
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C2", this.q, 0, new String[] { "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Int), "" });
        }
      }
      for (i1 = 0;; i1 = 1)
      {
        if (this.q > 1) {
          break label1293;
        }
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C1", this.q, 0, new String[] { String.valueOf(i1), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Int) });
        break;
        this.r = 2;
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_b_of_type_JavaUtilList.isEmpty()))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_b_of_type_JavaUtilList.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = (ApolloBoxData.ApolloBoxDataItem)((Iterator)localObject).next();
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.q, 0, new String[] { String.valueOf(localApolloBoxDataItem.jdField_a_of_type_Int), String.valueOf(i1 - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_Int), String.valueOf(localApolloBoxDataItem.jdField_a_of_type_Short) });
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.h == -501030L)
              {
                this.r = 3;
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C4", this.q, 0, new String[] { "0", String.valueOf(i1) });
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.h == -501040L)
              {
                this.r = 9;
                VipUtils.a(null, "cmshow", "Apollo", "0X80066F2", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_Long) });
                break;
              }
              this.r = 4;
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C5", this.q, 0, new String[] { "0", String.valueOf(i1) });
              break;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloBoxWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */