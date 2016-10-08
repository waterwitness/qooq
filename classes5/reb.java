import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.GodEntity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class reb
  extends DatingObserver
{
  public reb(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      DatingTopListActivity.a(this.a, paramString2, Long.parseLong(paramString1));
      return;
    }
    catch (RuntimeException paramString1) {}
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString)
  {
    DatingUtil.c(DatingTopListActivity.class.getSimpleName(), new Object[] { "ongetShowLove ", "issuccess = ", Boolean.valueOf(paramBoolean1), " uin = ", Long.valueOf(paramLong), " canChat = ", Boolean.valueOf(paramBoolean2), " can ShowLove = ", Boolean.valueOf(paramBoolean3), paramString });
    DatingTopListActivity localDatingTopListActivity = this.a;
    if (DatingTopListActivity.a(this.a) != null)
    {
      DatingTopListActivity.a(this.a).removeMessages(6);
      DatingTopListActivity.a(this.a).sendEmptyMessage(7);
    }
    String str2;
    String str1;
    if (paramBoolean1)
    {
      str2 = StringUtil.a(paramLong);
      str1 = null;
      if (!TextUtils.isEmpty(null)) {
        break label394;
      }
      Object localObject1 = DatingTopListActivity.a(this.a).values();
      if (localObject1 == null) {
        break label394;
      }
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (List)((Iterator)localObject1).next();
        if (localObject2 == null) {
          break label391;
        }
        localObject2 = ((List)localObject2).iterator();
        GodEntity localGodEntity;
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localGodEntity = (GodEntity)((Iterator)localObject2).next();
        } while (!str2.equals(localGodEntity.uin));
        str1 = localGodEntity.nickName;
      }
    }
    for (;;)
    {
      if (paramBoolean2) {
        DatingTopListActivity.a(this.a, this.a, str2, str1, paramArrayOfByte);
      }
      for (;;)
      {
        this.a.d = false;
        return;
        if (paramBoolean3)
        {
          if ((this.a.g & 0x1) == 1)
          {
            i = 1;
            label297:
            if (i == 0) {
              break label339;
            }
          }
          label339:
          for (int i = 1;; i = 0)
          {
            this.a.runOnUiThread(new rec(this, localDatingTopListActivity, str2, str1, i, paramArrayOfByte));
            break;
            i = 0;
            break label297;
          }
        }
        paramArrayOfByte = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayOfByte = localDatingTopListActivity.getString(2131372111);
        }
        DatingUtil.a(localDatingTopListActivity, paramArrayOfByte);
        continue;
        DatingUtil.a(localDatingTopListActivity, localDatingTopListActivity.getString(2131372112));
      }
      label391:
      break;
      label394:
      str1 = null;
    }
  }
  
  public void a(boolean paramBoolean1, List paramList1, List paramList2, long paramLong, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("DatingTopListActivity onGetRankList ").append(paramBoolean1).append(", cfgs size  = ");
      if (paramList1 == null) {
        break label126;
      }
      localObject = Integer.valueOf(paramList1.size());
      localStringBuilder = localStringBuilder.append(localObject).append(", godsList size = ");
      if (paramList2 == null) {
        break label133;
      }
    }
    label126:
    label133:
    for (Object localObject = Integer.valueOf(paramList2.size());; localObject = "null")
    {
      QLog.d("DatingTopListActivity", 2, localObject);
      if (!paramBoolean1) {
        break label179;
      }
      if ((paramLong == 0L) || (!paramBoolean3)) {
        break label140;
      }
      QQToast.a(BaseApplicationImpl.a, "榜单已变，请回到顶部下拉刷新。", 0).b(this.a.getTitleBarHeight());
      return;
      localObject = "null";
      break;
    }
    label140:
    DatingTopListActivity.a(this.a, 0);
    DatingTopListActivity.a(this.a, paramList1, paramList2, paramLong, paramBoolean2, paramInt);
    for (;;)
    {
      DatingTopListActivity.a(this.a).sendEmptyMessageDelayed(3, 800L);
      return;
      label179:
      QQToast.a(this.a.getApplicationContext(), "获取列表失败，请稍后再试。", 0).b(this.a.getTitleBarHeight());
      DatingTopListActivity.a(this.a, 1);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DatingTopListActivity", 2, "DatingTopListActivity onSetRankRefuse isSuccess = " + paramBoolean1 + ", refuse = " + paramBoolean2);
    }
    String str;
    List localList;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        str = this.a.b.a();
        if ((DatingTopListActivity.a(this.a) != null) && (DatingTopListActivity.a(this.a).insideRank))
        {
          if (this.a.g != DatingTopListActivity.a(this.a).listType) {
            break label329;
          }
          localList = (List)DatingTopListActivity.a(this.a).get(Integer.valueOf(this.a.g));
        }
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          GodEntity localGodEntity = (GodEntity)localIterator.next();
          if (str.equals(localGodEntity.uin))
          {
            localList.remove(localGodEntity);
            DatingTopListActivity.a(this.a).notifyDataSetChanged();
          }
        }
      }
      QQToast.a(BaseApplicationImpl.a, "设置成功，QQ不会将你选入排行榜。", 0).b(this.a.getTitleBarHeight());
      return;
      if ((DatingTopListActivity.b(this.a) != null) && (DatingTopListActivity.b(this.a).insideRank) && (this.a.g == DatingTopListActivity.b(this.a).listType))
      {
        localList = (List)DatingTopListActivity.a(this.a).get(Integer.valueOf(this.a.g));
        continue;
        QQToast.a(BaseApplicationImpl.a, "设置成功，允许将我选入排行榜。", 0).b(this.a.getTitleBarHeight());
        return;
        QQToast.a(BaseApplicationImpl.a, "设置失败，请稍后再试。", 0).b(this.a.getTitleBarHeight());
      }
      else
      {
        label329:
        localList = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\reb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */