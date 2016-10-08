import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import mqq.os.MqqHandler;

public class vnc
  implements ThreadExcutor.IThreadListener
{
  public vnc(TroopFileItemOperation paramTroopFileItemOperation, TroopFileTransferManager paramTroopFileTransferManager, TroopFileInfo paramTroopFileInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void c()
  {
    ThreadManager.c().post(new vnd(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vnc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */