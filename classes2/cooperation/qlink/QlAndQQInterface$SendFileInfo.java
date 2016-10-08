package cooperation.qlink;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QlAndQQInterface$SendFileInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String filePath;
  public long fileSize;
  public int msgseq;
  public int msgtime;
  public long msguid;
  public long sessionid;
  
  public QlAndQQInterface$SendFileInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlAndQQInterface$SendFileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */