package cooperation.qlink;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QlAndQQInterface$WorkState
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean mForIphone;
  public int mMode;
  public String mPeerNick;
  public String mPeerUin;
  public int mState;
  public int mTransferingCount;
  public boolean mWorking;
  
  public QlAndQQInterface$WorkState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mWorking = false;
    this.mState = 0;
    this.mPeerUin = "0";
    this.mPeerNick = "";
    this.mMode = 0;
    this.mTransferingCount = 0;
    this.mForIphone = false;
  }
  
  public QlAndQQInterface$WorkState(boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.mWorking = paramBoolean1;
    this.mState = paramInt1;
    this.mPeerUin = paramString1;
    this.mPeerNick = paramString2;
    this.mMode = paramInt2;
    this.mTransferingCount = paramInt3;
    this.mForIphone = paramBoolean2;
  }
  
  public WorkState clone()
  {
    try
    {
      WorkState localWorkState1 = (WorkState)super.clone();
      return localWorkState1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      WorkState localWorkState2 = new WorkState();
      localCloneNotSupportedException.printStackTrace();
      return localWorkState2;
    }
  }
  
  public String toString()
  {
    return " mWorking:" + this.mWorking + " mState:" + this.mState + " mPeerUin:" + this.mPeerUin + " mPeerNick:" + this.mPeerNick + " mMode:" + this.mMode + " mTransferingCount:" + this.mTransferingCount + " mForIphone:" + this.mForIphone;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qlink\QlAndQQInterface$WorkState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */