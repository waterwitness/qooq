package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class TempMsgHead
  extends JceStruct
{
  public int c2c_type;
  public int service_type;
  
  public TempMsgHead()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TempMsgHead(int paramInt1, int paramInt2)
  {
    this.c2c_type = paramInt1;
    this.service_type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.c2c_type = paramJceInputStream.read(this.c2c_type, 0, false);
    this.service_type = paramJceInputStream.read(this.service_type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.c2c_type, 0);
    paramJceOutputStream.write(this.service_type, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\OnlinePushPack\TempMsgHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */