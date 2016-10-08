package com.tencent.mobileqq.filemanager.data.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class FileSearchDetailActivity
  extends IphoneTitleBarActivity
{
  static FileEntitySearchResultModel jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel;
  private static final String jdField_a_of_type_JavaLangString = "keyword";
  FileEntitySearchResultModel b;
  
  public FileSearchDetailActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString, FileEntitySearchResultModel paramFileEntitySearchResultModel)
  {
    a = paramFileEntitySearchResultModel;
    paramFileEntitySearchResultModel = new Intent(paramContext, FileSearchDetailActivity.class);
    paramFileEntitySearchResultModel.putExtra("keyword", paramString);
    paramContext.startActivity(paramFileEntitySearchResultModel);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = a;
    super.setContentView(2130903204);
    super.setTitle(((FileManagerEntity)this.b.a.get(0)).fileName);
    Object localObject = getSupportFragmentManager();
    paramBundle = FileSearchDetailFragment.a(getIntent().getStringExtra("keyword"), this.b);
    localObject = ((FragmentManager)localObject).beginTransaction();
    ((FragmentTransaction)localObject).replace(2131297684, paramBundle);
    ((FragmentTransaction)localObject).commit();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\search\FileSearchDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */