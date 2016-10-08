package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReportHeader
  extends JceStruct
  implements Cloneable
{
  public long createTime;
  public int iNetType;
  public String platform;
  public int result;
  public String sAction;
  public String sKey;
  public String sModule;
  public long seqno;
  public long serverTime;
  public long uin;
  public String version;
  
  public ReportHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.platform = "";
    this.version = "";
    this.sModule = "";
    this.sAction = "";
    this.sKey = "";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.platform = paramJceInputStream.readString(0, false);
    this.version = paramJceInputStream.readString(1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, true);
    this.seqno = paramJceInputStream.read(this.seqno, 3, true);
    this.sModule = paramJceInputStream.readString(4, false);
    this.sAction = paramJceInputStream.readString(5, false);
    this.iNetType = paramJceInputStream.read(this.iNetType, 6, false);
    this.result = paramJceInputStream.read(this.result, 7, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.platform).append("|").append(this.version).append("|").append(this.uin).append("|").append(this.seqno).append("|").append(this.sModule).append("|").append(this.sAction).append("|").append(this.iNetType).append("|").append(this.result);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 0);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 1);
    }
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.seqno, 3);
    if (this.sModule != null) {
      paramJceOutputStream.write(this.sModule, 4);
    }
    if (this.sAction != null) {
      paramJceOutputStream.write(this.sAction, 5);
    }
    paramJceOutputStream.write(this.iNetType, 6);
    paramJceOutputStream.write(this.result, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VACDReport\ReportHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */