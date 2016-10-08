package com.tencent.mobileqq.search.ftsmsg;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSGroupSearchModelEntity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.List;

public class FTSGroupSearchModelMessage
  extends FTSGroupSearchModelEntity
{
  public FTSGroupSearchModelMessage(List paramList, String paramString)
  {
    super(paramList, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    return "聊天记录";
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.a, 40, 0, paramView);
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.d = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 0;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.h = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.i = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = -1;
    SQLiteFTSUtils.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.a, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ftsmsg\FTSGroupSearchModelMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */