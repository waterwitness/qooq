package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.WebView;
import wtm;

public class WebviewHandler
  extends Handler
{
  public WebviewHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (wtm)paramMessage.obj;
    } while ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentSmttSdkWebView == null) || (paramMessage.jdField_a_of_type_JavaLangString == null));
    try
    {
      paramMessage.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramMessage.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\js\WebviewHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */