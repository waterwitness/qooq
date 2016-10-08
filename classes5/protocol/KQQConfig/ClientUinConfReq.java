package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ClientUinConfReq
  extends JceStruct
{
  static ClientGetUinConfReq cache_clientGetUinConfReq;
  static ClientSetUinConfReq cache_clientSetUinConfReq;
  public ClientGetUinConfReq clientGetUinConfReq;
  public ClientSetUinConfReq clientSetUinConfReq;
  public int iUinCmdType;
  
  public ClientUinConfReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ClientUinConfReq(int paramInt, ClientSetUinConfReq paramClientSetUinConfReq, ClientGetUinConfReq paramClientGetUinConfReq)
  {
    this.iUinCmdType = paramInt;
    this.clientSetUinConfReq = paramClientSetUinConfReq;
    this.clientGetUinConfReq = paramClientGetUinConfReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUinCmdType = paramJceInputStream.read(this.iUinCmdType, 1, true);
    if (cache_clientSetUinConfReq == null) {
      cache_clientSetUinConfReq = new ClientSetUinConfReq();
    }
    this.clientSetUinConfReq = ((ClientSetUinConfReq)paramJceInputStream.read(cache_clientSetUinConfReq, 3, false));
    if (cache_clientGetUinConfReq == null) {
      cache_clientGetUinConfReq = new ClientGetUinConfReq();
    }
    this.clientGetUinConfReq = ((ClientGetUinConfReq)paramJceInputStream.read(cache_clientGetUinConfReq, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUinCmdType, 1);
    if (this.clientSetUinConfReq != null) {
      paramJceOutputStream.write(this.clientSetUinConfReq, 3);
    }
    if (this.clientGetUinConfReq != null) {
      paramJceOutputStream.write(this.clientGetUinConfReq, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\ClientUinConfReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */