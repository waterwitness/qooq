package com.tencent.biz.pubaccount.reactnative;

import com.facebook.react.ReactPackage;
import com.tencent.bitapp.manager.IPackageFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReadInjoyPackageFactroy
  implements IPackageFactory
{
  public ReadInjoyPackageFactroy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReactPackage createPackage()
  {
    return new ReadInjoyReactPackage();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\reactnative\ReadInjoyPackageFactroy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */