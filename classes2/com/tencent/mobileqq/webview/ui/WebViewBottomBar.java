package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import wjr;
import wjs;
import wjt;

public class WebViewBottomBar
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private WebViewBottomBar.OnBottomBarItemListener jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar$OnBottomBarItemListener;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  private wjs jdField_a_of_type_Wjs;
  private List b;
  private int d;
  private int e;
  
  public WebViewBottomBar(Context paramContext, GridView paramGridView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetGridView = paramGridView;
    this.jdField_a_of_type_Wjs = new wjs(this, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Wjs);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new wjr(this));
  }
  
  private WebViewBottomBar.ViewHolder a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        WebViewBottomBar.ViewHolder localViewHolder = (WebViewBottomBar.ViewHolder)localIterator.next();
        if (paramInt == WebViewBottomBar.ViewHolder.a(localViewHolder)) {
          return localViewHolder;
        }
      }
    }
    return null;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int a(int paramInt)
  {
    wjt localwjt = (wjt)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localwjt == null) {
      return 0;
    }
    return localwjt.b;
  }
  
  public WebViewBottomBar.OnBottomBarItemListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar$OnBottomBarItemListener;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Wjs.getCount()) || (this.d == paramInt)) {
      return;
    }
    this.d = paramInt;
    this.jdField_a_of_type_Wjs.notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, 3, String.valueOf(paramInt2), 0, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    wjt localwjt = (wjt)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localwjt == null)
    {
      a(paramInt1, paramInt2);
      localwjt = (wjt)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      localwjt.a(paramInt1, true);
      do
      {
        return;
      } while (paramInt3 < localwjt.b);
      localwjt.b = paramInt3;
      localwjt.jdField_a_of_type_Int = 3;
      localwjt.jdField_a_of_type_JavaLangString = String.valueOf(paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramInt1 == 1) {
      b(paramInt2, paramBoolean);
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        a(paramInt2, (String)paramVarArgs[0], paramInt3, paramBoolean);
        return;
      }
    } while (paramInt1 != 3);
    b(paramInt2, Integer.parseInt((String)paramVarArgs[0]));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), new wjt(this, paramInt2, paramString, paramBoolean, paramInt3));
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    wjt localwjt = (wjt)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localwjt == null)
    {
      a(paramInt1, paramBoolean);
      localwjt = (wjt)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      localwjt.a(paramInt1, paramBoolean);
      do
      {
        return;
      } while (paramInt2 < localwjt.b);
      localwjt.b = paramInt2;
      localwjt.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, 2, paramString, paramInt2, true);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    wjt localwjt = (wjt)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localwjt == null) {
      a(paramInt1, paramString, paramInt2);
    }
    for (paramString = (wjt)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));; paramString = localwjt)
    {
      paramString.a(paramInt1, paramBoolean);
      do
      {
        return;
      } while (paramInt2 < localwjt.b);
      localwjt.b = paramInt2;
      localwjt.jdField_a_of_type_Int = 2;
      localwjt.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 1, "", 0, paramBoolean);
  }
  
  public void a(WebViewBottomBar.OnBottomBarItemListener paramOnBottomBarItemListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar$OnBottomBarItemListener = paramOnBottomBarItemListener;
  }
  
  public boolean a(int paramInt)
  {
    WebViewBottomBar.ViewHolder localViewHolder = a(paramInt);
    if (localViewHolder == null) {}
    while ((localViewHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) && (localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) && (localViewHolder.b.getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public boolean a(int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length == 0) || (paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0)) {
      return false;
    }
    int k = paramArrayOfString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      String str = paramArrayOfString[i];
      WebViewBottomBar.BottomItem localBottomItem = new WebViewBottomBar.BottomItem(this);
      localBottomItem.jdField_a_of_type_Int = paramArrayOfInt1[j];
      localBottomItem.jdField_a_of_type_JavaLangString = str;
      localBottomItem.b = paramArrayOfInt2[j];
      this.b.add(localBottomItem);
      j += 1;
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_a_of_type_Wjs.getCount());
    this.d = ((int)this.jdField_a_of_type_Wjs.getItemId(0));
    return true;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\ui\WebViewBottomBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */