package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class CityInfoWithCellidReq
  extends JceStruct
{
  static GSMCell cache_cell;
  static ClientInfo cache_clientInfo;
  static GPSPoint cache_coords;
  static int cache_type;
  static ArrayList cache_vMacs;
  public GSMCell cell;
  public ClientInfo clientInfo;
  public GPSPoint coords;
  public int type;
  public ArrayList vMacs;
  
  public CityInfoWithCellidReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = QUERYTYPE.GPS_CELL_V1.value();
  }
  
  public CityInfoWithCellidReq(GSMCell paramGSMCell, GPSPoint paramGPSPoint, int paramInt, ClientInfo paramClientInfo, ArrayList paramArrayList)
  {
    this.type = QUERYTYPE.GPS_CELL_V1.value();
    this.cell = paramGSMCell;
    this.coords = paramGPSPoint;
    this.type = paramInt;
    this.clientInfo = paramClientInfo;
    this.vMacs = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_cell == null) {
      cache_cell = new GSMCell();
    }
    this.cell = ((GSMCell)paramJceInputStream.read(cache_cell, 1, true));
    if (cache_coords == null) {
      cache_coords = new GPSPoint();
    }
    this.coords = ((GPSPoint)paramJceInputStream.read(cache_coords, 2, true));
    this.type = paramJceInputStream.read(this.type, 3, false);
    if (cache_clientInfo == null) {
      cache_clientInfo = new ClientInfo();
    }
    this.clientInfo = ((ClientInfo)paramJceInputStream.read(cache_clientInfo, 4, false));
    if (cache_vMacs == null)
    {
      cache_vMacs = new ArrayList();
      cache_vMacs.add(Long.valueOf(0L));
    }
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cell, 1);
    paramJceOutputStream.write(this.coords, 2);
    paramJceOutputStream.write(this.type, 3);
    if (this.clientInfo != null) {
      paramJceOutputStream.write(this.clientInfo, 4);
    }
    if (this.vMacs != null) {
      paramJceOutputStream.write(this.vMacs, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\CityInfoWithCellidReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */