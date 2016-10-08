package FEEDS_RECOM_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class mobile_recom_report_req
  extends JceStruct
{
  static int cache_op_module;
  static int cache_op_type;
  static ArrayList cache_vec_record_cookie;
  public String cookie = "";
  public short feeds_type;
  public int op_module;
  public int op_type;
  public int position_index;
  public long uin;
  public ArrayList vec_record_cookie;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_op_module = 0;
    cache_op_type = 0;
    cache_vec_record_cookie = new ArrayList();
    cache_vec_record_cookie.add("");
  }
  
  public mobile_recom_report_req() {}
  
  public mobile_recom_report_req(long paramLong, int paramInt1, short paramShort, int paramInt2, int paramInt3, String paramString, ArrayList paramArrayList)
  {
    this.uin = paramLong;
    this.op_module = paramInt1;
    this.feeds_type = paramShort;
    this.position_index = paramInt2;
    this.op_type = paramInt3;
    this.cookie = paramString;
    this.vec_record_cookie = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.op_module = paramJceInputStream.read(this.op_module, 1, false);
    this.feeds_type = paramJceInputStream.read(this.feeds_type, 2, false);
    this.position_index = paramJceInputStream.read(this.position_index, 3, false);
    this.op_type = paramJceInputStream.read(this.op_type, 4, false);
    this.cookie = paramJceInputStream.readString(5, false);
    this.vec_record_cookie = ((ArrayList)paramJceInputStream.read(cache_vec_record_cookie, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.op_module, 1);
    paramJceOutputStream.write(this.feeds_type, 2);
    paramJceOutputStream.write(this.position_index, 3);
    paramJceOutputStream.write(this.op_type, 4);
    if (this.cookie != null) {
      paramJceOutputStream.write(this.cookie, 5);
    }
    if (this.vec_record_cookie != null) {
      paramJceOutputStream.write(this.vec_record_cookie, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\FEEDS_RECOM_REPORT\mobile_recom_report_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */