package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class DomainIpChannel
  extends JceStruct
{
  static ArrayList cache_vDomain_iplists;
  public ArrayList vDomain_iplists;
  
  public DomainIpChannel()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DomainIpChannel(ArrayList paramArrayList)
  {
    this.vDomain_iplists = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vDomain_iplists == null)
    {
      cache_vDomain_iplists = new ArrayList();
      DomainIpList localDomainIpList = new DomainIpList();
      cache_vDomain_iplists.add(localDomainIpList);
    }
    this.vDomain_iplists = ((ArrayList)paramJceInputStream.read(cache_vDomain_iplists, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vDomain_iplists, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\DomainIpChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */