package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class DomainIpList
  extends JceStruct
{
  static ArrayList cache_vIplist;
  public int uDomain_type;
  public ArrayList vIplist;
  
  public DomainIpList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DomainIpList(int paramInt, ArrayList paramArrayList)
  {
    this.uDomain_type = paramInt;
    this.vIplist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uDomain_type = paramJceInputStream.read(this.uDomain_type, 0, true);
    if (cache_vIplist == null)
    {
      cache_vIplist = new ArrayList();
      DomainIpInfo localDomainIpInfo = new DomainIpInfo();
      cache_vIplist.add(localDomainIpInfo);
    }
    this.vIplist = ((ArrayList)paramJceInputStream.read(cache_vIplist, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uDomain_type, 0);
    paramJceOutputStream.write(this.vIplist, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\DomainIpList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */