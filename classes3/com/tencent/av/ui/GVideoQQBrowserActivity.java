package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.SystemBarCompact;
import guh;

public class GVideoQQBrowserActivity
  extends AbsBaseWebViewActivity
{
  ImageView a;
  
  public GVideoQQBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView)
  {
    int i = 0;
    paramView.setVerticalScrollBarEnabled(false);
    paramView.setHorizontalScrollBarEnabled(false);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.w = true;
    this.mNeedStatusTrans = true;
    super.getWindow().setFlags(2048, 2048);
    super.getWindow().setWindowAnimations(2131558620);
    String str = super.getIntent().getStringExtra("url");
    if (TextUtils.isEmpty(str)) {}
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setTheme(2131558621);
    super.setContentView(2130903562);
    super.hideTitleBar();
    paramBundle = super.b((FrameLayout)super.findViewById(2131299251));
    a(paramBundle);
    paramBundle.loadUrl(str);
    if (this.mSystemBarComp != null)
    {
      int i = super.getResources().getColor(2131427379);
      this.mSystemBarComp.a(i);
      this.mSystemBarComp.b(i);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299252));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new guh(this));
    return false;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.mSystemBarComp != null)
    {
      int i = super.getResources().getColor(2131427379);
      this.mSystemBarComp.a(i);
      this.mSystemBarComp.b(i);
    }
  }
  
  public boolean showPreview()
  {
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      int i = super.getResources().getColor(2131427379);
      this.mSystemBarComp.a(i);
      this.mSystemBarComp.b(i);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\GVideoQQBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */