package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CircleVideoDrawableView
  extends CircleBubbleImageView
  implements VideoDrawable.OnAudioPlayOnceListener
{
  private static final String b = "CircleVideoDrawableView";
  public URLDrawable a;
  CircleVideoDrawableView.VideoListener a;
  public String a;
  public URLDrawable b;
  
  public CircleVideoDrawableView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a() {}
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof VideoDrawable))) {
        return ((VideoDrawable)localDrawable).isAudioPlaying();
      }
    }
    return false;
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof VideoDrawable)))
      {
        localObject = (VideoDrawable)localObject;
        ((VideoDrawable)localObject).setOnAudioPlayOnceListener(null);
        ((VideoDrawable)localObject).stopAudio();
      }
    }
  }
  
  public void d()
  {
    a();
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof VideoDrawable)))
      {
        localObject = (VideoDrawable)localObject;
        ((VideoDrawable)localObject).resetAndPlayAudioOnce();
        ((VideoDrawable)localObject).setOnAudioPlayOnceListener(this);
      }
    }
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " onFinish ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener.y();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable)
    {
      setURLDrawable(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable) {
      setURLDrawable(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
    paramURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VideoDrawable)))
    {
      paramURLDrawable = (VideoDrawable)paramURLDrawable;
      paramURLDrawable.resetAndPlayAudioOnce();
      paramURLDrawable.setOnAudioPlayOnceListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener.x();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof VideoDrawable)))
      {
        localObject = (VideoDrawable)localObject;
        ((VideoDrawable)localObject).stopAudio();
        ((VideoDrawable)localObject).setOnAudioPlayOnceListener(null);
      }
    }
    paramURLDrawable.setURLDrawableListener(this);
    setImageDrawable(paramURLDrawable);
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    paramURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VideoDrawable))) {
      ((VideoDrawable)paramURLDrawable).setOnAudioPlayOnceListener(this);
    }
  }
  
  public void setVideoListener(CircleVideoDrawableView.VideoListener paramVideoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener = paramVideoListener;
  }
  
  public void setVideoPath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\CircleVideoDrawableView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */