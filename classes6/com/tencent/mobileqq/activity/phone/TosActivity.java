package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ProtectedWebView;
import oqc;

public class TosActivity
  extends IphoneTitleBarActivity
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "frombusiness";
  private static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "key_file";
  private static final String c = "file:///android_asset/phone_tos.html";
  private static final String d = "file:///android_asset/business_tos.html";
  private static final String e = "file:///android_asset/phone_tos.html";
  private ProtectedWebView jdField_a_of_type_ComTencentWidgetProtectedWebView;
  
  public TosActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, TosActivity.class));
  }
  
  public static void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, TosActivity.class);
    localIntent.putExtra("key_file", 2);
    paramContext.startActivity(localIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = new ProtectedWebView(BaseApplicationImpl.a);
    this.a.setFadingEdgeLength(0);
    if (VersionUtils.c()) {
      this.a.setOverScrollMode(2);
    }
    setContentView(this.a);
    removeWebViewLayerType();
    setTitle("服务声明");
    if (getIntent().getIntExtra("key_file", 1) == 2) {}
    paramBundle = getIntent();
    if (paramBundle != null) {
      if (paramBundle.getIntExtra("frombusiness", 1) == 0) {
        this.a.loadUrl("file:///android_asset/business_tos.html");
      }
    }
    for (;;)
    {
      this.a.setOnLongClickListener(new oqc(this));
      return true;
      this.a.loadUrl("file:///android_asset/phone_tos.html");
      continue;
      this.a.loadUrl("file:///android_asset/phone_tos.html");
    }
  }
  
  protected void doOnDestroy()
  {
    setContentView(new TextView(this));
    try
    {
      this.a.stopLoading();
      try
      {
        this.a.clearView();
        try
        {
          this.a.destroy();
          super.doOnDestroy();
          return;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\TosActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */