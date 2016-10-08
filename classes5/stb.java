import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class stb
  extends Handler
{
  public stb(HotChatMemberListActivity paramHotChatMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.c)
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.c = false;
    }
    switch (paramMessage.what)
    {
    default: 
    case 3: 
    case 1: 
      do
      {
        return;
        List localList = (List)paramMessage.obj;
        if (localList != null) {
          this.a.jdField_a_of_type_JavaUtilList.addAll(localList);
        }
        i = paramMessage.arg1;
        this.a.a(i);
        return;
        this.a.stopTitleProgress();
        this.a.b.setVisibility(8);
        paramMessage = (List)paramMessage.obj;
        if (paramMessage != null) {
          this.a.jdField_a_of_type_JavaUtilList.addAll(paramMessage);
        }
      } while (this.a.jdField_a_of_type_JavaUtilList.size() == 0);
      HotChatMemberListActivity.a(this.a);
      if (this.a.jdField_a_of_type_Sty != null)
      {
        this.a.jdField_a_of_type_Sty.notifyDataSetChanged();
        if (this.a.jdField_e_of_type_AndroidViewView != null)
        {
          paramMessage = (stz)this.a.jdField_e_of_type_AndroidViewView.getTag();
          paramMessage.c.setText(this.a.jdField_e_of_type_JavaLangString);
          paramMessage = paramMessage.b;
          if (this.a.jdField_a_of_type_Byte != 1) {
            break label317;
          }
        }
      }
      label317:
      for (int i = 0;; i = 8)
      {
        paramMessage.setVisibility(i);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(HotChatMemberListActivity.a(this.a));
        return;
        this.a.jdField_a_of_type_Sty = new sty(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.a.jdField_a_of_type_Sty);
        break;
      }
    }
    this.a.stopTitleProgress();
    QQToast.a(this.a, this.a.getString(2131368639), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\stb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */