import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class gyc
  implements Runnable
{
  gyc(gyb paramgyb, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int k = -1;
    int m = this.jdField_a_of_type_Gyb.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_Gyb.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = 0;
    int j = k;
    Object localObject;
    if (i <= this.jdField_a_of_type_Gyb.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Gyb.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.jdField_a_of_type_Boolean;
      j = k;
      if (i >= m)
      {
        j = k;
        if (i <= n)
        {
          localObject = this.jdField_a_of_type_Gyb.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - m);
          if ((localObject instanceof PtvTemplateItemView))
          {
            localObject = (PtvTemplateItemView)localObject;
            if (!this.jdField_a_of_type_Boolean) {
              break label241;
            }
          }
        }
      }
    }
    label241:
    for (j = 1000;; j = -1)
    {
      ((PtvTemplateItemView)localObject).b(j);
      j = i;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = null;
        if (this.jdField_a_of_type_Gyb.a.d == j) {
          localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Gyb.a.jdField_a_of_type_JavaUtilArrayList.get(j);
        }
        if (localObject != null) {
          this.jdField_a_of_type_Gyb.a.a((PtvTemplateManager.PtvTemplateInfo)localObject);
        }
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */