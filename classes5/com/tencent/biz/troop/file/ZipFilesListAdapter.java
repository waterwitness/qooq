package com.tencent.biz.troop.file;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView.FileData;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView.FilesViewHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import jej;

public class ZipFilesListAdapter
  extends BaseAdapter
{
  public long a;
  public Activity a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  List jdField_a_of_type_JavaUtilList;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public ZipFilesListAdapter(List paramList, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904028, null);
      paramView = new ZipPreviewFileView.FilesViewHolder();
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131300951));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300952));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131301042));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131301043);
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(new jej(this));
    }
    paramView = (ZipPreviewFileView.FilesViewHolder)paramViewGroup.getTag();
    ZipPreviewFileView.FileData localFileData = (ZipPreviewFileView.FileData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localFileData.jdField_a_of_type_Boolean)
    {
      paramView.b.setText("文件夹");
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileData.jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130840348);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView$FileData = localFileData;
      return paramViewGroup;
      paramView.b.setText(FileUtil.a(localFileData.jdField_a_of_type_Long));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileData.jdField_a_of_type_JavaLangString);
      FileManagerUtil.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileData.jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troop\file\ZipFilesListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */