import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qwallet.plugin.ipc.CorpReq;

public class yjs
  implements Runnable
{
  public yjs(CorpReq paramCorpReq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    switch (CorpReq.corpReqType)
    {
    case 4: 
    default: 
      return;
    case 1: 
      this.a.onGetFaceFilePath();
      return;
    case 2: 
      this.a.onIsFriend();
      return;
    case 3: 
      this.a.onUserNcik();
      return;
    case 6: 
      this.a.deleteUserNickOB();
      return;
    }
    CorpReq.access$000(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */