import android.os.SystemClock;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rhp
  implements Runnable
{
  private float jdField_a_of_type_Float;
  protected long a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private float c;
  private float d;
  private float e;
  private float f;
  
  public rhp(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_Float = paramInt;
    paramFloat = 1.0F / (this.jdField_b_of_type_Float * 2.0F * (1.0F - this.jdField_b_of_type_Float));
    this.f = paramFloat;
    this.c = paramFloat;
    this.d = (this.jdField_b_of_type_Float / ((this.jdField_b_of_type_Float - 1.0F) * 2.0F));
    this.e = (1.0F / (1.0F - this.jdField_b_of_type_Float));
  }
  
  public float a(float paramFloat)
  {
    if (paramFloat < this.jdField_b_of_type_Float) {
      return this.c * paramFloat * paramFloat;
    }
    if (paramFloat < 1.0F - this.jdField_b_of_type_Float) {
      return this.d + this.e * paramFloat;
    }
    return 1.0F - this.f * (paramFloat - 1.0F) * (paramFloat - 1.0F);
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.post(this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
    if (f1 >= 1.0F)
    {
      a(1.0F, 1.0F);
      b();
      return;
    }
    a(f1, a(f1));
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.post(this);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */