import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class rkj
  implements Runnable
{
  public rkj(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EmotionPanelInfo localEmotionPanelInfo;
    int i;
    if (this.a.jdField_a_of_type_JavaUtilList != null)
    {
      localEmotionPanelInfo = null;
      i = 0;
      int j = this.a.jdField_a_of_type_JavaUtilList.size();
      if (i >= j) {
        break label104;
      }
      localEmotionPanelInfo = (EmotionPanelInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
      if ((localEmotionPanelInfo == null) || (localEmotionPanelInfo.a != 9)) {
        break label68;
      }
    }
    for (;;)
    {
      if (i == -1) {}
      label68:
      while ((EmoticonMainPanel.k != i) || (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter == null))
      {
        return;
        i += 1;
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localEmotionPanelInfo);
      return;
      label104:
      i = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */