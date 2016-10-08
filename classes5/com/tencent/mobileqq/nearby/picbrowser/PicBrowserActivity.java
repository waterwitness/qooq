package com.tencent.mobileqq.nearby.picbrowser;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import tkv;

public class PicBrowserActivity
  extends BaseActivity
{
  public static final String a = "intent_param_pic_infos";
  public static final String b = "intent_param_index";
  public static final String c = "report_visited_pic";
  public int a;
  public GalleryManager a;
  protected ImmersiveTitleBar2 a;
  public ArrayList a;
  boolean a;
  
  public PicBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = new tkv(this);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131297137));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    ImmersiveUtils.a(getWindow(), ThemeUtil.isNowThemeIsDefault(this.app, false, null));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(getResources().getColor(2131427409));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Int = getIntent().getIntExtra("intent_param_index", 0);
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getParcelableArrayListExtra("intent_param_pic_infos");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("report_visited_pic", false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(8);
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b()) {
      super.doOnBackPressed();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    setContentView(2130904249);
    a();
    b();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt, paramKeyEvent)) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void doOnPause()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b();
  }
  
  protected void doOnResume()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b(this);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\picbrowser\PicBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */