package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import prz;
import psa;
import psb;

public class ApolloStoreActivity
  extends ApolloBaseActivity
  implements Handler.Callback, PopupWindow.OnDismissListener, OnApolloViewListener, IApolloActivityJsCallBack
{
  public static final int a = 15;
  public static final String d = "extra_key_url_append";
  public static final String e = "extra_key_open_box";
  public static final String f = "extra_key_box_uin";
  static final int jdField_g_of_type_Int = 15;
  public static final String g = "extra_key_box_from";
  static final int h = 16;
  public static final String h = "extra_key_nickname";
  static final int i = 17;
  public static final String i = "extra_key_adtag";
  static final int j = 18;
  public static final String j = "drawer";
  static final int k = 19;
  public static final String k = "friendcard";
  static final int l = 20;
  public static final String l = "store";
  static final int jdField_m_of_type_Int = 21;
  static final int jdField_n_of_type_Int = 22;
  private static final String jdField_n_of_type_JavaLangString = "ApolloStoreActivity";
  static final int jdField_o_of_type_Int = 23;
  static final int jdField_p_of_type_Int = 24;
  static final int jdField_q_of_type_Int = 25;
  private static final int jdField_r_of_type_Int = 0;
  private static final int jdField_s_of_type_Int = 1;
  private int A;
  float jdField_a_of_type_Float;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  Button jdField_a_of_type_AndroidWidgetButton;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ApolloTextureView a;
  private IRenderCallback jdField_a_of_type_ComTencentMobileqqApolloIRenderCallback;
  public BarrageView a;
  private ApolloBoxWindow jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow;
  private ApolloImageShareLayout jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout;
  public WeakReferenceHandler a;
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public ApolloTextureView b;
  private IRenderCallback jdField_b_of_type_ComTencentMobileqqApolloIRenderCallback;
  boolean jdField_b_of_type_Boolean;
  public float c;
  int jdField_c_of_type_Int;
  FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  private float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean;
  private boolean jdField_n_of_type_Boolean;
  private String jdField_o_of_type_JavaLangString;
  private String jdField_p_of_type_JavaLangString;
  private String jdField_q_of_type_JavaLangString;
  private String jdField_r_of_type_JavaLangString;
  private String jdField_s_of_type_JavaLangString;
  private int jdField_t_of_type_Int;
  private String jdField_t_of_type_JavaLangString;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public ApolloStoreActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Float = 2.0F;
    this.jdField_f_of_type_Float = 1.0F;
  }
  
  private void c()
  {
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
    {
      if (super.getAppInterface() == null) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(22, 1500L);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(22, 500L);
  }
  
  public String a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt, String paramString1, String paramString2)
  {
    if (!ApolloActionHelper.a(getCurrentAccountUin(), paramInt5, paramArrayOfInt, this.app))
    {
      QQToast.a(this, "角色素材下载不完整", 0).a();
      return "{\"result\":1,\"msg\":\"资源不完整\"}";
    }
    a();
    this.r = paramString2;
    this.A = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(25, 500L);
    this.jdField_c_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt5;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    long l1;
    if (this.jdField_f_of_type_Float != 0.0F)
    {
      this.jdField_d_of_type_Int = ((int)(paramInt3 / this.jdField_f_of_type_Float));
      paramInt1 = (int)(paramInt4 * this.jdField_e_of_type_Float);
      paramArrayOfInt = Message.obtain();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && ((Float.compare(paramFloat, this.jdField_d_of_type_Float) != 0) || (paramInt3 != this.jdField_t_of_type_Int) || (paramInt1 != this.u)))
      {
        paramString1 = new RelativeLayout.LayoutParams(-1, paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setLayoutParams(paramString1);
        l1 = DeviceInfoUtil.i();
        if (Float.compare(0.0F, paramFloat) != 0) {
          break label409;
        }
      }
    }
    label409:
    for (this.jdField_a_of_type_Float = ((float)(l1 / 5L) / 368.0F);; this.jdField_a_of_type_Float = ((float)l1 * paramFloat / 368.0F))
    {
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * 330.0F / this.jdField_e_of_type_Float);
      this.jdField_t_of_type_Int = paramInt3;
      this.u = paramInt1;
      this.jdField_d_of_type_Float = paramFloat;
      paramArrayOfInt.what = 18;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramArrayOfInt);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "rate->" + paramFloat + " x->" + paramInt3 + " y->" + paramInt1 + " mScreenDensity->" + this.jdField_e_of_type_Float + " DeviceInfoUtil.getHeight()" + DeviceInfoUtil.i() + ",displayWidth:" + DeviceInfoUtil.h());
      }
      a(false, paramInt3, paramInt1);
      b(false);
      b("ipc_apollo_query_mine_redinfo");
      this.s = null;
      this.n = false;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      }
      return "{ result:0, msg: \"\" }";
      this.jdField_d_of_type_Int = paramInt3;
      break;
    }
  }
  
  public String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString1, int paramInt7, int paramInt8, int paramInt9, int paramInt10, String paramString2)
  {
    if (!ApolloActionHelper.a(getCurrentAccountUin(), this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.app))
    {
      QQToast.a(this, "角色素材下载不完整", 0).a();
      return "{\"result\":1,\"msg\":\"资源不完整\"}";
    }
    if (!ApolloUtil.a(paramInt1, paramInt2))
    {
      QQToast.a(this, "动作素材下载不完整", 0).a();
      return "{\"result\":1,\"msg\":\"资源不完整\"}";
    }
    ApolloActionManager.a().b();
    if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null))
    {
      QQToast.a(this, "未初始化，预览动作失败", 0).a();
      return "{\"result\":1,\"msg\":\"预览动作失败\"}";
    }
    a();
    this.z = paramInt1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(16);
    this.x = paramInt8;
    this.s = paramString2;
    this.y = paramInt10;
    boolean bool;
    if (paramInt9 == 1)
    {
      bool = true;
      this.n = bool;
      if (!TextUtils.isEmpty(paramString2)) {
        break label654;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      }
      label199:
      if (paramInt3 != 0) {
        break label865;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a();
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a(50L);
      }
      if (this.jdField_c_of_type_Int != paramInt2)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a();
        if (paramInt2 != 1) {
          break label717;
        }
        if (ApolloUtil.c(this.x))
        {
          float f1 = this.jdField_b_of_type_Float / 2.0F;
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(2, this.x, this.jdField_a_of_type_Float, this.jdField_d_of_type_Int - f1, 0.0F);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(2, ApolloResDownloader.a(this.x), null);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_d_of_type_Int + f1, 0.0F);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_a_of_type_ArrayOfInt, null);
        }
        label378:
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a(1000L);
      }
      paramString1 = ApolloActionTask.a(paramInt1, this.jdField_b_of_type_Int, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, paramInt1, ApolloActionManager.a().b(), paramString1[0], paramString1[1]);
      if (paramInt2 == 1)
      {
        paramString1 = ApolloActionTask.a(paramInt1, this.jdField_b_of_type_Int, false);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(2, paramInt1, ApolloActionManager.a().b(), paramString1[0], paramString1[1]);
      }
      this.jdField_c_of_type_Int = paramInt2;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (TextUtils.isEmpty(paramString2)) {
        break label848;
      }
      if ((paramInt10 != 1) || (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null)) {
        break label823;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getParent();
      paramInt1 = (int)((float)DeviceInfoUtil.i() * this.jdField_d_of_type_Float * 1.14F);
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == paramString1) {
        break label763;
      }
      if (paramString1 != null) {
        ((ViewGroup)paramString1).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
      }
      paramString1 = new RelativeLayout.LayoutParams(-1, paramInt1);
      paramString1.addRule(10, -1);
      paramString1.topMargin = (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() - paramInt1);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, 1, paramString1);
      label615:
      ApolloBarrageUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), paramInt1, this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, BaseApplicationImpl.getContext(), "", paramString2, true);
    }
    for (;;)
    {
      b(false);
      return "{\"result\":0,\"msg\":\"预览动作成功\"}";
      bool = false;
      break;
      label654:
      if (paramInt10 == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(this);
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setClickable(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(0);
        break label199;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null) {
        break label199;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      break label199;
      label717:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_d_of_type_Int, 0.0F);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_a_of_type_ArrayOfInt, null);
      break label378;
      label763:
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getHeight() == paramInt1) {
        break label615;
      }
      paramString1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams();
      paramString1.topMargin = (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() - paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams().height = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setLayoutParams(paramString1);
      break label615;
      label823:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b(0, 1, this.jdField_b_of_type_Int, this.s, null);
      continue;
      label848:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
    }
    label865:
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView == null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this, null);
      paramString1 = new RelativeLayout.LayoutParams(-2, (int)(super.getResources().getDisplayMetrics().heightPixels * 0.6F));
      paramString1.addRule(13, -1);
      paramString1.leftMargin = ApolloUtil.a(25.0F, this.jdField_e_of_type_Float);
      paramString1.rightMargin = ApolloUtil.a(25.0F, this.jdField_e_of_type_Float);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView, paramString1);
      paramString1 = super.getResources().getDisplayMetrics();
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a(new psa(this, paramString1, paramInt2, paramInt1));
      if (this.jdField_b_of_type_ComTencentMobileqqApolloIRenderCallback == null) {
        this.jdField_b_of_type_ComTencentMobileqqApolloIRenderCallback = new psb(this);
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(this.jdField_b_of_type_ComTencentMobileqqApolloIRenderCallback);
      label1039:
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a(50L);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().b();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
      if ((paramInt7 != 1) && (paramInt4 > 0)) {
        break label1183;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt1));
      break;
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramString1 = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(19, paramInt2, paramInt1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramString1, 100L);
      break label1039;
      label1183:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      ApolloUtil.a(this.jdField_a_of_type_AndroidWidgetImageView, paramInt4);
      if ((paramInt5 <= 0) && ((paramInt6 >= paramInt4) || (paramInt4 == 1))) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "{\"result\":1,\"msg\":\"uin是空\"}";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow = new ApolloBoxWindow(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, paramString, "store", getAppInterface(), this);
    b(false);
    return "{\"result\":0,\"msg\":\"\"}";
  }
  
  public String a(int[] paramArrayOfInt)
  {
    if (!ApolloActionHelper.a(getCurrentAccountUin(), this.jdField_b_of_type_Int, paramArrayOfInt, this.app))
    {
      QQToast.a(this, "角色素材下载不完整", 0).a();
      return "{\"result\":1,\"msg\":\"资源不完整\"}";
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_d_of_type_Int, 0.0F);
      }
      if ((!TextUtils.isEmpty(this.s)) && (this.n)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, paramArrayOfInt, null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a(1000L);
    }
    b(false);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.n = false;
    this.s = null;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
    }
    a();
    return "{\"result\":0,\"msg\":\"换装成功\"}";
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        AudioUtil.a(BaseApplicationImpl.getContext(), false);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloStoreActivity", 1, localThrowable.getMessage());
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.c("apollo && apollo.controller && apollo.controller.hitAvatar && apollo.controller.hitAvatar();");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "apollo.controller.hitAvatar()");
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "Avatar view is Ready.");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(18);
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    this.jdField_e_of_type_Int = 1;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout = new ApolloImageShareLayout(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout.a(getAppInterface(), this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Float);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout, new FrameLayout.LayoutParams(-1, -1));
    }
    a();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (!TextUtils.isEmpty(this.s))) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(0L);
    }
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(18).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Float, paramString, this.jdField_t_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((int)(this.jdField_e_of_type_Float * paramFloat1) - (this.v >> 1));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)(this.jdField_e_of_type_Float * paramFloat2 * 0.75F));
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean a(String paramString)
  {
    try
    {
      a();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(0L);
      }
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(18).sendToTarget();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(0L);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (!TextUtils.isEmpty(this.s))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(false);
      }
      Intent localIntent = new Intent(this, ApolloDiyTextActivity.class);
      localIntent.putExtra("extra_key_last_text", paramString);
      localIntent.addFlags(4194304);
      startActivityForResult(localIntent, 1);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloStoreActivity", 1, paramString.getMessage());
    }
    return false;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      this.z = 5;
      String[] arrayOfString = ApolloActionTask.a(6, this.jdField_b_of_type_Int, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, 5, ApolloActionManager.a().b(), arrayOfString[0], arrayOfString[1]);
      return "{ result:0, msg: \"\" }";
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(24, 100L);
    return "{\"result\":1,\"msg\":\"未初始化\"}";
  }
  
  public void b() {}
  
  void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      this.jdField_f_of_type_Float = (FontSettingManager.a() / 16.0F);
      if (this.jdField_f_of_type_Float != 0.0F) {
        this.jdField_e_of_type_Float = (DeviceInfoUtil.a() / this.jdField_f_of_type_Float);
      }
    } while (this.jdField_e_of_type_Float != 0.0F);
    this.jdField_e_of_type_Float = DeviceInfoUtil.a();
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      b(false);
    }
  }
  
  public void b(String paramString)
  {
    ApolloJsPlugin localApolloJsPlugin = (ApolloJsPlugin)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a("apollo");
    if (localApolloJsPlugin != null)
    {
      localApolloJsPlugin.mReqBundle.clear();
      localApolloJsPlugin.sendRemoteReq(DataFactory.a(paramString, "", localApolloJsPlugin.getRemoteKey(), localApolloJsPlugin.mReqBundle), false, true);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "send ipc mine redtouch req cmd=" + paramString);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localRelativeLayout.setVisibility(i1);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(25);
    this.jdField_e_of_type_Int = paramInt;
    if ("mall".equals(this.r)) {
      if (this.jdField_e_of_type_Int == 0)
      {
        this.jdField_m_of_type_JavaLangString = "快开启厘米秀吧！";
        if (this.A == 1) {
          this.jdField_m_of_type_JavaLangString = ApolloResDownloader.a(this.jdField_b_of_type_Int);
        }
        if (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
          break label145;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(17);
      }
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(16);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(16, 3000L);
      }
      return;
      if (this.jdField_e_of_type_Int == 2)
      {
        this.jdField_m_of_type_JavaLangString = "好久没换衣服了，不讲卫生";
        break;
      }
      this.jdField_m_of_type_JavaLangString = null;
      break;
      this.jdField_m_of_type_JavaLangString = null;
      break;
      label145:
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      } else {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(16);
      }
    }
  }
  
  public void d(int paramInt)
  {
    int i4 = 0;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)getSystemService("phone"));
    }
    int i1;
    if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 1))
    {
      i1 = 1;
      if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(2) != 0)) {
        break label227;
      }
    }
    label227:
    for (int i2 = 1;; i2 = 0)
    {
      int i3 = i4;
      if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)
      {
        i3 = i4;
        if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCallState() == 0) {
          i3 = 1;
        }
      }
      if ((ApolloResDownloader.a(paramInt)) && (i2 == 0) && (i1 == 0) && (i3 != 0)) {}
      try
      {
        AudioUtil.a(BaseApplicationImpl.getContext(), true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(ApolloConstant.l + paramInt + "/" + "music.amr");
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloStoreActivity", 1, localThrowable.getMessage());
      }
      i1 = 0;
      break;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1 = null;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "doOnActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " data:" + paramIntent);
      }
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null);
      if (paramIntent != null) {
        str1 = paramIntent.getStringExtra("text");
      }
      String str2;
      if (TextUtils.isEmpty(str1)) {
        str2 = "";
      }
      for (;;)
      {
        if (paramInt2 != -1) {
          break label194;
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.c("apollo && apollo.controller && apollo.controller.closeEditor && apollo.controller.closeEditor(1,'" + ApolloUtil.a(str2) + "')");
        break;
        str2 = str1;
        if (str1.length() > 12) {
          str2 = str1.substring(0, 12);
        }
      }
      label194:
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.c("apollo && apollo.controller && apollo.controller.closeEditor && apollo.controller.closeEditor(0,'" + ApolloUtil.a(str2) + "')");
      continue;
      if (paramInt2 == -1) {
        VipUtils.a(null, "cmshow", "Apollo", "QzoneSuccess", 0, 0, new String[0]);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2130903099);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296895));
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14))
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131297086));
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = super.b(null);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView, 0, paramBundle);
    b(super.getIntent());
    paramBundle = super.getIntent().getStringExtra("extra_key_url_append");
    this.jdField_m_of_type_Boolean = super.getIntent().getBooleanExtra("extra_key_open_box", false);
    this.q = super.getIntent().getStringExtra("extra_key_box_uin");
    this.p = super.getIntent().getStringExtra("extra_key_box_from");
    this.jdField_t_of_type_JavaLangString = super.getIntent().getStringExtra("extra_key_nickname");
    Object localObject1 = super.getIntent().getStringExtra("extra_key_adtag");
    long l1 = DeviceInfoUtil.i();
    long l2 = DeviceInfoUtil.h();
    this.o = (VasWebviewConstants.APOLLO_STORE_URL + "&screenWidth=" + (int)((float)l2 / this.jdField_e_of_type_Float) + "&screenHeight=" + (int)((float)l1 / this.jdField_e_of_type_Float));
    if (!TextUtils.isEmpty(paramBundle))
    {
      if (paramBundle.startsWith("&")) {
        this.o += paramBundle;
      }
    }
    else
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.o = (this.o + "&adtag=" + (String)localObject1);
      }
      if (!this.o.contains("tab")) {
        this.o += "&tab=mall";
      }
      if (!this.jdField_m_of_type_Boolean) {
        break label1466;
      }
    }
    label1466:
    for (this.o += "&openBox=true";; this.o += "&openBox=false")
    {
      this.jdField_c_of_type_JavaLangString = this.o;
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.o);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this, null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setClickable(false);
      paramBundle = new RelativeLayout.LayoutParams(1, 1);
      this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCallback = new prz(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCallback);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramBundle);
      paramBundle = super.getResources();
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838321);
      this.v = ApolloUtil.a(25.0F, this.jdField_e_of_type_Float);
      this.w = ApolloUtil.a(25.0F, this.jdField_e_of_type_Float);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.v, this.w);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(9, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(10, -1);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
      localObject1 = new ImageView(this);
      ((ImageView)localObject1).setImageResource(2130838321);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
      setImmersiveStatus();
      if (this.mSystemBarComp != null)
      {
        this.mSystemBarComp.init();
        int i1 = paramBundle.getColor(2131428295);
        this.mSystemBarComp.a(i1);
        this.mSystemBarComp.b(i1);
      }
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext().getApplicationContext());
      }
      this.jdField_c_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8366104);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject1).leftMargin = ApolloUtil.a(15.0F, this.jdField_e_of_type_Float);
      ((FrameLayout.LayoutParams)localObject1).rightMargin = ApolloUtil.a(15.0F, this.jdField_e_of_type_Float);
      this.jdField_c_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new FrameLayout.LayoutParams(ApolloUtil.a(81.0F, this.jdField_e_of_type_Float), ApolloUtil.a(58.0F, this.jdField_e_of_type_Float));
      ((FrameLayout.LayoutParams)localObject1).topMargin = ApolloUtil.a(32.0F, this.jdField_e_of_type_Float);
      ((FrameLayout.LayoutParams)localObject1).rightMargin = ((int)(DeviceInfoUtil.h() / 2L) - ApolloUtil.a(35.0F, this.jdField_e_of_type_Float) - ApolloUtil.a(81.0F, this.jdField_e_of_type_Float));
      ((FrameLayout.LayoutParams)localObject1).gravity = 53;
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837833);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_c_of_type_AndroidWidgetFrameLayout, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297083));
      if (this.jdField_f_of_type_Float != 0.0F)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(17.0F / this.jdField_f_of_type_Float);
        localObject1 = super.findViewById(2131297082).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).height / this.jdField_f_of_type_Float));
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).height / this.jdField_f_of_type_Float));
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ApolloUtil.a(10.0F, this.jdField_e_of_type_Float);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F / this.jdField_f_of_type_Float);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramBundle.getColor(2131427430));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      paramBundle = new RelativeLayout.LayoutParams(-2, (int)((float)DeviceInfoUtil.i() * 0.6F));
      paramBundle.addRule(13, -1);
      paramBundle.leftMargin = ApolloUtil.a(25.0F, this.jdField_e_of_type_Float);
      paramBundle.rightMargin = ApolloUtil.a(25.0F, this.jdField_e_of_type_Float);
      localObject1 = LayoutInflater.from(this).inflate(2130903100, null);
      ((View)localObject1).findViewById(2131297090).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131297091));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localObject2 = new RoundRectColorDrawable(-7707920, 15.0F, (int)(DeviceInfoUtil.h() - AIOUtils.a(72.0F, getResources())), AIOUtils.a(44.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131297088));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131297089));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, paramBundle);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(21, 12000L);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(20);
      this.jdField_g_of_type_Boolean = true;
      c();
      return false;
      this.o = (this.o + "&" + paramBundle);
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().c();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    ApolloActionManager.a().g();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a();
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout.a(true);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("extra_key_url_append");
    long l1 = DeviceInfoUtil.i();
    long l2 = DeviceInfoUtil.h();
    this.o = (VasWebviewConstants.APOLLO_STORE_URL + "&screenWidth=" + (int)((float)l2 / this.jdField_e_of_type_Float) + "&screenHeight=" + (int)((float)l1 / this.jdField_e_of_type_Float));
    if (!TextUtils.isEmpty(paramIntent)) {
      if (!paramIntent.startsWith("&")) {
        break label185;
      }
    }
    label185:
    for (this.o += paramIntent;; this.o = (this.o + "&" + paramIntent))
    {
      if (!this.o.contains("tab")) {
        this.o += "&tab=mall";
      }
      this.jdField_c_of_type_JavaLangString = this.o;
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.o);
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    label556:
    int i1;
    int i2;
    float f1;
    float f3;
    float f2;
    switch (paramMessage.what)
    {
    default: 
    case 24: 
    case 22: 
    case 15: 
    case 16: 
    case 17: 
    case 25: 
    case 23: 
      do
      {
        do
        {
          do
          {
            return false;
          } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null));
          paramMessage = ApolloActionTask.a(6, this.jdField_b_of_type_Int, true);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, 5, ApolloActionManager.a().b(), paramMessage[0], paramMessage[1]);
          return false;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow == null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow = new ApolloBoxWindow(this);
          }
        } while (!this.jdField_m_of_type_Boolean);
        if (TextUtils.isEmpty(this.q)) {
          this.q = getCurrentAccountUin();
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxWindow.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, this.q, this.p, getAppInterface(), this);
        return false;
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(false);
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(18);
        return true;
        if (this.jdField_c_of_type_AndroidWidgetFrameLayout != null) {
          this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        }
        return true;
        if (this.jdField_m_of_type_JavaLangString != null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_m_of_type_JavaLangString);
          this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        }
        for (;;)
        {
          return true;
          this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        }
        c(this.jdField_e_of_type_Int);
        return true;
      } while ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0));
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      return false;
    case 18: 
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_c_of_type_Int != 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_d_of_type_Int, 0.0F);
        if (this.jdField_b_of_type_Int != 0) {
          break label556;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, ApolloResDownloader.jdField_a_of_type_ArrayOfInt, null);
      }
      for (;;)
      {
        if ((paramMessage.arg1 > 0) && (!TextUtils.isEmpty(this.s)) && (this.n) && (this.y == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b(0, 1, this.jdField_b_of_type_Int, this.s, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a(1000L);
        this.jdField_c_of_type_Int = 0;
        this.jdField_d_of_type_Boolean = true;
        this.jdField_b_of_type_Boolean = false;
        b(false);
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0)) {
          break;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(23, 100L);
        return false;
        if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ArrayOfInt != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_a_of_type_ArrayOfInt, null);
        }
      }
    case 19: 
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_AndroidWidgetButton == null)) {
        return true;
      }
      i1 = paramMessage.arg1;
      i2 = paramMessage.arg2;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)
      {
        f1 = 77.0F;
        f3 = (float)(Math.max(DeviceInfoUtil.g(), DeviceInfoUtil.f()) / 7L) / 368.0F;
        if ((i1 != 1) || (!ApolloUtil.c(this.x))) {
          break label1142;
        }
        f2 = 330.0F * f3 / DeviceInfoUtil.jdField_a_of_type_Float / 2.0F;
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(2, this.x, f3, this.jdField_c_of_type_Float - f2, f1);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(2, ApolloResDownloader.a(this.x), null);
        paramMessage = ApolloActionTask.a(i2, this.x, false);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(2, i2, ApolloActionManager.a().b(), paramMessage[0], paramMessage[1]);
      }
      break;
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_b_of_type_Int, f3, f2 + this.jdField_c_of_type_Float, f1);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, this.jdField_a_of_type_ArrayOfInt, null);
      paramMessage = ApolloActionTask.a(i2, this.jdField_b_of_type_Int, true);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a(1000L);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, i2, ApolloActionManager.a().b(), paramMessage[0], paramMessage[1]);
      if (!TextUtils.isEmpty(this.s))
      {
        if ((this.y == 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null))
        {
          this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
          i1 = (int)((float)(DeviceInfoUtil.i() / 7L) * 1.14F);
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getParent();
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != paramMessage)
          {
            if (paramMessage != null) {
              ((ViewGroup)paramMessage).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
            }
            paramMessage = new RelativeLayout.LayoutParams(-1, i1);
            paramMessage.addRule(12, -1);
            paramMessage.leftMargin = ApolloUtil.a(25.0F, this.jdField_e_of_type_Float);
            paramMessage.rightMargin = ApolloUtil.a(25.0F, this.jdField_e_of_type_Float);
            paramMessage.bottomMargin = (AIOUtils.a(f1, getResources()) + (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight()) / 2);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, 1, paramMessage);
          }
          ApolloBarrageUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth(), i1, this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, BaseApplicationImpl.getContext(), "", this.s, true);
          return true;
          f1 = 42.0F;
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().b(0, 1, this.jdField_b_of_type_Int, this.s, null);
        return true;
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
      return true;
      b(false);
      return false;
      this.jdField_e_of_type_Boolean = true;
      b(true);
      return false;
      label1142:
      f2 = 0.0F;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_f_of_type_Boolean = true;
    c();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView) {
      if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.c("window.onReturn &&　window.onReturn()");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreActivity", 2, "onBackEvent");
        }
        VipUtils.a(null, "cmshow", "Apollo", "0X80065CA", 0, 0, new String[0]);
      }
    }
    do
    {
      return;
      super.onBackEvent();
      break;
      if (paramView.getId() == 2131297090)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(15);
        a();
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    a();
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.c("window.openVipFromAction && window.openVipFromAction(" + paramView.getTag() + ")");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(15);
  }
  
  public void onDismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
    }
  }
  
  public boolean showPreview()
  {
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      int i1 = super.getResources().getColor(2131428295);
      this.mSystemBarComp.a(i1);
      this.mSystemBarComp.b(i1);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloStoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */