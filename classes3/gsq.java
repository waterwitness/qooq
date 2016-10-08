import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gsq
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  long b;
  
  public gsq(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI, int paramInt, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramLong2;
  }
  
  void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.a(true, 1, paramLong1);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 2)
        {
          this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.a(false, 1, paramLong1);
          return;
        }
        if (paramInt == 3)
        {
          this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.a(true, 2, paramLong1);
          return;
        }
        if (paramInt == 4)
        {
          this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.a(false, 2, paramLong1);
          return;
        }
        if (paramInt == 5)
        {
          this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.n = false;
          DoubleVideoMeetingCtrlUI.e(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI);
          return;
        }
        if (paramInt != 6) {
          break;
        }
      } while (paramLong1 == this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.b);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.c(true);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("DoubleVideoMeetingCtrlUI", 2, "ERROR-->The RefreshType is Error. Type = " + paramInt);
  }
  
  public void run()
  {
    a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */