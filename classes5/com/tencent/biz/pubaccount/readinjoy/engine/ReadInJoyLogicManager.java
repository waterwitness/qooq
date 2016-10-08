package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.manager.Manager;

public class ReadInJoyLogicManager
  implements Manager
{
  private AppInterface a;
  
  public ReadInJoyLogicManager(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramAppInterface;
    a();
  }
  
  public ReadInJoyLogicEngine a()
  {
    return ReadInJoyLogicEngine.a();
  }
  
  public void a()
  {
    ReadInJoyLogicEngine.a().a(this.a);
  }
  
  public void b()
  {
    ReadInJoyLogicEngine.a().a();
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\engine\ReadInJoyLogicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */