package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SSummaryCardRsp
  extends JceStruct
{
  static ArrayList cache_bgtype;
  static SUserLabel cache_label;
  static int cache_res;
  public long bgid;
  public ArrayList bgtype;
  public String bgurl;
  public long cardid;
  public long color;
  public String emsg;
  public SUserLabel label;
  public int res;
  public long styleid;
  
  public SSummaryCardRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bgurl = "";
    this.emsg = "";
  }
  
  public SSummaryCardRsp(int paramInt, long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, SUserLabel paramSUserLabel, String paramString2, ArrayList paramArrayList)
  {
    this.bgurl = "";
    this.emsg = "";
    this.res = paramInt;
    this.cardid = paramLong1;
    this.styleid = paramLong2;
    this.bgurl = paramString1;
    this.bgid = paramLong3;
    this.color = paramLong4;
    this.label = paramSUserLabel;
    this.emsg = paramString2;
    this.bgtype = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.res = paramJceInputStream.read(this.res, 0, true);
    this.cardid = paramJceInputStream.read(this.cardid, 1, true);
    this.styleid = paramJceInputStream.read(this.styleid, 2, false);
    this.bgurl = paramJceInputStream.readString(3, false);
    this.bgid = paramJceInputStream.read(this.bgid, 4, false);
    this.color = paramJceInputStream.read(this.color, 5, false);
    if (cache_label == null) {
      cache_label = new SUserLabel();
    }
    this.label = ((SUserLabel)paramJceInputStream.read(cache_label, 6, false));
    this.emsg = paramJceInputStream.readString(7, false);
    if (cache_bgtype == null)
    {
      cache_bgtype = new ArrayList();
      cache_bgtype.add(Integer.valueOf(0));
    }
    this.bgtype = ((ArrayList)paramJceInputStream.read(cache_bgtype, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.res, 0);
    paramJceOutputStream.write(this.cardid, 1);
    paramJceOutputStream.write(this.styleid, 2);
    if (this.bgurl != null) {
      paramJceOutputStream.write(this.bgurl, 3);
    }
    paramJceOutputStream.write(this.bgid, 4);
    paramJceOutputStream.write(this.color, 5);
    if (this.label != null) {
      paramJceOutputStream.write(this.label, 6);
    }
    if (this.emsg != null) {
      paramJceOutputStream.write(this.emsg, 7);
    }
    if (this.bgtype != null) {
      paramJceOutputStream.write(this.bgtype, 8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCardTaf\SSummaryCardRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */