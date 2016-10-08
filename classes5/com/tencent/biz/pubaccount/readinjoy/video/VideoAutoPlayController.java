package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgVideoController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoAutoPlayController
{
  private static VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private static String jdField_a_of_type_JavaLangString = ReadInJoyUtils.c;
  public float a;
  public Context a;
  protected boolean a;
  public float b;
  private boolean b;
  public float c;
  private boolean c;
  private boolean d = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoAutoPlayController(Context paramContext)
  {
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_c_of_type_Float = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels / 16.0D * 9.0D));
    this.jdField_b_of_type_Float = (2.0F * this.jdField_c_of_type_Float * 1.1F);
    this.jdField_b_of_type_Boolean = false;
    if ((StructMsgVideoController.a().a()) && (Build.VERSION.SDK_INT >= 14)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "mDeviceAutoPlaySwitch : " + this.jdField_a_of_type_Boolean);
      }
      return;
    }
  }
  
  public static VideoAutoPlayController a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = new VideoAutoPlayController(paramContext);
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  }
  
  private void a()
  {
    if (this.d) {
      jdField_a_of_type_JavaLangString = ReadInJoyUtils.b();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED))
        {
          int i = paramContext.getType();
          if (i == 1) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d(VideoAutoPlayController.class.getSimpleName(), 2, paramContext.toString());
    }
    return false;
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    this.d = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    a();
    if (ReadInJoyUtils.c.equals(jdField_a_of_type_JavaLangString)) {}
    do
    {
      return false;
      if ((ReadInJoyUtils.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_JavaLangString)) && (NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))) {
        return this.jdField_a_of_type_Boolean;
      }
    } while ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Boolean));
    return true;
  }
  
  public boolean a(View paramView)
  {
    float f3 = paramView.getTop();
    float f4 = this.jdField_c_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    float f1 = f2;
    if (f2 > this.jdField_a_of_type_Float) {
      f1 = this.jdField_a_of_type_Float;
    }
    return (f3 >= -100.0F) && (f3 + f4 <= f1);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    if (ReadInJoyUtils.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_JavaLangString)) {}
    while ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    if (ReadInJoyUtils.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_JavaLangString)) {}
    while ((this.jdField_c_of_type_Boolean) || (d())) {
      return false;
    }
    return true;
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\video\VideoAutoPlayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */