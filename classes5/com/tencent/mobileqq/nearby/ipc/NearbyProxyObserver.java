package com.tencent.mobileqq.nearby.ipc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class NearbyProxyObserver
{
  public boolean a;
  
  public NearbyProxyObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4126: 
      a();
      return;
    case 4105: 
      a((String)paramVarArgs[0]);
      return;
    }
    a((BusinessInfoCheckUpdate.AppInfo)paramVarArgs[0]);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void a(String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\ipc\NearbyProxyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */