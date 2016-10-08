import com.tencent.mobileqq.richstatus.StatusJsHandler;
import com.tencent.smtt.sdk.WebView;

public class ujj
  implements Runnable
{
  /* Error */
  public ujj(StatusJsHandler paramStatusJsHandler, String paramString1, String paramString2, WebView paramWebView)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 15	ujj:jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler	Lcom/tencent/mobileqq/richstatus/StatusJsHandler;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 17	ujj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: aload_3
    //   12: putfield 19	ujj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: aload_0
    //   16: aload 4
    //   18: putfield 21	ujj:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   21: aload_0
    //   22: invokespecial 24	java/lang/Object:<init>	()V
    //   25: getstatic 30	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   28: istore 5
    //   30: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	ujj
    //   0	31	1	paramStatusJsHandler	StatusJsHandler
    //   0	31	2	paramString1	String
    //   0	31	3	paramString2	String
    //   0	31	4	paramWebView	WebView
    //   28	1	5	bool	boolean
  }
  
  public void run()
  {
    String str = "javascript:" + this.jdField_a_of_type_JavaLangString + "(" + this.jdField_b_of_type_JavaLangString + ")";
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(str);
      if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.a = false;
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.jdField_b_of_type_Boolean = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */