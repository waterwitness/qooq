package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import nte;

public class AIOGalleryAdapter$GalleryURLImageView
  extends AbstractImageAdapter.URLImageView2
{
  int jdField_a_of_type_Int;
  public AIORichMediaInfo a;
  boolean b;
  
  public AIOGalleryAdapter$GalleryURLImageView(AIOGalleryAdapter paramAIOGalleryAdapter, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("GalleryURLImageView draw: height: ").append(getMeasuredHeight()).append(" ,width: ").append(getMeasuredWidth()).append(" ,drawable: ");
      if (getDrawable() != null) {
        break label73;
      }
    }
    label73:
    for (Object localObject = "null";; localObject = getDrawable())
    {
      QLog.d("AIOGalleryAdapter", 2, localObject);
      super.draw(paramCanvas);
      return;
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramURLDrawable = paramURLDrawable.getURL().getRef();
    if ((paramURLDrawable == null) || (!paramURLDrawable.equals("DISPLAY"))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Int, false);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    String str = paramURLDrawable.getURL().getRef();
    if ((str != null) && (str.equals("NOSAMPLE")))
    {
      this.jdField_a_of_type_Boolean = true;
      super.onLoadSuccessed(paramURLDrawable);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Int, true);
    }
    do
    {
      return;
      super.onLoadSuccessed(paramURLDrawable);
      if ((str == null) || (!str.equals("DISPLAY"))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Int, true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.b == -2) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.b = paramURLDrawable.getExifOrientation();
        }
        AIOGalleryAdapter.a(this, paramURLDrawable, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.b);
      }
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
    } while (!VideoDrawable.class.isInstance(paramURLDrawable));
    ((VideoDrawable)paramURLDrawable).setOnPlayRepeatListener(new nte(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOGalleryAdapter$GalleryURLImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */