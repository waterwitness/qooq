package com.tencent.mobileqq.search.ftsentity;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.ArrayList;
import java.util.List;

public abstract class FTSEntitySearchResultModel
  implements ISearchResultModel
{
  public int a;
  protected QQAppInterface a;
  protected CharSequence a;
  protected String a;
  protected ArrayList a;
  protected List a;
  public int b;
  protected CharSequence b;
  protected String b;
  public int c;
  protected CharSequence c;
  public int d;
  protected CharSequence d;
  
  public FTSEntitySearchResultModel(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList paramArrayList, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
    this.d = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public abstract int a();
  
  public abstract CharSequence a();
  
  public abstract String a();
  
  public abstract void a(View paramView);
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.size() > 1;
  }
  
  public abstract CharSequence b();
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public abstract CharSequence c();
  
  public CharSequence d()
  {
    return null;
  }
  
  public abstract CharSequence e();
  
  public abstract CharSequence f();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ftsentity\FTSEntitySearchResultModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */