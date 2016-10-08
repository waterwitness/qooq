package com.tencent.mobileqq.nearby.rn;

import com.facebook.react.ReactPackage;
import com.tencent.bitapp.manager.IPackageFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyPackageFactroy
  implements IPackageFactory
{
  public NearbyPackageFactroy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReactPackage createPackage()
  {
    return new NearbyReactPackage();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyPackageFactroy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */