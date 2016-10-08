package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class strupbuffResp
  extends JceStruct
{
  public int seqno;
  
  public strupbuffResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public strupbuffResp(int paramInt)
  {
    this.seqno = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.seqno = paramJceInputStream.read(this.seqno, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seqno, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\strupbuffResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */