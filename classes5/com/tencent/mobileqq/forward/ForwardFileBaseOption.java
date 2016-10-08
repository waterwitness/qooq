package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import slc;
import sld;

public abstract class ForwardFileBaseOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardFileBaseOption";
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public ForwardFileBaseOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i = paramContext.getColumnIndexOrThrow("_data");
        paramContext.moveToFirst();
        paramUri = paramContext.getString(i);
        paramContext.close();
        return paramUri;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static String a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    try
    {
      paramString = localBaseApplication.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      if ((paramString == null) || (paramString != null)) {
        paramString.close();
      }
    }
    finally
    {
      try
      {
        if (paramString.moveToFirst())
        {
          paramUri = paramString.getString(paramString.getColumnIndexOrThrow("_data"));
          if (paramString != null) {
            paramString.close();
          }
          return paramUri;
        }
        if (paramString != null) {
          paramString.close();
        }
        return null;
      }
      finally {}
      paramUri = finally;
      paramString = (String)localObject;
    }
    throw paramUri;
  }
  
  protected String a(Uri paramUri)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 1;
    }
    Object localObject;
    for (;;)
    {
      if (i != 0)
      {
        localObject = paramUri.getPathSegments();
        if ((((List)localObject).size() >= 2) && ("document".equals(((List)localObject).get(0))))
        {
          localObject = (String)((List)localObject).get(1);
          if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
          {
            localObject = ((String)localObject).split(":");
            if ("primary".equalsIgnoreCase(localObject[0]))
            {
              return Environment.getExternalStorageDirectory() + "/" + localObject[1];
              i = 0;
            }
          }
          else
          {
            if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority())) {
              return a(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf((String)localObject).longValue()), null, null);
            }
            if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
            {
              localObject = ((String)localObject).split(":");
              paramUri = localObject[0];
              if ("image".equals(paramUri)) {
                paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return a(paramUri, "_id=?", new String[] { localObject[1] });
      if ("video".equals(paramUri))
      {
        paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
      }
      else if ("audio".equals(paramUri))
      {
        paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        continue;
        if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority())) {}
        return a(this.jdField_a_of_type_AndroidContentContext, paramUri);
        return a(this.jdField_a_of_type_AndroidContentContext, paramUri);
      }
      else
      {
        paramUri = null;
      }
    }
  }
  
  public boolean a()
  {
    super.a();
    Uri localUri = this.jdField_a_of_type_AndroidContentIntent.getData();
    if (localUri != null) {
      a(localUri);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("fileinfo"));
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("fileinfo_array");
    return true;
  }
  
  protected boolean a(Uri paramUri)
  {
    Object localObject = a(paramUri);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramUri = d();
      localObject = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131558973);
      ((QQCustomDialog)localObject).setContentView(2130903241);
      ((QQCustomDialog)localObject).setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131368978));
      ((QQCustomDialog)localObject).setMessage(paramUri);
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject).setCancelable(false);
      ((QQCustomDialog)localObject).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131367975), new slc(this));
      ((QQCustomDialog)localObject).show();
      return false;
    }
    paramUri = new File((String)localObject);
    long l = paramUri.length();
    if (l == 0L)
    {
      paramUri = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131558973);
      paramUri.setContentView(2130903241);
      paramUri.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131368978));
      paramUri.setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131370477));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131367975), new sld(this));
      paramUri.show();
      return false;
    }
    String str = paramUri.getName();
    if (!paramUri.canRead())
    {
      this.c = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_type", -1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", (String)localObject);
    if (l < 1024L) {
      paramUri = l + " bytes";
    }
    for (;;)
    {
      b((String)localObject);
      this.c = (this.jdField_a_of_type_AndroidContentContext.getString(2131369854) + str + "\n" + this.jdField_a_of_type_AndroidContentContext.getString(2131369855) + paramUri);
      return true;
      if (l < 1048576L)
      {
        paramUri = l / 1024L + " KB";
      }
      else
      {
        paramUri = new DecimalFormat("##0.00");
        paramUri = paramUri.format(l / 1048576.0D) + " MB";
      }
    }
  }
  
  protected void b(String paramString) {}
  
  protected boolean c()
  {
    Intent localIntent;
    boolean bool;
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", PublicAccountManager.a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (!this.f) {
          break label178;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label178:
      if (!bool) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
    }
  }
  
  protected String d()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131370476);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardFileBaseOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */