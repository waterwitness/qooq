package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Cell_V2
  extends JceStruct
{
  public double dStationLat;
  public double dStationLon;
  public int iCellId;
  public int iLac;
  public int iRssi;
  public short shMcc;
  public short shMnc;
  
  public Cell_V2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.shMcc = -1;
    this.shMnc = -1;
    this.iLac = -1;
    this.iCellId = -1;
  }
  
  public Cell_V2(short paramShort1, short paramShort2, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2)
  {
    this.shMcc = -1;
    this.shMnc = -1;
    this.iLac = -1;
    this.iCellId = -1;
    this.shMcc = paramShort1;
    this.shMnc = paramShort2;
    this.iLac = paramInt1;
    this.iCellId = paramInt2;
    this.iRssi = paramInt3;
    this.dStationLat = paramDouble1;
    this.dStationLon = paramDouble2;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.shMcc, "shMcc");
    paramStringBuilder.display(this.shMnc, "shMnc");
    paramStringBuilder.display(this.iLac, "iLac");
    paramStringBuilder.display(this.iCellId, "iCellId");
    paramStringBuilder.display(this.iRssi, "iRssi");
    paramStringBuilder.display(this.dStationLat, "dStationLat");
    paramStringBuilder.display(this.dStationLon, "dStationLon");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shMcc = paramJceInputStream.read(this.shMcc, 0, true);
    this.shMnc = paramJceInputStream.read(this.shMnc, 1, true);
    this.iLac = paramJceInputStream.read(this.iLac, 2, true);
    this.iCellId = paramJceInputStream.read(this.iCellId, 3, true);
    this.iRssi = paramJceInputStream.read(this.iRssi, 4, false);
    this.dStationLat = paramJceInputStream.read(this.dStationLat, 5, false);
    this.dStationLon = paramJceInputStream.read(this.dStationLon, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shMcc, 0);
    paramJceOutputStream.write(this.shMnc, 1);
    paramJceOutputStream.write(this.iLac, 2);
    paramJceOutputStream.write(this.iCellId, 3);
    paramJceOutputStream.write(this.iRssi, 4);
    paramJceOutputStream.write(this.dStationLat, 5);
    paramJceOutputStream.write(this.dStationLon, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBS_V2_PROTOCOL\Cell_V2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */