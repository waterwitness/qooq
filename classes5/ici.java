import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfoNew;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTagsContainer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class ici
  implements Runnable
{
  public ici(ReadinjoyTagsContainer paramReadinjoyTagsContainer, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i <= this.jdField_a_of_type_Int) {
        try
        {
          ReportController.b(null, "dc00899", "qq_kandian", "", "0X8006F43", "0X8006F43", 0, 0, "", "", "", ReadInJoyUtils.a(((ChannelInfoNew)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTagsContainer.getChildAt(i).getTag()).jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTagsContainer.jdField_a_of_type_Int));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(ReadinjoyTagsContainer.jdField_a_of_type_JavaLangString, 2, "onLayout ", localException);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ici.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */