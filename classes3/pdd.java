import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class pdd
  implements Runnable
{
  pdd(pdc parampdc, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = -1;
    int m = this.jdField_a_of_type_Pdc.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_Pdc.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = m;
    int k = j;
    Object localObject;
    if (i <= n)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Pdc.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.jdField_a_of_type_Boolean;
      localObject = this.jdField_a_of_type_Pdc.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - m);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (this.jdField_a_of_type_Boolean) {
          j = 1000;
        }
        ((PtvTemplateItemView)localObject).b(j);
      }
      k = i;
    }
    if ((this.jdField_a_of_type_Pdc.a.b + 1 == k) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Pdc.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null))
    {
      localObject = PtvTemplateManager.g + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      this.jdField_a_of_type_Pdc.a.d = ((String)localObject);
      if (this.jdField_a_of_type_Pdc.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null) {
        this.jdField_a_of_type_Pdc.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter((String)localObject);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */