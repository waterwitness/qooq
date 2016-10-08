import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbyReportManager.ReportRecord;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;

public class tij
  implements Runnable
{
  public tij(NearbyReportManager paramNearbyReportManager, LongSparseArray paramLongSparseArray, NearbyHandler paramNearbyHandler, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentUtilLongSparseArray.a())
    {
      localArrayList.add((NearbyReportManager.ReportRecord)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */