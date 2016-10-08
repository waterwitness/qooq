package com.tencent.biz.qqstory.view.widget;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import jab;

public class LoadingMoreHelper
{
  protected int a;
  protected LoadMoreLayout a;
  protected LoadingMoreHelper.OnLoadMoreListener a;
  protected boolean a;
  
  public LoadingMoreHelper(LoadMoreLayout paramLoadMoreLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout = paramLoadMoreLayout;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(LoadingMoreHelper.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper$OnLoadMoreListener = paramOnLoadMoreListener;
    if (paramOnLoadMoreListener != null) {
      a(true);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setOnClickListener(new jab(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setWillLoadMoreText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(3);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 3;; i = 4)
    {
      if (paramString != null) {
        a(paramString);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(i);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.b(i)) {
        break;
      }
      paramString = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper$OnLoadMoreListener;
      if (paramString == null) {
        break;
      }
      paramString.a();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a() == 0) || (!this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.b(2)));
      bool = true;
      LoadingMoreHelper.OnLoadMoreListener localOnLoadMoreListener = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper$OnLoadMoreListener;
      if (localOnLoadMoreListener != null) {
        bool = localOnLoadMoreListener.a(paramBoolean);
      }
    } while (!bool);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(2);
  }
  
  public void c(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\LoadingMoreHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */