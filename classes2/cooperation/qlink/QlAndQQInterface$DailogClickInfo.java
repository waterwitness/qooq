package cooperation.qlink;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QlAndQQInterface$DailogClickInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int type;
  
  public QlAndQQInterface$DailogClickInfo(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlAndQQInterface$DailogClickInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */