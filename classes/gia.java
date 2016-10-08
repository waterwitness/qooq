import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class gia
  implements Runnable
{
  public gia(AVNotifyCenter paramAVNotifyCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a(String.valueOf(this.a.jdField_b_of_type_Ghu.jdField_a_of_type_Long))) {}
    do
    {
      return;
      if (this.a.a != null) {
        this.a.a.postDelayed(this, 1000L);
      }
    } while (!this.a.i);
    String str1 = UITools.a(this.a.jdField_b_of_type_Long);
    if (this.a.jdField_b_of_type_Ghu.jdField_a_of_type_Int == 3)
    {
      String str2 = Long.toString(this.a.jdField_b_of_type_Ghu.jdField_a_of_type_Long);
      this.a.a(29, 0, str2, str1);
      return;
    }
    this.a.a(29, 0, this.a.jdField_b_of_type_Ghu.jdField_a_of_type_JavaLangString, str1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\gia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */