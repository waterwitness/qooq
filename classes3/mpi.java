import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mpi
  implements Runnable
{
  mpi(mph parammph, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (this.jdField_a_of_type_Int > 99)
      {
        this.jdField_a_of_type_Mph.a.leftView.setText(this.jdField_a_of_type_Mph.a.getString(2131367566) + "(" + "99+" + ")");
        return;
      }
      this.jdField_a_of_type_Mph.a.leftView.setText(this.jdField_a_of_type_Mph.a.getString(2131367566) + "(" + this.jdField_a_of_type_Int + ")");
      return;
    }
    this.jdField_a_of_type_Mph.a.leftView.setText(this.jdField_a_of_type_Mph.a.getString(2131367566));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */