package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SLableInfo
  extends JceStruct
{
  public long likeit;
  public String name;
  public boolean valid;
  
  public SLableInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = "";
    this.valid = true;
  }
  
  public SLableInfo(long paramLong, String paramString, boolean paramBoolean)
  {
    this.name = "";
    this.valid = true;
    this.likeit = paramLong;
    this.name = paramString;
    this.valid = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.likeit = paramJceInputStream.read(this.likeit, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.valid = paramJceInputStream.read(this.valid, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.likeit, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.valid, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCardTaf\SLableInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */