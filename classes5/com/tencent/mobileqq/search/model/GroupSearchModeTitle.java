package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class GroupSearchModeTitle
  implements ISearchResultGroupModel
{
  private String a;
  
  public GroupSearchModeTitle(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public List a()
  {
    return null;
  }
  
  public void a(View paramView) {}
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public int b()
  {
    return 3;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupSearchModeTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */