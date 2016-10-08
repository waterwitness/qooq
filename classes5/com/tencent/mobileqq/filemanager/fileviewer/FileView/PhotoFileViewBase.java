package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerGalleryAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.Gallery;
import java.util.List;
import sgh;
import sgi;

public abstract class PhotoFileViewBase
  extends FileViewBase
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FileViewerGalleryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter;
  public AdapterView.OnItemClickListener a;
  public AdapterView.OnItemSelectedListener a;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  private final String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public PhotoFileViewBase(Activity paramActivity, List paramList, int paramInt)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "PhotoFileViewBase";
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new sgh(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new sgi(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter = new FileViewerGalleryAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.a(paramList);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("PhotoFileViewBase", 4, "initVarView: but adapter is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getItem(this.jdField_a_of_type_Int) != null) && (FileManagerUtil.a(((IFileViewerAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getItem(this.jdField_a_of_type_Int)).a())) && (1 == ((IFileViewerAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getItem(this.jdField_a_of_type_Int)).a().getCloudType())) {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131362871));
    }
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_a_of_type_AndroidViewView.findViewById(2131298351));
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131492970));
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904023, paramViewGroup, false);
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public abstract PhotoFileViewBase.IControllProxyInterface a();
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getCount() > 1)
    {
      int i = this.jdField_a_of_type_Int;
      return i + 1 + "/" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getCount();
    }
    return BaseApplicationImpl.getContext().getString(2131362788);
  }
  
  public void a()
  {
    a().b();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoFileViewBase", 1, "fileid or thumb is null!");
      }
    }
    IFileViewerAdapter localIFileViewerAdapter;
    do
    {
      do
      {
        return;
        localIFileViewerAdapter = (IFileViewerAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.getItem(this.jdField_a_of_type_Int);
      } while (localIFileViewerAdapter == null);
      if (localIFileViewerAdapter.a() != null)
      {
        FileManagerEntity localFileManagerEntity = localIFileViewerAdapter.a();
        if ((localFileManagerEntity != null) && (localFileManagerEntity.strTroopFilePath != null) && (localFileManagerEntity.strTroopFilePath.equalsIgnoreCase(paramString1)))
        {
          if ((paramString2 != null) && (paramString2.length() > 1)) {
            localIFileViewerAdapter.b(paramString2);
          }
          localIFileViewerAdapter.a(0);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.notifyDataSetChanged();
          return;
        }
      }
    } while ((!paramString1.equalsIgnoreCase(localIFileViewerAdapter.e())) && (!paramString1.equalsIgnoreCase(localIFileViewerAdapter.f())));
    if ((paramString2 != null) && (paramString2.length() > 1)) {
      localIFileViewerAdapter.b(paramString2);
    }
    localIFileViewerAdapter.a(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.notifyDataSetChanged();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerGalleryAdapter.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\PhotoFileViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */