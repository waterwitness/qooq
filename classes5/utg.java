import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;
import com.tencent.qphone.base.util.QLog;

public class utg
  extends utf
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  boolean c;
  public boolean g;
  public boolean h;
  
  public utg(TCProgressBar paramTCProgressBar, boolean paramBoolean)
  {
    super(paramTCProgressBar);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = false;
    this.h = false;
    this.c = paramBoolean;
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.j;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (this.j + this.k);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.k);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.l);
      super.a(paramCanvas);
      return;
    }
    int i;
    if (this.f) {
      i = this.k;
    }
    for (;;)
    {
      boolean bool = a(this.jdField_a_of_type_Int - 5);
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "ProgressBlock:hasMorePart=" + this.jdField_a_of_type_Boolean + " bounds=" + bool);
      }
      if ((!this.jdField_a_of_type_Boolean) || (!bool)) {
        break label392;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.j;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.m);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (i + this.j);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.n);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      break;
      i = this.k - this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.p;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = (this.j + i);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (this.j + this.k);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.o);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
    }
    label392:
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.j;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (i + this.j);
    if (this.b) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.n);
    }
    for (;;)
    {
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      break;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.m);
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt > this.j) && (paramInt < this.j + this.k - this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.p);
  }
  
  public boolean b(int paramInt)
  {
    return (paramInt < this.j) || (a(paramInt));
  }
  
  public boolean c(int paramInt)
  {
    return (paramInt > this.j + this.k) || (a(paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\utg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */