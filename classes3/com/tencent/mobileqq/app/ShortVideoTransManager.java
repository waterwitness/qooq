package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.manager.Manager;

public class ShortVideoTransManager
  implements Manager
{
  private EntityManager a;
  
  public ShortVideoTransManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface.a().createEntityManager();
  }
  
  public ShortVideoUpInfo a(String paramString)
  {
    return (ShortVideoUpInfo)this.a.a(ShortVideoUpInfo.class, paramString);
  }
  
  public void a(ShortVideoUpInfo paramShortVideoUpInfo)
  {
    ShortVideoUpInfo localShortVideoUpInfo = (ShortVideoUpInfo)this.a.a(ShortVideoUpInfo.class, paramShortVideoUpInfo.key);
    if (localShortVideoUpInfo != null)
    {
      localShortVideoUpInfo.transferedSize = paramShortVideoUpInfo.transferedSize;
      localShortVideoUpInfo.timeStamp = paramShortVideoUpInfo.timeStamp;
      this.a.a(localShortVideoUpInfo);
      return;
    }
    this.a.a(paramShortVideoUpInfo);
  }
  
  public boolean a(String paramString)
  {
    return this.a.a(ShortVideoUpInfo.class, paramString) == null;
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = this.a.b(paramString);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ShortVideoTransManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */