import android.content.Intent;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

public class ohl
  implements ReadInJoySearchTipsContainer.OnTipClickListener
{
  public ohl(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    SearchProtocol.WordItem localWordItem;
    if (paramString != null)
    {
      Iterator localIterator = this.a.b.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWordItem = (SearchProtocol.WordItem)localIterator.next();
      } while (!paramString.equals(localWordItem.word));
    }
    for (;;)
    {
      if ((localWordItem != null) && (localWordItem.type == 2))
      {
        paramString = new Intent(this.a, QQBrowserActivity.class);
        paramString.putExtra("hide_operation_bar", true);
        paramString.putExtra("url", localWordItem.jumpUrl);
        paramString.putExtra("articalChannelId", 14);
        this.a.startActivity(paramString);
        if (localWordItem != null)
        {
          if (localWordItem.type != 2) {
            break label231;
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006818", "0X8006818", 0, 0, localWordItem.word, localWordItem.jumpUrl, "", "");
        }
      }
      else
      {
        if (this.a.d == ClassificationSearchActivity.jdField_a_of_type_Int)
        {
          this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
          ClassificationSearchActivity.a(this.a, paramString);
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramString, "");
        }
        for (;;)
        {
          this.a.a(paramString);
          break;
          this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramString, false);
        }
      }
      label231:
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006818", "0X8006818", 0, 0, localWordItem.word, "0", "", "");
      return;
      localWordItem = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */