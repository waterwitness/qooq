package com.tencent.mobileqq.search.ftsentity;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;

public abstract class FTSEntitySearchResultDetailModel
  implements ISearchResultModel
{
  protected QQAppInterface a;
  protected FTSEntity a;
  protected CharSequence a;
  protected String a;
  protected ArrayList a;
  protected CharSequence b;
  protected CharSequence c;
  private CharSequence d;
  
  public FTSEntitySearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList, FTSEntity paramFTSEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity = paramFTSEntity;
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract CharSequence a();
  
  public abstract String a();
  
  public abstract void a(View paramView);
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.d == null) {
      this.d = SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity.mContent, this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity.mProximityStart, this.jdField_a_of_type_JavaUtilArrayList);
    }
    return this.d;
  }
  
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
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ftsentity\FTSEntitySearchResultDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */