package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Hashtable;

public class SwiftBrowserSetting
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  public static final String a = "web_view_long_click";
  public static final String b = "image_long_click";
  Hashtable a;
  
  public SwiftBrowserSetting()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new Hashtable();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    paramString = (Boolean)this.a.get(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return paramString.booleanValue();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */