package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class upload_finish_rsp
  extends JceStruct
{
  public int retry_timeout;
  
  public upload_finish_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public upload_finish_rsp(int paramInt)
  {
    this.retry_timeout = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retry_timeout = paramJceInputStream.read(this.retry_timeout, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retry_timeout, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\upload_finish_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */