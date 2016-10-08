package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class birth_info
  extends JceStruct
{
  public int birthDay;
  public int birthDayLunar;
  public int birthMon;
  public int birthMonLunar;
  
  public birth_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public birth_info(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.birthMon = paramInt1;
    this.birthDay = paramInt2;
    this.birthMonLunar = paramInt3;
    this.birthDayLunar = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.birthMon = paramJceInputStream.read(this.birthMon, 0, false);
    this.birthDay = paramJceInputStream.read(this.birthDay, 1, false);
    this.birthMonLunar = paramJceInputStream.read(this.birthMonLunar, 3, false);
    this.birthDayLunar = paramJceInputStream.read(this.birthDayLunar, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.birthMon, 0);
    paramJceOutputStream.write(this.birthDay, 1);
    paramJceOutputStream.write(this.birthMonLunar, 3);
    paramJceOutputStream.write(this.birthDayLunar, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\birth_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */