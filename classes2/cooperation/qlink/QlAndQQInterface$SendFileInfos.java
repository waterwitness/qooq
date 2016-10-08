package cooperation.qlink;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;

public class QlAndQQInterface$SendFileInfos
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public ArrayList infos;
  public String strUin;
  
  public QlAndQQInterface$SendFileInfos()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.infos = new ArrayList();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlAndQQInterface$SendFileInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */