import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;

class pdv
  implements Runnable
{
  pdv(pdt parampdt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风读取数据错误...");
    }
    localRMVideoStateMgr.g = true;
    localRMVideoStateMgr.d = false;
    if (localRMVideoStateMgr.a != null)
    {
      if (localRMVideoStateMgr.a.o != -1) {
        break label92;
      }
      localRMVideoStateMgr.b(0, "麦克风被禁用", false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风被禁用,音频录制失败 errorcode=" + localRMVideoStateMgr.a.o);
      }
      return;
      label92:
      if (localRMVideoStateMgr.a.o == -2) {
        localRMVideoStateMgr.b(0, "麦克风可能被禁用", false);
      } else if (localRMVideoStateMgr.a.o == -3) {
        localRMVideoStateMgr.b(0, "麦克风可能被禁用", false);
      } else {
        localRMVideoStateMgr.b(0, "麦克风可能被禁用", false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */