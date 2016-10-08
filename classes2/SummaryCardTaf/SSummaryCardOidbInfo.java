package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SSummaryCardOidbInfo
  extends JceStruct
{
  public String bgurl;
  public long styleid;
  public String version;
  
  public SSummaryCardOidbInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bgurl = "";
    this.version = "";
  }
  
  public SSummaryCardOidbInfo(long paramLong, String paramString1, String paramString2)
  {
    this.bgurl = "";
    this.version = "";
    this.styleid = paramLong;
    this.bgurl = paramString1;
    this.version = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.styleid = paramJceInputStream.read(this.styleid, 1, false);
    this.bgurl = paramJceInputStream.readString(2, false);
    this.version = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.styleid, 1);
    if (this.bgurl != null) {
      paramJceOutputStream.write(this.bgurl, 2);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCardTaf\SSummaryCardOidbInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */