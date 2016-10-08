import com.tencent.biz.pubaccount.util.PAReportInfo;
import com.tencent.biz.pubaccount.util.PAReportManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ieu
  implements Runnable
{
  public ieu(PAReportManager paramPAReportManager, PAReportInfo paramPAReportInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportInfo == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      if (PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager) == -1) {
        PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager, PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager).b().a(PAReportInfo.class.getSimpleName()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "before insert into db mCount = " + PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager));
      }
      if (PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager) < 80) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "databases message records is out of 80 delete the first _id ");
      }
      ??? = String.format("delete from %s where _id = (select min(_id) from %s)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportInfo.getTableName(), this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportInfo.getTableName() });
      localSQLiteDatabase = PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager).a();
    } while (localSQLiteDatabase == null);
    if (localSQLiteDatabase.a((String)???)) {}
    synchronized (PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager))
    {
      PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager).clear();
      PAReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager);
      PAReportManager.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager);
      PAReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportManager).a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPAReportInfo);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ieu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */