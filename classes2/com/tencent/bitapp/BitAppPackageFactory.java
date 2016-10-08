package com.tencent.bitapp;

import com.facebook.react.ReactPackage;
import com.tencent.bitapp.manager.IPackageFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BitAppPackageFactory
  implements IPackageFactory
{
  public BitAppPackageFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReactPackage createPackage()
  {
    return new QQNativeModulePackage();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppPackageFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */