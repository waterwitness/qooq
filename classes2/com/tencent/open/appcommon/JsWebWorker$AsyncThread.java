package com.tencent.open.appcommon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class JsWebWorker$AsyncThread
  implements Runnable
{
  protected String a;
  protected String[] a;
  protected String b;
  protected String c;
  
  public JsWebWorker$AsyncThread(JsWebWorker paramJsWebWorker, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsWebWorker.b(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\JsWebWorker$AsyncThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */