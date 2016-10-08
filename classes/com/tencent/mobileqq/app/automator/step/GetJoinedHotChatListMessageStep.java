package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GetJoinedHotChatListMessageStep
  extends AsyncStep
{
  private static final String c = "GetJoinedHotChatListMessage";
  
  public GetJoinedHotChatListMessageStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (HotChatManager.a(this.a.b))
    {
      HotChatManager localHotChatManager = (HotChatManager)this.a.b.getManager(59);
      Object localObject = localHotChatManager.b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(50);
        localStringBuilder.append("troopUin: ");
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((HotChatInfo)localIterator.next()).troopUin).append("  ");
        }
        QLog.d("GetJoinedHotChatListMessage", 2, localStringBuilder.toString());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localHotChatManager.b((HotChatInfo)((Iterator)localObject).next(), 0);
      }
    }
    return 7;
  }
  
  public void a() {}
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetJoinedHotChatListMessageStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */