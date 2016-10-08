import android.widget.ProgressBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sic
  implements Runnable
{
  sic(sib paramsib, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Sib.a.a.setVisibility(0);
    float f = (float)this.jdField_a_of_type_Long / (float)this.b;
    this.jdField_a_of_type_Sib.a.a.setProgress((int)(f * 100.0F));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */