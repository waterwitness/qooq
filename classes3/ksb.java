import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;

public final class ksb
  implements Runnable
{
  public ksb(Context paramContext, List paramList, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ChatActivityFacade.b = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    ChatActivityFacade.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364614);
    ChatActivityFacade.b.a(str);
    ChatActivityFacade.b.a(2131368306, 3);
    ChatActivityFacade.b.d(2131367262);
    ChatActivityFacade.b.a(new ksc(this));
    ChatActivityFacade.b.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ksb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */