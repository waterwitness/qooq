package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Random;

public class FloatViewBuilder
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Random jdField_a_of_type_JavaUtilRandom;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public FloatViewBuilder(Context paramContext, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[] { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(HeartLayout paramHeartLayout)
  {
    if ((paramHeartLayout == null) || (paramHeartLayout.a() == null)) {}
    do
    {
      return;
      paramHeartLayout = paramHeartLayout.a();
    } while (paramHeartLayout == null);
    paramHeartLayout.l = 2400;
    com.tencent.mobileqq.hotchat.anim.HeartAnimator.Config.b = 0.05F;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(3);
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas == null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
      }
      Bitmap localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      Bitmap localBitmap2 = HeartView.a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      if (localBitmap2 == null) {
        return null;
      }
      Canvas localCanvas = this.jdField_a_of_type_AndroidGraphicsCanvas;
      localCanvas.setBitmap(localBitmap2);
      Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      localPaint.setColorFilter(new PorterDuffColorFilter(this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_ArrayOfInt.length)], PorterDuff.Mode.SRC_ATOP));
      localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, localPaint);
      localPaint.setColorFilter(null);
      if (Build.VERSION.SDK_INT >= 11) {
        localCanvas.setBitmap(null);
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\ui\FloatViewBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */