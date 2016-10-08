import LBS.Attr;
import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import MyCarrier.ReqCarrier;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mybusiness.MyBusinessObserver;
import com.tencent.mobileqq.mybusiness.MyBusinessServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.Packet;

public class thd
  extends SosoInterface.OnLocationListener
{
  public thd(MyBusinessServlet paramMyBusinessServlet, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, int paramInt2, String paramString3, Packet paramPacket, Intent paramIntent)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyBusinessServlet", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null))
    {
      GPS localGPS = new GPS((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D), (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D), -1, 0);
      ArrayList localArrayList = new ArrayList();
      if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
          localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject2).b, ((SosoInterface.SosoCell)localObject2).c, ((SosoInterface.SosoCell)localObject2).d, (short)((SosoInterface.SosoCell)localObject2).e));
        }
      }
      Object localObject2 = new ArrayList();
      if (paramSosoLbsInfo.b != null)
      {
        localObject1 = paramSosoLbsInfo.b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
          ((ArrayList)localObject2).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
        }
      }
      Object localObject1 = null;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
        localObject1 = new Attr(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_a_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.b, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.c);
      }
      paramSosoLbsInfo = new LBSInfo(localGPS, (ArrayList)localObject2, localArrayList, (Attr)localObject1);
      if (QLog.isDevelopLevel()) {
        QLog.d("MyBusinessServlet", 4, "......onSend bindMobile = " + this.jdField_a_of_type_JavaLangString + ", bindType = " + this.jdField_a_of_type_Int + ", lbsInfo = " + paramSosoLbsInfo);
      }
      paramSosoLbsInfo = new ReqCarrier(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramSosoLbsInfo, this.d);
      this.jdField_a_of_type_MqqAppPacket.setSSOCommand("CarrierEntry.queryCarrier");
      this.jdField_a_of_type_MqqAppPacket.setServantName("CarrierEntry");
      this.jdField_a_of_type_MqqAppPacket.setFuncName("queryCarrier");
      this.jdField_a_of_type_MqqAppPacket.addRequestPacket("ReqCarrier", paramSosoLbsInfo);
      paramSosoLbsInfo = this.jdField_a_of_type_MqqAppPacket.toMsg();
      if ((paramSosoLbsInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessServlet.a().k)) {
        MyBusinessServlet.a(this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessServlet, this.jdField_a_of_type_AndroidContentIntent, paramSosoLbsInfo);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessServlet.notifyObserver(this.jdField_a_of_type_AndroidContentIntent, 1, false, new Bundle(), MyBusinessObserver.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\thd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */