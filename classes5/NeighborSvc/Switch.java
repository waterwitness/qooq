package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Switch
  extends JceStruct
{
  static int cache_type;
  public byte is_open;
  public int type;
  
  public Switch()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Switch(int paramInt, byte paramByte)
  {
    this.type = paramInt;
    this.is_open = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.is_open = paramJceInputStream.read(this.is_open, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.is_open, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NeighborSvc\Switch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */