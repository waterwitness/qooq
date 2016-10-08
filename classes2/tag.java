import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.magicface.drawable.PngPlayParam;
import com.tencent.qphone.base.util.QLog;

public final class tag
  extends Drawable.ConstantState
{
  public int a;
  public Paint a;
  Shader.TileMode a;
  public boolean a;
  public String[] a;
  public int b;
  Shader.TileMode jdField_b_of_type_AndroidGraphicsShader$TileMode;
  boolean jdField_b_of_type_Boolean;
  public String[] b;
  int c;
  int d;
  public int e;
  
  public tag(PngPlayParam paramPngPlayParam)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 119;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_AndroidGraphicsShader$TileMode = null;
    this.jdField_b_of_type_AndroidGraphicsShader$TileMode = null;
    this.e = 160;
    if (paramPngPlayParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(PngFrameDrawable.a(), 2, "【ramdom magic】 png frame param is null.");
      }
      throw new IllegalArgumentException("【ramdom magic】 png frame param is null.");
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramPngPlayParam.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramPngPlayParam.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_Int = paramPngPlayParam.c;
    this.jdField_b_of_type_Int = paramPngPlayParam.jdField_b_of_type_Int;
    this.jdField_a_of_type_Boolean = paramPngPlayParam.jdField_a_of_type_Boolean;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new PngFrameDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PngFrameDrawable.a(), 2, "func newDrawable");
    }
    return new PngFrameDrawable(this, paramResources, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */