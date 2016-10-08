package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class ApolloBoxWindow$ApolloCardLayout
  extends RelativeLayout
{
  private BoxViewBuilder a;
  
  public ApolloBoxWindow$ApolloCardLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private BoxViewBuilder a(Context paramContext, ApolloBoxData paramApolloBoxData)
  {
    if ((paramApolloBoxData.jdField_a_of_type_JavaUtilList != null) && (!paramApolloBoxData.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (paramApolloBoxData.b.equals(paramApolloBoxData.jdField_a_of_type_JavaLangString)) {
        return new BoxViewBuilder.DataFillViewBuilder(paramContext, paramApolloBoxData);
      }
      return new BoxViewBuilder.StolenFillViewBuilder(paramContext, paramApolloBoxData);
    }
    return new BoxViewBuilder.DataLostViewBuilder(paramContext, paramApolloBoxData);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void a(Context paramContext, ApolloBoxData paramApolloBoxData)
  {
    if ((paramApolloBoxData == null) || (TextUtils.isEmpty(paramApolloBoxData.b)) || (TextUtils.isEmpty(paramApolloBoxData.jdField_a_of_type_JavaLangString)) || (paramContext == null)) {
      return;
    }
    super.removeAllViews();
    this.a = a(paramContext, paramApolloBoxData);
    this.a.a(this);
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloBoxWindow$ApolloCardLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */