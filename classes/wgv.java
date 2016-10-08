import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class wgv
  implements Runnable
{
  wgv(wgu paramwgu, CustomWebView paramCustomWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a("about:blank");
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.clearView();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.destroy();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQBrowser", 1, "Pre_Load_webview error:" + localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */