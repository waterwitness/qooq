import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rhw
  extends CardObserver
{
  public rhw(MessengerService paramMessengerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("MessengerService.onCardDownload", 2, "received onCardDownload");
    }
    Object localObject;
    long l1;
    int i;
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      localObject = (QQAppInterface)MessengerService.e(this.a);
      if ((localObject != null) && (Utils.a(((QQAppInterface)localObject).a(), ((Card)paramObject).uin))) {
        if ((((Card)paramObject).templateRet == 0) || (((Card)paramObject).templateRet == 101107) || (((Card)paramObject).templateRet == 101108))
        {
          l1 = ((Card)paramObject).lCurrentBgId;
          l2 = ((Card)paramObject).lCurrentStyleId;
          i = 0;
        }
      }
    }
    for (;;)
    {
      paramObject = new Bundle();
      ((Bundle)paramObject).putLong("currentId", l1);
      ((Bundle)paramObject).putLong("styleId", l2);
      ((Bundle)paramObject).putInt("result", i);
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = (Bundle)this.a.jdField_a_of_type_JavaUtilList.remove(0);
        ((Bundle)localObject).putBundle("response", (Bundle)paramObject);
        this.a.a((Bundle)localObject);
      }
      return;
      i = -1;
      l1 = 0L;
      continue;
      i = -1;
      l1 = 0L;
      continue;
      i = -1;
      l1 = 0L;
    }
  }
  
  public void d(boolean paramBoolean, Object paramObject)
  {
    int j = -1;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramBoolean)
    {
      str1 = str2;
      i = j;
      if (paramObject != null)
      {
        if (!(paramObject instanceof Card)) {
          break label157;
        }
        i = 0;
        str1 = str2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "onSetCardTemplateReturn...resultCode=" + i);
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle != null)
      {
        paramObject = new Bundle();
        this.a.jdField_a_of_type_AndroidOsBundle.putString("cmd", "card_setSummaryCard");
        ((Bundle)paramObject).putInt("result", i);
        ((Bundle)paramObject).putString("message", str1);
        this.a.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)paramObject);
        this.a.a(this.a.jdField_a_of_type_AndroidOsBundle);
        this.a.jdField_a_of_type_AndroidOsBundle = null;
      }
      return;
      label157:
      str1 = str2;
      i = j;
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        i = ((Integer)((Pair)paramObject).first).intValue();
        str1 = (String)((Pair)paramObject).second;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */