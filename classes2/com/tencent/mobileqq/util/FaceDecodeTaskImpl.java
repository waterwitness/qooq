package com.tencent.mobileqq.util;

import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class FaceDecodeTaskImpl
  extends FaceDecodeTask
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.FaceDecodeTaskImpl";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public FaceDecodeTaskImpl(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    super(paramQQAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected void a()
  {
    b = 0;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.o);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 101) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1001)) {
        break label293;
      }
      localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1001) {
        break label121;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = localDiscussionHandler.a(DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString), false);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        for (;;)
        {
          DiscussionHandler localDiscussionHandler;
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 4) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString)))
          {
            String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
            this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str);
            if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
            {
              int i = HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(BaseApplicationImpl.a.getResources(), i);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, this.jdField_a_of_type_AndroidGraphicsBitmap);
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
            try
            {
              if (jdField_a_of_type_MqqOsMqqHandler == null) {
                continue;
              }
              jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
              return;
            }
            catch (Exception localException3) {}
            if (QLog.isColorLevel()) {
              QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException3);
            }
          }
          else
          {
            if ((Setting)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int).second != null) {
              break label655;
            }
            this.jdField_a_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-settingNull, faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.toString());
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
            try
            {
              if (jdField_a_of_type_MqqOsMqqHandler != null)
              {
                jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
                return;
              }
            }
            catch (Exception localException4) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException4);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int)) {
        break label813;
      }
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        if (!this.jdField_a_of_type_Boolean) {
          break label819;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-fileNotExit, faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
        try
        {
          if (jdField_a_of_type_MqqOsMqqHandler == null) {
            break;
          }
          jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          return;
        }
        catch (Exception localException5) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException5);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 101) {
        break label896;
      }
      Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
      if ((localPair == null) || (!((Boolean)localPair.first).booleanValue())) {
        break label1080;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte = 1;
      FaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
      for (;;)
      {
        switch (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Byte)
        {
        case 1: 
          this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, false, b, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
          if ((QLog.isColorLevel()) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
            QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap fail. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler == null) {
              break label120;
            }
            jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
            return;
          }
          catch (Exception localException6) {}
          if (!QLog.isColorLevel()) {
            break label120;
          }
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException6);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Boolean) && (localException6 != null) && ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 32)))
          {
            DynamicAvatarManager localDynamicAvatarManager = (DynamicAvatarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(179);
            if (localDynamicAvatarManager.a(localDynamicAvatarManager.b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString), (Setting)localException6.second, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int))
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.dynamicAvatar", 2, "FaceDecodeTaskImpl isNeed2UpdateSettingInfo.");
              }
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte = 1;
              FaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
            }
          }
          break;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localThrowable);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler != null)
            {
              jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
              return;
            }
          }
          catch (Exception localException7) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException7);
      return;
    }
    finally
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
        try
        {
          if (jdField_a_of_type_MqqOsMqqHandler != null) {
            jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          }
          throw ((Throwable)localObject);
        }
        catch (Exception localException8)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException8);
            }
          }
        }
        b = 1;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FaceDecodeTaskImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */