import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class pzr
  extends FriendListObserver
{
  public pzr(MayknowRecommendManager paramMayknowRecommendManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "onAddFriend " + paramString);
    }
    Iterator localIterator;
    try
    {
      localIterator = MayknowRecommendManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        if (((MayKnowRecommend)localIterator.next()).uin.equals(paramString)) {
          localIterator.remove();
        }
      }
      localIterator = MayknowRecommendManager.b(this.a).iterator();
    }
    finally {}
    while (localIterator.hasNext()) {
      if (((MayKnowRecommend)localIterator.next()).uin.equals(paramString)) {
        localIterator.remove();
      }
    }
    ((FriendListHandler)MayknowRecommendManager.a(this.a).a(1)).a(108, true, null);
  }
  
  protected void e(boolean paramBoolean, String paramString)
  {
    int m = 0;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "isSuccess :" + paramBoolean + " onAddReqStatesChanged: " + paramString);
    }
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      j = k;
    }
    for (;;)
    {
      try
      {
        if (i < MayknowRecommendManager.a(this.a).size())
        {
          if (((MayKnowRecommend)MayknowRecommendManager.a(this.a).get(i)).uin.equals(paramString)) {
            ((MayKnowRecommend)MayknowRecommendManager.a(this.a).get(i)).friendStatus = 1;
          }
        }
        else
        {
          if (j < MayknowRecommendManager.b(this.a).size())
          {
            if (!((MayKnowRecommend)MayknowRecommendManager.b(this.a).get(j)).uin.equals(paramString)) {
              break label387;
            }
            ((MayKnowRecommend)MayknowRecommendManager.b(this.a).get(j)).friendStatus = 1;
            break label387;
            FriendsManager localFriendsManager = (FriendsManager)MayknowRecommendManager.a(this.a).getManager(50);
            i = 0;
            j = m;
            if (i < MayknowRecommendManager.a(this.a).size())
            {
              if ((!((MayKnowRecommend)MayknowRecommendManager.a(this.a).get(i)).uin.equals(paramString)) || (localFriendsManager.b(paramString))) {
                break label396;
              }
              ((MayKnowRecommend)MayknowRecommendManager.a(this.a).get(i)).friendStatus = 0;
              break label396;
            }
            if (j < MayknowRecommendManager.b(this.a).size())
            {
              if ((!((MayKnowRecommend)MayknowRecommendManager.b(this.a).get(j)).uin.equals(paramString)) || (localFriendsManager.b(paramString))) {
                break label405;
              }
              ((MayKnowRecommend)MayknowRecommendManager.b(this.a).get(j)).friendStatus = 0;
              break label405;
            }
          }
          ((FriendListHandler)MayknowRecommendManager.a(this.a).a(1)).a(108, true, null);
          return;
        }
      }
      finally {}
      i += 1;
      break;
      label387:
      j += 1;
      continue;
      label396:
      i += 1;
      continue;
      label405:
      j += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */