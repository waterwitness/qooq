package com.tencent.open.appcommon;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
import wsr;

public class ResourceUpdater$CheckUpdateCallback
  implements HttpCgiAsyncTask.Callback
{
  public String a;
  public CountDownLatch a;
  
  public ResourceUpdater$CheckUpdateCallback(CountDownLatch paramCountDownLatch, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = paramCountDownLatch;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(Exception paramException)
  {
    LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> CheckUpdateCallback -> Check update cgi request exception : " + paramException.toString());
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    LogUtility.b(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> Resource update check end !!!");
    Common.a(false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogUtility.a(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> CheckUpdateCallback -> reponseCode OK. result = " + paramJSONObject);
    ThreadManager.d(new wsr(this, paramJSONObject));
    Common.a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\ResourceUpdater$CheckUpdateCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */