import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView.DisplayRuleDef;

public final class wls
  implements AnyScaleTypeImageView.DisplayRuleDef
{
  public wls()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f = Math.max(paramInt1 / i, paramInt2 / j);
    localMatrix.setScale(f, f);
    localMatrix.postTranslate((int)(0.0F + 0.5F), (int)(0.0F + 0.5F));
    return localMatrix;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */