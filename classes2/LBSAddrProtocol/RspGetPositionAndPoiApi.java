package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RspGetPositionAndPoiApi
  extends JceStruct
{
  static GPS cache_stUsrLoc;
  static ArrayList cache_vPoiList;
  public int iDistrictCode;
  public int iRange;
  public int iTotalNum;
  public GPS stUsrLoc;
  public String strCity;
  public String strDistrict;
  public String strPremises;
  public String strProvince;
  public String strRoad;
  public String strTown;
  public ArrayList vPoiList;
  
  public RspGetPositionAndPoiApi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iRange = -1;
    this.strProvince = "";
    this.strCity = "";
    this.strDistrict = "";
    this.strTown = "";
    this.strRoad = "";
    this.strPremises = "";
  }
  
  public RspGetPositionAndPoiApi(GPS paramGPS, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, int paramInt3, ArrayList paramArrayList)
  {
    this.iRange = -1;
    this.strProvince = "";
    this.strCity = "";
    this.strDistrict = "";
    this.strTown = "";
    this.strRoad = "";
    this.strPremises = "";
    this.stUsrLoc = paramGPS;
    this.iRange = paramInt1;
    this.strProvince = paramString1;
    this.strCity = paramString2;
    this.strDistrict = paramString3;
    this.strTown = paramString4;
    this.strRoad = paramString5;
    this.strPremises = paramString6;
    this.iDistrictCode = paramInt2;
    this.iTotalNum = paramInt3;
    this.vPoiList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUsrLoc == null) {
      cache_stUsrLoc = new GPS();
    }
    this.stUsrLoc = ((GPS)paramJceInputStream.read(cache_stUsrLoc, 0, true));
    this.iRange = paramJceInputStream.read(this.iRange, 1, true);
    this.strProvince = paramJceInputStream.readString(2, true);
    this.strCity = paramJceInputStream.readString(3, true);
    this.strDistrict = paramJceInputStream.readString(4, true);
    this.strTown = paramJceInputStream.readString(5, true);
    this.strRoad = paramJceInputStream.readString(6, true);
    this.strPremises = paramJceInputStream.readString(7, true);
    this.iDistrictCode = paramJceInputStream.read(this.iDistrictCode, 8, true);
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 9, true);
    if (cache_vPoiList == null)
    {
      cache_vPoiList = new ArrayList();
      PoiInfo localPoiInfo = new PoiInfo();
      cache_vPoiList.add(localPoiInfo);
    }
    this.vPoiList = ((ArrayList)paramJceInputStream.read(cache_vPoiList, 10, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUsrLoc, 0);
    paramJceOutputStream.write(this.iRange, 1);
    paramJceOutputStream.write(this.strProvince, 2);
    paramJceOutputStream.write(this.strCity, 3);
    paramJceOutputStream.write(this.strDistrict, 4);
    paramJceOutputStream.write(this.strTown, 5);
    paramJceOutputStream.write(this.strRoad, 6);
    paramJceOutputStream.write(this.strPremises, 7);
    paramJceOutputStream.write(this.iDistrictCode, 8);
    paramJceOutputStream.write(this.iTotalNum, 9);
    paramJceOutputStream.write(this.vPoiList, 10);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBSAddrProtocol\RspGetPositionAndPoiApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */