package cooperation.dingdong;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;
import com.tencent.mobileqq.data.DingdongOpenId;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdRsp;
import yav;
import yaw;
import yax;

public class DingdongOpenIdProvider
{
  public static final long a = -1L;
  private static final String jdField_a_of_type_JavaLangString = "DingdongOpenIdProvider";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DingdongPluginBizObserver jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  private long jdField_b_of_type_Long;
  private final HashMap jdField_b_of_type_JavaUtilHashMap;
  
  public DingdongOpenIdProvider(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver = new yaw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver);
  }
  
  private String a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramLong2);
    if (-1L != paramLong3)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(paramLong3);
    }
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong)
  {
    new Handler(Looper.getMainLooper()).post(new yav(this, paramLong));
  }
  
  private void b(long paramLong)
  {
    yax localyax = (yax)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localyax != null)
    {
      this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      DingdongOpenIdProvider.Callback localCallback = localyax.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider$Callback;
      if (localCallback != null) {
        localCallback.a(paramLong, localyax.jdField_a_of_type_JavaUtilList);
      }
    }
  }
  
  public long a(long paramLong, List paramList, boolean paramBoolean, DingdongOpenIdProvider.Callback paramCallback)
  {
    if ((paramList == null) || (paramCallback == null)) {
      return -1L;
    }
    yax localyax = new yax(this, paramList, paramCallback, paramBoolean);
    int i = 0;
    ArrayList localArrayList = new ArrayList(paramList.size());
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Iterator localIterator = localyax.jdField_a_of_type_JavaUtilList.iterator();
    paramList = null;
    if (localIterator.hasNext())
    {
      oidb_0x589.GetUserOpenIdRsp localGetUserOpenIdRsp = (oidb_0x589.GetUserOpenIdRsp)localIterator.next();
      long l2 = -1L;
      int j = localGetUserOpenIdRsp.msg_req_id.uint32_req_flag.get();
      switch (j)
      {
      default: 
        l1 = localGetUserOpenIdRsp.msg_req_id.uint64_req_uin.get();
        label149:
        if (paramBoolean)
        {
          String str = a(j, paramLong, l1, l2);
          paramCallback = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          paramList = paramCallback;
          if (paramCallback == null)
          {
            DingdongOpenId localDingdongOpenId = (DingdongOpenId)localEntityManager.a(DingdongOpenId.class, str);
            paramList = paramCallback;
            if (localDingdongOpenId != null)
            {
              paramList = localDingdongOpenId.openId;
              this.jdField_a_of_type_JavaUtilHashMap.put(str, paramList);
            }
          }
        }
        if (paramList != null)
        {
          localGetUserOpenIdRsp.uint32_result.set(0);
          switch (j)
          {
          default: 
            localGetUserOpenIdRsp.bytes_open_id.set(ByteStringMicro.copyFrom(paramList.getBytes()), true);
          }
        }
        break;
      }
      for (;;)
      {
        break;
        l2 = localGetUserOpenIdRsp.msg_req_id.uint64_req_host_uin.get();
        l1 = localGetUserOpenIdRsp.msg_req_id.uint64_req_uin.get();
        break label149;
        l2 = localGetUserOpenIdRsp.msg_req_id.uint64_req_host_uin.get();
        l1 = localGetUserOpenIdRsp.msg_req_id.uint64_req_uin.get();
        break label149;
        paramCallback = paramList.split("/");
        if (1 < paramCallback.length)
        {
          localGetUserOpenIdRsp.bytes_open_id.set(ByteStringMicro.copyFrom(paramCallback[0].getBytes()), true);
          localGetUserOpenIdRsp.bytes_discuss_open_id.set(ByteStringMicro.copyFrom(paramCallback[1].getBytes()), true);
          continue;
          paramCallback = paramList.split("/");
          if (1 < paramCallback.length)
          {
            localGetUserOpenIdRsp.bytes_open_id.set(ByteStringMicro.copyFrom(paramCallback[0].getBytes()), true);
            localGetUserOpenIdRsp.bytes_group_open_id.set(ByteStringMicro.copyFrom(paramCallback[1].getBytes()), true);
            continue;
            i = 1;
            localArrayList.add(localGetUserOpenIdRsp.msg_req_id.get());
            localyax.a(localGetUserOpenIdRsp);
          }
        }
      }
    }
    localEntityManager.a();
    long l1 = this.jdField_b_of_type_Long + 1L;
    this.jdField_b_of_type_Long = l1;
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(l1), localyax);
    if (i != 0)
    {
      paramList = (DingdongPluginBizHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(75);
      if (paramList != null) {
        paramList.a(l1, paramLong, localArrayList);
      }
    }
    for (;;)
    {
      return this.jdField_b_of_type_Long;
      QLog.e("DingdongOpenIdProvider", 1, "DingdongOpenIdProvider error : get DingDongPluginBizHandler fail.");
      continue;
      a(l1);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\DingdongOpenIdProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */