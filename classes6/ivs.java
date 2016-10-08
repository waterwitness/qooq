import com.tencent.biz.qqstory.takevideo.NewStoryPoiSearchViewPart;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class ivs
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  
  public ivs(NewStoryPoiSearchViewPart paramNewStoryPoiSearchViewPart)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      InputMethodUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */