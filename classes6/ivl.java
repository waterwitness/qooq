import com.tencent.biz.qqstory.takevideo.NewStoryPoiList;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class ivl
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  
  public ivl(NewStoryPoiList paramNewStoryPoiList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList.a != null) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList.a.size() - 1)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList.a();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */