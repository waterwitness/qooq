package cooperation.qqhotspot.hotspotnode;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheck.APNodeCheckReq;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheck.APNodeCheckResp;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheck.APNodeInfo;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheckResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class QQHotSpotListHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final int b = 2;
  protected String a;
  public Map a;
  public AtomicInteger a;
  
  public QQHotSpotListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleQueryWifiListResp: start");
    }
    APNodeCheckResult localAPNodeCheckResult = new APNodeCheckResult();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleQueryWifiListResp: req == null || resp == null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        int i = paramToServiceMsg.extraData.getInt("callbackSeq");
        QQHotSpotListHandler.Callback localCallback = (QQHotSpotListHandler.Callback)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
        if (localCallback == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "callback = null");
          }
        }
        else
        {
          Serializable localSerializable = paramToServiceMsg.extraData.getSerializable("ExtraData");
          if (paramFromServiceMsg.getResultCode() != 1000)
          {
            localCallback.a(false, localAPNodeCheckResult, localSerializable);
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleQueryWifiListResp: response.getResultCode returns value which is not CODE_OK");
            }
          }
          else
          {
            paramToServiceMsg = new APNodeCheck.APNodeCheckResp();
            try
            {
              paramToServiceMsg.mergeFrom((byte[])paramObject);
              if (paramToServiceMsg == null)
              {
                localCallback.a(false, localAPNodeCheckResult, localSerializable);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleQueryWifiListResp: resp == null");
              }
            }
            catch (InvalidProtocolBufferMicroException paramToServiceMsg)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleQueryWifiListResp: resp.mergeFrom, InvalidProtocolBufferMicroException");
                }
                paramToServiceMsg.printStackTrace();
                paramToServiceMsg = null;
              }
              if (paramToServiceMsg.retcode.has()) {
                localAPNodeCheckResult.nRetCode = paramToServiceMsg.retcode.get();
              }
              if (paramToServiceMsg.nodeinfo.has())
              {
                paramToServiceMsg = paramToServiceMsg.nodeinfo.get();
                if (QLog.isColorLevel()) {
                  QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleQueryWifiListResp: resp.nodeinfo size: " + paramToServiceMsg.size());
                }
                i = 0;
                while (i < paramToServiceMsg.size())
                {
                  paramFromServiceMsg = new QQHotSpotHelper.HotSpotNodeAPInfo();
                  paramObject = (APNodeCheck.APNodeInfo)paramToServiceMsg.get(i);
                  paramFromServiceMsg.mApInfo.BSSID = ((APNodeCheck.APNodeInfo)paramObject).bssid.get().toUpperCase();
                  paramFromServiceMsg.mApInfo.SSID = ((APNodeCheck.APNodeInfo)paramObject).ssid.get();
                  paramFromServiceMsg.mApInfo.WiFiID = ((APNodeCheck.APNodeInfo)paramObject).wifiid.get();
                  paramFromServiceMsg.mApInfo.ManuID = Integer.toString(((APNodeCheck.APNodeInfo)paramObject).spid.get());
                  paramFromServiceMsg.mApInfo.StoreName = ((APNodeCheck.APNodeInfo)paramObject).storename.get();
                  paramFromServiceMsg.mApInfoEx.LogoURL_S = (((APNodeCheck.APNodeInfo)paramObject).logourl.get() + "100");
                  paramFromServiceMsg.mApInfoEx.LogoURL_B = (((APNodeCheck.APNodeInfo)paramObject).logourl.get() + "200");
                  paramFromServiceMsg.mApInfoEx.StoreAdUrl = ((APNodeCheck.APNodeInfo)paramObject).storeadurl.get();
                  paramFromServiceMsg.mApInfoEx.StorebannerAdUrl = ((APNodeCheck.APNodeInfo)paramObject).bbadurl.get();
                  localAPNodeCheckResult.arrApInfo.add(paramFromServiceMsg);
                  i += 1;
                }
              }
              localCallback.a(true, localAPNodeCheckResult, localSerializable);
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "handleQueryWifiListResp: returnCode:" + localAPNodeCheckResult.nRetCode);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(int paramInt, List paramList, String paramString, QQHotSpotListHandler.Callback paramCallback, Serializable paramSerializable)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
        paramCallback = new APNodeCheck.APNodeCheckReq();
        paramCallback.filter.set(paramInt);
        switch (paramInt)
        {
        default: 
          paramList = a("QQWifiTcpSvc.APNodeCheck");
          paramList.putWupBuffer(paramCallback.toByteArray());
          paramList.extraData.putInt("callbackSeq", i);
          paramList.extraData.putSerializable("ExtraData", paramSerializable);
          b(paramList);
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "sendAPNodeCheckReq: start nFilter: " + String.valueOf(paramInt));
          }
          return;
        }
      }
      paramCallback.bssidlist.addAll(paramList);
      continue;
      paramCallback.wifiid.set(paramString);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
    } while ((a(str)) || (!"QQWifiTcpSvc.APNodeCheck".equals(str)));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  protected boolean a(String paramString)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("QQWifiTcpSvc.APNodeCheck");
    }
    return !this.b.contains(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\QQHotSpotListHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */