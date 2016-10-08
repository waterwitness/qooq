import android.graphics.Matrix;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qwy
{
  private qwy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(View paramView)
  {
    return paramView.getPivotX();
  }
  
  public static Matrix a(View paramView)
  {
    return paramView.getMatrix();
  }
  
  public static void a(View paramView, float paramFloat)
  {
    paramView.setPivotX(paramFloat);
  }
  
  public static void a(View paramView, int paramInt)
  {
    paramView.setScrollX(paramInt);
  }
  
  public static float b(View paramView)
  {
    return paramView.getPivotY();
  }
  
  public static void b(View paramView, float paramFloat)
  {
    paramView.setPivotY(paramFloat);
  }
  
  public static void b(View paramView, int paramInt)
  {
    paramView.setScrollY(paramInt);
  }
  
  public static float c(View paramView)
  {
    return paramView.getAlpha();
  }
  
  public static void c(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  public static float d(View paramView)
  {
    return paramView.getScaleX();
  }
  
  public static void d(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  public static float e(View paramView)
  {
    return paramView.getScaleY();
  }
  
  public static void e(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  public static float f(View paramView)
  {
    return paramView.getScrollX();
  }
  
  public static void f(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  public static float g(View paramView)
  {
    return paramView.getScrollY();
  }
  
  public static void g(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  public static float h(View paramView)
  {
    return paramView.getTranslationX();
  }
  
  public static void h(View paramView, float paramFloat)
  {
    paramView.setX(paramFloat);
  }
  
  public static float i(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static float j(View paramView)
  {
    return paramView.getX();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */