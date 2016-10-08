import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;

class aj
  implements Runnable
{
  aj(aa paramaa, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    ((ClipboardManager)this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", this.jdField_a_of_type_JavaLangString));
    LiteActivity.a(this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_Aa.a.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_Aa.a.app.a().a(this.jdField_a_of_type_Int).e();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */