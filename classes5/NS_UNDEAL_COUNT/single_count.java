package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class single_count
  extends JceStruct
{
  public byte iControl;
  public long uCount;
  
  public single_count()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public single_count(long paramLong, byte paramByte)
  {
    this.uCount = paramLong;
    this.iControl = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCount = paramJceInputStream.read(this.uCount, 0, false);
    this.iControl = paramJceInputStream.read(this.iControl, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCount, 0);
    paramJceOutputStream.write(this.iControl, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\single_count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */