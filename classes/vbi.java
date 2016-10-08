import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

public class vbi
  implements Runnable
{
  public long a;
  public ProtoReqManager.ProtoResp a;
  public NewIntent a;
  public boolean a;
  long b;
  public boolean b;
  public long c;
  public boolean c;
  
  public vbi(ProtoReqManager paramProtoReqManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
  }
  
  public void run()
  {
    QLog.d("Q.richmedia.ProtoReqManager", 2, "ProtoReqRunnable.run() : resp.startTime" + this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("key_timeout", this.jdField_a_of_type_Long);
    MessageObserver.StatictisInfo localStatictisInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    localStatictisInfo.d += 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a.put(this.jdField_a_of_type_MqqAppNewIntent, this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */