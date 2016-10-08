import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.PoiItemAdapter;
import com.tencent.biz.PoiMapActivity.PoiTab;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class hfl
  implements AbsListView.OnScrollListener
{
  public hfl(PoiMapActivity.PoiTab paramPoiTab, PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.t() == paramAbsListView.d_() - 1) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.b))
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.b(false);
      if (!PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity)) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", "turn_page", this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.f, this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.e, "", "");
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */