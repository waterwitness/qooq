package com.tencent.mobileqq.shortvideo.error;

import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class ErrorCenter
  implements ErrorCode, ReportError
{
  private static ErrorCenter jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter = new ErrorCenter();
  private static String jdField_a_of_type_JavaLangString;
  private ErrorCenter.ErrorHandleCallback jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private ErrorCenter()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static ErrorCenter a()
  {
    return jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback = null;
  }
  
  public void a(ErrorCenter.ErrorHandleCallback paramErrorHandleCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback = paramErrorHandleCallback;
  }
  
  public boolean a(MessageStruct paramMessageStruct)
  {
    int i = paramMessageStruct.mParam0;
    paramMessageStruct = (String)paramMessageStruct.mObj0;
    switch (i)
    {
    default: 
      return true;
    case 1001: 
      a(true, 1001, "抱歉，初始化失败（" + 1001 + "）", true);
      return false;
    case 1002: 
      a(true, 1002, "抱歉，初始化失败（" + 1002 + "）", true);
      return false;
    case 1003: 
      a(true, 1003, "抱歉，初始化失败（" + 1003 + "）", true);
      return false;
    case 11: 
      a(true, 1004, "抱歉，写文件异常，请检查SD卡，或者重启机器（" + 1004 + "）", true);
      return true;
    case 13: 
      a(true, 1005, "抱歉，程序异常（" + 1005 + "）", true);
      return true;
    case 14: 
      a(true, 1006, "抱歉，程序异常（" + 1006 + "）", true);
      return true;
    case 1013: 
      a(true, 1007, "抱歉，录制出现错误（" + 1007 + "）", true);
      return true;
    case 1004: 
      a(false, 1007, "抱歉，播放出现错误（" + 1007 + "）", true);
      return true;
    }
    return false;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, "抱歉，初始化失败（" + 2001 + "）", true);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\error\ErrorCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */