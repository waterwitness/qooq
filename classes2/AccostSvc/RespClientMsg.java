package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespClientMsg
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static Msg cache_stMsg;
  public RespHeader stHeader;
  public Msg stMsg;
  
  public RespClientMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespClientMsg(RespHeader paramRespHeader, Msg paramMsg)
  {
    this.stHeader = paramRespHeader;
    this.stMsg = paramMsg;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stMsg == null) {
      cache_stMsg = new Msg();
    }
    this.stMsg = ((Msg)paramJceInputStream.read(cache_stMsg, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stMsg, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\RespClientMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */