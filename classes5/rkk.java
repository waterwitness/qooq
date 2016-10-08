import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class rkk
  implements Runnable
{
  public rkk(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i;
    EmotionPanelInfo localEmotionPanelInfo;
    if (this.a.jdField_a_of_type_JavaUtilList != null)
    {
      i = 0;
      if (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        localEmotionPanelInfo = (EmotionPanelInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
        if ((localEmotionPanelInfo == null) || (localEmotionPanelInfo.a != 4)) {}
      }
    }
    for (;;)
    {
      if ((localEmotionPanelInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localEmotionPanelInfo);
      }
      return;
      i += 1;
      break;
      localEmotionPanelInfo = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */