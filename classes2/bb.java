import android.view.View;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;

public class bb
  implements OverScrollViewListener
{
  public bb(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramInt = this.a.app.a().a(this.a.p).a(15);
    if (paramInt > 0)
    {
      this.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.b();
      this.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(paramInt, 0);
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */