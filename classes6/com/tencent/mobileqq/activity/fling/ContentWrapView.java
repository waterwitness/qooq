package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import okt;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private okt jdField_a_of_type_Okt;
  
  public ContentWrapView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    a(paramContext);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    a(paramContext);
  }
  
  private void a()
  {
    okt localokt = this.jdField_a_of_type_Okt;
    if (localokt == null) {}
    while (!localokt.jdField_a_of_type_Boolean) {
      return;
    }
    okt.a(localokt).setTranslate(localokt.jdField_a_of_type_Float, localokt.b);
    localokt.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    okt localokt = this.jdField_a_of_type_Okt;
    if (localokt != null)
    {
      a();
      paramCanvas.concat(okt.a(localokt));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Okt == null) {
      this.jdField_a_of_type_Okt = new okt();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Okt != null) {
      return this.jdField_a_of_type_Okt.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Okt != null) {
      return this.jdField_a_of_type_Okt.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    okt localokt = this.jdField_a_of_type_Okt;
    if (localokt.jdField_a_of_type_Float != paramFloat)
    {
      localokt.jdField_a_of_type_Float = paramFloat;
      localokt.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void transXBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
  
  public void transY(float paramFloat)
  {
    ensureTransformationInfo();
    okt localokt = this.jdField_a_of_type_Okt;
    if (localokt.b != paramFloat)
    {
      localokt.b = paramFloat;
      localokt.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void transYBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\fling\ContentWrapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */