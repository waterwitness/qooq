package com.tencent.biz.pubaccount.reactnative;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.shell.MainReactPackage;
import com.tencent.biz.pubaccount.reactnative.module.ReactBaseModule;
import com.tencent.biz.pubaccount.reactnative.module.ReadInjoyNetworkingModule;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.rn.QQBaseModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadInjoyReactPackage
  extends MainReactPackage
{
  private static final String jdField_a_of_type_JavaLangString = "ReadInjoyReactPackage";
  public static List a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  
  public ReadInjoyReactPackage() {}
  
  public ReadInjoyReactPackage(Activity paramActivity)
  {
    this(paramActivity, null);
  }
  
  public ReadInjoyReactPackage(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((jdField_a_of_type_JavaUtilList == null) || (jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilList.size()) {
      try
      {
        if ((jdField_a_of_type_JavaUtilList.get(i) instanceof ReactBaseModule)) {
          ((ReactBaseModule)jdField_a_of_type_JavaUtilList.get(i)).doRefreshContext(paramActivity);
        }
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public List createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    List localList = super.createNativeModules(paramReactApplicationContext);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(localList);
    jdField_a_of_type_JavaUtilList = Arrays.asList(new NativeModule[] { new ReadInjoyNetworkingModule(paramReactApplicationContext), new QQBaseModule(paramReactApplicationContext) });
    localArrayList.addAll(jdField_a_of_type_JavaUtilList);
    return localArrayList;
  }
  
  public List createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    paramReactApplicationContext = super.createViewManagers(paramReactApplicationContext);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramReactApplicationContext);
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\reactnative\ReadInjoyReactPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */