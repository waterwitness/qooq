package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;

public class GetSelfPendantId
  extends AsyncStep
{
  private static final String c = "GetSelfPendantId";
  
  public GetSelfPendantId()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String a()
  {
    if ((this.a.b.getAccount() != null) && (this.a.b.isLogin())) {
      return this.a.b.getAccount();
    }
    return "0";
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetSelfPendantId", 2, "doStep");
    }
    IndividuationUrlHelper.a(this.a.b);
    ((FriendListHandler)this.a.b.a(1)).a(new String[] { a() }, new int[] { 27025, 20059, 27201, 27041 });
    ((FriendsManager)this.a.b.getManager(50)).b();
    this.a.b.getManager(43);
    ClubContentJsonTask.a();
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetSelfPendantId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */