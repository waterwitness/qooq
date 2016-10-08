package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class GroupSearchModelMoreItem
  implements ISearchResultGroupModel
{
  private String a;
  private int c;
  
  public GroupSearchModelMoreItem(String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
    this.c = paramInt;
  }
  
  public int a()
  {
    return 2;
  }
  
  public String a()
  {
    return "网络搜索";
  }
  
  public List a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Intent localIntent = new Intent((Activity)paramView.getContext(), SearchContactsActivity.class);
    localIntent.putExtra("start_search_key", this.a);
    localIntent.putExtra("jump_src_key", 0);
    localIntent.putExtra("fromType", this.c);
    ((Activity)paramView.getContext()).startActivity(localIntent);
    SearchUtils.a(this.a, 0, 0, paramView);
    ReportController.b(null, "CliOper", "", "", "0X80061B7", "0X80061B7", 0, 0, "", "", "", "");
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupSearchModelMoreItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */