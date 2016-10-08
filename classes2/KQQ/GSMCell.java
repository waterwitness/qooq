package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GSMCell
  extends JceStruct
{
  public int cellid;
  public int lac;
  public short mcc;
  public short mnc;
  
  public GSMCell()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mcc = -1;
    this.mnc = -1;
    this.lac = -1;
    this.cellid = -1;
  }
  
  public GSMCell(short paramShort1, short paramShort2, int paramInt1, int paramInt2)
  {
    this.mcc = -1;
    this.mnc = -1;
    this.lac = -1;
    this.cellid = -1;
    this.mcc = paramShort1;
    this.mnc = paramShort2;
    this.lac = paramInt1;
    this.cellid = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mcc = paramJceInputStream.read(this.mcc, 0, true);
    this.mnc = paramJceInputStream.read(this.mnc, 1, true);
    this.lac = paramJceInputStream.read(this.lac, 2, true);
    this.cellid = paramJceInputStream.read(this.cellid, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mcc, 0);
    paramJceOutputStream.write(this.mnc, 1);
    paramJceOutputStream.write(this.lac, 2);
    paramJceOutputStream.write(this.cellid, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\GSMCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */