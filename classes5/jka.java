import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

class jka
  implements Runnable
{
  jka(jjz paramjjz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.isFinishing()) {
      QQToast.a(this.a.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.getApplicationContext(), 1, 2131364907, 1).b(this.a.a.jdField_a_of_type_Int);
    }
    this.a.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */