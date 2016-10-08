package com.tencent.biz.pubaccount;

import android.os.AsyncTask;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PublicAccountJavascriptInterface$HttpTask
  extends AsyncTask
{
  String jdField_a_of_type_JavaLangString;
  
  public PublicAccountJavascriptInterface$HttpTask(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected String a(String... paramVarArgs)
  {
    if (super.isCancelled()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.a(paramVarArgs[0], paramVarArgs[1]);
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "{\"r\" : \"-100\"}";
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs("clientCallback", new String[] { Util.b(str), Util.b(this.jdField_a_of_type_JavaLangString) });
  }
  
  protected void a(Integer... paramVarArgs) {}
  
  protected void onCancelled()
  {
    super.onCancelled();
  }
  
  protected void onPreExecute() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountJavascriptInterface$HttpTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */