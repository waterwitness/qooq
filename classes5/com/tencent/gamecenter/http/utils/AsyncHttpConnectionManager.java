package com.tencent.gamecenter.http.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHttpConnectionManager
{
  public static final int a = 5;
  private static AsyncHttpConnectionManager jdField_a_of_type_ComTencentGamecenterHttpUtilsAsyncHttpConnectionManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  public AsyncHttpConnectionManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  }
  
  public static AsyncHttpConnectionManager a()
  {
    if (jdField_a_of_type_ComTencentGamecenterHttpUtilsAsyncHttpConnectionManager == null) {
      jdField_a_of_type_ComTencentGamecenterHttpUtilsAsyncHttpConnectionManager = new AsyncHttpConnectionManager();
    }
    return jdField_a_of_type_ComTencentGamecenterHttpUtilsAsyncHttpConnectionManager;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\gamecenter\http\utils\AsyncHttpConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */