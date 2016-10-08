import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gud
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public gud(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt2;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */