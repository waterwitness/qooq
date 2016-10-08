package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;

public class GalleryProgressView
  implements AbstractProgressView
{
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  PhotoProgressDrawable jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  public GalleryProgressView()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = BitmapFactory.decodeResource(paramActivity.getResources(), 2130842480);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = new PhotoProgressDrawable((Bitmap)localObject2, (int)(paramActivity.getResources().getDisplayMetrics().density * 12.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(0);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.b) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 4))
    {
      if ((this.jdField_a_of_type_AndroidGraphicsRect.width() == 0) || (this.jdField_a_of_type_AndroidGraphicsRect.height() == 0))
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 100))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(paramInt * 100);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.invalidateSelf();
    }
  }
  
  public void a(Activity paramActivity, ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    a(paramActivity);
  }
  
  public void a(Activity paramActivity, AbstractGalleryScene paramAbstractGalleryScene)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RelativeLayout)paramAbstractGalleryScene.a()).findViewById(2131299695));
    a(paramActivity);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = true;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsRect.width() == 0) || (this.jdField_a_of_type_AndroidGraphicsRect.height() == 0))
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((paramInt >= 0) && (paramInt < 100))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(paramInt * 100);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.invalidateSelf();
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = false;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\galleryactivity\GalleryProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */