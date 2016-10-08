package com.tencent.open.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import wua;
import wub;
import wuc;

public class ToastUtil
{
  protected static ToastUtil a;
  protected Handler a;
  public Toast a;
  public Toast b;
  
  public ToastUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static ToastUtil a()
  {
    if (jdField_a_of_type_ComTencentOpenBaseToastUtil == null) {
      jdField_a_of_type_ComTencentOpenBaseToastUtil = new ToastUtil();
    }
    return jdField_a_of_type_ComTencentOpenBaseToastUtil;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new wub(this, paramInt1, paramInt2));
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new wuc(this, paramView, paramInt));
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new wua(this, paramString, paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\ToastUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */