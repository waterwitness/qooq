package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import whm;

public class SwiftBrowserComponentsProvider
{
  public static final int a = 1;
  public static final String a = "url";
  public static final int b = 2;
  public static final String b = "state_machine_step";
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = -1;
  public static final int i = -2;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 4;
  public static final int m = 8;
  public static final int n = 16;
  public static final int o = 32;
  public static final int p = 47;
  private SwiftBrowserComponentsProvider.SwiftBrowserComponentContext jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext;
  final SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory;
  public final SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext a;
  final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  final int q;
  
  public SwiftBrowserComponentsProvider(SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext paramSwiftBrowserComponentProviderContext, int paramInt, SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory paramSwiftBrowserComponentFactory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext = new whm(this);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext = paramSwiftBrowserComponentProviderContext;
    this.q = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory = paramSwiftBrowserComponentFactory;
    int i1 = 0;
    while (i1 < 32)
    {
      int i3 = i2;
      if ((1 << i1 & paramInt) != 0) {
        i3 = i2 + 1;
      }
      i1 += 1;
      i2 = i3;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(i2);
  }
  
  public Object a(int paramInt)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      Object localObject4;
      try
      {
        if ((this.q & paramInt) == 0) {
          break label239;
        }
        localObject4 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        Object localObject1 = localObject4;
        if (localObject4 != null) {
          break label136;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory == null) {
          break label244;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentFactory.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new SwiftBrowserSetting();
      label136:
      label239:
      label244:
      do
      {
        if ((localObject3 instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponent))
        {
          localObject4 = (SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject3;
          ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject4).jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext;
          ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject4).a();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new SwiftBrowserNavigator(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext);
          break;
          localObject3 = new SwiftBrowserUIStyleHandler();
          break;
          localObject3 = new SwiftBrowserShareMenuHandler();
          break;
          localObject3 = new SwiftBrowserLongClickHandler(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
          break;
          localObject3 = new SwiftBrowserStatistics();
          break;
          localObject3 = new SwiftBrowserTBSHandler(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
          break;
          localObject3 = new SwiftBrowserMiscHandler();
          break;
          localObject3 = null;
        }
        localObject3 = localObject4;
      } while (localObject4 != null);
      switch (paramInt)
      {
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (paramBundle.hasNext())
    {
      Object localObject = paramBundle.next();
      if ((localObject instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponent)) {
        ((SwiftBrowserComponentsProvider.SwiftBrowserComponent)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserComponentsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */