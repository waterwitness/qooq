package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FrameGifView
  extends ImageView
  implements SimpleFrameZipDecoder.onFrameDecodeListener
{
  public static final String a = "http://cmshow.gtimg.cn/client/zip/box_gif.zip";
  public static final String b = "http://cmshow.gtimg.cn/client/zip/drawer_btn_anim.zip";
  public static final String c = "http://cmshow.gtimg.cn/client/zip/apollo_float_card.zip";
  public static final String d = "http://cmshow.gtimg.cn/client/zip/apollo_float_card_2016_05_09.zip";
  public static final String e = "http://cmshow.gtimg.cn/client/zip/apollo_float_card_2016_06_15.zip";
  FrameGifView.AnimationListener a;
  protected QQFrameZipDecoder a;
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder = new QQFrameZipDecoder(this);
  }
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder = new QQFrameZipDecoder(this);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a();
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a();
    }
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$AnimationListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$AnimationListener.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.b();
    }
  }
  
  public void setAnimaListener(FrameGifView.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$AnimationListener = paramAnimationListener;
  }
  
  public void setGifData(int paramInt, Drawable paramDrawable, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (getDrawable() == null) {
      super.setImageDrawable(paramDrawable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a(paramInt, paramString1, paramString2, paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\FrameGifView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */