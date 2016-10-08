import com.dataline.util.RouterSessionAdapter;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class qfs
  implements Runnable
{
  public qfs(RouterHandler paramRouterHandler, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = (Session)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.get(Long.valueOf(this.jdField_a_of_type_Long));
    Object localObject2;
    if (localObject1 == null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_JavaUtilArrayList.iterator();
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        RouterMsgRecord localRouterMsgRecord = (RouterMsgRecord)localIterator.next();
        if (localRouterMsgRecord.uSessionID != this.jdField_a_of_type_Long) {
          break label245;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, localRouterMsgRecord.filename, null, DataLineHandler.d(localRouterMsgRecord.msgtype), 0, this.jdField_a_of_type_Long, 0, 0, 0);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label245;
        }
        if (0L == ((Session)localObject2).uSessionID) {
          ((Session)localObject2).uSessionID = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
        }
        ((Session)localObject2).msgHeader = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(localRouterMsgRecord.peerDin);
        this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.b, null);
        this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.put(Long.valueOf(this.jdField_a_of_type_Long), localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.d.put(Long.valueOf(localRouterMsgRecord.uSessionID), localRouterMsgRecord);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(0, (Session)localObject2, 0.0D, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.notifyDataSetChanged();
      }
      return;
      label245:
      break;
      localObject2 = localObject1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */