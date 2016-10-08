package cooperation.qzone;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import NS_MOBILE_OPERATION.LbsInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;

public class LbsDataV2
{
  public static int a;
  public static int b;
  public static int c = 12103;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 900000000;
    jdField_b_of_type_Int = 500;
  }
  
  public static Cell_V2 a(LbsDataV2.CellInfo paramCellInfo)
  {
    if (paramCellInfo == null) {
      return null;
    }
    Cell_V2 localCell_V2 = new Cell_V2();
    localCell_V2.shMcc = ((short)paramCellInfo.jdField_a_of_type_Int);
    localCell_V2.shMnc = ((short)paramCellInfo.jdField_b_of_type_Int);
    localCell_V2.iLac = paramCellInfo.c;
    localCell_V2.iCellId = paramCellInfo.jdField_d_of_type_Int;
    localCell_V2.iRssi = paramCellInfo.jdField_e_of_type_Int;
    localCell_V2.dStationLat = paramCellInfo.jdField_a_of_type_Double;
    localCell_V2.dStationLon = paramCellInfo.jdField_b_of_type_Double;
    return localCell_V2;
  }
  
  public static GPS_V2 a(LbsDataV2.GpsInfo paramGpsInfo)
  {
    GPS_V2 localGPS_V2 = new GPS_V2();
    if (paramGpsInfo != null)
    {
      localGPS_V2.eType = paramGpsInfo.jdField_d_of_type_Int;
      localGPS_V2.iAlt = paramGpsInfo.c;
      localGPS_V2.iLat = paramGpsInfo.jdField_a_of_type_Int;
      localGPS_V2.iLon = paramGpsInfo.jdField_b_of_type_Int;
    }
    return localGPS_V2;
  }
  
  public static GeoInfo_V2 a(LbsDataV2.GeoInfo paramGeoInfo)
  {
    GeoInfo_V2 localGeoInfo_V2 = new GeoInfo_V2();
    if (paramGeoInfo != null)
    {
      localGeoInfo_V2.iDistrictCode = paramGeoInfo.jdField_a_of_type_Int;
      localGeoInfo_V2.iRange = paramGeoInfo.jdField_b_of_type_Int;
      localGeoInfo_V2.strCountry = paramGeoInfo.jdField_b_of_type_JavaLangString;
      localGeoInfo_V2.strProvince = paramGeoInfo.c;
      localGeoInfo_V2.strCity = paramGeoInfo.jdField_d_of_type_JavaLangString;
      localGeoInfo_V2.strDistrict = paramGeoInfo.jdField_e_of_type_JavaLangString;
      localGeoInfo_V2.strTown = paramGeoInfo.jdField_f_of_type_JavaLangString;
      localGeoInfo_V2.strVillage = paramGeoInfo.g;
      localGeoInfo_V2.strRoad = paramGeoInfo.h;
      localGeoInfo_V2.strDefaultName = paramGeoInfo.i;
    }
    return localGeoInfo_V2;
  }
  
  public static Wifi_V2 a(LbsDataV2.WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      return null;
    }
    Wifi_V2 localWifi_V2 = new Wifi_V2();
    localWifi_V2.strMac = paramWifiInfo.jdField_a_of_type_JavaLangString;
    localWifi_V2.iRssi = paramWifiInfo.jdField_a_of_type_Int;
    return localWifi_V2;
  }
  
  public static LbsInfo a(LbsDataV2.PoiInfo paramPoiInfo)
  {
    if (paramPoiInfo == null) {
      return null;
    }
    LbsInfo localLbsInfo = new LbsInfo();
    if (paramPoiInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo != null)
    {
      localLbsInfo.lbs_x = String.valueOf(paramPoiInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo.jdField_b_of_type_Int / 1000000.0D);
      localLbsInfo.lbs_y = String.valueOf(paramPoiInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo.jdField_a_of_type_Int / 1000000.0D);
    }
    localLbsInfo.lbs_idnm = paramPoiInfo.jdField_d_of_type_JavaLangString;
    if (TextUtils.isEmpty(localLbsInfo.lbs_idnm)) {
      localLbsInfo.lbs_idnm = paramPoiInfo.jdField_b_of_type_JavaLangString;
    }
    localLbsInfo.lbs_nm = paramPoiInfo.jdField_e_of_type_JavaLangString;
    localLbsInfo.s_lbs_id = paramPoiInfo.jdField_a_of_type_JavaLangString;
    localLbsInfo.i_poi_num = paramPoiInfo.jdField_f_of_type_Int;
    localLbsInfo.i_poi_order_type = paramPoiInfo.jdField_e_of_type_Int;
    localLbsInfo.i_poi_type = paramPoiInfo.jdField_a_of_type_Int;
    try
    {
      localLbsInfo.lbs_id = Integer.parseInt(paramPoiInfo.jdField_a_of_type_JavaLangString);
      return localLbsInfo;
    }
    catch (Exception paramPoiInfo)
    {
      paramPoiInfo.printStackTrace();
    }
    return localLbsInfo;
  }
  
  public static LbsInfo a(LocalImageShootInfo paramLocalImageShootInfo)
  {
    Object localObject;
    if (paramLocalImageShootInfo == null) {
      localObject = null;
    }
    LbsInfo localLbsInfo;
    do
    {
      return (LbsInfo)localObject;
      localLbsInfo = new LbsInfo();
      localObject = localLbsInfo;
    } while (paramLocalImageShootInfo.a == null);
    localLbsInfo.lbs_x = String.valueOf(paramLocalImageShootInfo.a.b);
    localLbsInfo.lbs_y = String.valueOf(paramLocalImageShootInfo.a.a);
    return localLbsInfo;
  }
  
  public static LbsDataV2.CellInfo a(Cell_V2 paramCell_V2)
  {
    if (paramCell_V2 == null) {
      return null;
    }
    LbsDataV2.CellInfo localCellInfo = new LbsDataV2.CellInfo();
    localCellInfo.jdField_a_of_type_Int = paramCell_V2.shMcc;
    localCellInfo.jdField_b_of_type_Int = paramCell_V2.shMnc;
    localCellInfo.c = paramCell_V2.iLac;
    localCellInfo.jdField_d_of_type_Int = paramCell_V2.iCellId;
    localCellInfo.jdField_e_of_type_Int = paramCell_V2.iRssi;
    localCellInfo.jdField_a_of_type_Double = paramCell_V2.dStationLat;
    localCellInfo.jdField_b_of_type_Double = paramCell_V2.dStationLon;
    return localCellInfo;
  }
  
  public static LbsDataV2.GeoInfo a(GeoInfo_V2 paramGeoInfo_V2)
  {
    LbsDataV2.GeoInfo localGeoInfo = new LbsDataV2.GeoInfo();
    if (paramGeoInfo_V2 != null)
    {
      localGeoInfo.jdField_a_of_type_Int = paramGeoInfo_V2.iDistrictCode;
      localGeoInfo.jdField_b_of_type_Int = paramGeoInfo_V2.iRange;
      localGeoInfo.jdField_b_of_type_JavaLangString = paramGeoInfo_V2.strCountry;
      localGeoInfo.c = paramGeoInfo_V2.strProvince;
      localGeoInfo.jdField_d_of_type_JavaLangString = paramGeoInfo_V2.strCity;
      localGeoInfo.jdField_e_of_type_JavaLangString = paramGeoInfo_V2.strDistrict;
      localGeoInfo.jdField_f_of_type_JavaLangString = paramGeoInfo_V2.strTown;
      localGeoInfo.g = paramGeoInfo_V2.strVillage;
      localGeoInfo.h = paramGeoInfo_V2.strRoad;
      localGeoInfo.i = paramGeoInfo_V2.strDefaultName;
    }
    return localGeoInfo;
  }
  
  public static LbsDataV2.GeoInfo a(GeoInfo_V2 paramGeoInfo_V2, GPS_V2 paramGPS_V2)
  {
    LbsDataV2.GeoInfo localGeoInfo = new LbsDataV2.GeoInfo();
    if (paramGeoInfo_V2 != null)
    {
      localGeoInfo.jdField_a_of_type_Int = paramGeoInfo_V2.iDistrictCode;
      localGeoInfo.jdField_b_of_type_Int = paramGeoInfo_V2.iRange;
      localGeoInfo.jdField_b_of_type_JavaLangString = paramGeoInfo_V2.strCountry;
      localGeoInfo.c = paramGeoInfo_V2.strProvince;
      localGeoInfo.jdField_d_of_type_JavaLangString = paramGeoInfo_V2.strCity;
      localGeoInfo.jdField_e_of_type_JavaLangString = paramGeoInfo_V2.strDistrict;
      localGeoInfo.jdField_f_of_type_JavaLangString = paramGeoInfo_V2.strTown;
      localGeoInfo.g = paramGeoInfo_V2.strVillage;
      localGeoInfo.h = paramGeoInfo_V2.strRoad;
      localGeoInfo.i = paramGeoInfo_V2.strDefaultName;
    }
    localGeoInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = a(paramGPS_V2);
    return localGeoInfo;
  }
  
  public static LbsDataV2.GpsInfo a(GPS_V2 paramGPS_V2)
  {
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    if (paramGPS_V2 != null)
    {
      localGpsInfo.jdField_d_of_type_Int = paramGPS_V2.eType;
      localGpsInfo.c = paramGPS_V2.iAlt;
      localGpsInfo.jdField_a_of_type_Int = paramGPS_V2.iLat;
      localGpsInfo.jdField_b_of_type_Int = paramGPS_V2.iLon;
    }
    return localGpsInfo;
  }
  
  public static LbsDataV2.PoiInfo a(PoiInfo_V2 paramPoiInfo_V2)
  {
    LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
    if (paramPoiInfo_V2 != null)
    {
      localPoiInfo.jdField_e_of_type_JavaLangString = paramPoiInfo_V2.strAddress;
      localPoiInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = a(paramPoiInfo_V2.stGps);
      localPoiInfo.j = paramPoiInfo_V2.strCity;
      localPoiInfo.h = paramPoiInfo_V2.strCity;
      localPoiInfo.jdField_b_of_type_Int = paramPoiInfo_V2.iDistrictCode;
      localPoiInfo.k = paramPoiInfo_V2.strDistrict;
      localPoiInfo.i = paramPoiInfo_V2.strProvince;
      localPoiInfo.c = paramPoiInfo_V2.iDistance;
      localPoiInfo.jdField_a_of_type_JavaLangString = paramPoiInfo_V2.strPoiId;
      localPoiInfo.jdField_b_of_type_JavaLangString = paramPoiInfo_V2.strName;
      localPoiInfo.jdField_e_of_type_Int = paramPoiInfo_V2.iPoiOrderType;
      localPoiInfo.jdField_f_of_type_Int = paramPoiInfo_V2.iPoiNum;
      localPoiInfo.jdField_d_of_type_Int = paramPoiInfo_V2.iHotValue;
      localPoiInfo.jdField_f_of_type_JavaLangString = paramPoiInfo_V2.strPhone;
      localPoiInfo.jdField_d_of_type_JavaLangString = paramPoiInfo_V2.strDefaultName;
      localPoiInfo.g = paramPoiInfo_V2.strDianPingId;
    }
    return localPoiInfo;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\LbsDataV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */