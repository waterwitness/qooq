import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

class pdu
  implements Runnable
{
  pdu(pdt parampdt, RMVideoStateMgr paramRMVideoStateMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.unlockFrameSync();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */