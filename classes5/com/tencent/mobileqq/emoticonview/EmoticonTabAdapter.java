package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.LruCache;
import android.support.v4.util.MQLruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import rkn;

public class EmoticonTabAdapter
  extends BaseAdapter
{
  public static LruCache a;
  int jdField_a_of_type_Int;
  protected Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public QQAppInterface a;
  List jdField_a_of_type_JavaUtilList;
  Drawable b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public EmoticonTabAdapter(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837556);
    this.b = paramContext.getResources().getDrawable(2130837557);
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131428137);
  }
  
  public static URL a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    URL localURL;
    do
    {
      return (URL)localObject;
      localURL = (URL)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      localObject = localURL;
    } while (localURL != null);
    try
    {
      localObject = new URL("protocol_vas_extension_image", "EMOTICON_TAB", paramString);
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject);
      return (URL)localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localObject = localURL;
        if (QLog.isColorLevel())
        {
          QLog.d("EmoticonTabAdapter", 2, localMalformedURLException.getMessage());
          localObject = localURL;
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    BaseApplicationImpl.a.remove(paramString.toString());
  }
  
  public Drawable a(EmoticonTabAdapter.EmoticonTabItem paramEmoticonTabItem)
  {
    URL localURL = a(paramEmoticonTabItem.jdField_a_of_type_JavaLangString);
    Object localObject = null;
    if (localURL != null)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (10 != paramEmoticonTabItem.jdField_a_of_type_Int) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = (bool + ":" + paramEmoticonTabItem.jdField_a_of_type_Boolean);
      paramEmoticonTabItem = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      localObject = paramEmoticonTabItem;
      if (paramEmoticonTabItem.getStatus() == 2)
      {
        paramEmoticonTabItem.restartDownload();
        localObject = paramEmoticonTabItem;
      }
      return (Drawable)localObject;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      QLog.e("EmoticonTabAdapter", 1, "getItem error");
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new EmoticonTabAdapter.ViewHolder(this);
      paramView = HorizontalListViewEx.a();
      if (paramView != null) {
        break label522;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903340, paramViewGroup, false);
    }
    label250:
    label506:
    label519:
    label522:
    for (;;)
    {
      ((EmoticonTabAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131297092));
      ((EmoticonTabAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298192));
      ((EmoticonTabAdapter.ViewHolder)localObject).b = ((ImageView)paramView.findViewById(2131298191));
      ((EmoticonTabAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131296964);
      ((EmoticonTabAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      paramView.setTag(localObject);
      View localView = paramView;
      paramViewGroup = (ViewGroup)localObject;
      EmoticonTabAdapter.EmoticonTabItem localEmoticonTabItem;
      for (;;)
      {
        localEmoticonTabItem = (EmoticonTabAdapter.EmoticonTabItem)getItem(paramInt);
        if (localEmoticonTabItem != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 1, "getView item is null ,position = " + paramInt);
        return null;
        paramViewGroup = (EmoticonTabAdapter.ViewHolder)paramView.getTag();
        localView = paramView;
      }
      paramView = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (paramInt != getCount() - 1)
      {
        paramInt = 0;
        paramView.setVisibility(paramInt);
        paramViewGroup.b.setVisibility(8);
        switch (localEmoticonTabItem.jdField_a_of_type_Int)
        {
        case 5: 
        default: 
          paramView = null;
        }
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (paramView != null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
          if (localEmoticonTabItem.b == 4)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            if (!localEmoticonTabItem.jdField_a_of_type_Boolean) {
              break label506;
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841692);
          }
        }
        for (;;)
        {
          return localView;
          paramInt = 4;
          break;
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841724);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label519;
          }
          localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
          if ((localObject != null) && (((EmoticonManager)localObject).a()))
          {
            paramViewGroup.b.setVisibility(0);
            break label250;
          }
          break label250;
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841717);
          break label250;
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841716);
          break label250;
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837555);
          break label250;
          localObject = a(localEmoticonTabItem);
          paramView = (View)localObject;
          if (localObject != null) {
            break label250;
          }
          paramView = new StateListDrawable();
          localObject = this.b;
          paramView.addState(new int[] { 16842913 }, (Drawable)localObject);
          localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          paramView.addState(new int[0], (Drawable)localObject);
          ThreadManager.a(new rkn(this, localEmoticonTabItem), 5, null, false);
          break label250;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841693);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmoticonTabAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */