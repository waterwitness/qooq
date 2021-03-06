package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespDeleteBlackList
  extends JceStruct
{
  static RespHeader cache_stHeader;
  public RespHeader stHeader;
  
  public RespDeleteBlackList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespDeleteBlackList(RespHeader paramRespHeader)
  {
    this.stHeader = paramRespHeader;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\RespDeleteBlackList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */