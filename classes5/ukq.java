import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Map;

public class ukq
  implements AdapterView.OnItemClickListener
{
  public ukq(GroupSearchActivity paramGroupSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ThreadPriorityManager.a(true);
    SearchHistory localSearchHistory;
    label190:
    int i;
    if ((paramAdapterView == GroupSearchActivity.a(this.a)) && (GroupSearchActivity.a(this.a) != null))
    {
      paramAdapterView = (IContactSearchable)GroupSearchActivity.a(this.a).getItem(paramInt);
      if ((paramAdapterView instanceof ContactSearchableSearchHistory))
      {
        localSearchHistory = ((ContactSearchableSearchHistory)paramAdapterView).a();
        QLog.d("searchUtils", 2, "on serarch history click, " + localSearchHistory.toString());
        switch (localSearchHistory.type)
        {
        default: 
          paramInt = 1;
          if (paramInt != 0)
          {
            SearchUtils.a(this.a.app, localSearchHistory.displayName, localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type);
            if (localSearchHistory.type != 1) {
              break label819;
            }
            i = 2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      label236:
      paramInt = 0;
      if (GroupSearchActivity.e == 2) {
        paramInt = 3;
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "Search", "May_find", paramInt, 0, String.valueOf(i), "", "", "");
        return;
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localSearchHistory.uin, 33);
        localAllInOne.a = new ArrayList();
        localAllInOne.k = localSearchHistory.displayName;
        if (!TextUtils.isEmpty(localSearchHistory.uin))
        {
          String[] arrayOfString = localSearchHistory.uin.split("\\|");
          if (arrayOfString != null)
          {
            paramInt = 0;
            if (paramInt < arrayOfString.length)
            {
              ArrayList localArrayList = localAllInOne.a;
              StringBuilder localStringBuilder = new StringBuilder().append("电话");
              if (arrayOfString.length > 0) {}
              for (paramAdapterView = Integer.valueOf(paramInt + 1);; paramAdapterView = "")
              {
                localArrayList.add(new ProfileActivity.CardContactInfo(paramAdapterView, arrayOfString[paramInt], null));
                paramInt += 1;
                break;
              }
            }
          }
        }
        localAllInOne.f = 3;
        ProfileActivity.b(paramView.getContext(), localAllInOne);
        paramInt = 1;
        break label190;
        paramAdapterView = (FriendsManager)this.a.app.getManager(50);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.c(localSearchHistory.uin);
          if (paramAdapterView != null)
          {
            RecentUtil.a = true;
            RecentUtil.a(paramView.getContext(), this.a.app, localSearchHistory.uin, 0, ContactUtils.a(paramAdapterView), false);
          }
          paramInt = 1;
          break label190;
        }
        paramInt = 0;
        break label190;
        paramAdapterView = (DiscussionManager)this.a.app.getManager(52);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.a(localSearchHistory.troopUin);
          if (paramAdapterView != null)
          {
            paramAdapterView = (DiscussionMemberInfo)paramAdapterView.get(localSearchHistory.uin);
            if (paramAdapterView != null)
            {
              RecentUtil.a = true;
              RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, paramAdapterView.memberName, false);
              paramInt = 1;
              break label190;
            }
          }
        }
        RecentUtil.a = true;
        RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label190;
        RecentUtil.a = true;
        RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label190;
        RecentUtil.a = true;
        RecentUtil.a(paramView.getContext(), this.a.app, localSearchHistory.uin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label190;
        if (!TextUtils.equals(localSearchHistory.uin, AppConstants.aZ)) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "");
        ReadInJoyActivityHelper.a(paramView.getContext(), null, -1L, 1);
        paramInt = 1;
        break label190;
        ReportController.b(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "");
        ReadInJoyActivityHelper.a(this.a.app, paramView.getContext(), 1, 0);
        break;
        label819:
        if (localSearchHistory.type != 3000) {
          break label861;
        }
        i = 3;
        break label236;
        if (GroupSearchActivity.e == 10) {
          paramInt = 2;
        } else if (GroupSearchActivity.e == 1) {
          paramInt = 1;
        }
      }
      label861:
      i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ukq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */