import android.text.TextUtils;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.ListItem;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class mzf
  extends CardObserver
{
  public mzf(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(((Card)paramObject).uin)))
      {
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        UncommonlyUsedContactsActivity.ListItem localListItem;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localListItem = (UncommonlyUsedContactsActivity.ListItem)localIterator.next();
        } while ((localListItem.a == null) || (!(localListItem.a instanceof Friends)) || (!((Card)paramObject).uin.equals(((Friends)localListItem.a).uin)));
      }
      for (int i = 1; i != 0; i = 0)
      {
        UncommonlyUsedContactsActivity.a(this.a);
        this.a.jdField_a_of_type_Mzj.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */