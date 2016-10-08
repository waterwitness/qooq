package com.tencent.mobileqq.transfile;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import vbh;
import vbi;

public class ProtoReqManager
{
  public static final String a = "Q.richmedia.ProtoReqManager";
  public static final String b = "key_runnable_index";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ConcurrentHashMap a;
  private boolean jdField_a_of_type_Boolean;
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a()
  {
    if (DeviceProfileManager.a().a() == 4) {
      RichMediaStrategy.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.a(new vbh(this));
  }
  
  private void a(Intent paramIntent, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramProtoResp.jdField_a_of_type_ArrayOfVbi[i].jdField_b_of_type_Boolean = true;
    paramProtoResp.jdField_a_of_type_ArrayOfVbi[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(ProtoReqManager.ProtoResp paramProtoResp)
  {
    paramProtoResp.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramProtoResp.jdField_a_of_type_ArrayOfVbi.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramProtoResp.jdField_a_of_type_ArrayOfVbi[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramProtoResp.jdField_a_of_type_ArrayOfVbi[i]);
      i += 1;
    }
  }
  
  private boolean a(ProtoReqManager.ProtoReq paramProtoReq)
  {
    return ("PttStore.GroupPttUp".equals(paramProtoReq.jdField_a_of_type_JavaLangString)) || ("PttStore.GroupPttDown".equals(paramProtoReq.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(paramProtoReq.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramProtoReq.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = 0;
    while (i < paramProtoResp.jdField_a_of_type_ArrayOfVbi.length)
    {
      if ((!paramProtoResp.jdField_a_of_type_ArrayOfVbi[i].jdField_b_of_type_Boolean) && ((paramProtoResp.jdField_a_of_type_ArrayOfVbi[i].jdField_a_of_type_Boolean == true) || (paramProtoResp.jdField_a_of_type_ArrayOfVbi[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void c(ProtoReqManager.ProtoReq paramProtoReq)
  {
    paramProtoReq.jdField_a_of_type_Int = RichMediaStrategy.c();
    paramProtoReq.jdField_b_of_type_Int = RichMediaStrategy.a();
    paramProtoReq.c = RichMediaStrategy.b();
  }
  
  private void d(ProtoReqManager.ProtoReq paramProtoReq)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      paramProtoReq.jdField_a_of_type_Int = PttOptimizeParams.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramProtoReq.jdField_b_of_type_Int = PttOptimizeParams.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramProtoReq.c = PttOptimizeParams.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + paramProtoReq.jdField_a_of_type_Int + paramProtoReq.jdField_b_of_type_Int + paramProtoReq.c);
      }
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    for (;;)
    {
      ProtoReqManager.ProtoResp localProtoResp;
      ProtoReqManager.ProtoReq localProtoReq;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onRecieve." + paramFromServiceMsg);
        }
        if ((paramIntent != null) && (paramFromServiceMsg != null))
        {
          localProtoResp = (ProtoReqManager.ProtoResp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
          if (localProtoResp != null)
          {
            boolean bool = localProtoResp.jdField_a_of_type_Boolean;
            if (!bool) {
              continue;
            }
          }
        }
        return;
        a(paramIntent, localProtoResp);
        localProtoReq = localProtoResp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq;
        localProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        localProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo.c = localProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a(localProtoResp);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack == null) {
            continue;
          }
          i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramIntent = new byte[i];
          PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramIntent);
          localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack.a(localProtoResp, localProtoReq);
          continue;
        }
        if (i != 2901) {
          break label328;
        }
      }
      finally {}
      long l1 = System.currentTimeMillis() - localProtoResp.jdField_a_of_type_Long;
      if ((l1 < localProtoReq.e) && (localProtoResp.jdField_a_of_type_Int < localProtoReq.jdField_b_of_type_Int))
      {
        long l2 = localProtoReq.jdField_a_of_type_Int;
        paramIntent = localProtoResp.jdField_a_of_type_ArrayOfVbi[localProtoResp.jdField_a_of_type_Int];
        localProtoResp.jdField_a_of_type_Int += 1;
        paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
        a(paramIntent, 0L);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localProtoResp.jdField_a_of_type_Int);
        }
        label328:
        if (a(localProtoResp))
        {
          a(localProtoResp);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (i == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new ProtoReqManager.CheckConErroObserverImp(this, localProtoResp, localProtoReq));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
          }
          else if (localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack != null)
          {
            localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack.a(localProtoResp, localProtoReq);
          }
        }
      }
    }
  }
  
  public void a(ProtoReqManager.ProtoReq paramProtoReq)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + paramProtoReq.jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          a();
          this.jdField_a_of_type_Boolean = true;
        }
        if (paramProtoReq != null)
        {
          if ((paramProtoReq.jdField_a_of_type_JavaLangString != null) && ((paramProtoReq.jdField_a_of_type_JavaLangString.equals("ImgStore.GroupPicUp")) || (paramProtoReq.jdField_a_of_type_JavaLangString.equals("LongConn.OffPicUp")))) {
            c(paramProtoReq);
          }
          if ((paramProtoReq.jdField_a_of_type_JavaLangString != null) && ((paramProtoReq.jdField_a_of_type_JavaLangString.equals("PttStore.GroupPttUp")) || (paramProtoReq.jdField_a_of_type_JavaLangString.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
            d(paramProtoReq);
          }
          ProtoReqManager.ProtoResp localProtoResp = new ProtoReqManager.ProtoResp();
          paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp = localProtoResp;
          localProtoResp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq = paramProtoReq;
          localProtoResp.jdField_a_of_type_Long = System.currentTimeMillis();
          localProtoResp.jdField_a_of_type_ArrayOfVbi = new vbi[paramProtoReq.jdField_b_of_type_Int];
          byte[] arrayOfByte = paramProtoReq.jdField_a_of_type_ArrayOfByte;
          Object localObject = ByteBuffer.allocate(arrayOfByte.length + 4);
          ((ByteBuffer)localObject).putInt(arrayOfByte.length + 4).put(arrayOfByte);
          arrayOfByte = ((ByteBuffer)localObject).array();
          i = 0;
          if (i >= paramProtoReq.jdField_b_of_type_Int) {
            break label502;
          }
          localObject = new vbi(this);
          localProtoResp.jdField_a_of_type_ArrayOfVbi[i] = localObject;
          ((vbi)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp = localProtoResp;
          ((vbi)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), ProtoServlet.class);
          localObject = ((vbi)localObject).jdField_a_of_type_MqqAppNewIntent;
          ((NewIntent)localObject).putExtra("key_body", arrayOfByte);
          ((NewIntent)localObject).putExtra("key_cmd", paramProtoReq.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("key_fastresend", paramProtoReq.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", paramProtoReq.jdField_b_of_type_Boolean);
          if ((a(paramProtoReq)) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) && (PttOptimizeParams.d((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface)))
          {
            ((NewIntent)localObject).putExtra("quickSendEnable", true);
            ((NewIntent)localObject).putExtra("quickSendStrategy", 1);
            if (QLog.isColorLevel())
            {
              QLog.d("http_sideway", 2, "set");
              break label493;
              if (i < paramProtoReq.c)
              {
                long l1 = paramProtoReq.jdField_a_of_type_Int * i / paramProtoReq.c;
                long l2 = paramProtoReq.jdField_a_of_type_Int;
                long l3 = paramProtoReq.d * i;
                localProtoResp.jdField_a_of_type_ArrayOfVbi[i].jdField_a_of_type_Long = (l2 - l1 - l3);
                a(localProtoResp.jdField_a_of_type_ArrayOfVbi[i], l1);
                i += 1;
                continue;
              }
              localProtoResp.jdField_a_of_type_Int = paramProtoReq.c;
            }
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      label493:
      i += 1;
      continue;
      label502:
      int i = 0;
    }
  }
  
  public void a(NewIntent paramNewIntent)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramNewIntent);
  }
  
  void a(vbi paramvbi, long paramLong)
  {
    paramvbi.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramvbi, paramLong);
  }
  
  public void b(ProtoReqManager.ProtoReq paramProtoReq)
  {
    if (paramProtoReq != null) {}
    try
    {
      if (paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp != null) {
        a(paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp);
      }
      return;
    }
    finally
    {
      paramProtoReq = finally;
      throw paramProtoReq;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\ProtoReqManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */