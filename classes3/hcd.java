import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockCircle.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hcd
  extends Thread
{
  public boolean a;
  boolean b;
  
  public hcd(ChildLockCircle paramChildLockCircle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener != null) {
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener.a();
    }
    this.b = false;
    f2 = 0.0F;
    if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.e = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.post(new hce(this));
      f1 = f2;
      if (!this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_Boolean) {}
      try
      {
        Thread.sleep(ChildLockCircle.jdField_a_of_type_Long);
        f1 = f2;
      }
      catch (InterruptedException localInterruptedException6)
      {
        for (;;)
        {
          label111:
          label214:
          label353:
          label443:
          label469:
          f1 = f2;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_Boolean) {
          break label353;
        }
        this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int = ((int)((float)(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int + this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_Int * 15L / 1000L) + f1));
        if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int >= this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.e = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_AndroidGraphicsBitmap;
          this.b = true;
        }
        f1 = (float)(f1 + 0.08D);
        this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
        if (!this.b) {
          break label443;
        }
        if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener != null) {
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener.c();
        }
      }
      if ((!this.b) || (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_Boolean)) {}
      try
      {
        Thread.sleep(ChildLockCircle.jdField_a_of_type_Long * 2L);
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener != null) {
            this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener.b();
          }
          return;
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_Int;
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.e = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int = ((int)((float)(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_Int * 15L / 1000L) - f1));
          if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int > 0) {
            break label214;
          }
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.e = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.d;
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_AndroidGraphicsBitmap;
          this.b = true;
          break label214;
          try
          {
            Thread.sleep(15L);
          }
          catch (InterruptedException localInterruptedException1) {}
          break label111;
          try
          {
            Thread.sleep(ChildLockCircle.jdField_a_of_type_Long);
          }
          catch (InterruptedException localInterruptedException2) {}
          continue;
          this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
          try
          {
            Thread.sleep(15L);
            if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int - 9L * 15L / 5L * this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_Int / 1000L));
              if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int > 0) {
                break label469;
              }
              this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int = 0;
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
              if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener != null) {
                this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener.d();
              }
              try
              {
                Thread.sleep(15L * 2L);
              }
              catch (InterruptedException localInterruptedException3) {}
              break;
              this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int + 9L * 15L / 5L * this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_Int / 1000L));
              if (this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_c_of_type_Int < this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.jdField_b_of_type_Int) {
                break label469;
              }
            }
          }
          catch (InterruptedException localInterruptedException4)
          {
            for (;;) {}
          }
        }
      }
      catch (InterruptedException localInterruptedException5)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */