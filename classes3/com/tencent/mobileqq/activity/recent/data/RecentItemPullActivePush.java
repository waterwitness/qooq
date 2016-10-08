package com.tencent.mobileqq.activity.recent.data;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class RecentItemPullActivePush
  extends RecentUserBaseData
{
  public long a;
  
  public RecentItemPullActivePush(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, long paramLong)
  {
    this.b = paramString;
    this.a = paramLong;
    this.c = TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemPullActivePush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */