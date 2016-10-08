package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SmallEmoticonInfo
  extends EmoticonInfo
{
  public int a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Emoticon a;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int h;
  private String k;
  private String l;
  
  public SmallEmoticonInfo(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = "SmallEmoticonInfo";
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
    if (QLog.isColorLevel()) {
      QLog.d(this.k, 2, "currentAccountUin:" + paramString);
    }
    this.l = paramString;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130837545);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130840120);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.k, 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.k, 2, paramString.getMessage());
    }
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        paramContext = URLDrawable.getDrawable(paramContext, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, false);
        paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        paramContext.addHeader("my_uin", this.l);
        return paramContext;
      }
      catch (MalformedURLException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.k, 2, "getDrawable ,", paramContext);
        }
        return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e(this.k, 1, "fail to send small_emotion.");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      int i2 = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      paramContext = EmosmUtils.a(i2, i1);
      int i = paramContext[3];
      int j = paramContext[2];
      int m = paramContext[1];
      int n = paramContext[0];
      int i3 = paramEditText.getSelectionStart();
      int i4 = paramEditText.getSelectionEnd();
      paramEditText.getEditableText().replace(i3, i4, String.valueOf(new char[] { '\024', i, j, m, n }));
      paramEditText.requestFocus();
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717E", 0, 0, i2 + "", i1 + "", "", "");
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
      QLog.e(this.k, 1, "fail to send small_emotion. id is not Int.");
    }
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return false;
    }
    Object localObject = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 1) {
      localObject = EmoticonUtils.o.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    }
    boolean bool1;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      int i;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) && (bool1))
      {
        localObject = EmoticonUtils.k.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        if (localObject == null) {
          break label184;
        }
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
          i = 1;
        }
      }
      for (;;)
      {
        label154:
        if ((bool1) && (i != 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          return bool1;
          bool1 = false;
          break;
          i = 0;
          break label154;
        }
        return bool1;
        label184:
        i = 0;
      }
      bool1 = false;
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null)
    {
      localObject = null;
      return (Drawable)localObject;
    }
    for (;;)
    {
      Drawable localDrawable;
      try
      {
        paramContext = new URL("emotion_pic", "fromAIO", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if ((this.jdField_b_of_type_Int != 0) && (this.h != 0))
        {
          paramContext = URLDrawable.getDrawable(paramContext, this.jdField_b_of_type_Int, this.h, (Drawable)localObject, localDrawable, true);
          localObject = paramContext;
          if (paramContext.getStatus() == 1) {
            break;
          }
          paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
          paramContext.addHeader("my_uin", this.l);
          paramContext.addHeader("emo_big", "true");
          localObject = paramContext;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(this.k, 2, "b.getStatus=" + paramContext.getStatus() + " e.epId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " e.eId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
          return paramContext;
        }
      }
      catch (MalformedURLException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.k, 2, "getDrawable ,", paramContext);
        }
        return null;
      }
      paramContext = URLDrawable.getDrawable(paramContext, (Drawable)localObject, localDrawable, true);
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      localObject = EmoticonUtils.l.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      label50:
      if (localObject == null) {
        break label108;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label110;
      }
    }
    for (;;)
    {
      return bool;
      localObject = EmoticonUtils.m.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      break label50;
      label108:
      break;
      label110:
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\SmallEmoticonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */