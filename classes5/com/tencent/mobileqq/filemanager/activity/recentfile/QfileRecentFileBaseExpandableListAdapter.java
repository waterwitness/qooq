package com.tencent.mobileqq.filemanager.activity.recentfile;

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
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import rvf;

public class QfileRecentFileBaseExpandableListAdapter
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
  
  public QfileRecentFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
  
  private String a(FileManagerEntity paramFileManagerEntity)
  {
    String str = null;
    Object localObject1;
    Object localObject2;
    switch (paramFileManagerEntity.nOpType)
    {
    default: 
      localObject1 = null;
      if (paramFileManagerEntity.getCloudType() == 0) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362762);
      }
      localObject2 = localObject1;
      if (paramFileManagerEntity.getCloudType() == 5)
      {
        if (paramFileManagerEntity.bSend)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362764);
          label230:
          localObject1 = paramFileManagerEntity.peerNick;
        }
      }
      else
      {
        if ((localObject2 != null) && (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362752))) && (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362763)))) {
          localObject1 = paramFileManagerEntity.peerNick;
        }
        localObject1 = localObject2;
        if (paramFileManagerEntity.nOpType == 1)
        {
          localObject1 = localObject2;
          if (paramFileManagerEntity.bSend) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362764);
          }
        }
        localObject2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
        if (paramFileManagerEntity.TroopUin == 0L) {
          break label1036;
        }
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(51)).a(String.valueOf(paramFileManagerEntity.TroopUin));
        if ((localObject1 != null) && (((TroopInfo)localObject1).troopname != null)) {
          break label878;
        }
        localObject1 = "";
        label375:
        if (!paramFileManagerEntity.bSend) {
          break label920;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362902) + (String)localObject1;
        label409:
        localObject1 = null;
      }
      break;
    }
    label510:
    label878:
    label920:
    label992:
    label1036:
    for (;;)
    {
      Object localObject3 = localObject2;
      if (localObject1 != null)
      {
        localObject3 = localObject2;
        if (((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362752))) {
          localObject3 = null;
        }
      }
      if ((paramFileManagerEntity.peerType == 3000) && (localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362752))))
      {
        localObject1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(52)).a(String.valueOf(paramFileManagerEntity.peerUin));
        if ((localObject1 == null) || (((DiscussionInfo)localObject1).discussionName == null))
        {
          localObject1 = "";
          if (!paramFileManagerEntity.bSend) {
            break label992;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362903) + (String)localObject1;
          localObject2 = str;
        }
      }
      for (;;)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362770);
        str = QfileTimeUtils.c(paramFileManagerEntity.srvTime) + a((String)localObject3, (String)localObject2) + a((String)localObject3, (String)localObject1);
        if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362763))) && (paramFileManagerEntity.bSend))
        {
          return QfileTimeUtils.c(paramFileManagerEntity.srvTime) + a((String)localObject3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362764)) + a((String)localObject3, (String)localObject1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362762);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362752);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362764);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362763);
          break;
          if (paramFileManagerEntity.bSend)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362764);
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362762);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362884);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362885);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362886);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362887);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362888);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362889);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362890);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362891);
          break;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362762);
          break label230;
          if ((localObject1 != null) && (((TroopInfo)localObject1).troopname != null) && (((TroopInfo)localObject1).troopname.length() > 14))
          {
            localObject1 = FileManagerUtil.d(((TroopInfo)localObject1).troopname);
            break label375;
          }
          localObject1 = ((TroopInfo)localObject1).troopname;
          break label375;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362901) + (String)localObject1;
          break label409;
          if ((localObject1 != null) && (((DiscussionInfo)localObject1).discussionName != null) && (((DiscussionInfo)localObject1).discussionName.length() > 14))
          {
            localObject1 = FileManagerUtil.d(((DiscussionInfo)localObject1).discussionName);
            break label510;
          }
          localObject1 = ((DiscussionInfo)localObject1).discussionName;
          break label510;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362904) + (String)localObject1;
          localObject2 = str;
          continue;
        }
        return str;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
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
  
  private String b(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject;
    String str2;
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      localObject = null;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362770);
      str2 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, (String)localObject) + a(str3, str1);
      localObject = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, str1);
      if ((paramFileManagerEntity.getCloudType() == 2) && (3 == paramFileManagerEntity.nOpType)) {
        localObject = str2;
      }
      break;
    }
    do
    {
      return (String)localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362729);
      str1 = FileManagerUtil.a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType, false);
      str1 = str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362765);
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362730);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131366104);
      break;
      if (paramFileManagerEntity.getCloudType() == 5) {
        return str2;
      }
    } while (paramFileManagerEntity.TroopUin == 0L);
    return str2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      localObject3 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (rvf)((Iterator)localObject3).next();
          if (((rvf)localObject2).jdField_a_of_type_Int != paramInt2) {
            break label1448;
          }
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((rvf)localObject2).jdField_b_of_type_Int);
        }
      }
    }
    while (localObject2 == null)
    {
      return paramView;
      localObject2 = (FileManagerEntity)getChild(paramInt1, paramInt2);
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject3 = new QfileRecentFileBaseExpandableListAdapter.RecentItemHolder(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903988, paramViewGroup, false);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131300926));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.c);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject3);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300931));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131300927));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300929));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300930));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300889));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297885));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300933));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).d = ((TextView)paramView.findViewById(2131298399));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131296817));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.b);
        localObject1 = paramView;
        paramView.setTag(localObject3);
        paramViewGroup = (ViewGroup)localObject3;
      }
      catch (Exception paramViewGroup)
      {
        paramView = (View)localObject1;
        continue;
      }
      try
      {
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject2);
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        paramViewGroup.c = paramInt2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.d);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
        if (FileManagerUtil.a(((FileManagerEntity)localObject2).fileName) == 0)
        {
          if (FileUtils.b(((FileManagerEntity)localObject2).getFilePath()))
          {
            FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).getFilePath(), ((FileManagerEntity)localObject2).nFileType);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(((FileManagerEntity)localObject2).fileName));
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(b((FileManagerEntity)localObject2));
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.d.setText(FileManagerUtil.a((FileManagerEntity)localObject2));
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            if (5 != ((FileManagerEntity)localObject2).cloudType) {
              FileManagerUtil.c((FileManagerEntity)localObject2);
            }
          }
          switch (((FileManagerEntity)localObject2).status)
          {
          case 16: 
          case 17: 
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
            {
              paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838312);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a((FileManagerEntity)localObject2));
              return paramView;
              localObject1 = paramView;
              paramViewGroup = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
              continue;
              if (FileUtils.b(((FileManagerEntity)localObject2).strThumbPath))
              {
                a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).strThumbPath);
                continue;
              }
            }
            break;
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).fileName, ((FileManagerEntity)localObject2).nFileType);
        continue;
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject2);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362932);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 2;
        paramViewGroup.d.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362933);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 3;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramBoolean = FileUtil.a(((FileManagerEntity)localObject2).getFilePath());
        if ((((FileManagerEntity)localObject2).getCloudType() == 3) || (((FileManagerEntity)localObject2).getCloudType() == 5) || (paramBoolean))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362931);
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramViewGroup.jdField_a_of_type_Int = 0;
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          continue;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362934);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362933);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 3;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362931);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362934);
        paramViewGroup.jdField_a_of_type_Int = 1;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362931);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362931);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362934);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362931);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362934);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      label1448:
      break;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject1 = a(paramInt);
    if (localObject1 != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        int j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (FileManagerEntity)localIterator.next();
          int k;
          if ((((FileManagerEntity)localObject2).getCloudType() == 0) || ((((FileManagerEntity)localObject2).getCloudType() == 5) && (!((FileManagerEntity)localObject2).bSend) && (((FileManagerEntity)localObject2).status != 1)))
          {
            k = j + 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            k = j;
            j = i;
            i = k;
            break;
            localObject2 = new rvf(this);
            ((rvf)localObject2).jdField_a_of_type_Int = i;
            ((rvf)localObject2).jdField_b_of_type_Int = (i + j);
            localArrayList.add(localObject2);
            k = i + 1;
            i = j;
            j = k;
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
        i = ((ArrayList)localObject1).size() - j;
      }
    }
    else
    {
      return i;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    return ((ArrayList)localObject1).size();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\recentfile\QfileRecentFileBaseExpandableListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */