import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixb
  extends GestureHelper.ZoomItem
{
  final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  final RectF jdField_a_of_type_AndroidGraphicsRectF;
  final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public String c;
  public String d;
  
  public ixb(FaceLayer paramFaceLayer, Bitmap paramBitmap)
  {
    super(paramBitmap.getWidth(), paramBitmap.getHeight());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(-this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, -this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
  }
  
  public ixb(FaceLayer paramFaceLayer, Drawable paramDrawable)
  {
    super(paramDrawable.getBounds().width(), paramDrawable.getBounds().height());
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramDrawable.getBounds());
  }
  
  public ixb(FaceLayer paramFaceLayer, ixb paramixb, float paramFloat)
  {
    super(paramixb, paramFloat);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramixb.jdField_a_of_type_AndroidGraphicsBitmap;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramixb.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramixb.jdField_a_of_type_AndroidGraphicsRectF);
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramCanvas.translate(-this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F, -this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, -this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F, -this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F, this.b.a);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */