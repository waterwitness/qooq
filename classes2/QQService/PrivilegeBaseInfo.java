package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class PrivilegeBaseInfo
  extends JceStruct
{
  static ArrayList cache_vClosePriv;
  static ArrayList cache_vOpenPriv;
  public String strJumpUrl = "";
  public String strMsg = "";
  public ArrayList vClosePriv;
  public ArrayList vOpenPriv;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_vOpenPriv = new ArrayList();
    PrivilegeInfo localPrivilegeInfo = new PrivilegeInfo();
    cache_vOpenPriv.add(localPrivilegeInfo);
    cache_vClosePriv = new ArrayList();
    localPrivilegeInfo = new PrivilegeInfo();
    cache_vClosePriv.add(localPrivilegeInfo);
  }
  
  public PrivilegeBaseInfo() {}
  
  public PrivilegeBaseInfo(String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.strMsg = paramString1;
    this.strJumpUrl = paramString2;
    this.vOpenPriv = paramArrayList1;
    this.vClosePriv = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strMsg = paramJceInputStream.readString(0, true);
    this.strJumpUrl = paramJceInputStream.readString(1, true);
    this.vOpenPriv = ((ArrayList)paramJceInputStream.read(cache_vOpenPriv, 2, false));
    this.vClosePriv = ((ArrayList)paramJceInputStream.read(cache_vClosePriv, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strMsg, 0);
    paramJceOutputStream.write(this.strJumpUrl, 1);
    if (this.vOpenPriv != null) {
      paramJceOutputStream.write(this.vOpenPriv, 2);
    }
    if (this.vClosePriv != null) {
      paramJceOutputStream.write(this.vClosePriv, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\PrivilegeBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */