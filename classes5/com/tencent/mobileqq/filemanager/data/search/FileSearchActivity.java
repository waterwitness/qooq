package com.tencent.mobileqq.filemanager.data.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.List;

public class FileSearchActivity
  extends BaseSearchActivity
{
  static List jdField_a_of_type_JavaUtilList;
  String jdField_a_of_type_JavaLangString;
  List b;
  
  public FileSearchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString, List paramList)
  {
    Intent localIntent = new Intent(paramContext, FileSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    jdField_a_of_type_JavaUtilList = paramList;
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return new FileSearchFragment(this, this.app, this.jdField_a_of_type_JavaLangString, jdField_a_of_type_JavaUtilList);
  }
  
  protected String a()
  {
    return "搜索文件";
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("keyword");
    this.b = new ArrayList();
    this.b.addAll(jdField_a_of_type_JavaUtilList);
    jdField_a_of_type_JavaUtilList = null;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\search\FileSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */