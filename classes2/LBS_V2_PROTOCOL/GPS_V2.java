package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GPS_V2
  extends JceStruct
{
  public int eType;
  public int iAlt;
  public int iLat;
  public int iLon;
  
  public GPS_V2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iLat = 900000000;
    this.iLon = 900000000;
    this.eType = 0;
    this.iAlt = -10000000;
  }
  
  public GPS_V2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iLat = 900000000;
    this.iLon = 900000000;
    this.eType = 0;
    this.iAlt = -10000000;
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.eType = paramInt3;
    this.iAlt = paramInt4;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.iLat, "iLat");
    paramStringBuilder.display(this.iLon, "iLon");
    paramStringBuilder.display(this.eType, "eType");
    paramStringBuilder.display(this.iAlt, "iAlt");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLat = paramJceInputStream.read(this.iLat, 0, true);
    this.iLon = paramJceInputStream.read(this.iLon, 1, true);
    this.eType = paramJceInputStream.read(this.eType, 2, true);
    this.iAlt = paramJceInputStream.read(this.iAlt, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
    paramJceOutputStream.write(this.eType, 2);
    paramJceOutputStream.write(this.iAlt, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBS_V2_PROTOCOL\GPS_V2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */