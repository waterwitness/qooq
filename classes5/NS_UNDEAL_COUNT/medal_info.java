package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class medal_info
  extends JceStruct
{
  public int level;
  public int medalid;
  public int updated;
  
  public medal_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public medal_info(int paramInt1, int paramInt2, int paramInt3)
  {
    this.updated = paramInt1;
    this.medalid = paramInt2;
    this.level = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.updated = paramJceInputStream.read(this.updated, 0, false);
    this.medalid = paramJceInputStream.read(this.medalid, 1, false);
    this.level = paramJceInputStream.read(this.level, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.updated, 0);
    paramJceOutputStream.write(this.medalid, 1);
    paramJceOutputStream.write(this.level, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\medal_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */