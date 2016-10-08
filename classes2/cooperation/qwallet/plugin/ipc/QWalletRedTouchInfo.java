package cooperation.qwallet.plugin.ipc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QWalletRedTouchInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String buffer;
  public String imageRedContent;
  public String imageRedDesc;
  public String path;
  public int type;
  
  public QWalletRedTouchInfo(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.path = paramString1;
    this.type = paramInt;
    this.buffer = paramString2;
    this.imageRedDesc = paramString3;
    this.imageRedContent = paramString4;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\ipc\QWalletRedTouchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */