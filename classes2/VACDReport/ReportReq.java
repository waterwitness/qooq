package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReportReq
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_reports;
  public ArrayList reports;
  
  public ReportReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_reports == null)
    {
      cache_reports = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      cache_reports.add(localReportInfo);
    }
    this.reports = ((ArrayList)paramJceInputStream.read(cache_reports, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reports, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VACDReport\ReportReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */