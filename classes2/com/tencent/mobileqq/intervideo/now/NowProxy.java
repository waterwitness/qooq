package com.tencent.mobileqq.intervideo.now;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import mqq.manager.Manager;

public class NowProxy
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "XProxy|NowProxy";
  private static final String b = "1600000615";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected NowPlugin a;
  
  public NowProxy()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin = new NowPlugin();
  }
  
  public NowProxy(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin = new NowPlugin(paramQQAppInterface);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.f();
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramBundle);
  }
  
  public void a(IVPluginEvtListener paramIVPluginEvtListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramIVPluginEvtListener);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramString, paramBundle);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a();
  }
  
  public boolean a(Context paramContext)
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramContext);
  }
  
  public boolean a(NowProxy.ListNameData paramListNameData, long paramLong, NowFromData paramNowFromData, int paramInt, Bundle paramBundle)
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramListNameData, paramLong, paramNowFromData, paramInt, paramBundle);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.e();
  }
  
  public void b(IVPluginEvtListener paramIVPluginEvtListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.b(paramIVPluginEvtListener);
  }
  
  public boolean b(Context paramContext)
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.b(paramContext);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\NowProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */