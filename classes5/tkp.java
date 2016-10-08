import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.PinnedHeaderExpandableListView;

class tkp
  implements Runnable
{
  tkp(tko paramtko, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Tko.a.a(this.jdField_a_of_type_Boolean, this.b);
    this.jdField_a_of_type_Tko.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.H();
    if (this.b)
    {
      this.jdField_a_of_type_Tko.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Tko.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setSelection(0);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Tko.a, 1, this.jdField_a_of_type_Tko.a.getString(2131368597), 0).b(this.jdField_a_of_type_Tko.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */