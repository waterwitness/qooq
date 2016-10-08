import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class krq
  implements Runnable
{
  krq(kro paramkro, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Call.a(this.jdField_a_of_type_Kro.a) != null)
    {
      Call.a(this.jdField_a_of_type_Kro.a).a(this.jdField_a_of_type_Kro.a.a, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Boolean) {
        Call.a(this.jdField_a_of_type_Kro.a).a(true, true, Call.a(this.jdField_a_of_type_Kro.a));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */