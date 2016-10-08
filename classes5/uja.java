import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class uja
  implements Runnable
{
  public uja(StatusHistoryActivity paramStatusHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object[] arrayOfObject = (Object[])localEntry.getValue();
      int i = SignatureManager.a((String)localEntry.getKey(), this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a());
      Object localObject = AIOUtils.a(AIOUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i));
      if ((localObject != null) && ((localObject instanceof StatusHistoryActivity.ItemViewHolder)))
      {
        localObject = (StatusHistoryActivity.ItemViewHolder)localObject;
        this.a.a((String)localEntry.getKey(), ((Integer)arrayOfObject[0]).intValue(), (String)arrayOfObject[1], (SignatureTemplateInfo.DynamicItem)arrayOfObject[2], ((StatusHistoryActivity.ItemViewHolder)localObject).a);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("Q.richstatus.history", 2, "runnable list view item's tag can not cast to ItemViewHolder, object:" + localObject);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */