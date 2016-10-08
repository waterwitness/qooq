import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqj
  implements Runnable
{
  public yqj(RecordSVInteractActivity paramRecordSVInteractActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.a)
    {
      RecordSVInteractActivity.a(this.a).a(2002, "抱歉，摄像头可能被禁止了", false);
      if (QLog.isColorLevel()) {
        QLog.d("RecordSVInteractActivity", 2, "[@] ERR_CODE_CAMERA_CREATE  黑名单机型,2秒还没有获取到预览帧,可能没有权限");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */