import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gwm
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public gwm(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */