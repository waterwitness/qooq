package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.base.QfileFileItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QfileFileAdapterFacade
{
  public QfileFileAdapterFacade()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    QfileFileItemHolder localQfileFileItemHolder = new QfileFileItemHolder();
    paramContext = LayoutInflater.from(paramContext).inflate(2130903998, paramViewGroup, false);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext.findViewById(2131300959));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localQfileFileItemHolder);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramContext.findViewById(2131300927));
    localQfileFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramContext.findViewById(2131300929));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131300960));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131300889));
    localQfileFileItemHolder.b = ((TextView)paramContext.findViewById(2131300962));
    localQfileFileItemHolder.c = ((TextView)paramContext.findViewById(2131300933));
    localQfileFileItemHolder.d = ((TextView)paramContext.findViewById(2131298399));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131297446));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131300931));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localQfileFileItemHolder);
    paramContext.setTag(localQfileFileItemHolder);
    return paramContext;
  }
  
  public static View a(Context paramContext, FileInfo paramFileInfo, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    if (!paramFileInfo.a()) {
      return a(paramContext, paramViewGroup, paramOnClickListener, paramOnLongClickListener);
    }
    paramContext = new QfileFileItemHolder();
    paramFileInfo = localLayoutInflater.inflate(2130903995, paramViewGroup, false);
    paramFileInfo.setOnClickListener(paramOnClickListener);
    paramContext.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131300951));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131298784));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131300952));
    paramFileInfo.setTag(paramContext);
    return paramFileInfo;
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    if (paramInt == 5)
    {
      FileManagerUtil.a(paramAsyncImageView, paramString, 5);
      return;
    }
    FileManagerUtil.a(paramAsyncImageView, paramString, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\adapter\QfileFileAdapterFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */