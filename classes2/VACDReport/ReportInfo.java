package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReportInfo
  extends JceStruct
  implements Cloneable
{
  static ReportBody cache_body;
  static ReportHeader cache_header;
  public ReportBody body;
  public ReportHeader header;
  
  public ReportInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_header == null) {
      cache_header = new ReportHeader();
    }
    this.header = ((ReportHeader)paramJceInputStream.read(cache_header, 0, true));
    if (cache_body == null) {
      cache_body = new ReportBody();
    }
    this.body = ((ReportBody)paramJceInputStream.read(cache_body, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.header, 0);
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VACDReport\ReportInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */