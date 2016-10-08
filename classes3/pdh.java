import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class pdh
  implements Runnable
{
  pdh(pdg parampdg, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.jdField_a_of_type_Pdg.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Pdg.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = j;
    for (;;)
    {
      Object localObject;
      if (i <= k)
      {
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Pdg.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id))) {
          break label140;
        }
        ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = false;
        ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.jdField_a_of_type_Boolean;
        localObject = this.jdField_a_of_type_Pdg.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - j);
        if ((localObject instanceof PtvTemplateItemView))
        {
          localObject = (PtvTemplateItemView)localObject;
          if (!this.jdField_a_of_type_Boolean) {
            break label135;
          }
        }
      }
      label135:
      for (i = 1000;; i = -1)
      {
        ((PtvTemplateItemView)localObject).b(i);
        return;
      }
      label140:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */