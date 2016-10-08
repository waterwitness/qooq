package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_header
  extends JceStruct
{
  public int tih_year;
  public int type;
  
  public cell_header()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public cell_header(int paramInt1, int paramInt2)
  {
    this.type = paramInt1;
    this.tih_year = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.tih_year = paramJceInputStream.read(this.tih_year, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.tih_year, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */