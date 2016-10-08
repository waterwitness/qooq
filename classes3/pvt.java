import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class pvt
  implements Runnable
{
  pvt(pvs parampvs)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendsManager localFriendsManager = (FriendsManager)ConditionSearchManager.a(this.a.a).getManager(50);
    Card localCard = localFriendsManager.b(ConditionSearchManager.a(this.a.a).a());
    Object localObject;
    String str;
    if (localCard.strLocationCodes != null)
    {
      localObject = localCard.strLocationCodes.split("-");
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "parse location codes: " + localCard.strLocationCodes);
      }
      str = this.a.a.a((String[])localObject);
      localObject = str;
      if (str.equals("不限")) {
        localObject = "";
      }
      localCard.strLocationDesc = ((String)localObject);
    }
    if (localCard.strHometownCodes != null)
    {
      localObject = localCard.strHometownCodes.split("-");
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "parse hometown codes: " + localCard.strHometownCodes);
      }
      str = this.a.a.a((String[])localObject);
      localObject = str;
      if (str.equals("不限")) {
        localObject = "";
      }
      localCard.strHometownDesc = ((String)localObject);
    }
    localFriendsManager.a(localCard);
    this.a.a.c = false;
    this.a.a.b(this.a.a.a);
    ((CardHandler)ConditionSearchManager.a(this.a.a).a(2)).a(43, true, localCard);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */