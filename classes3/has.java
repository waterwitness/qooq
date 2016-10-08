import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class has
  extends GAudioUIObserver
{
  public has(VideoNetStateBar paramVideoNetStateBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onCreateRoomSuc-->GroupID=" + paramLong);
    }
    this.a.i();
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    this.a.i();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\has.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */