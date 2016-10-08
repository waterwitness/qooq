import com.dataline.mpfile.MpfileTaskRecord;
import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qnl
  implements Runnable
{
  public qnl(MpfileTaskProxy paramMpfileTaskProxy, MpfileTaskRecord paramMpfileTaskRecord, WaitEvent paramWaitEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy.a(this.jdField_a_of_type_ComDatalineMpfileMpfileTaskRecord, null);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */