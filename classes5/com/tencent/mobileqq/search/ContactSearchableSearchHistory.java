package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ContactSearchableSearchHistory
  extends IContactSearchable
{
  private SearchHistory a;
  
  public ContactSearchableSearchHistory(QQAppInterface paramQQAppInterface, SearchHistory paramSearchHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramSearchHistory;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public SearchHistory a()
  {
    return this.a;
  }
  
  public String a()
  {
    return this.a.extralInfo;
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return null;
  }
  
  public int c()
  {
    switch (this.a.type)
    {
    default: 
    case 3000: 
    case 1: 
    case 1006: 
    case 56938: 
    case 1008: 
      do
      {
        return 1;
        return 101;
        return 4;
        return 11;
      } while (!TextUtils.equals(this.a.uin, AppConstants.aZ));
      return 110;
    }
    return 111;
  }
  
  public String c()
  {
    return this.a.displayName;
  }
  
  public String d()
  {
    return this.a.uin;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ContactSearchableSearchHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */