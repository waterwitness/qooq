package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReportRsp
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_headers;
  public ArrayList headers;
  
  public ReportRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_headers == null)
    {
      cache_headers = new ArrayList();
      ReportHeader localReportHeader = new ReportHeader();
      cache_headers.add(localReportHeader);
    }
    this.headers = ((ArrayList)paramJceInputStream.read(cache_headers, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.headers, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VACDReport\ReportRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */