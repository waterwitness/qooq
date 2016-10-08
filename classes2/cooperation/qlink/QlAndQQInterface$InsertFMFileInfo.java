package cooperation.qlink;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QlAndQQInterface$InsertFMFileInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean bSend;
  public String filePath;
  public int fileType;
  public long sessionId;
  public String thumbPath;
  public int transSeq;
  public String uin;
  
  public QlAndQQInterface$InsertFMFileInfo(String paramString1, boolean paramBoolean, long paramLong, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.fileType = -1;
    this.uin = paramString1;
    this.bSend = paramBoolean;
    this.sessionId = paramLong;
    this.filePath = paramString2;
    this.thumbPath = paramString3;
    this.transSeq = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlAndQQInterface$InsertFMFileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */