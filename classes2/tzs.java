import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import java.util.ArrayList;
import java.util.List;

public class tzs
  implements Runnable
{
  public tzs(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.app == null) {}
    Object localObject1;
    int j;
    int i;
    label67:
    label94:
    do
    {
      return;
      if (QCallDetailActivity.a(this.a, QCallDetailActivity.a(this.a)))
      {
        localObject1 = MsgProxyUtils.q;
        j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label401;
        }
        int k = localObject1[i];
        if (QCallDetailActivity.a(this.a) != k) {
          break;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = (PhoneContactManager)this.a.app.getManager(10);
          if (localObject1 != null) {
            break label318;
          }
          localObject1 = null;
          if (localObject1 != null) {
            QCallDetailActivity.a(this.a).a(((PhoneContact)localObject1).mobileCode, 1006, QCallDetailActivity.a(this.a), QCallDetailActivity.a(this.a));
          }
        }
      }
    } while (QCallDetailActivity.a(this.a) == null);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      synchronized (QCallDetailActivity.a(this.a))
      {
        if ((QCallDetailActivity.b(this.a) == 2) || (QCallDetailActivity.b(this.a) == 3) || (QCallDetailActivity.a(this.a) == 25))
        {
          localObject1 = QCallDetailActivity.a(this.a).a(QCallDetailActivity.a(this.a), 8);
          if ((QCallDetailActivity.a(this.a) == null) || (localObject1 == null) || (((List)localObject1).isEmpty())) {
            continue;
          }
          i = 20;
          j = 0;
          if ((j >= i) || (j >= ((List)localObject1).size())) {
            break label407;
          }
          if (((QCallRecord)((List)localObject1).get(j)).type != QCallRecord.TYPE_DATE) {
            break label398;
          }
          i += 1;
          localArrayList.add(((List)localObject1).get(j));
          j += 1;
          continue;
          i += 1;
          break;
          label318:
          localObject1 = ((PhoneContactManager)localObject1).c(QCallDetailActivity.a(this.a));
          break label94;
        }
        localObject1 = QCallDetailActivity.a(this.a).a(QCallDetailActivity.a(this.a), QCallDetailActivity.a(this.a));
        continue;
        this.a.app.runOnUiThread(new tzt(this, localArrayList, bool));
        return;
        bool = true;
      }
      label398:
      continue;
      label401:
      i = 0;
      break label67;
      label407:
      boolean bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */