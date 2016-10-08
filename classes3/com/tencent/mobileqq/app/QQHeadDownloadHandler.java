package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import mqq.app.MobileQQ;
import qfc;
import qfd;

public class QQHeadDownloadHandler
  extends FaceDownloader
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final String d = "Q.qqhead.QQHeadDownloadHandler";
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838658, 2130843467, 2130843468, 2130843469 };
  }
  
  public QQHeadDownloadHandler(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = paramFriendListHandler;
  }
  
  private void a(int paramInt, File paramFile)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < jdField_a_of_type_ArrayOfInt.length) {}
    }
    else
    {
      i = 0;
    }
    InputStream localInputStream = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().openRawResource(jdField_a_of_type_ArrayOfInt[i]);
    byte[] arrayOfByte = new byte['Ȁ'];
    paramFile = new FileOutputStream(paramFile);
    for (;;)
    {
      paramInt = localInputStream.read(arrayOfByte);
      if (paramInt <= 0) {
        break;
      }
      paramFile.write(arrayOfByte, 0, paramInt);
    }
    paramFile.close();
    localInputStream.close();
  }
  
  public static void b() {}
  
  public String a()
  {
    return PicIPManager.a(0);
  }
  
  public String b()
  {
    return PicIPManager.a(1);
  }
  
  protected void b(FaceInfo paramFaceInfo)
  {
    QQHeadInfo localQQHeadInfo = paramFaceInfo.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(localQQHeadInfo.uin, localQQHeadInfo.phoneNum);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(0, str, localQQHeadInfo.dstUsrType, 3);
    paramFaceInfo.a(FaceInfo.m);
    bool2 = false;
    bool1 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    i8 = 0;
    int i1 = 0;
    int i12 = 0;
    int k = 0;
    int i13 = 0;
    int i3 = 0;
    Object localObject4 = localQQHeadInfo.downLoadUrl;
    int i17 = 0;
    int i10 = 0;
    int i7 = 0;
    i = 0;
    j = 0;
    int i11 = 0;
    i2 = 0;
    int m = 0;
    int i16 = 0;
    int i14 = 0;
    int n = 0;
    int i15 = 0;
    i4 = 0;
    bool3 = bool2;
    int i9 = i10;
    int i5 = i12;
    Object localObject5 = localObject4;
    int i6 = i14;
    try
    {
      if (TextUtils.isEmpty(localQQHeadInfo.downLoadUrl)) {
        break label4027;
      }
      bool3 = bool2;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      if (localQQHeadInfo.dstUsrType != 4) {
        break label2267;
      }
      bool3 = bool2;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localObject1 = "troop_" + str;
    }
    catch (Throwable paramFaceInfo) {}finally
    {
      ThreadManager.a(new qfc(this, i9, str, localQQHeadInfo.idType, localQQHeadInfo.dstUsrType, 4, i5, (String)localObject5, i6, System.currentTimeMillis()), null, false);
    }
    bool3 = bool2;
    i9 = i10;
    i5 = i12;
    localObject5 = localObject4;
    i6 = i14;
    Setting localSetting = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject1);
    if (localSetting == null)
    {
      bool3 = bool2;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting = new Setting();
      bool3 = bool2;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.uin = ((String)localObject1);
      bool1 = true;
      label321:
      bool3 = bool1;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.bFaceFlags = localQQHeadInfo.dwFaceFlgas;
      bool3 = bool1;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.bUsrType = localQQHeadInfo.dstUsrType;
      bool3 = bool1;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.url = localQQHeadInfo.downLoadUrl;
      bool3 = bool1;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.updateTimestamp = System.currentTimeMillis();
      bool3 = bool1;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      if (localQQHeadInfo.cHeadType == 0)
      {
        bool3 = bool1;
        i9 = i10;
        i5 = i12;
        localObject5 = localObject4;
        i6 = i14;
        localSetting.bSourceType = 0;
        bool2 = bool1;
        if (!bool1)
        {
          bool3 = bool1;
          i9 = i10;
          i5 = i12;
          localObject5 = localObject4;
          i6 = i14;
          if (localSetting.bHeadType == localQQHeadInfo.cHeadType) {
            break label2553;
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      bool3 = bool1;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      if (localQQHeadInfo.dstUsrType != 32)
      {
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          bool3 = bool1;
          i9 = i10;
          i5 = i12;
          localObject5 = localObject4;
          i6 = i14;
          if (localSetting.bHeadType == 1)
          {
            bool2 = bool1;
            bool3 = bool1;
            i9 = i10;
            i5 = i12;
            localObject5 = localObject4;
            i6 = i14;
            if (localQQHeadInfo.cHeadType == 0)
            {
              bool3 = bool1;
              i9 = i10;
              i5 = i12;
              localObject5 = localObject4;
              i6 = i14;
              localObject1 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localSetting.bUsrType, str, localQQHeadInfo.idType));
              bool2 = bool1;
              if (localObject1 != null)
              {
                bool2 = bool1;
                bool3 = bool1;
                i9 = i10;
                i5 = i12;
                localObject5 = localObject4;
                i6 = i14;
                if (((File)localObject1).exists())
                {
                  bool3 = bool1;
                  i9 = i10;
                  i5 = i12;
                  localObject5 = localObject4;
                  i6 = i14;
                  ((File)localObject1).delete();
                  bool2 = bool1;
                }
              }
            }
          }
        }
      }
      bool3 = bool2;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.bHeadType = localQQHeadInfo.cHeadType;
      bool3 = bool2;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.systemHeadID = localQQHeadInfo.systemHeadID;
      bool3 = bool2;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.headImgTimestamp = localQQHeadInfo.dwTimestamp;
      bool3 = bool2;
      i9 = i10;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      if (ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()))
      {
        bool3 = bool2;
        i9 = i10;
        i5 = i12;
        localObject5 = localObject4;
        i6 = i14;
        if (SystemUtil.a())
        {
          bool3 = bool2;
          i9 = i10;
          i5 = i12;
          localObject5 = localObject4;
          i6 = i14;
          localObject1 = jdField_a_of_type_JavaLangObject;
          bool3 = bool2;
          i9 = i10;
          i5 = i12;
          localObject5 = localObject4;
          i6 = i14;
        }
      }
      for (;;)
      {
        Object localObject2;
        Object localObject6;
        File localFile;
        label1889:
        label2018:
        label2267:
        label2553:
        long l1;
        long l2;
        bool1 = false;
        continue;
        i9 = i10;
        i5 = i12;
        localObject5 = localObject4;
        i6 = i14;
        bool5 = bool1;
        i8 = i11;
        bool3 = bool6;
        i1 = i13;
        Object localObject3 = localObject4;
        m = i15;
        j = a((String)localObject4, localFile, paramFaceInfo, false);
        if (j != 0) {
          break label4090;
        }
        i9 = i10;
        i5 = i12;
        localObject5 = localObject4;
        i6 = j;
        bool5 = bool1;
        i8 = i11;
        bool3 = bool6;
        i1 = i13;
        localObject3 = localObject4;
        m = j;
        i3 = (int)localFile.length();
        bool3 = true;
        bool4 = true;
        i9 = i10;
        i5 = i3;
        localObject5 = localObject4;
        i6 = j;
        bool5 = bool1;
        i8 = i11;
        i1 = i3;
        localObject3 = localObject4;
        m = j;
        ThreadManager.a(new qfd(this, localSetting, paramFaceInfo), null, false);
        i4 = j;
        continue;
        i9 = i;
        i5 = i3;
        localObject5 = localObject4;
        i6 = i4;
        bool5 = bool1;
        i8 = i2;
        bool3 = bool4;
        i1 = i3;
        localObject3 = localObject4;
        m = i4;
        if (localQQHeadInfo.dstUsrType == 32)
        {
          i9 = i;
          i5 = i3;
          localObject5 = localObject4;
          i6 = i4;
          bool5 = bool1;
          i8 = i2;
          bool3 = bool4;
          i1 = i3;
          localObject3 = localObject4;
          m = i4;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, str, localQQHeadInfo.idType);
          j = i2;
          i7 = i;
          bool2 = bool4;
          k = i3;
          localObject6 = localObject4;
          n = i4;
        }
        else
        {
          i9 = i;
          i5 = i3;
          localObject5 = localObject4;
          i6 = i4;
          bool5 = bool1;
          i8 = i2;
          bool3 = bool4;
          i1 = i3;
          localObject3 = localObject4;
          m = i4;
          if (localQQHeadInfo.dstUsrType == 16)
          {
            i9 = i;
            i5 = i3;
            localObject5 = localObject4;
            i6 = i4;
            bool5 = bool1;
            i8 = i2;
            bool3 = bool4;
            i1 = i3;
            localObject3 = localObject4;
            m = i4;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, str, localQQHeadInfo.idType);
            j = i2;
            i7 = i;
            bool2 = bool4;
            k = i3;
            localObject6 = localObject4;
            n = i4;
          }
          else
          {
            i9 = i;
            i5 = i3;
            localObject5 = localObject4;
            i6 = i4;
            bool5 = bool1;
            i8 = i2;
            bool3 = bool4;
            i1 = i3;
            localObject3 = localObject4;
            m = i4;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, str, localQQHeadInfo.idType);
            j = i2;
            i7 = i;
            bool2 = bool4;
            k = i3;
            localObject6 = localObject4;
            n = i4;
            break label4053;
            i9 = i7;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool3 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            if (localQQHeadInfo.dstUsrType == 4)
            {
              i9 = i7;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool3 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(30, true, new Object[] { str });
              i9 = i7;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool3 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4, str, 0, (String)localObject1);
              i = j;
              bool3 = bool1;
              paramFaceInfo = (FaceInfo)localObject1;
              localObject4 = localObject6;
              bool1 = bool2;
              bool2 = bool3;
              continue;
            }
            i9 = i7;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool3 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            if (localQQHeadInfo.dstUsrType == 32)
            {
              i9 = i7;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool3 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(5, true, new Object[] { str, Integer.valueOf(localQQHeadInfo.idType), Boolean.valueOf(true) });
              i9 = i7;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool3 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(104, true, new Object[] { str, Integer.valueOf(localQQHeadInfo.idType), localObject6 });
              i = j;
              bool3 = bool1;
              paramFaceInfo = (FaceInfo)localObject1;
              localObject4 = localObject6;
              bool1 = bool2;
              bool2 = bool3;
              continue;
            }
            i9 = i7;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool3 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            if (localQQHeadInfo.dstUsrType == 16)
            {
              i9 = i7;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool3 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(6, true, new Object[] { str, Integer.valueOf(localQQHeadInfo.idType), Boolean.valueOf(true) });
              i = j;
              bool3 = bool1;
              paramFaceInfo = (FaceInfo)localObject1;
              localObject4 = localObject6;
              bool1 = bool2;
              bool2 = bool3;
              continue;
            }
            i9 = i7;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool3 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, str, 0, (String)localObject1);
            i9 = i7;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool3 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(4, true, new Object[] { str });
          }
        }
        label4027:
        label4053:
        do
        {
          i = j;
          bool3 = bool1;
          paramFaceInfo = (FaceInfo)localObject1;
          localObject4 = localObject6;
          bool1 = bool2;
          bool2 = bool3;
          break label2018;
          break label321;
          localObject1 = str;
          break;
          i = 0;
          bool1 = false;
          bool2 = false;
          paramFaceInfo = null;
          i7 = i17;
          k = i8;
          n = m;
          break label2018;
          if (bool2) {
            break label1889;
          }
        } while (bool1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QQHeadDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */