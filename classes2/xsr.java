import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.image.ProxyDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.BubblePopupWindow;

public class xsr
  extends ProxyDrawable
{
  int jdField_a_of_type_Int;
  int b;
  
  public xsr(BubblePopupWindow paramBubblePopupWindow, Drawable paramDrawable)
  {
    super(paramDrawable);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (this.b > this.jdField_a_of_type_Int)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(this.jdField_a_of_type_Int, 0, this.b, localRect.height());
      this.mCurrDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */