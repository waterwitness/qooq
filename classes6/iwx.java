import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iwx
  implements Runnable
{
  float jdField_a_of_type_Float;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  float jdField_b_of_type_Float;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  float c;
  float d;
  float e;
  float f;
  
  public iwx(QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.c = paramFloat2;
    this.d = paramFloat3;
    this.e = paramFloat4;
    this.f = paramFloat5;
    this.jdField_b_of_type_Float = (33.33F / paramFloat1);
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    Paint localPaint = new Paint();
    Canvas localCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    Rect localRect = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    localPaint.setAntiAlias(true);
    localCanvas.drawCircle(paramFloat2, paramFloat3, f1 * 0.8F * (1.0F - paramFloat1), localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, localRect, localPaint);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Float < 1.0F)
    {
      long l = System.currentTimeMillis();
      a(this.jdField_a_of_type_Float, this.c + (this.e - this.c) * this.jdField_a_of_type_Float, this.d + (this.f - this.d) * this.jdField_a_of_type_Float);
      this.jdField_a_of_type_Float += this.jdField_b_of_type_Float;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoQQStoryTakeVideoCloseAnimationActivity.a.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
      int i = (int)(System.currentTimeMillis() - l);
      if (i < 33)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoQQStoryTakeVideoCloseAnimationActivity.a.postDelayed(this, 33 - i);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoQQStoryTakeVideoCloseAnimationActivity.a.post(this);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoQQStoryTakeVideoCloseAnimationActivity.a.setImageDrawable(new ColorDrawable(0));
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoQQStoryTakeVideoCloseAnimationActivity.finish();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */