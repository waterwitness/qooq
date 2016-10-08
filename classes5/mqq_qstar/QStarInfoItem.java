package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class QStarInfoItem
  extends JceStruct
{
  public String headurl;
  public int level;
  public String levelurl;
  public String name;
  public long starid;
  public int totalexp;
  
  public QStarInfoItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = "";
    this.headurl = "";
    this.levelurl = "";
  }
  
  public QStarInfoItem(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.name = "";
    this.headurl = "";
    this.levelurl = "";
    this.starid = paramLong;
    this.name = paramString1;
    this.level = paramInt1;
    this.totalexp = paramInt2;
    this.headurl = paramString2;
    this.levelurl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.starid = paramJceInputStream.read(this.starid, 0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.level = paramJceInputStream.read(this.level, 2, false);
    this.totalexp = paramJceInputStream.read(this.totalexp, 3, false);
    this.headurl = paramJceInputStream.readString(4, false);
    this.levelurl = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.starid, 0);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 1);
    }
    paramJceOutputStream.write(this.level, 2);
    paramJceOutputStream.write(this.totalexp, 3);
    if (this.headurl != null) {
      paramJceOutputStream.write(this.headurl, 4);
    }
    if (this.levelurl != null) {
      paramJceOutputStream.write(this.levelurl, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\mqq_qstar\QStarInfoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */