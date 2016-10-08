package com.tencent.bitapp;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.tencent.bitapp.nativemodule.BitApp;
import com.tencent.bitapp.nativemodule.BitAppNativeModulePackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQNativeModulePackage
  extends BitAppNativeModulePackage
{
  public QQNativeModulePackage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public List createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    List localList = super.createNativeModules(paramReactApplicationContext);
    Object localObject = localList.iterator();
    NativeModule localNativeModule;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localNativeModule = (NativeModule)((Iterator)localObject).next();
    } while (!(localNativeModule instanceof BitApp));
    for (localObject = (BitApp)localNativeModule;; localObject = null)
    {
      if (localObject != null) {
        ((BitApp)localObject).setOnSaveBitmapListener(new QQNativeModulePackage.1(this, paramReactApplicationContext));
      }
      localObject = new ArrayList();
      ((List)localObject).addAll(localList);
      ((List)localObject).add(new QQNativeModule(paramReactApplicationContext));
      return (List)localObject;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\QQNativeModulePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */