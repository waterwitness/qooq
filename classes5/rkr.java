import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.List;

public class rkr
  implements AbsListView.OnScrollListener
{
  public rkr(EmotionPanelViewPagerAdapter paramEmotionPanelViewPagerAdapter, int paramInt, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      if (this.jdField_a_of_type_Int == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(EmotionPanelViewPagerAdapter.a, 2, "onScrollStateChanged preload systememoji");
        }
        int j = paramAbsListView.s();
        int i = (paramAbsListView.t() + 1) * 7;
        paramInt = i;
        while ((paramInt < i + 35) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
        {
          paramAbsListView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          if ((paramAbsListView instanceof SystemAndEmojiEmoticonInfo))
          {
            paramAbsListView = (SystemAndEmojiEmoticonInfo)paramAbsListView;
            if ((paramAbsListView != null) && (paramAbsListView.c != 3) && (paramAbsListView.j != -1))
            {
              paramAbsListView = (URLDrawable)paramAbsListView.a(EmotionPanelViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter), EmotionPanelViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter));
              if ((paramAbsListView != null) && (paramAbsListView.getStatus() != 1)) {
                paramAbsListView.startDownload();
              }
            }
          }
          paramInt += 1;
        }
        i = j * 7 - 1;
        paramInt = i;
        while ((paramInt >= 0) && (paramInt > i - 35))
        {
          paramAbsListView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          if ((paramAbsListView instanceof SystemAndEmojiEmoticonInfo))
          {
            paramAbsListView = (SystemAndEmojiEmoticonInfo)paramAbsListView;
            if ((paramAbsListView != null) && (paramAbsListView.c != 3) && (paramAbsListView.j != -1))
            {
              paramAbsListView = (URLDrawable)paramAbsListView.a(EmotionPanelViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter), EmotionPanelViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter));
              if ((paramAbsListView != null) && (paramAbsListView.getStatus() != 1)) {
                paramAbsListView.startDownload();
              }
            }
          }
          paramInt -= 1;
        }
      }
    }
    else
    {
      URLDrawable.pause();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */