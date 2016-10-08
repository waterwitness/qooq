package com.tencent.biz.webviewbase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import jgt;
import jgu;
import jgv;

public class WebAIOController
{
  static final String jdField_a_of_type_JavaLangString = "AIOBanner";
  public static volatile boolean b = false;
  public static volatile boolean c = false;
  public static final int e = 1135042;
  public static final int f = 1135043;
  public static final String f = "enable_switch";
  public static final int g = 1135044;
  public static final String g = "switch_aio_btn_res";
  public static final int h = 1135045;
  public static final String h = "target_activity_name";
  public static final String i = "banner_icon_res";
  public static final String j = "banner_txt";
  public static final String k = "banner_timeout";
  public static final String l = "start_flags";
  public static final String m = "action";
  public static final String n = "category";
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  Client.onRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  String e;
  
  private WebAIOController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 2130843509;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 360000;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "";
    this.e = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new jgu(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new jgv(this);
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (!this.jdField_a_of_type_Boolean) || (!(this.jdField_a_of_type_AndroidViewView instanceof RelativeLayout))) {
      return;
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843321));
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Int));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new jgt(this));
    RelativeLayout localRelativeLayout2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    localRelativeLayout2.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.setMargins(0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), 0);
    localRelativeLayout2.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 36.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 36.0F));
    localLayoutParams.addRule(0, 2131296798);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.setMargins(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), 0);
    localRelativeLayout1.addView(localRelativeLayout2, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1134041: 
    case 1134042: 
      paramVarArgs = DataFactory.a("ipc_jump_to_conversation", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, null);
      paramVarArgs.putInt("banner_msg", paramInt);
      paramVarArgs.putCharSequence("banner_tips", this.jdField_b_of_type_JavaLangString);
      paramVarArgs.putInt("banner_icon", this.jdField_b_of_type_Int);
      paramVarArgs.putInt("banner_timeout", this.jdField_c_of_type_Int);
      paramVarArgs.putCharSequence("activity", this.jdField_c_of_type_JavaLangString);
      paramVarArgs.putInt("flags", this.jdField_d_of_type_Int);
      paramVarArgs.putCharSequence("action", this.jdField_d_of_type_JavaLangString);
      paramVarArgs.putCharSequence("category", this.e);
      a(paramVarArgs);
      return;
    case 1135042: 
      b(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  public void a(Context paramContext)
  {
    a(1134041, new Object[0]);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, SplashActivity.class);
    localIntent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
    localIntent.setFlags(335544320);
    localIntent.putExtra("tab_index", 0);
    paramContext.startActivity(localIntent);
  }
  
  void a(Bundle paramBundle)
  {
    if (!WebIPCOperator.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOBanner", 2, "messenger service is not connected!");
      }
      return;
    }
    WebIPCOperator.a().a(paramBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      a(1134042, new Object[0]);
      e();
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (paramBoolean)
      {
        b(false);
        jdField_c_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOBanner", 2, "unregister receiver error:" + localException.toString());
    }
  }
  
  void b()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      c();
      a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "init for switch aio cost " + (System.currentTimeMillis() - l1) + "ms");
    }
  }
  
  void b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (jdField_b_of_type_Boolean)
            {
              b(false);
              return;
            }
          } while ((!jdField_c_of_type_Boolean) || (jdField_b_of_type_Boolean));
          b(true);
          return;
        } while ((paramVarArgs.length < 1) || (!(paramVarArgs[0] instanceof String)));
        paramVarArgs = (String)paramVarArgs[0];
      } while (TextUtils.isEmpty(paramVarArgs));
      this.jdField_b_of_type_JavaLangString = paramVarArgs;
      return;
    } while (paramVarArgs.length < 1);
    this.jdField_b_of_type_Int = ((Integer)paramVarArgs[0]).intValue();
  }
  
  public void b(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localImageView.setVisibility(i1);
      return;
    }
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.msg.newmessage"));
  }
  
  void d()
  {
    try
    {
      WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOBanner", 2, "bind messenger service error:" + localException.toString());
    }
  }
  
  void e()
  {
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewbase\WebAIOController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */