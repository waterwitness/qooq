import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ag
  implements Runnable
{
  ag(aa paramaa, int paramInt, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Aa.a.app.a().a(this.jdField_a_of_type_Int).b(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!localDataLineMsgRecord.isSendFromLocal());
        this.jdField_a_of_type_Aa.a.app.a().a(this.jdField_a_of_type_Int).e();
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Aa.a.app.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
        if ((localDataLineMsgSet == null) || (localDataLineMsgSet.isSingle())) {
          break;
        }
      } while (this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComTencentWidgetXListView));
      this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    } while (localDataLineMsgRecord.bIsResendOrRecvFile);
    LiteActivity.a(this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComTencentWidgetXListView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */