import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelLinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rkq
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public rkq(EmotionPanelLinearLayout paramEmotionPanelLinearLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = EmotionPanelLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout);
  }
  
  public void run()
  {
    EmoticonInfo localEmoticonInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.getParent() != null) && (this.jdField_a_of_type_Int == EmotionPanelLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.jdField_a_of_type_AndroidViewView != null))
    {
      localEmoticonInfo = (EmoticonInfo)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.jdField_a_of_type_AndroidViewView.getTag();
      if (localEmoticonInfo != null)
      {
        if ((EmotionPanelLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout) != null) && (EmotionPanelLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout).a(localEmoticonInfo))) {
          break label160;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.getParent().requestDisallowInterceptTouchEvent(true);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.sendAccessibilityEvent(2);
        if (!"delete".equals(localEmoticonInfo.a)) {
          break label120;
        }
      }
    }
    label120:
    while (("setting".equals(localEmoticonInfo.a)) || ("add".equals(localEmoticonInfo.a))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.jdField_a_of_type_AndroidViewView, localEmoticonInfo);
    return;
    label160:
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelLinearLayout.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */