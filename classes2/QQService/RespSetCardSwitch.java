package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespSetCardSwitch
  extends JceStruct
{
  static RespHead cache_stHeader;
  public RespHead stHeader;
  public long uCloseNeighborVote;
  public long uCloseTimeGateVote;
  
  public RespSetCardSwitch()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uCloseNeighborVote = 2L;
    this.uCloseTimeGateVote = 2L;
  }
  
  public RespSetCardSwitch(RespHead paramRespHead, long paramLong1, long paramLong2)
  {
    this.uCloseNeighborVote = 2L;
    this.uCloseTimeGateVote = 2L;
    this.stHeader = paramRespHead;
    this.uCloseNeighborVote = paramLong1;
    this.uCloseTimeGateVote = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uCloseNeighborVote = paramJceInputStream.read(this.uCloseNeighborVote, 1, true);
    this.uCloseTimeGateVote = paramJceInputStream.read(this.uCloseTimeGateVote, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.uCloseNeighborVote, 1);
    paramJceOutputStream.write(this.uCloseTimeGateVote, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespSetCardSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */