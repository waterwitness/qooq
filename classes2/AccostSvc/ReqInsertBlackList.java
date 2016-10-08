package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReqInsertBlackList
  extends JceStruct
{
  static int cache_eType;
  static ReqHeader cache_stHeader;
  static ArrayList cache_vBlackList;
  public int eType;
  public ReqHeader stHeader;
  public ArrayList vBlackList;
  
  public ReqInsertBlackList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.eType = 0;
  }
  
  public ReqInsertBlackList(ReqHeader paramReqHeader, ArrayList paramArrayList, int paramInt)
  {
    this.eType = 0;
    this.stHeader = paramReqHeader;
    this.vBlackList = paramArrayList;
    this.eType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_vBlackList == null)
    {
      cache_vBlackList = new ArrayList();
      cache_vBlackList.add(Long.valueOf(0L));
    }
    this.vBlackList = ((ArrayList)paramJceInputStream.read(cache_vBlackList, 1, true));
    this.eType = paramJceInputStream.read(this.eType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.vBlackList, 1);
    paramJceOutputStream.write(this.eType, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\ReqInsertBlackList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */