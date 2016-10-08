package com.tencent.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageCollectionGallery
  extends Gallery
{
  private ImageCollectionGallery.OnOverScrollListener a;
  
  public ImageCollectionGallery(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ImageCollectionGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842864);
  }
  
  public ImageCollectionGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int a(boolean paramBoolean, int paramInt1, int paramInt2, Point paramPoint)
  {
    paramInt1 = super.a(paramBoolean, paramInt1, paramInt2, paramPoint);
    if ((this.aF == 0) && (!paramBoolean))
    {
      paramInt2 = b.left;
      int i = paramPoint.x;
      if (this.a != null) {
        this.a.a(paramInt2 + i);
      }
    }
    return paramInt1;
  }
  
  public void setOnOverScrollListener(ImageCollectionGallery.OnOverScrollListener paramOnOverScrollListener)
  {
    this.a = paramOnOverScrollListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ImageCollectionGallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */