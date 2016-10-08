package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class ApolloViewBinder
{
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public Context a;
  public SessionInfo a;
  public List a;
  public int k;
  public int l;
  public int m;
  
  public ApolloViewBinder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = 0;
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a()
  {
    return null;
  }
  
  public View a(int paramInt)
  {
    View localView = a();
    a(localView, paramInt);
    return localView;
  }
  
  public ApolloInfo a(String paramString)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloViewBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */