package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_setspaceright_rsp
  extends JceStruct
{
  public long cur_seq;
  
  public mobile_sub_setspaceright_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_setspaceright_rsp(long paramLong)
  {
    this.cur_seq = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cur_seq = paramJceInputStream.read(this.cur_seq, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cur_seq, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_setspaceright_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */