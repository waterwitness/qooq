package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReportItem
  extends JceStruct
  implements Cloneable, Comparable
{
  public long costTime;
  public long createTime;
  public String failReason;
  public String params;
  public int result;
  public String step;
  
  public ReportItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.step = "";
    this.params = "";
    this.failReason = "";
  }
  
  public int compareTo(ReportItem paramReportItem)
  {
    if (this.createTime < paramReportItem.createTime) {
      return -1;
    }
    if (this.createTime == paramReportItem.createTime) {
      return 0;
    }
    return 1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.step = paramJceInputStream.readString(0, false);
    this.costTime = paramJceInputStream.read(this.costTime, 1, false);
    this.params = paramJceInputStream.readString(2, false);
    this.result = paramJceInputStream.read(this.result, 3, false);
    this.failReason = paramJceInputStream.readString(4, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.step).append("|").append(this.costTime).append("|").append(this.params).append("|").append(this.result).append("|").append(this.failReason).append("|").append(this.createTime);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.step != null) {
      paramJceOutputStream.write(this.step, 0);
    }
    paramJceOutputStream.write(this.costTime, 1);
    if (this.params != null) {
      paramJceOutputStream.write(this.params, 2);
    }
    paramJceOutputStream.write(this.result, 3);
    if (this.failReason != null) {
      paramJceOutputStream.write(this.failReason, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VACDReport\ReportItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */