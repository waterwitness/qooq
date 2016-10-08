package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SwiftBrowserNavigator
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  final SwiftBrowserComponentsProvider.SwiftBrowserComponentContext b;
  
  public SwiftBrowserNavigator(SwiftBrowserComponentsProvider.SwiftBrowserComponentContext paramSwiftBrowserComponentContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramSwiftBrowserComponentContext;
  }
  
  public boolean a(Intent paramIntent)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */