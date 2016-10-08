package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import sdd;
import sde;
import sdf;
import sdg;
import sdh;
import sdi;
import sdj;
import sdk;
import sdl;
import sdm;
import sdp;

public class ActionBarUtil
{
  public ActionBarUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdk(paramActivity, paramString, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(DataLineHandler paramDataLineHandler, BaseActivity paramBaseActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdl(paramDataLineHandler, paramBaseActivity, paramString, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdg(paramFileManagerEntity, paramQQAppInterface, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, IFileBrowser paramIFileBrowser, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdd(paramIFileBrowser, paramQQAppInterface, paramString, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdj(paramQQAppInterface, paramString, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, FileManagerEntity paramFileManagerEntity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdm(paramBaseActivity, paramFileManagerEntity, paramQQAppInterface, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sde(paramQQAppInterface, paramFileManagerEntity, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdh(paramFileManagerEntity, paramQQAppInterface, paramInt, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(boolean paramBoolean, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdp(paramBoolean, paramString, paramQQAppInterface, paramActivity, paramIActionBarClickEvent);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.status = 2;
    paramQQAppInterface.a().d(localFileManagerEntity);
    paramQQAppInterface = ForwardFileOption.a(localFileManagerEntity);
    paramQQAppInterface.b(paramInt);
    paramFileManagerEntity = new Bundle();
    paramFileManagerEntity.putInt("forward_type", 0);
    paramFileManagerEntity.putParcelable("fileinfo", paramQQAppInterface);
    paramFileManagerEntity.putBoolean("not_forward", true);
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtras(paramFileManagerEntity);
    paramQQAppInterface.putExtra("destroy_last_activity", true);
    paramQQAppInterface.putExtra("forward_type", 0);
    paramQQAppInterface.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramQQAppInterface.putExtra("forward_text", "已选择" + FileManagerUtil.d(localFileManagerEntity.fileName) + "。");
    paramQQAppInterface.putExtra("k_favorites", FileManagerUtil.c(localFileManagerEntity));
    if (((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7)) && (localFileManagerEntity.nFileType == 0)) {
      paramQQAppInterface.putExtra("forward_type", 1);
    }
    ForwardBaseOption.a(paramActivity, paramQQAppInterface, 103);
  }
  
  public static View.OnClickListener b(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdf(paramString, paramActivity, paramQQAppInterface, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener b(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new sdi(paramFileManagerEntity, paramQQAppInterface, paramActivity, paramInt, paramIActionBarClickEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\ActionBarUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */