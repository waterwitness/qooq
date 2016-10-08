package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Color
  extends JceStruct
{
  public long B;
  public long G;
  public long R;
  
  public Color()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Color(long paramLong1, long paramLong2, long paramLong3)
  {
    this.R = paramLong1;
    this.G = paramLong2;
    this.B = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.R = paramJceInputStream.read(this.R, 0, true);
    this.G = paramJceInputStream.read(this.G, 1, true);
    this.B = paramJceInputStream.read(this.B, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.R, 0);
    paramJceOutputStream.write(this.G, 1);
    paramJceOutputStream.write(this.B, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\Color.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */