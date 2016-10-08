import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class ohi
  implements SearchProtocol.SearchObserver
{
  public ohi(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SearchProtocol.WordItem paramWordItem) {}
  
  public void a(int paramInt, ArrayList paramArrayList) {}
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchActivity", 2, "hot words size: " + paramList.size());
      }
      this.a.b = paramList;
      ClassificationSearchActivity.a(this.a, true);
    }
  }
  
  public void a(int paramInt, JSONArray paramJSONArray) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */