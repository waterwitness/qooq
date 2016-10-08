package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_adv_container_attach
  extends JceStruct
{
  static s_picdata cache_picinfo = new s_picdata();
  public int actiontype;
  public String actionurl = "";
  public int is_report;
  public s_picdata picinfo;
  public String remark = "";
  public String report_url = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public cell_adv_container_attach() {}
  
  public cell_adv_container_attach(s_picdata params_picdata, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this.picinfo = params_picdata;
    this.remark = paramString1;
    this.actiontype = paramInt1;
    this.actionurl = paramString2;
    this.is_report = paramInt2;
    this.report_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picinfo = ((s_picdata)paramJceInputStream.read(cache_picinfo, 0, false));
    this.remark = paramJceInputStream.readString(1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.actionurl = paramJceInputStream.readString(3, false);
    this.is_report = paramJceInputStream.read(this.is_report, 4, false);
    this.report_url = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picinfo != null) {
      paramJceOutputStream.write(this.picinfo, 0);
    }
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 3);
    }
    paramJceOutputStream.write(this.is_report, 4);
    if (this.report_url != null) {
      paramJceOutputStream.write(this.report_url, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_adv_container_attach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */