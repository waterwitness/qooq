package com.tencent.mobileqq.nearby;

import appoint.define.appoint_define.Cell;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.Wifi;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;

public class LbsUtils
{
  public LbsUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static appoint_define.LBSInfo a(String paramString)
  {
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a == 0.0D) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b == 0.0D)) {
      SosoInterface.a(60000L, paramString);
    }
    for (paramString = SosoInterface.a();; paramString = (String)localObject1)
    {
      if (paramString != null)
      {
        localObject1 = new appoint_define.LBSInfo();
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if (paramString.b != null)
        {
          localObject2 = paramString.b.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new appoint_define.Wifi();
              ((appoint_define.Wifi)localObject4).uint64_mac.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long);
              ((appoint_define.Wifi)localObject4).int32_rssi.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int);
              ((appoint_define.LBSInfo)localObject1).rpt_msg_wifis.add((MessageMicro)localObject4);
            }
          }
        }
        if (paramString.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject2 = paramString.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new appoint_define.Cell();
              ((appoint_define.Cell)localObject4).int32_cellid.set(((SosoInterface.SosoCell)localObject3).d);
              ((appoint_define.Cell)localObject4).int32_lac.set(((SosoInterface.SosoCell)localObject3).c);
              ((appoint_define.Cell)localObject4).int32_rssi.set(((SosoInterface.SosoCell)localObject3).e);
              ((appoint_define.Cell)localObject4).int32_mcc.set(((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int);
              ((appoint_define.Cell)localObject4).int32_mnc.set(((SosoInterface.SosoCell)localObject3).b);
              ((appoint_define.LBSInfo)localObject1).rpt_msg_cells.add((MessageMicro)localObject4);
            }
          }
        }
        if (paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)
        {
          localObject2 = new appoint_define.GPS();
          ((appoint_define.GPS)localObject2).int32_lon.set((int)(paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D));
          ((appoint_define.GPS)localObject2).int32_lat.set((int)(paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D));
          ((appoint_define.GPS)localObject2).int32_type.set(0);
          ((appoint_define.LBSInfo)localObject1).msg_gps.set((MessageMicro)localObject2);
          return (appoint_define.LBSInfo)localObject1;
        }
      }
      else
      {
        NearbyUtils.a("getLbsInfo", new Object[] { "lbs is null" });
        return null;
      }
      return (appoint_define.LBSInfo)localObject1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\LbsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */