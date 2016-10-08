package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AddFrdSrcInfo
  extends JceStruct
{
  public String strSrcName;
  public long uSrcId;
  public long uSubSrcId;
  
  public AddFrdSrcInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strSrcName = "";
  }
  
  public AddFrdSrcInfo(String paramString, long paramLong1, long paramLong2)
  {
    this.strSrcName = "";
    this.strSrcName = paramString;
    this.uSrcId = paramLong1;
    this.uSubSrcId = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strSrcName = paramJceInputStream.readString(0, false);
    this.uSrcId = paramJceInputStream.read(this.uSrcId, 1, false);
    this.uSubSrcId = paramJceInputStream.read(this.uSubSrcId, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strSrcName != null) {
      paramJceOutputStream.write(this.strSrcName, 0);
    }
    paramJceOutputStream.write(this.uSrcId, 1);
    paramJceOutputStream.write(this.uSubSrcId, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\AddFrdSrcInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */