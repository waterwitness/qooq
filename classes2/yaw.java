import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.GetOpenIdNotifyData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.GetOpenIdNotifyData.GetOpenIdData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.GetOpenIdNotifyData.ReqData;
import com.tencent.mobileqq.data.DingdongOpenId;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import cooperation.dingdong.DingdongOpenIdProvider;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdRsp;

public class yaw
  extends DingdongPluginBizObserver
{
  public yaw(DingdongOpenIdProvider paramDingdongOpenIdProvider)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DingdongPluginBizObserver.GetOpenIdNotifyData paramGetOpenIdNotifyData)
  {
    if (paramGetOpenIdNotifyData != null)
    {
      long l3 = paramGetOpenIdNotifyData.jdField_a_of_type_Long;
      if (-1 != paramGetOpenIdNotifyData.jdField_a_of_type_Int)
      {
        long l4 = paramGetOpenIdNotifyData.b;
        yax localyax = (yax)DingdongOpenIdProvider.a(this.a).get(Long.valueOf(l3));
        if (localyax != null)
        {
          String[] arrayOfString = new String[localyax.b.size()];
          int k = arrayOfString.length;
          int i = 0;
          long l2;
          int j;
          long l1;
          if (i < k)
          {
            l2 = -1L;
            localObject1 = (oidb_0x589.GetUserOpenIdRsp)localyax.b.get(i);
            j = ((oidb_0x589.GetUserOpenIdRsp)localObject1).msg_req_id.uint32_req_flag.get();
            switch (j)
            {
            default: 
              l1 = ((oidb_0x589.GetUserOpenIdRsp)localObject1).msg_req_id.uint64_req_uin.get();
            }
            for (;;)
            {
              arrayOfString[i] = DingdongOpenIdProvider.a(this.a, j, l4, l1, l2);
              i += 1;
              break;
              l1 = ((oidb_0x589.GetUserOpenIdRsp)localObject1).msg_req_id.uint64_req_uin.get();
              l2 = ((oidb_0x589.GetUserOpenIdRsp)localObject1).msg_req_id.uint64_req_host_uin.get();
              continue;
              l1 = ((oidb_0x589.GetUserOpenIdRsp)localObject1).msg_req_id.uint64_req_uin.get();
              l2 = ((oidb_0x589.GetUserOpenIdRsp)localObject1).msg_req_id.uint64_req_host_uin.get();
            }
          }
          Object localObject1 = DingdongOpenIdProvider.a(this.a).a().createEntityManager();
          DingdongPluginBizObserver.GetOpenIdNotifyData.GetOpenIdData[] arrayOfGetOpenIdData = paramGetOpenIdNotifyData.jdField_a_of_type_ArrayOfComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$GetOpenIdData;
          int m = arrayOfGetOpenIdData.length;
          i = 0;
          while (i < m)
          {
            DingdongPluginBizObserver.GetOpenIdNotifyData.GetOpenIdData localGetOpenIdData = arrayOfGetOpenIdData[i];
            l2 = -1L;
            switch (localGetOpenIdData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Int)
            {
            default: 
              l1 = localGetOpenIdData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Long;
              paramGetOpenIdNotifyData = localGetOpenIdData.jdField_a_of_type_JavaLangString;
            }
            for (;;)
            {
              String str = DingdongOpenIdProvider.a(this.a, localGetOpenIdData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Int, l4, l1, l2);
              j = 0;
              while (j < k)
              {
                if (arrayOfString[j].equals(str))
                {
                  Object localObject2 = (oidb_0x589.GetUserOpenIdRsp)localyax.b.get(j);
                  ((oidb_0x589.GetUserOpenIdRsp)localObject2).uint32_result.set(localGetOpenIdData.jdField_a_of_type_Int);
                  if (localGetOpenIdData.jdField_a_of_type_Int == 0)
                  {
                    ((oidb_0x589.GetUserOpenIdRsp)localObject2).bytes_open_id.set(ByteStringMicro.copyFrom(localGetOpenIdData.jdField_a_of_type_JavaLangString.getBytes()));
                    ((oidb_0x589.GetUserOpenIdRsp)localObject2).bytes_group_open_id.set(ByteStringMicro.copyFrom(localGetOpenIdData.b.getBytes()));
                    ((oidb_0x589.GetUserOpenIdRsp)localObject2).bytes_discuss_open_id.set(ByteStringMicro.copyFrom(localGetOpenIdData.c.getBytes()));
                    ((oidb_0x589.GetUserOpenIdRsp)localObject2).bytes_token.set(ByteStringMicro.copyFrom(localGetOpenIdData.d.getBytes()));
                    if (localyax.a)
                    {
                      DingdongOpenIdProvider.b(this.a).put(str, paramGetOpenIdNotifyData);
                      localObject2 = new DingdongOpenId();
                      ((DingdongOpenId)localObject2).qqId = str;
                      ((DingdongOpenId)localObject2).openId = paramGetOpenIdNotifyData;
                      ((EntityManager)localObject1).b((Entity)localObject2);
                    }
                  }
                }
                j += 1;
              }
              l1 = localGetOpenIdData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Long;
              l2 = localGetOpenIdData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.b;
              paramGetOpenIdNotifyData = localGetOpenIdData.jdField_a_of_type_JavaLangString + "/" + localGetOpenIdData.b;
              continue;
              l1 = localGetOpenIdData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Long;
              l2 = localGetOpenIdData.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.b;
              paramGetOpenIdNotifyData = localGetOpenIdData.jdField_a_of_type_JavaLangString + "/" + localGetOpenIdData.c;
            }
            i += 1;
          }
          ((EntityManager)localObject1).a();
        }
      }
      DingdongOpenIdProvider.b(this.a, l3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */