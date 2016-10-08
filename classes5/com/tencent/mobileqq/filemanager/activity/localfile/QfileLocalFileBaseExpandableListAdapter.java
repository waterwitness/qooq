package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import rtg;

public class QfileLocalFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private View.OnClickListener b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public QfileLocalFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = paramOnClickListener1;
    this.c = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.d = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    return FileUtil.a(paramFileInfo.a());
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130840362);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, QfileLocalFileBaseExpandableListAdapter.LocalItemHolder paramLocalItemHolder)
  {
    int i = paramString.hashCode();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)) == true)
    {
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      return;
    }
    switch (paramInt1)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(FileManagerUtil.c(paramInt1));
    }
    for (;;)
    {
      ThreadManager.a(new rtg(this, paramString, paramInt1, paramInt2, paramInt3, paramLocalItemHolder), 8, null, false);
      return;
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130840362);
      continue;
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130840343);
      if (FileUtil.b(paramString))
      {
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
        continue;
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130840399);
      }
    }
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "groupPosition[" + paramInt1 + "],childPosition[" + paramInt2 + "]");
    }
    if ((paramInt1 == 5) && (paramInt2 == 0) && (QLog.isDevelopLevel())) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "ready crash!");
    }
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (paramView == null) {}
    try
    {
      QfileLocalFileBaseExpandableListAdapter.LocalItemHolder localLocalItemHolder = new QfileLocalFileBaseExpandableListAdapter.LocalItemHolder(this);
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903988, paramViewGroup, false);
      paramView = paramViewGroup;
      try
      {
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131300926));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.c);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localLocalItemHolder);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131300931));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131300927));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131300929));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300930));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300889));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131297885));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300933));
        paramView = paramViewGroup;
        localLocalItemHolder.d = ((TextView)paramViewGroup.findViewById(2131298399));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131296817));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.b);
        paramView = paramViewGroup;
        paramViewGroup.setTag(localLocalItemHolder);
        while (localFileInfo == null)
        {
          return paramViewGroup;
          localLocalItemHolder = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
          paramViewGroup = paramView;
        }
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_Int = paramInt1;
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_Int = paramInt2;
        paramView = paramViewGroup;
        localFileInfo.a((String)getGroup(paramInt1));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_JavaLangObject = localFileInfo;
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.d);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localLocalItemHolder);
        paramView = paramViewGroup;
        paramInt1 = localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getHeight();
        paramView = paramViewGroup;
        paramInt2 = localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getWidth();
        paramView = paramViewGroup;
        a(localFileInfo.d(), FileManagerUtil.a(localFileInfo.d()), paramInt2, paramInt1, localLocalItemHolder);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileInfo.e()));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileInfo));
        paramView = paramViewGroup;
        localLocalItemHolder.d.setText(QfileTimeUtils.c(localFileInfo.b()));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131362931);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramView = paramViewGroup;
        localLocalItemHolder.c = 0;
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
        {
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838312);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
        }
        else
        {
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
      }
      catch (Exception paramViewGroup) {}
    }
    catch (Exception paramViewGroup)
    {
      for (;;) {}
    }
    paramViewGroup.printStackTrace();
    return paramView;
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\localfile\QfileLocalFileBaseExpandableListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */