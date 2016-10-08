import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;

class pdp
  implements Runnable
{
  pdp(pdn parampdn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (CameraCompatibleList.a(CameraCompatibleList.y)) {
      RMVideoStateMgr.a().a(1102, "已经获取权限，需要重新进入打开摄像头", true);
    }
    for (;;)
    {
      return;
      try
      {
        if (!this.a.d) {
          RMVideoStateMgr.a().a(1102, "初始化失败,code=1102", true);
        }
        if (QLog.isColorLevel())
        {
          QLog.e("RMVideoInitState", 2, "[ERR_CODE_INIT_TIMEOUT]初始化失败,code=1102");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */