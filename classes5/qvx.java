import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.businessCard.views.BusinessCardView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.IndexView;
import java.util.ArrayList;
import java.util.HashMap;

public class qvx
  extends Handler
{
  public qvx(BusinessCardListActivity paramBusinessCardListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    ??? = (Object[])paramMessage.obj;
    HashMap localHashMap;
    Long localLong;
    if ((??? != null) && (???.length == 3))
    {
      paramMessage = (ArrayList)???[0];
      localHashMap = (HashMap)???[1];
      localLong = (Long)???[2];
    }
    for (;;)
    {
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramMessage);
        this.a.jdField_a_of_type_JavaUtilHashMap = localHashMap;
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.invalidate();
        if (localLong.longValue() != 0L) {
          break label177;
        }
        bool = true;
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(bool);
        if ((this.a.f == 1) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      }
      return;
      label177:
      boolean bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */