package com.tencent.bitapp.nativemodule;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.shell.MainReactPackage;
import java.util.ArrayList;
import java.util.List;

public class BitAppNativeModulePackage
  extends MainReactPackage
{
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    List localList = super.createNativeModules(paramReactApplicationContext);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(localList);
    localArrayList.add(new BitApp(paramReactApplicationContext));
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\nativemodule\BitAppNativeModulePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */