package cooperation.qqhotspot.hotspotnode.protocol.pbsrc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;

public class APNodeCheckResult
  implements Serializable
{
  public ArrayList arrApInfo;
  public int nRetCode;
  
  public APNodeCheckResult()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.arrApInfo = new ArrayList();
    this.nRetCode = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\protocol\pbsrc\APNodeCheckResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */