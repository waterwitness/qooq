package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetBlackList
  extends JceStruct
{
  static int cache_eListType;
  static int cache_eType;
  static ReqHeader cache_stHeader;
  public int eListType;
  public int eType;
  public long lNextMid;
  public ReqHeader stHeader;
  
  public ReqGetBlackList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.eListType = 1;
    this.eType = 0;
  }
  
  public ReqGetBlackList(ReqHeader paramReqHeader, long paramLong, int paramInt1, int paramInt2)
  {
    this.eListType = 1;
    this.eType = 0;
    this.stHeader = paramReqHeader;
    this.lNextMid = paramLong;
    this.eListType = paramInt1;
    this.eType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 1, true);
    this.eListType = paramJceInputStream.read(this.eListType, 2, false);
    this.eType = paramJceInputStream.read(this.eType, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lNextMid, 1);
    paramJceOutputStream.write(this.eListType, 2);
    paramJceOutputStream.write(this.eType, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\ReqGetBlackList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */