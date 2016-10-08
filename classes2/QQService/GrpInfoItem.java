package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GrpInfoItem
  extends JceStruct
{
  public long Content;
  public byte Type;
  
  public GrpInfoItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GrpInfoItem(byte paramByte, long paramLong)
  {
    this.Type = paramByte;
    this.Content = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Type = paramJceInputStream.read(this.Type, 0, true);
    this.Content = paramJceInputStream.read(this.Content, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Type, 0);
    paramJceOutputStream.write(this.Content, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\GrpInfoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */