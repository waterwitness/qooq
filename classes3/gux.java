import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gux
  extends VideoObserver
{
  public gux(MultiIncomingCallsActivity paramMultiIncomingCallsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if ((this.a.c != null) && (this.a.c.equals(paramString)))
    {
      this.a.b();
      this.a.a(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d(MultiIncomingCallsActivity.a, 2, "onClose, reason:" + paramInt + ", peerUin:" + paramString + ", mPeerUin:" + this.a.c);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((this.a.c != null) && (this.a.c.equals(paramString))) {
      this.a.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d(MultiIncomingCallsActivity.a, 2, "onDestroyUI, peerUin:" + paramString + ", isQuit:" + paramBoolean + ", mPeerUin:" + this.a.c);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gux.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */