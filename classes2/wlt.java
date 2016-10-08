import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView.DisplayRuleDef;

public final class wlt
  implements AnyScaleTypeImageView.DisplayRuleDef
{
  public wlt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    paramInt2 = paramDrawable.getIntrinsicWidth();
    float f = paramInt1 / paramInt2;
    localMatrix.setScale(f, f);
    return localMatrix;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */