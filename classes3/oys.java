import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oys
  implements Runnable
{
  public static final int a = 60;
  private float jdField_a_of_type_Float;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private PointF jdField_b_of_type_AndroidGraphicsPointF;
  private int c;
  private int d;
  
  public oys(DragFrameLayout paramDragFrameLayout, PointF paramPointF, RectF paramRectF)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 9;
    this.c = 20;
    this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int * paramDragFrameLayout.getResources().getDisplayMetrics().density));
    this.c = ((int)(this.c * paramDragFrameLayout.getResources().getDisplayMetrics().density));
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramPointF.x, paramPointF.y);
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
    this.jdField_a_of_type_Float = ((float)Math.sqrt(this.jdField_a_of_type_AndroidGraphicsRectF.width() * this.jdField_a_of_type_AndroidGraphicsRectF.width() + this.jdField_a_of_type_AndroidGraphicsRectF.height() * this.jdField_a_of_type_AndroidGraphicsRectF.height()));
    if (this.jdField_a_of_type_Float <= 0.01D)
    {
      this.d = 0;
      return;
    }
    this.c = ((int)(this.c * this.jdField_a_of_type_Float / DragFrameLayout.b(paramDragFrameLayout)));
    this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int * this.jdField_a_of_type_Float / DragFrameLayout.b(paramDragFrameLayout)));
    this.d = (-this.c);
  }
  
  public PointF a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPointF;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((Math.abs(this.d) < this.jdField_b_of_type_Int) || (this.jdField_b_of_type_Int == 0)) {
      if (DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout) == this)
      {
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, -1);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout).setVisibility(0);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.invalidate();
      return;
      this.jdField_b_of_type_AndroidGraphicsPointF.x = (this.jdField_a_of_type_AndroidGraphicsPointF.x + this.d * this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_Float);
      this.jdField_b_of_type_AndroidGraphicsPointF.y = (this.jdField_a_of_type_AndroidGraphicsPointF.y + this.d * this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_Float);
      if (this.d < 0) {
        this.d = (-this.d - this.jdField_b_of_type_Int);
      } else {
        this.d = (-this.d + this.jdField_b_of_type_Int);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */