import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.IPtvTemplateItemCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class pdb
  implements PtvTemplateAdapter.IPtvTemplateItemCallback
{
  public pdb(PtvTemplateAdapter paramPtvTemplateAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(PtvTemplateManager.a, 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      do
      {
        return;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      } while (localPtvTemplateInfo == null);
      this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.a(paramInt, (int)(-this.a.jdField_a_of_type_Int * 0.75F), 400);
    } while (localPtvTemplateInfo.usable);
    FlowCameraMqqAction.b("", "0X8006A1A");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */