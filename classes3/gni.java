import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.groupvideo.GroupVideoWrapper;

public class gni
  extends MessageObserver
{
  public gni(QQServiceForAV paramQQServiceForAV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (this.a.a != null) {
      new GroupVideoWrapper(this.a.a).a(new gnj(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */