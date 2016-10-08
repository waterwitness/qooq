package com.tencent.common.galleryactivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ImageScene
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public GalleryManager a;
  
  public ImageScene()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public abstract void a(ViewGroup paramViewGroup);
  
  void a(GalleryManager paramGalleryManager)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = paramGalleryManager;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public abstract boolean d();
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void j() {}
  
  public void k() {}
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\galleryactivity\ImageScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */