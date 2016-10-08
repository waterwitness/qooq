import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.FlowSendTask;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class paa
  implements Runnable
{
  public paa(FlowSendTask paramFlowSendTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.i, 2, "FlowSendTask(): isPTV:" + this.a.jdField_b_of_type_Boolean + ", mVideoFileDir:" + this.a.jdField_b_of_type_JavaLangString + ",is to call AVideoCodec.recordSubmit()");
      }
      RecordManager.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        this.a.t = -6;
        synchronized (this.a.a.a)
        {
          this.a.a.a.set(true);
          this.a.a.a.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.a.i, 2, "FlowSendTask(): isPTV:" + this.a.jdField_b_of_type_Boolean + ", mVideoFileDir:" + this.a.jdField_b_of_type_JavaLangString + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\paa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */